package com.mobiliz.portal.test.ui.common;

public enum MenuItems {


    GOSTERGELER("Göstergeler","main-menu-item--dashboard"),
    TAKIP("Takip","main-menu-item--tracking"),
    YONETIM("Yönetim","main-menu-item--management"),
    UST_DUZEY_YONETIM("Üst DÜzey Yönetim","main-menu-item--admin"),
    RAPORLAR("Raporlar","main-menu-item--reports"),
    BILDIRIM("Bildirim","main-menu-item--notifications"),
    MESAJLAR("Mesajlar","main-menu-item--messages"),
    DESTEK("Destek","main-menu-item--support");

    public String Tanim;
    public String Attribute_ID;

    MenuItems(String menuItemDef,String menuItemIDAttribute) {

        this.Tanim = menuItemDef;
        this.Attribute_ID = menuItemIDAttribute;
    }

    public String getTanim()
    {
        return Tanim;
    }

    public String getAttribute_ID()
    {
        return Attribute_ID;
    }



}

