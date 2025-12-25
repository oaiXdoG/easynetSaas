package com.easynet.saas.protocol;

import com.easynet.saas.protocol.dto.MenuGroupDTO;
import com.easynet.saas.protocol.dto.MenuItemDTO;

import java.util.List;

/**
 * 同步菜单请求（超管）
 */
public class SyncMenusRequest {
    private List<MenuGroupDTO> groups;
    private List<MenuItemDTO> menus;

    public List<MenuGroupDTO> getGroups() {
        return groups;
    }

    public void setGroups(List<MenuGroupDTO> groups) {
        this.groups = groups;
    }

    public List<MenuItemDTO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuItemDTO> menus) {
        this.menus = menus;
    }
}
