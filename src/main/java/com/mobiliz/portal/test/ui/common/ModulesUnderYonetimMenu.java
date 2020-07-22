package com.mobiliz.portal.test.ui.common;

public enum ModulesUnderYonetimMenu {

    TEMEL_ISLEVLER("Temel İşlevler", "a[ui-sref='management.core']"),
    HAT_OTOMASYONU_YENI("Hat Otomasyonu(Yeni)", ""),
    HAT_OTOMASYONU("Hat Otomasyonu", ""),
    SURUCUMETRE("Srücümetre", ""),
    FILO_YONETIMI("Filo Yönetimi", ""),
    IUGO("iUGO", ""),
    NFPC("NFPC", ""),
    PIXSELECT_KAMERA_ENTEGRASYONU("PixSelect Kamera Entegrasyonu", ""),
    COCUGUM_GUVENDE("Çocuğum Güvende", ""),
    YOLUM_GUVENDE("Yolum Güvende", ""),
    TAKOMETRE("Takometre", ""),
    MOBIL_GUVENLIK_HIZMETLERI("Mobil Güvenlik Hizmetleri", "a[href='#!/management/mobile-security-services']");


    public String Tanim;
    public String CssSelector;

    ModulesUnderYonetimMenu(String menuItemDef, String cssSelector) {
        this.Tanim = menuItemDef;
        this.CssSelector = cssSelector;
    }

    public String getTanim() {
        return Tanim;
    }

    public String getCssSelector() {
        return CssSelector;
    }
}
