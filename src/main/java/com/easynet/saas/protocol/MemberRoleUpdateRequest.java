package com.easynet.saas.protocol;

/**
 * 修改成员角色请求
 */
public class MemberRoleUpdateRequest {
    private Long projectId;
    private Long userId;
    private Long roleId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
