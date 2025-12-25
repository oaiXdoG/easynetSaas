package com.easynet.saas.protocol;

import com.easynet.saas.protocol.dto.UserInfoDTO;

/**
 * 登录响应
 */
public class LoginResponse {
    private String token;
    private UserInfoDTO userInfo;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfoDTO getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoDTO userInfo) {
        this.userInfo = userInfo;
    }
}
