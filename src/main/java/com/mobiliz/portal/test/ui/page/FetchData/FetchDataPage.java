package com.mobiliz.portal.test.ui.page.FetchData;

import com.mobiliz.portal.test.service.rest.WebServiceMethods;
import com.mobiliz.portal.test.ui.base.BasePage;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.log4j.helpers.OptionConverter;
import org.hamcrest.core.Is;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;

public class FetchDataPage extends BasePage {


    public FetchDataPage() {
        super();
    }

    WebServiceMethods webServiceMethods = new WebServiceMethods();

    public int get_OUTBOUNDID_From_OUTBOUNDLOG(int MUID) {

        int OUTBOUNDID = 0;

        ArrayList<Map> arrayList = webServiceMethods.getData_From_Table_OUTBOUNDLOG(MUID);
        if (arrayList.size() != 0) {

            OUTBOUNDID = (Integer) arrayList.get(0).get("OUTBOUNDID");
        }

        return OUTBOUNDID;
    }


    public void fetch_DataAndPrint_From_OUTBOUND(int MUID) {

        ArrayList<Map> arrayList = webServiceMethods.getData_From_OUTBOUND(MUID);

        System.out.println("OUTBOUND : ");

        for (Map map : arrayList) {

            System.out.println(map);
        }

        System.out.println();

    }

    public void fetch_DataAndPrint_From_OUTBOUNDLOG(int MUID) {

        ArrayList<Map> arrayList = webServiceMethods.getData_From_Table_OUTBOUNDLOG(MUID);

        System.out.println("OUTBOUNDLOG : ");

        for (Map map : arrayList) {

            System.out.println(map);
        }

        System.out.println();

    }

    public void fetch_DataAndPrint_From_PROGRAMMINGQUEUE() {

        ArrayList<Map> arrayList = webServiceMethods.getData_From_PROGRAMMINGQUEUE();

        System.out.println("PROGRAMMINGQUEUE : ");

        for (Map map : arrayList) {

            System.out.println(map);

        }

        System.out.println();
    }

    public void fetch_DataAndPrint_From_PROGRAMMINGQUEUELOG(int MUID) {

        ArrayList<Map> arrayList = webServiceMethods.getData_From_Table_PROGRAMMINGQUEUELOG(MUID);

        System.out.println("PROGRAMMINGQUEUELOG : ");

        for (Map map : arrayList) {

            System.out.println(map);

        }

        System.out.println();
    }

    public void fetch_DataAndPrint_From_MUMONITORINGPROGRAMS(int MUID) {

        ArrayList<Map> arrayList = webServiceMethods.getData_From_MUMONITORINGPROGRAMS(MUID);

        System.out.println("MUMONITORINGPROGRAMS  : ");

        for (Map map : arrayList) {

            System.out.println(map);

        }

        System.out.println();
    }

    public void fetch_DataAndPrint_From_MUMONITORINGPROGRAMS_LOG(int MUID) {


        ArrayList<Map> arrayList = webServiceMethods.getData_From_Table_MUMONITORINGPROGRAMS_LOG(MUID);

        System.out.println("MUMONITORINGPROGRAMS_LOG  : ");

        for (Map map : arrayList) {

            System.out.println(map);

        }

        System.out.println();
    }


    //region DELETE METHODS
    public void delete_Data_From_OUTBOUND(int MUID) {

        int HowManyRowDeleted = webServiceMethods.deleteData_From_OUTBOUND(MUID);

        System.out.println("How many rows deleted in OUTBOUND ? : " + HowManyRowDeleted);

        System.out.println();
    }

    public void delete_Data_From_OUTBOUNDLOG(int MUID) {

        int HowManyRowDeleted = webServiceMethods.deleteData_From_OUTBOUNDLOG(MUID);

        System.out.println("How many rows deleted in OUTBOUNDLOG ? : " + HowManyRowDeleted);

        System.out.println();
    }

    public void delete_Data_From_PROGRAMMINGQUEUE() {

        int howManyRowDeleted = webServiceMethods.deleteData_From_PROGRAMMINGQUEUE();

        System.out.println("How many rows deleted in PROGRAMMINGQUEUE? : " + howManyRowDeleted);

        System.out.println();
    }

    public void delete_Data_From_PROGRAMMINGQUEUE_LOG(int OUTBOUNDID) {

        int howManyRowDeleted = webServiceMethods.deleteData_From_PROGRAMMINGQUEUE_LOG(OUTBOUNDID);

        System.out.println("How many rows deleted in PROGRAMMINGQUEUELOG ? : " + howManyRowDeleted + "  OUTBOUNDID : " + OUTBOUNDID);

        System.out.println();
    }

    public void delete_Data_From_MUMONITORINGPROGRAMS(int MUID) {
        int howManyRowDeleted = webServiceMethods.deleteData_From_MUMONITORINGPROGRAMS(MUID);

        System.out.println("How many rows deleted in MUMONITORINGPROGRAMS ? : " + howManyRowDeleted);

        System.out.println();
    }


    public void delete_Data_From_MUMONITORINGPROGRAMS_LOG(int MUID) {
        int howManyRowDeleted = webServiceMethods.deleteData_From_MUMONITORINGPROGRAMS_LOG(MUID);

        System.out.println("How many rows deleted in MUMONITORINGPROGRAMS_LOG ? : " + howManyRowDeleted);

        System.out.println();
    }
    //endregion

}

