package com.mobiliz.portal.test.ui.common;

public enum TabNames {


    //YÖNETİM --> TEMEL İŞLEVLER --> TABS

    SURUCULER("Sürücüler", ""),
    KULLANICILAR("Kullanıcılar", ""),
    SMS_TERCIHLERI("Sms Tercihleri", ""),
    PROGRAMLAMA("Programlama", ""),
    BILDIRIM_DAGITIM_TERCIHLERI("Bildirim Dağıtım Tercihleri", ""),


    // YÖNETİM --> FİLO YÖNETİMİ --> TABS

    ARAC_YETKILENDIRME("Araç Yetkilendirme", ""),
    ATS_OLMAYAN_ARACLAR("ATS Olmayan Araçlar", ""),
    TEDARIKCILER("Tedarikçiler", ""),
    SOZLESMELER("Sözleşmeler", ""),
    AKARYAKIT("Akaryakıt", ""),
    ARAC_BLGILERI("Araç Bilgileri", ""),
    SURUCU_BILGILERI("Sürücü Bilgileri", ""),
    BILDIRIM_AYARLARI("Bildirim Ayarları", ""),

    //YÖNETİM --> MOBİL GÜVENLİK HİZMETLERİ -->

    MGH_ALARM_IZLEME("Alarm İzleme", "a[ui-sref='management.mobile-security-services.alarm-monitoring']"),
    MGH_ARAC_ALARM_GECMISI("", ""),
    MGH_ARAC_OZELLIKLERI("", ""),
    MGH_SENARYOLAR("", ""),
    MGH_IZLEME_TANIMLARI("", ""),
    MGH_TEST_PLANLARI("", ""),
    MGH_ATRAQ_ENTEGRASYONU("", ""),
    MGH_ARAC_YETKILENDIRME("", "a[ui-sref='management.mobile-security-services.vehicle']"),


    // ÜST DÜZEY YÖNETİM --> TEMEL İŞLEVLER --> TABS

    ARAMA("Arama", ""),
    ARACLAR("Araçlar", ""),
    MODUL_YETKILENDIRME("Modül Yetkilendirme", ""),
    WEB_SERVIS_YETKILENDIRME("Web Servis Yetkilendirme", ""),
    EMM_ADMIN_KULLANICILARI("EMM Admin Kullanıcıları", ""),
    ZAMAMLANMIS_GOREVLER("Zamanlanmış Görevler", ""),
    DESTEK("Destek", ""),
    CSGUI("Destek", ""),


    //ÜST DÜZEY YÖNETİM --> KAMERA -->

    DVR("DVR", "");


    public String Tanim;
    public String CssSelectorDef;

    TabNames(String tanim, String cssSelectorDefinition) {

        this.Tanim = tanim;
        this.CssSelectorDef = cssSelectorDefinition;
    }


    public String getTanim() {
        return Tanim;
    }

    public String getCssSelectorDef() {
        return CssSelectorDef;

    }
}
