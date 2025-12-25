package com.easynet.saas.protocol;

/**
 * 切换当前项目请求
 */
public class SwitchProjectRequest {
    private Long projectId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
