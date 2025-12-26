package com.easynet.saas.controller;

import com.easynet.core.Net;
import com.easynet.core.internal.anno.Packet;
import com.easynet.core.internal.session.Session;
import com.easynet.orm.Orm;
import com.easynet.saas.common.ErrorCode;
import com.easynet.saas.util.TokenCache;
import com.easynet.saas.common.UserConstants;
import com.easynet.saas.entity.SysUser;
import com.easynet.saas.protocol.ApiResponse;
import com.easynet.saas.protocol.LoginRequest;
import com.easynet.saas.protocol.LoginResponse;
import com.easynet.saas.protocol.LogoutRequest;
import com.easynet.saas.protocol.dto.UserInfoDTO;
import com.easynet.utils.JwtUtils;
import com.easynet.utils.Md5Utils;

import java.time.LocalDateTime;

public class LoginController {

    @Packet
    public void onLoginRequest(Session session, LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        SysUser sysUser = Orm.query(SysUser.class)
                .eq(SysUser::getUsername, username)
                .selectOne();

        if (sysUser == null) {
            Net.send(session, ApiResponse.error(ErrorCode.USER_NOT_FOUND));
            return;
        }

        if (!Md5Utils.encrypt(password).equals(sysUser.getPassword())) {
            Net.send(session, ApiResponse.error(ErrorCode.PASSWORD_ERROR));
            return;
        }

        if (sysUser.getStatus() == UserConstants.ACCOUNT_DISABLED) {
            Net.send(session, ApiResponse.error(ErrorCode.USER_BAN));
            return;
        }

        Orm.update(SysUser.class)
                .eq(SysUser::getId, sysUser.getId())
                .set(SysUser::getLastLoginAt, LocalDateTime.now())
                .exec();

        String token = JwtUtils.generateToken(sysUser.getId());
        // 存入缓存
        TokenCache.put(sysUser.getId(), token);

        LoginResponse response = new LoginResponse();
        UserInfoDTO userInfo = new UserInfoDTO();
        userInfo.setId(sysUser.getId());
        userInfo.setUsername(sysUser.getUsername());
        userInfo.setRealName(sysUser.getRealName());
        userInfo.setAvatar(sysUser.getAvatar());
        userInfo.setIsSuperAdmin(sysUser.getIsSuperAdmin() == UserConstants.SUPER_ADMIN);
        response.setUserInfo(userInfo);
        response.setToken(token);

        Net.send(session, ApiResponse.success(response));
    }

    @Packet
    public void onLogoutRequest(Session session, LogoutRequest logoutRequest) {
        String token = logoutRequest.getToken();

        if (token == null || token.isEmpty()) {
            Net.send(session, ApiResponse.error(ErrorCode.TOKEN_INVALID));
            return;
        }

        long userId = JwtUtils.parseToken(token);
        if (userId <= 0) {
            Net.send(session, ApiResponse.error(ErrorCode.TOKEN_INVALID));
            return;
        }

        // 从缓存删除
        TokenCache.remove(userId);

        Net.send(session, ApiResponse.success());
    }
}
