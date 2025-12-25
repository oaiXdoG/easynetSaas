package com.easynet.saas.protocol;

/**
 * 菜单分组DTO（菜单同步用）
 */
public class MenuGroupDTO {
    private String groupCode;
    private String groupTitle;
    private Integer sortOrder;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}
