/*

 */

/*
 *
 */

package com.branding.middaymeal.pojo;

public class DrawerItem {
    private int drawerMenuItem;
    private String menuName;
    private boolean active;

    public int getDrawerMenuItem() {
        return drawerMenuItem;
    }

    public void setDrawerMenuItem(int drawerMenuItem) {
        this.drawerMenuItem = drawerMenuItem;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
