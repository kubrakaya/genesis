package com.mobiliz.portal.test.ui.testMethods.FetchData;

import com.mobiliz.portal.test.ui.common.VehicleList;
import com.mobiliz.portal.test.ui.page.FetchData.FetchDataPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FetchDataTest {

    protected FetchDataPage fetchDataPage;

    @BeforeClass
    public void setup() {

        fetchDataPage = new FetchDataPage();
    }

//İzleme Parametreleri programlamaları bilgisi getiren method
    @Test
    public void get_Data_ForVehicleMonitoringProgramDone() {

        int MUID = VehicleList.VEHICLE_753102_DT900F_POINTER.MUID;
        //int MUID = VehicleList.VEHICLE_2382515_DT465_QUECLINK.MUID;
        //int MUID = VehicleList.VEHICLE_1234321_DT900F.MUID;


        fetchDataPage.fetch_DataAndPrint_From_OUTBOUND(MUID);

        fetchDataPage.fetch_DataAndPrint_From_OUTBOUNDLOG(MUID);

        fetchDataPage.fetch_DataAndPrint_From_PROGRAMMINGQUEUE();

        fetchDataPage.fetch_DataAndPrint_From_PROGRAMMINGQUEUELOG(MUID);

        fetchDataPage.fetch_DataAndPrint_From_MUMONITORINGPROGRAMS(MUID);

        fetchDataPage.fetch_DataAndPrint_From_MUMONITORINGPROGRAMS_LOG(MUID);


    }

    //TODO : çıkış kontrolü programlamaları redis de tutuluyor. MUMONITORINGPROGRAMS tablosuna denk gelen TİPTE DATAYI, java üzerinden redis e bağlanıp,redis desktop manager kullanmadan
    //TODO : silme eklenecek
    @Test
    public void delete_Data_ForVehicleMonitoringProgramDone() {

        int MUID = VehicleList.VEHICLE_753102_DT900F_POINTER.MUID;
        //int MUID = VehicleList.VEHICLE_2382515_DT465_QUECLINK.MUID;

        //int MUID = VehicleList.VEHICLE_1234321_DT900F.MUID;


        fetchDataPage.delete_Data_From_OUTBOUND(MUID);

        int OUTBOUNDID = fetchDataPage.get_OUTBOUNDID_From_OUTBOUNDLOG(MUID);

        fetchDataPage.delete_Data_From_OUTBOUNDLOG(MUID);

        fetchDataPage.delete_Data_From_PROGRAMMINGQUEUE();

        fetchDataPage.delete_Data_From_PROGRAMMINGQUEUE_LOG(OUTBOUNDID);

        fetchDataPage.delete_Data_From_MUMONITORINGPROGRAMS(MUID);

        fetchDataPage.delete_Data_From_MUMONITORINGPROGRAMS_LOG(MUID);

    }

    //Aşırı Hız Programlama
    @Test
    public void get_Data_ForVehicleOverSpeedProgramDone()
    {

        int MUID = VehicleList.VEHICLE_753102_DT900F_POINTER.MUID;


        fetchDataPage.fetch_DataAndPrint_From_OUTBOUND(MUID);

        fetchDataPage.fetch_DataAndPrint_From_OUTBOUNDLOG(MUID);

        fetchDataPage.fetch_DataAndPrint_From_PROGRAMMINGQUEUE();

        fetchDataPage.fetch_DataAndPrint_From_PROGRAMMINGQUEUELOG(MUID);

        //TODO: Buraya MUVIOLATIONPROGRAMS ve MUVIOLATIONPROGRAMS_LOG tablolarından kayıt getiren metotlar eklenecek
    }



}
