package org.practice.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.practice.base.BaseTest;
import org.practice.utils.ExtentReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

ExtentTest test;
ExtentReports extent =ExtentReporter.generateReport();


    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL,"Test Failed");
        test.fail(result.getThrowable());

        WebDriver driver = ((BaseTest) result.getInstance()).driver;

        if (driver != null) {
            try {
                String filepath = getScreenshot(result.getMethod().getMethodName(), driver);
                test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Driver is null, cannot capture screenshot!");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
      test.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestStart(ITestResult result) {
     test=extent.createTest(result.getMethod().getMethodName());
    }
}
