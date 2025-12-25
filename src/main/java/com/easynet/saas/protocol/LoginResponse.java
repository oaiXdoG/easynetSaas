package com.easynet.saas.protocol;

import com.easynet.saas.protocol.dto.UserInfo;

/**
 * 登录响应
 */
public class LoginResponse {
    private String token;
    private UserInfo userInfo;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
