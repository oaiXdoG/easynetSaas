package com.easynet.saas.protocol;

/**
 * 同步菜单响应
 */
public class SyncMenusResponse {
    private Integer groupsAdded;
    private Integer groupsUpdated;
    private Integer groupsDeleted;
    private Integer menusAdded;
    private Integer menusUpdated;
    private Integer menusDeleted;

    public Integer getGroupsAdded() {
        return groupsAdded;
    }

    public void setGroupsAdded(Integer groupsAdded) {
        this.groupsAdded = groupsAdded;
    }

    public Integer getGroupsUpdated() {
        return groupsUpdated;
    }

    public void setGroupsUpdated(Integer groupsUpdated) {
        this.groupsUpdated = groupsUpdated;
    }

    public Integer getGroupsDeleted() {
        return groupsDeleted;
    }

    public void setGroupsDeleted(Integer groupsDeleted) {
        this.groupsDeleted = groupsDeleted;
    }

    public Integer getMenusAdded() {
        return menusAdded;
    }

    public void setMenusAdded(Integer menusAdded) {
        this.menusAdded = menusAdded;
    }

    public Integer getMenusUpdated() {
        return menusUpdated;
    }

    public void setMenusUpdated(Integer menusUpdated) {
        this.menusUpdated = menusUpdated;
    }

    public Integer getMenusDeleted() {
        return menusDeleted;
    }

    public void setMenusDeleted(Integer menusDeleted) {
        this.menusDeleted = menusDeleted;
    }
}
