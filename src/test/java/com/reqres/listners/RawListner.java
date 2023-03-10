package com.reqres.listners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.reqres.report.ReportExtent;
import com.reqres.test.Base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class RawListner extends Base implements ITestListener {

    ReportExtent reportExtent;
    ExtentTest extentTest;
    @Override
    public void onTestStart(ITestResult iTestResult) {
        extentTest = reportExtent.createTest(iTestResult.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
       // extentTest.log(Status.PASS, iTestResult.getMethod().getDescription());
        OnTestRun(iTestResult);
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
       // extentTest.log(Status.FAIL, iTestResult.getThrowable().fillInStackTrace());
        OnTestRun(iTestResult);
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
       // extentTest.log(Status.SKIP, getTestMethodName(iTestResult));
        OnTestRun(iTestResult);
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }
    @Override
    public void onStart(ITestContext iTestContext) {
        reportExtent = new ReportExtent();

    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        reportExtent.flush();
    }
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void OnTestRun(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            extentTest.assignCategory(result.getInstanceName());
            extentTest.log(Status.FAIL,"Details: "+result.getMethod().getDescription());
            extentTest.log(Status.FAIL, MarkupHelper.createLabel("FAILED test case name is:"+""+result.getName(),ExtentColor.RED));
            Reporter.log("Failed Report"+"",true);
            extentTest.log(Status.FAIL,MarkupHelper.createLabel("Testcase FAILED due to below issues:"+"", ExtentColor.RED));
            extentTest.fail(result.getThrowable());
            extentTest.log(Status.FAIL,"ParamsPassed:");
            for(int i=0;i<result.getParameters().length;i++){
                extentTest.log(Status.FAIL,result.getParameters()[i].toString());
            }
        }
        else if(result.getStatus()==ITestResult.SUCCESS){
            extentTest.log(Status.PASS,"TestClass:"+""+result.getMethod().getDescription());
        }
        else if(result.getStatus()==ITestResult.SKIP){
            extentTest.log(Status.SKIP,"TestCaseSKIPPEDis"+""+result.getMethod().getDescription());
        }
    }
}
