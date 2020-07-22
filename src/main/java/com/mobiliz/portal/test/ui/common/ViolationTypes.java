package com.mobiliz.portal.test.ui.common;

public enum ViolationTypes {

    ASIRI_HIZ_LIMITI_IHLALI("Aşırı Hız Limiti İhlali", 0);

    public String Tanim;
    public int Value;

    ViolationTypes(String tanim, Integer value)
    {
        this.Tanim = tanim;
        this.Value = value;
    }
/*
* 0	Asiri Hiz Limiti Ihlali
1	Günlük Azami Durma Süresi Ihlali
2	Anlik Azami Durma Süresi Ihlali
3	Günlük Azami Hareket Süresi Ihlali
4	Günlük Azami Rölanti Süresi Ihlali
5	Anlik Azami Rölanti Süresi Ihlali
6	Ise Baslama Zamani Ihlali
8	Günlük Azami Sürücü Sayisi Ihlali
9	Alan Içi Sinirlamasi Ihlali
10	Alan Disi Sinirlamasi Ihlali
11	WayPoint Ihlali
12	Kontak Kapali Iken Hareket Ihlali
13	Kontak Kapali Iken Hiz Ihlali
14	Ani yavaşlama ihlali
15	Ani Yön Değişimi İhlali (Kaza İhtimali)
16	Kapi Açilma Ihlali
17	Genel Giris Aktif Ihlali
18	Acil Çagri Butonu Aktif Ihlali
19	Yol Riski Hiz Ihlali
20	Yerleşim Dışı Yol Hız İhlali
21	Yerleşim İçi Yol Hız İhlali
22	Yüksek Sicaklik Ihlali
23	Düsük Sicaklik Ihlali
24	Yüksek Yakit Seviyesi Ihlali
25	Düsük Yakit Seviyesi Ihlali
26	Araç Kapali Alanda
27	Anlik Hizlanma Ihlali
28	Rota Ihlali
29	Yüksek Sicaklik (II) Ihlali
30	Düsük Sicaklik (II) Ihlali
31	Input A Girisi Aktif Ihlali
32	Input A Girisi Aktif Degil Ihlali
33	Input B Girisi Aktif Ihlali
34	Input B Girisi Aktif Degil Ihlali
35	Genel Giris Aktif Degil Ihlali
36	Acil Giris Aktif Degil Ihlali
37	Mesajlasma Terminali Bagli Degil Ihlali
38	Ana Guc Dusuk Ihlali
39	Ana Guc Bagli Degil Ihlali
40	EMap Rota Dışı İhlali
41	EMap Alan Dışı Ihlali
42	Modüler Sensör Ihlali
43	Ana Guc Bagli Ihlali
44	Haftasonu Ise Baslama Zamani Ihlali
45	Haftasonu Is Birakma Zamani Ihlali
46	Güzergah Hız İhlali
47	Mesai Dışı Çalışma İhlali
48	Haftasonu Çalışma İhlali
49	Ani Yakıt Düşüş İhlali
50	Yüksek Devir İhlali
51	Düşük Devir İhlali
52	Yüksek Nem İhlali
53	Düşük Nem İhlali
54	Yüksek Yakıt İhlali
55	Düşük Yakıt İhlali
56	EMap Rota İçi İhlali
57	EMap Alan İçi İhlali
58	Düsük AdBlue Seviyesi Ihlali (Yol Bilgisayari)
59	AdBlue Seviyesi Degisim Ihlali (%) (Yol Bilgisayari)
60	Düşük Akü Voltaj Durumu Ihlali (Yol Bilgisayari)
61	Yüksek Akü Voltaj Durumu Ihlali (Yol Bilgisayari)
62	Yüksek Emme Manifold Sicakligi Ihlali (Yol Bilgisayari)
63	Düsük Hararet Ihlali (Yol Bilgisayari)
64	Yüksek Hararet Ihlali (Yol Bilgisayari)
65	Yüksek Hiz Ihlali (Yol Bilgisayari)
66	Düsük Motor Devri Ihlali (Yol Bilgisayari)
67	Yüksek Motor Devri Ihlali (Yol Bilgisayari)
68	Yüksek Yag Basinci Ihlali (Yol Bilgisayari)
69	Düsük Yag Seviyesi Ihlali (Yol Bilgisayari)
70	Yag Seviyesi Degisim Ihlali (%) (Yol Bilgisayari)
71	Düsük Yag Sicakligi Ihlali (Yol Bilgisayari)
72	Yüksek Yag Sicakligi Ihlali (Yol Bilgisayari)
73	Düsük Yakit Seviyesi Ihlali (Yol Bilgisayari)
74	Yakit Seviyesi Degisim Ihlali (Yol Bilgisayari)
75	Düsük Yakit Sicakligi Ihlali (Yol Bilgisayari)
76	Yüksek Yakit Sicakligi Ihlali (Yol Bilgisayari)
77	Yüksek Takviye Basinci ihlali (Yol Bilgisayari)
78	Düşük Ortam Sıcaklığı ihlali (Yol Bilgisayari)
79	Yüksek Ortam Sıcaklığı ihlali (Yol Bilgisayari)
80	Ardışık iki Km. Arasındaki Fark ihlali (Yol Bilgisayari)
81	Düşük Dijital Sıcaklık İhlali (Modüler Sensör)
82	Yüksek Dijital Sıcaklık İhlali (Modüler Sensör)
83	Düşük Dijital Nem İhlali (Modüler Sensör)
84	Yüksek Dijital Nem İhlali (Modüler Sensör)
85	Düşük 2.Dijital Sıcaklık İhlali (Modüler Sensör)
86	Yüksek 2.Dijital Sıcaklık İhlali (Modüler Sensör)
87	Düşük 3.Dijital Sıcaklık İhlali (Modüler Sensör)
88	Yüksek 3.Dijital Sıcaklık İhlali (Modüler Sensör)
89	Düşük 4.Dijital Sıcaklık İhlali (Modüler Sensör)
90	Yüksek 4.Dijital Sıcaklık İhlali (Modüler Sensör)
91	Yüksek Tekerlek Hızı İhlali (Modüler Sensör)
92	Yüksek Gaz Pedalı İhlali (Modüler Sensör)
93	Yüksek Motor Yükü İhlali (Modüler Sensör)
94	Yakıt Seviyesi Değişim İhlali (%) (Modüler Sensör)
95	Düşük Yakıt Seviyesi İhlali (Modüler Sensör)
96	Düşük Motor Devri İhlali (Modüler Sensör)
97	Yüksek Motor Devri İhlali (Modüler Sensör)
98	Mesafe Sayacı İhlali (Modüler Sensör)
99	Düsük Hararet Ihlali (Modüler Sensör)
100	Yüksek Hararet Ihlali (Modüler Sensör)
101	Rölantideki Yakıt Tüketimi İhlali (Modüler Sensör)
102	Düşük Yağ Sıcaklığı İhlali (Modüler Sensör)
103	Yüksek Yağ Sıcaklığı İhlali (Modüler Sensör)
104	Adblue Seviyesi Değişim İhlali (%) (Modüler Sensör)
105	Düşük Adblue Seviyesi İhlali (Modüler Sensör)
106	Düşük 1.Sıcaklık Sensörü İhlali (Modüler Sensör)
107	Yüksek 1.Sıcaklık Sensörü İhlali (Modüler Sensör)
108	Düşük 2.Sıcaklık Sensörü İhlali (Modüler Sensör)
109	Yüksek 2.Sıcaklık Sensörü İhlali (Modüler Sensör)
110	Düşük 3.Sıcaklık Sensörü İhlali (Modüler Sensör)
111	Yüksek 3.Sıcaklık Sensörü İhlali (Modüler Sensör)
112	Ortem Yakıt Seviyesi Değişim İhlali (%) (Modüler Sensör)
113	Düşük Ortem Yakıt Seviyesi İhlali (Modüler Sensör)
114	Sürücü Aralıksız Çalışma Süresi İhlali
115	Sürücü Mesai Süresi İhlali
116	Sürücü Dinlenme Süresi Erken Bitirme İhlali
117	Sürücü Olmaksızın Hareket
118	Gsm Bağlantı Kopuk İhlali
119	Motor Yükü Yüksek İhlali (Yol Bilgisayar\u0131)
120	Motor Yükü Değişim İhlali (%) (Yol Bilgisayarı)
121	Yakıt Seviye Lamba İhlali (Yol Bilgisayarı)
122	Düşük 4.Sıcaklık Sensörü İhlali (Modüler Sensör)
123	Yüksek 4.Sıcaklık Sensörü İhlali (Modüler Sensör)
124	Düşük 5.Sıcaklık Sensörü İhlali (Modüler Sensör)
125	Yüksek 5.Sıcaklık Sensörü İhlali (Modüler Sensör)
126	Düşük 6.Sıcaklık Sensörü İhlali (Modüler Sensör)
127	Yüksek 6.Sıcaklık Sensörü İhlali (Modüler Sensör)
128	Düşük 7.Sıcaklık Sensörü İhlali (Modüler Sensör)
129	Yüksek 7.Sıcaklık Sensörü İhlali (Modüler Sensör)
130	Yakıt Seviyesi Değişim İhlali (%) (Modüler Sensör 2)
131	Düşük Yakıt Seviyesi İhlali (Modüler Sensör 2)
132	Yakıt Seviyesi Değişim İhlali (%) (Modüler Sensör 3)
133	Düşük Yakıt Seviyesi İhlali (Modüler Sensör 3)
134	Kontrol Mesajı Gecikme İhlali
135	Ani Yavaşlama İhlali (Kaza ihtimali)
136	Ani Hızlanma İhlali (Kaza ihtimali)
137	Durak Zamanı Erken İhlali
138	Bekleme Süresi Erken İhlali
139	Durak Zamanı Geç İhlali
140	Bekleme Süresi Geç İhlali
142	Hatalı Şerit Değiştirme (Sağ) İhlali
143	Hatalı Şerit Değiştirme (Sol) İhlali
144	Öndeki Araca Tehlikeli Yaklaşım İhlali
145	Öndeki Yayaya Tehlikeli Yaklaşım İhlali
146	Takip Mesafesi İhlali
147	Ani Fren ve Dönüş İhlali
148	Ani Fren ve Dönüş İhlali (Kaza ihtimali)
149	Ani Hızlanma ve Dönüş İhlali
150	Ani Hızlanma ve Dönüş İhlali (Kaza ihtimali)
151	Yakit Seviyesi Azalma Ihlali (LT) (Yol Bilgisayari)
152	Yakit Seviyesi Artma Ihlali (LT) (Yol Bilgisayari)
153	Yakit Seviyesi Azalma Ihlali (%) (Yol Bilgisayari)
154	Yakit Seviyesi Artma Ihlali (%) (Yol Bilgisayari)2	Anlik Azami Durma Süresi Ihlali
3	Günlük Azami Hareket Süresi Ihlali
4	Günlük Azami Rölanti Süresi Ihlali
5	Anlik Azami Rölanti Süresi Ihlali
6	Ise Baslama Zamani Ihlali
8	Günlük Azami Sürücü Sayisi Ihlali
9	Alan Içi Sinirlamasi Ihlali
10	Alan Disi Sinirlamasi Ihlali
11	WayPoint Ihlali
12	Kontak Kapali Iken Hareket Ihlali
13	Kontak Kapali Iken Hiz Ihlali
14	Ani yavaşlama ihlali
15	Ani Yön Değişimi İhlali (Kaza İhtimali)
16	Kapi Açilma Ihlali
17	Genel Giris Aktif Ihlali
18	Acil Çagri Butonu Aktif Ihlali
19	Yol Riski Hiz Ihlali
20	Yerleşim Dışı Yol Hız İhlali
21	Yerleşim İçi Yol Hız İhlali
22	Yüksek Sicaklik Ihlali
23	Düsük Sicaklik Ihlali
24	Yüksek Yakit Seviyesi Ihlali
25	Düsük Yakit Seviyesi Ihlali
26	Araç Kapali Alanda
27	Anlik Hizlanma Ihlali
28	Rota Ihlali
29	Yüksek Sicaklik (II) Ihlali
30	Düsük Sicaklik (II) Ihlali
31	Input A Girisi Aktif Ihlali
32	Input A Girisi Aktif Degil Ihlali
33	Input B Girisi Aktif Ihlali
34	Input B Girisi Aktif Degil Ihlali
35	Genel Giris Aktif Degil Ihlali
36	Acil Giris Aktif Degil Ihlali
37	Mesajlasma Terminali Bagli Degil Ihlali
38	Ana Guc Dusuk Ihlali
39	Ana Guc Bagli Degil Ihlali
40	EMap Rota Dışı İhlali
41	EMap Alan Dışı Ihlali
42	Modüler Sensör Ihlali
43	Ana Guc Bagli Ihlali
44	Haftasonu Ise Baslama Zamani Ihlali
45	Haftasonu Is Birakma Zamani Ihlali
46	Güzergah Hız İhlali
47	Mesai Dışı Çalışma İhlali
48	Haftasonu Çalışma İhlali
49	Ani Yakıt Düşüş İhlali
50	Yüksek Devir İhlali
51	Düşük Devir İhlali
52	Yüksek Nem İhlali
53	Düşük Nem İhlali
54	Yüksek Yakıt İhlali
55	Düşük Yakıt İhlali
56	EMap Rota İçi İhlali
57	EMap Alan İçi İhlali
58	Düsük AdBlue Seviyesi Ihlali (Yol Bilgisayari)
59	AdBlue Seviyesi Degisim Ihlali (%) (Yol Bilgisayari)
60	Düşük Akü Voltaj Durumu Ihlali (Yol Bilgisayari)
61	Yüksek Akü Voltaj Durumu Ihlali (Yol Bilgisayari)
62	Yüksek Emme Manifold Sicakligi Ihlali (Yol Bilgisayari)
63	Düsük Hararet Ihlali (Yol Bilgisayari)
64	Yüksek Hararet Ihlali (Yol Bilgisayari)
65	Yüksek Hiz Ihlali (Yol Bilgisayari)
66	Düsük Motor Devri Ihlali (Yol Bilgisayari)
67	Yüksek Motor Devri Ihlali (Yol Bilgisayari)
68	Yüksek Yag Basinci Ihlali (Yol Bilgisayari)
69	Düsük Yag Seviyesi Ihlali (Yol Bilgisayari)
70	Yag Seviyesi Degisim Ihlali (%) (Yol Bilgisayari)
71	Düsük Yag Sicakligi Ihlali (Yol Bilgisayari)
72	Yüksek Yag Sicakligi Ihlali (Yol Bilgisayari)
73	Düsük Yakit Seviyesi Ihlali (Yol Bilgisayari)
74	Yakit Seviyesi Degisim Ihlali (Yol Bilgisayari)
75	Düsük Yakit Sicakligi Ihlali (Yol Bilgisayari)
76	Yüksek Yakit Sicakligi Ihlali (Yol Bilgisayari)
77	Yüksek Takviye Basinci ihlali (Yol Bilgisayari)
78	Düşük Ortam Sıcaklığı ihlali (Yol Bilgisayari)
79	Yüksek Ortam Sıcaklığı ihlali (Yol Bilgisayari)
80	Ardışık iki Km. Arasındaki Fark ihlali (Yol Bilgisayari)
81	Düşük Dijital Sıcaklık İhlali (Modüler Sensör)
82	Yüksek Dijital Sıcaklık İhlali (Modüler Sensör)
83	Düşük Dijital Nem İhlali (Modüler Sensör)
84	Yüksek Dijital Nem İhlali (Modüler Sensör)
85	Düşük 2.Dijital Sıcaklık İhlali (Modüler Sensör)
86	Yüksek 2.Dijital Sıcaklık İhlali (Modüler Sensör)
87	Düşük 3.Dijital Sıcaklık İhlali (Modüler Sensör)
88	Yüksek 3.Dijital Sıcaklık İhlali (Modüler Sensör)
89	Düşük 4.Dijital Sıcaklık İhlali (Modüler Sensör)
90	Yüksek 4.Dijital Sıcaklık İhlali (Modüler Sensör)
91	Yüksek Tekerlek Hızı İhlali (Modüler Sensör)
92	Yüksek Gaz Pedalı İhlali (Modüler Sensör)
93	Yüksek Motor Yükü İhlali (Modüler Sensör)
94	Yakıt Seviyesi Değişim İhlali (%) (Modüler Sensör)
95	Düşük Yakıt Seviyesi İhlali (Modüler Sensör)
96	Düşük Motor Devri İhlali (Modüler Sensör)
97	Yüksek Motor Devri İhlali (Modüler Sensör)
98	Mesafe Sayacı İhlali (Modüler Sensör)
99	Düsük Hararet Ihlali (Modüler Sensör)
100	Yüksek Hararet Ihlali (Modüler Sensör)
101	Rölantideki Yakıt Tüketimi İhlali (Modüler Sensör)
102	Düşük Yağ Sıcaklığı İhlali (Modüler Sensör)
103	Yüksek Yağ Sıcaklığı İhlali (Modüler Sensör)
104	Adblue Seviyesi Değişim İhlali (%) (Modüler Sensör)
105	Düşük Adblue Seviyesi İhlali (Modüler Sensör)
106	Düşük 1.Sıcaklık Sensörü İhlali (Modüler Sensör)
107	Yüksek 1.Sıcaklık Sensörü İhlali (Modüler Sensör)
108	Düşük 2.Sıcaklık Sensörü İhlali (Modüler Sensör)
109	Yüksek 2.Sıcaklık Sensörü İhlali (Modüler Sensör)
110	Düşük 3.Sıcaklık Sensörü İhlali (Modüler Sensör)
111	Yüksek 3.Sıcaklık Sensörü İhlali (Modüler Sensör)
112	Ortem Yakıt Seviyesi Değişim İhlali (%) (Modüler Sensör)
113	Düşük Ortem Yakıt Seviyesi İhlali (Modüler Sensör)
114	Sürücü Aralıksız Çalışma Süresi İhlali
115	Sürücü Mesai Süresi İhlali
116	Sürücü Dinlenme Süresi Erken Bitirme İhlali
117	Sürücü Olmaksızın Hareket
118	Gsm Bağlantı Kopuk İhlali
119	Motor Yükü Yüksek İhlali (Yol Bilgisayar\u0131)
120	Motor Yükü Değişim İhlali (%) (Yol Bilgisayarı)
121	Yakıt Seviye Lamba İhlali (Yol Bilgisayarı)
122	Düşük 4.Sıcaklık Sensörü İhlali (Modüler Sensör)
123	Yüksek 4.Sıcaklık Sensörü İhlali (Modüler Sensör)
124	Düşük 5.Sıcaklık Sensörü İhlali (Modüler Sensör)
125	Yüksek 5.Sıcaklık Sensörü İhlali (Modüler Sensör)
126	Düşük 6.Sıcaklık Sensörü İhlali (Modüler Sensör)
127	Yüksek 6.Sıcaklık Sensörü İhlali (Modüler Sensör)
128	Düşük 7.Sıcaklık Sensörü İhlali (Modüler Sensör)
129	Yüksek 7.Sıcaklık Sensörü İhlali (Modüler Sensör)
130	Yakıt Seviyesi Değişim İhlali (%) (Modüler Sensör 2)
131	Düşük Yakıt Seviyesi İhlali (Modüler Sensör 2)
132	Yakıt Seviyesi Değişim İhlali (%) (Modüler Sensör 3)
133	Düşük Yakıt Seviyesi İhlali (Modüler Sensör 3)
134	Kontrol Mesajı Gecikme İhlali
135	Ani Yavaşlama İhlali (Kaza ihtimali)
136	Ani Hızlanma İhlali (Kaza ihtimali)
137	Durak Zamanı Erken İhlali
138	Bekleme Süresi Erken İhlali
139	Durak Zamanı Geç İhlali
140	Bekleme Süresi Geç İhlali
142	Hatalı Şerit Değiştirme (Sağ) İhlali
143	Hatalı Şerit Değiştirme (Sol) İhlali
144	Öndeki Araca Tehlikeli Yaklaşım İhlali
145	Öndeki Yayaya Tehlikeli Yaklaşım İhlali
146	Takip Mesafesi İhlali
147	Ani Fren ve Dönüş İhlali
148	Ani Fren ve Dönüş İhlali (Kaza ihtimali)
149	Ani Hızlanma ve Dönüş İhlali
150	Ani Hızlanma ve Dönüş İhlali (Kaza ihtimali)
151	Yakit Seviyesi Azalma Ihlali (LT) (Yol Bilgisayari)
152	Yakit Seviyesi Artma Ihlali (LT) (Yol Bilgisayari)
153	Yakit Seviyesi Azalma Ihlali (%) (Yol Bilgisayari)
154	Yakit Seviyesi Artma Ihlali (%) (Yol Bilgisayari)*/

}
