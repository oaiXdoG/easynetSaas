package com.easynet.saas.protocol;

/**
 * 需要认证的请求基类
 */
public class BaseAuthRequest {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
