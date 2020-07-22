package com.mobiliz.portal.test.service.test;

import com.mobiliz.portal.TestRail.UseAsTestRailId;
import com.mobiliz.portal.test.service.resource.Resources;
import com.mobiliz.portal.test.service.rest.WebServiceMethods;
import com.mobiliz.portal.test.ui.base.BasePage;
import com.mobiliz.portal.test.ui.base.BaseTest;
import com.mobiliz.portal.test.ui.testMethods.login.LoginTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.*;

@Listeners(com.mobiliz.portal.Listeners.Listener.class)
public class VehicleActivitySummaryTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);


    WebServiceMethods webServiceMethods = new WebServiceMethods();
    protected BasePage basePage;

    @BeforeClass
    public void setup() {
        basePage = new BasePage(driver);

    }

    /*Bu metot sadece UI tarafından kullanıldığı için Token parametresi userLogin servisinden
    elde edilir ve dinamik olarak sürekli değişiyor*/
    //Raporlar --> Araç Bazlı Raporlar --> Araç Aktivite Özet Raporu

    /**
     * (TESTCASEID:C7)(Report Services - UI)(GET)(2 Parameters)Check that "vehicle-reports/summary/" returns success data set
     * when entering valid values for "metadata" and "ui-metadata" parameters and valid token is entered in header
     */

    @Test
    @UseAsTestRailId(testRailCaseId = 7, testRailRunId = Resources.TestRailRunID)
    public void VerifyThat_Get_VehicleActivityReportsSummary_WorksSuccessfully() {

        logger.info("START : VerifyThat_Get_VehicleActivityReportsSummary_WorksSuccessfully");

        String user_token = webServiceMethods.post_Login_UserLogin_2Parameters();

        webServiceMethods.get_Vehicle_Reports_Summary_2Parameters(user_token);


    }

    /*Bu metot sadece UI tarafından kullanıldığı için Token parametresi userLogin servisinden
       elde edilir ve dinamik olarak sürekli değişiyor*/
    //Raporlar --> Araç Bazlı Raporlar --> Araç Aktivite Özet Raporu

    /**
     * TESTCASEID:C14)(Report Services - UI)(POST)Check that "vehicle-reports/summary/" returns data set successfully (Zaman Aralığı : Özel, Çalıştırılma Zamanı : Şimdi)
     */
    @Test(timeOut = 100000, dataProvider = "get_paramStartDate_paramEndDate_startDateInDB_endDateInDB_getRandomMuIDList")
    @UseAsTestRailId(testRailCaseId = 14, testRailRunId = Resources.TestRailRunID)
    public void VerifyThat_Post_VehicleActivityReportsSummary_WorksSuccessfully(String startDateZFormat, String endDateZFormat, String startDate_expectedInDB_SFormat, String endDate_expectedInDB_SFormat, JSONArray ramdomJSONMuIDList) {


        logger.info("START : VerifyThat_Post_VehicleActivityReportsSummary_WorksSuccessfully");

        String user_token = webServiceMethods.post_Login_UserLogin_2Parameters();

        webServiceMethods.post_Vehicle_Reports_Summary_2Parameters(user_token, startDateZFormat, endDateZFormat, ramdomJSONMuIDList);

        int countOfDataInTable = webServiceMethods.get_DataCount_From_TableReportRequests(startDate_expectedInDB_SFormat, endDate_expectedInDB_SFormat);

        System.out.println("countOfDataInTable = " + countOfDataInTable);

        Assert.assertEquals(countOfDataInTable, Resources.IsDataInsertedToTableSuccessfully);
    }

    /**
     * TestCase(C15)(Report Services - Integration)(POST) Check that "vehicle-reports/summary/instant/" returns
     * data set successfully when entering valid values for parameters
     */
    @Test
    @UseAsTestRailId(testRailCaseId = 15, testRailRunId = Resources.TestRailRunID)
    public void VerifyThat_Post_VehicleActivityReportsSummary_Instant_WorksSuccessfully() {

        logger.info("START : VerifyThat_Post_VehicleActivityReportsSummary_Instant_WorksSuccessfully");

        Date currentDay = new Date();
        String endDateZFormat = basePage.convertDateToWantedFormat(Resources.simpleDateFormat_ZFormat, currentDay);
        Date before32Days = basePage.takeDate7MonthsBack(currentDay);
        String startDateZFormat = basePage.convertDateToWantedFormat(Resources.simpleDateFormat_ZFormat,before32Days);
        webServiceMethods.post_Vehicle_Reports_Summary_Instant_2Parameters(startDateZFormat,endDateZFormat);
    }


    public void denemeTest() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));

    }


    @DataProvider(name = "get_paramStartDate_paramEndDate_startDateInDB_endDateInDB_getRandomMuIDList")
    public Object[][] get_parameters_data(ITestContext context) {

        JSONArray jsonMuIDList;

        jsonMuIDList = webServiceMethods.get_MobileUnits_From_ViewVMOBILEUNIT();

        JSONArray randomJSONMuIDList;
        randomJSONMuIDList = webServiceMethods.composeRandomMuIDList(jsonMuIDList);

        Date currentDay = new Date();
        Date yesterday = basePage.yesterday();

        Date currentDay3HoursAhead = basePage.takeDate3HoursAhead(currentDay);
        Date yesterday3HoursAhead = basePage.takeDate3HoursAhead(yesterday);

        String startDateZFormat = basePage.convertDateToWantedFormat(Resources.simpleDateFormat_ZFormat, yesterday);
        String endDateZFormat = basePage.convertDateToWantedFormat(Resources.simpleDateFormat_ZFormat, currentDay);

        String startDate_savedInDB_SFormat = basePage.convertDateToWantedFormat(Resources.simpleDateFormat_SFormat, yesterday3HoursAhead);
        String endDate_savedInDB_SFormat = basePage.convertDateToWantedFormat(Resources.simpleDateFormat_SFormat, currentDay3HoursAhead);


        return new Object[][]
                {
                        {
                                startDateZFormat,
                                endDateZFormat,
                                startDate_savedInDB_SFormat,
                                endDate_savedInDB_SFormat,
                                randomJSONMuIDList
                        }
                };

    }


}
