package com.ics.admin.Models;

public class SubMenuPermissions {

    String  permission_id;
    String  submenu;
    String  menu_name ;

    public String getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(String permission_id) {
        this.permission_id = permission_id;
    }

    public String getMenu_id() {
        return submenu;
    }

    public void setMenu_id(String submenu) {
        this.submenu = submenu;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public SubMenuPermissions(String permission_id, String submenu) {
        this.permission_id = permission_id;
        this.submenu = submenu;

    }
}
