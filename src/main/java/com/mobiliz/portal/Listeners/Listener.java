package com.mobiliz.portal.Listeners;

import java.lang.reflect.Method;

import com.mobiliz.portal.TestRail.Program;
import com.mobiliz.portal.TestRail.UseAsTestRailId;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // TODO Auto-generated method stub

    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // TODO Auto-generated method stub

    }

    public void onStart(ISuite suite) {
        // TODO Auto-generated method stub

    }

    public void onFinish(ISuite suite) {
        // TODO Auto-generated method stub

    }

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
        try {

            System.out.println("onTestSuccess Method triggered for :" + result.getName());

            int TestID = 0;
            int TestRunID = 0;
            Program pr = new Program();

            if (result.getAttribute("testRailCaseIDs") == null) {

                for (Method testMethod : result.getTestClass().getRealClass().getMethods()) {
                    if (testMethod.getName().equals(result.getName())
                            && testMethod.isAnnotationPresent(UseAsTestRailId.class)) {
                        UseAsTestRailId useAsTestName = testMethod.getAnnotation(UseAsTestRailId.class);
                        int[] caseIDSet = useAsTestName.testRailCaseId();
                        TestRunID = useAsTestName.testRailRunId();
                        for (int i = 0; i < caseIDSet.length; i++) {
                            TestID = caseIDSet[i];
                            //System.out.println("Test ID---> " + TestID + " Test Run ID ---> " + TestRunID);
                            pr.enterTestResult(TestRunID, TestID, 1);
                        }

                        // 1 = Passed status in TestRail

                    }
                }
                System.out.println();
            } else {


                int[] values = (int[]) result.getAttribute("testRailCaseIDs");

                result.getAttribute("TESTRAILCASEID");
                result.getAttribute("TESTRAILRUNID");

                for (Method testMethod : result.getTestClass().getRealClass().getMethods()) {


                    if (testMethod.getName().equals(result.getName())) {
                        for (int i = 0; i < values.length; i++) {

                            TestID = values[i];
                            TestRunID = (Integer) result.getAttribute("TESTRAILRUNID");
                            System.out.println("result.getAttribute(TESTRAILCASEID" + i + ")-->" + values[i]);
                            //System.out.println("TestRunID-->" + TestRunID);
                            // 1 = Passed status in TestRail
                            pr.enterTestResult(TestRunID, TestID, 1);
                        }
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void onTestFailure(ITestResult result) {
        try {

            System.out.println("onTestFailure Method for :" + result.getName());
            int TestID = 0;
            int TestRunID = 0;
            Program pr = new Program();

            if (result.getAttribute("testRailCaseIDs") == null) {

                for (Method testMethod : result.getTestClass().getRealClass().getMethods()) {

                    if (testMethod.getName().equals(result.getName())
                            && testMethod.isAnnotationPresent(UseAsTestRailId.class)) {

                        UseAsTestRailId useAsTestName = testMethod.getAnnotation(UseAsTestRailId.class);
                        if (useAsTestName.testRailCaseId() == null)
                            return;
                        int[] caseIDSet = useAsTestName.testRailCaseId();
                        for (int i = 0; i < caseIDSet.length; i++) {
                            TestID = caseIDSet[i];
                        }

                        TestRunID = useAsTestName.testRailRunId();
                        System.out.println("Test ID---> " + TestID + " Test Run ID ---> " + TestRunID);

                        // 5 = Failed status in TestRail
                        pr.enterTestResult(TestRunID, TestID, 5);
                    }
                }

            } else {

                int values[] = (int[]) result.getAttribute("testRailCaseIDs");
                System.out.println();

                result.getAttribute("TESTRAILCASEID");
                result.getAttribute("TESTRAILRUNID");

                for (Method testMethod : result.getTestClass().getRealClass().getMethods()) {
                    if (testMethod.getName().equals(result.getName())) {

                        for (int i = 0; i < values.length; i++) {

                            TestID = values[i];
                            TestRunID = (Integer) result.getAttribute("TESTRAILRUNID");
                            System.out.println("result.getAttribute(TESTRAILCASEID-" + i + ")-->" + values[i]);
                            System.out.println("TestRunID -->" + TestRunID);
                            pr.enterTestResult(TestRunID, TestID, 5);
                        }

                    }
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void onTestSkipped(ITestResult result) {
        try {

            System.out.println("onTestSkipped Method triggered for :" + result.getName());

            int TestID = 0;
            int TestRunID = 0;
            Program pr = new Program();

            if (result.getAttribute("testRailCaseIDs") == null) {

                for (Method testMethod : result.getTestClass().getRealClass().getMethods()) {
                    if (testMethod.getName().equals(result.getName())
                            && testMethod.isAnnotationPresent(UseAsTestRailId.class)) {
                        UseAsTestRailId useAsTestName = testMethod.getAnnotation(UseAsTestRailId.class);
                        int[] caseIDSet = useAsTestName.testRailCaseId();
                        for (int i = 0; i < caseIDSet.length; i++) {
                            TestID = caseIDSet[i];
                        }

                        TestRunID = useAsTestName.testRailRunId();
                        System.out.println("Test ID---> " + TestID + " Test Run ID ---> " + TestRunID);

                        // 5 = Failed status in TestRail
                        pr.enterTestResult(TestRunID, TestID, 2);
                    }
                }

            } else { // when result.setAttribute code is worked
                int values[] = (int[]) result.getAttribute("testRailCaseIDs");
                System.out.println("result.getAttribute(TESTRAILRUNID); -->" + result.getAttribute("TESTRAILRUNID"));
                TestRunID = (Integer) result.getAttribute("TESTRAILRUNID");

                for (Method testMethod : result.getTestClass().getRealClass().getMethods()) {
                    if (testMethod.getName().equals(result.getName())) {
                        for (int i = 0; i < values.length; i++) {

                            TestID = values[i];
                            System.out.println("result.getAttribute(TESTRAILCASEID" + i + ")-->" + values[i]);

                            // 2 = Blocked status in TestRail
                            pr.enterTestResult(TestRunID, TestID, 2);
                        }

                    }
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
    }

}
