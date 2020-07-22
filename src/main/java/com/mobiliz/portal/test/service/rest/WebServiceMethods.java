package com.mobiliz.portal.test.service.rest;

import com.mobiliz.portal.DB.DBQueries;
import com.mobiliz.portal.test.ui.base.BasePage;
import com.mobiliz.portal.test.ui.base.BaseTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;

import com.mobiliz.portal.test.service.resource.Resources;
import org.json.JSONArray;
import org.json.JSONObject;

import com.jayway.restassured.response.ValidatableResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.jayway.restassured.RestAssured.given;


public class WebServiceMethods extends BaseTest {


    protected BasePage basePage;


    DBQueries dbQueries;

    public WebServiceMethods() {
        //TODO : DBQueries class ından iki farklı instance tanımlancak
        //TODO : ilk instance (dbQueries_eMOVE_TEST) DBQueries class ının MS SQL Server - TEST connection lı construction a sahip halinden türetilecek
        //TODO : ikinci instance (dbQueries_sessiondb) DBQueries class ının sessiondb connection lı construction a sahip halinden türetilecek
        dbQueries = new DBQueries();
        basePage = new BasePage(driver);
    }

    public void get_Vehicle_Reports_Summary_2Parameters(String mobilizToken) {


        String servicePath = Resources.SERVICEHOST + "rs/vehicle-reports/summary/";
        servicePath = servicePath + "?metadata="
                + Resources.VEHICLE_REPORTS_SUMMARY_PARAM_metadata + "&ui-metadata="
                + Resources.VEHICLE_REPORTS_SUMMARY_PARAM_ui_metadata;

        ValidatableResponse validatableResponse = given()
                .contentType(APPLICATION_JSON.toString())
                .header("Mobiliz-Token", mobilizToken)
                .get(servicePath).then().statusCode(200)
                .body("success", equalTo(Resources.VEHICLE_REPORTS_SUMMARY_BODYASSERTION_success));

        //String responseBodyAsJsonString = validatableResponse.extract().response().body().asString();
        //JSONObject jsonOb = new JSONObject(responseBodyAsJsonString);
        //System.out.println(jsonOb.getJSONObject("result").getJSONObject("configuration").getJSONArray("customTimeIntervalTypes").getString(0));

    }

    public void post_Vehicle_Reports_Summary_2Parameters(String mobilizToken, String startDate, String endDate, JSONArray jsonArray) {


        String servicePath = Resources.SERVICEHOST + "rs/vehicle-reports/summary/";
        JSONObject jsonObj = new JSONObject()
                .put("destinationMuList", jsonArray)
                .put("startDate", startDate)
                .put("endDate", endDate)
                .put("sendEmailToMe", false)
                .put("cronExpression", "asap")
                .put("notify", false)
                .put("locale", "tr_TR")
                .put("sendEmail", true)
                .put("validUntil", "2018-08-10T08:22:49.616Z")
                .put("reportFormat", "xlsx");
        ValidatableResponse validatableResponse = given().contentType("application/json")
                .header("Mobiliz-Token", mobilizToken)
                .body(jsonObj.toString())
                .post(servicePath).then().statusCode(200).body("type", equalTo("SUCCESS"));

        String responseBodyAsJsonString = validatableResponse.extract().response().body().asString();
        System.out.println(responseBodyAsJsonString);
    }

    public void post_Vehicle_Reports_Summary_Instant_2Parameters(String startDate, String endDate) {

        String servicePath = Resources.SERVICEHOST + "rs/vehicle-reports/summary/instant";

        JSONObject jsonObj = new JSONObject()
                .put("startDate", startDate)
                .put("endDate", endDate);

        ValidatableResponse validatableResponse = given().contentType("application/json")
                .header("Mobiliz-Token", Resources.ELGIN_NAKLIYAT_ClientApp_Token)
                .body(jsonObj.toString())
                .post(servicePath).then().statusCode(200)
                .body("type", equalTo(Resources.ACTIVITY_SUMMARY_INSTANT_BODYASSERTION_type));

        //String responseBodyAsJsonString = validatableResponse.extract().response().body().asString();
        //System.out.println(responseBodyAsJsonString);
    }

    public String post_Login_UserLogin_2Parameters() {
        String servicePath = Resources.SERVICEHOST + "sso/login/userLogin";

        JSONObject jsonObj = new JSONObject()
                .put("userName", Resources.username_UDSY)
                .put("password", Resources.password_UDSY);

        ValidatableResponse validatableResponse = given().contentType("application/json")
                .header("Mobiliz-App-Token", Resources.Public_UI_Token)
                .header("Mobiliz-User-Language", Resources.LOGIN_USERLOGIN_Mobiliz_User_Language)
                .body(jsonObj.toString())
                .post(servicePath).then().statusCode(200)
                .body("type", equalTo(Resources.LOGIN_USERLOGIN_BODYASSERTION_type))
                .body("success", equalTo(true));

        String responseBodyAsJsonString = validatableResponse.extract().response().body().asString();
        JSONObject jsonObject = new JSONObject(responseBodyAsJsonString);
        String user_token = jsonObject.getJSONObject("result").get("token").toString();

        return user_token;

    }
    //System.out.println(jsonOb.getJSONObject("result").getJSONObject("configuration").getJSONArray("customTimeIntervalTypes").getString(0));

