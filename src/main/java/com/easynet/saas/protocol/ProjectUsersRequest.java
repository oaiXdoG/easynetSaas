package com.easynet.saas.protocol;

import java.util.List;

/**
 * 分配用户到项目请求（超管）
 */
public class ProjectUsersRequest {
    private Long projectId;
    private List<Long> userIds;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }
}
