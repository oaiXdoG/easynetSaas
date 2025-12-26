package com.easynet.saas.common;

/**
 * 错误码枚举
 */
public enum ErrorCode {

    // 通用错误 1-999
    SUCCESS(200, "success"),
    PARAM_ERROR(400, "参数错误"),
    UNAUTHORIZED(401, "未登录或Token失效"),
    FORBIDDEN(403, "无权限"),
    NOT_FOUND(404, "资源不存在"),
    SERVER_ERROR(500, "服务器错误"),

    // 认证模块 10000-10999
    USER_NOT_FOUND(10001, "用户不存在"),
    PASSWORD_ERROR(10002, "密码错误"),
    TOKEN_INVALID(10003, "Token无效"),
    TOKEN_EXPIRED(10004, "Token已过期"),
    USER_BAN(10005,"用户被禁用"),

    // 用户模块 11000-11999
    USERNAME_EXISTS(11001, "用户名已存在"),
    USER_DISABLED(11002, "用户已禁用"),

    // 项目模块 12000-12999
    PROJECT_NOT_FOUND(12001, "项目不存在"),
    PROJECT_NAME_EXISTS(12002, "项目名称已存在"),

    // 角色模块 13000-13999
    ROLE_NOT_FOUND(13001, "角色不存在"),
    ROLE_NAME_EXISTS(13002, "角色名称已存在"),

    // 成员模块 14000-14999
    MEMBER_NOT_FOUND(14001, "成员不存在"),
    MEMBER_EXISTS(14002, "成员已存在"),

    // 权限模块 15000-15999
    PERMISSION_NOT_FOUND(15001, "权限不存在"),
    PERMISSION_CODE_EXISTS(15002, "权限编码已存在"),

    // 菜单模块 16000-16999
    MENU_NOT_FOUND(16001, "菜单不存在"),
    MENU_CODE_EXISTS(16002, "菜单编码已存在");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
