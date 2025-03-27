package org.practice.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {


    public  static ExtentReports generateReport(){

        String filePath= System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reports = new ExtentSparkReporter(filePath);
        reports.config().setReportName("Complete Automation Report");
        reports.config().setDocumentTitle("Test Results for Application");

        ExtentReports extent = new  ExtentReports();
        extent.attachReporter(reports);
        extent.setSystemInfo("Automated By","Arunima");
        return extent;
    }
}