    public int get_DataCount_From_TableReportRequests(String startDate, String endDate) {

        int counter = 0;

        try {

            //while (counter == 0) {
            counter = dbQueries.get_Data_From_ReportRequests(startDate, endDate);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }
        return counter;
    }


    public JSONArray get_MobileUnits_From_ViewVMOBILEUNIT() {

        JSONArray jsonArray = new JSONArray();

        try {

            jsonArray = dbQueries.get_MobileUnits_From_ViewVMOBILEUNIT("Elgin");

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }

        return jsonArray;
    }


    public ArrayList<Map> getData_From_OUTBOUND(int MUID) {

        ArrayList<Map> map = new ArrayList<Map>();

        try {

            map = dbQueries.get_Data_From_OUTBOUND(MUID);

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }

        return map;
    }

    public ArrayList<Map> getData_From_Table_OUTBOUNDLOG(int MUID) {

        ArrayList<Map> map = new ArrayList<Map>();

        try {

            map = dbQueries.get_Data_From_OUTBOUNDLOG(MUID);

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }

        return map;
    }

    public ArrayList<Map> getData_From_PROGRAMMINGQUEUE() {

        ArrayList<Map> map = new ArrayList<Map>();

        try {

            map = dbQueries.get_Data_From_PROGRAMMINGQUEUE();

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }

        return map;
    }

    public ArrayList<Map> getData_From_Table_PROGRAMMINGQUEUELOG(int MUID) {

        ArrayList<Map> map = new ArrayList<Map>();

        try {

            map = dbQueries.get_Data_From_PROGRAMMINGQUEUELOG(MUID);

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }

        return map;
    }

    public ArrayList<Map> getData_From_MUMONITORINGPROGRAMS(int MUID) {

        ArrayList<Map> map = new ArrayList<Map>();

        try {

            map = dbQueries.get_Data_From_MUMONITORINGPROGRAMS(MUID);

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }

        return map;


    }

    public ArrayList<Map> getData_From_Table_MUMONITORINGPROGRAMS_LOG(int MUID) {

        ArrayList<Map> map = new ArrayList<Map>();

        try {

            map = dbQueries.get_Data_From_MUMONITORINGPROGRAMS_LOG(MUID);

        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }

        return map;

    }


    //region DELETE METHODS
    public int deleteData_From_OUTBOUND(int MUID) {

        int HowManyRowDeleted = 0;
        try {

            HowManyRowDeleted = dbQueries.delete_Data_From_OUTBOUND(MUID);


        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }

        return HowManyRowDeleted;

    }

    public int deleteData_From_OUTBOUNDLOG(int MUID) {
        int HowManyRowDeleted = 0;

        try {
            HowManyRowDeleted = dbQueries.delete_Data_From_OUTBOUNDLOG(MUID);


        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }

        return HowManyRowDeleted;
    }

    public int deleteData_From_PROGRAMMINGQUEUE() {


        int howManyRowDeleted = 0;
        try {
            howManyRowDeleted = dbQueries.delete_Data_From_PROGRAMMINGQUEUE();


        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }

        return howManyRowDeleted;
    }


    public int deleteData_From_PROGRAMMINGQUEUE_LOG(int OUTBOUNDID) {


        int howManyRowDeleted = 0;
        try {
            howManyRowDeleted = dbQueries.delete_Data_From_PROGRAMMINGQUEUE_LOG(OUTBOUNDID);


        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }

        return howManyRowDeleted;


    }


    public int deleteData_From_MUMONITORINGPROGRAMS(int MUID) {

        int howManyRowDeleted = 0;
        try {
            howManyRowDeleted = dbQueries.delete_Data_From_MUMONITORINGPROGRAMS(MUID);


        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }

        return howManyRowDeleted;
    }


    public int deleteData_From_MUMONITORINGPROGRAMS_LOG(int MUID) {
        int howManyRowDeleted = 0;
        try {
            howManyRowDeleted = dbQueries.delete_Data_From_MUMONITORINGPROGRAMS_LOG(MUID);


        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {
            if (dbQueries != null) {
                dbQueries.close();
            }
        }

        return howManyRowDeleted;
    }
    //endregion

    /**
     * This method returns a number between 0 and (n-1)
     */
    public int giveMeRandomNumber(int n) {

        Random rand = new Random();
        return rand.nextInt(n);

    }

    public Boolean IsElementAvailableInJsonArray(JSONArray jsonArray, String element) {

        Boolean doesExist = false;

        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.get(i).equals(element)) {
                doesExist = true;
            }
        }

        return doesExist;
    }

    public JSONArray composeRandomMuIDList(JSONArray jsonArray) {

        JSONArray randomJSONMuIDList = new JSONArray();
        int sizeOfForLoop = 1 + giveMeRandomNumber(jsonArray.length());

        for (int i = 0; i < sizeOfForLoop; i++) {
            int randomItemIndex = giveMeRandomNumber(jsonArray.length());
            if (!IsElementAvailableInJsonArray(randomJSONMuIDList, jsonArray.get(randomItemIndex).toString())) {
                randomJSONMuIDList.put(jsonArray.get(randomItemIndex));
            }
        }
        return randomJSONMuIDList;
    }

}
