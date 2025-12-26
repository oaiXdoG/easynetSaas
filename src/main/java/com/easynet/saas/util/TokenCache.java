package com.easynet.saas.util;

import com.easynet.utils.JwtUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Token缓存管理
 */
public final class TokenCache {

    // Token缓存：key=userId, value=token
    private static final Map<Long, String> CACHE = new ConcurrentHashMap<>();

    private TokenCache() {
    }

    /**
     * 存入Token
     */
    public static void put(long userId, String token) {
        CACHE.put(userId, token);
    }

    /**
     * 移除Token
     */
    public static void remove(long userId) {
        CACHE.remove(userId);
    }

    /**
     * 获取Token
     */
    public static String get(long userId) {
        return CACHE.get(userId);
    }

    /**
     * 验证Token是否有效
     */
    public static boolean isValid(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        long userId = JwtUtils.parseToken(token);
        if (userId <= 0) {
            return false;
        }
        String cachedToken = CACHE.get(userId);
        return token.equals(cachedToken);
    }

    /**
     * 根据Token获取userId，无效返回-1
     */
    public static long getUserId(String token) {
        if (!isValid(token)) {
            return -1;
        }
        return JwtUtils.parseToken(token);
    }
}
