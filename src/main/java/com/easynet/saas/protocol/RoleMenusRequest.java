package com.easynet.saas.protocol;

import java.util.List;

/**
 * 配置角色菜单请求
 */
public class RoleMenusRequest {
    private Long roleId;
    private List<Long> menuIds;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }
}
