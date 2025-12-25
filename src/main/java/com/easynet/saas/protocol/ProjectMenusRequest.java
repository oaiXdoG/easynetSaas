package com.easynet.saas.protocol;

import java.util.List;

/**
 * 配置项目菜单请求（超管）
 */
public class ProjectMenusRequest {
    private Long projectId;
    private List<Long> menuIds;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public List<Long> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Long> menuIds) {
        this.menuIds = menuIds;
    }
}
