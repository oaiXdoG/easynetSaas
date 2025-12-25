package com.easynet.saas.protocol;

import java.util.List;

/**
 * 配置角色权限请求
 */
public class RolePermissionsRequest {
    private Long roleId;
    private List<Long> permissionIds;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
