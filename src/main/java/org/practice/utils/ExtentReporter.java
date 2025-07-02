package org.practice.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReporter {


    public  static ExtentReports generateReport(){

        String reportDirPath = System.getProperty("user.dir") + "/reports";
        File reportDir = new File(reportDirPath);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        String filePath= reportDirPath+"/index.html";
        ExtentSparkReporter reports = new ExtentSparkReporter(filePath);
        reports.config().setReportName("Complete Automation Report");
        reports.config().setDocumentTitle("Test Results for Application");

        ExtentReports extent = new  ExtentReports();
        extent.attachReporter(reports);
        extent.setSystemInfo("Automated By","Arunima");
        return extent;
    }
}
