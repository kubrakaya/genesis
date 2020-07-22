package com.mobiliz.portal.TestRail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class Program {

    public static void main(String[] args) throws Exception {

    }

    public APIClient connectTestRail() {

        //APIClient client = new APIClient("http://10.0.33.57/");

        APIClient client = new APIClient("https://mobiliz.testrail.io/");

        client.setUser("kubraka@mobiliz.com.tr");
        client.setPassword("5clAdfAk");

        return client;

    }

    public void enterTestResult(int runId, int caseId, int testResult)
            throws MalformedURLException, IOException, APIException {
        APIClient client = connectTestRail();
        Map data = new HashMap();
        data.put("status_id", new Integer(testResult));
        data.put("comment", "This ui worked fine!");
        JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" + runId + "/" + caseId, data);

    }

}