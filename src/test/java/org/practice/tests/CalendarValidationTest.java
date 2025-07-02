package org.practice.tests;

import org.practice.base.BaseTest;
import org.practice.pageObjects.BookingPage;
import org.testng.annotations.Test;

public class CalendarValidationTest extends BaseTest {

    @Test(groups = {"Regression"})
    public void calendarAutomateWithYatra(){

        driver.get("https://www.yatra.com/");
        driver.manage().window().maximize();
        BookingPage bp=  new BookingPage(driver);
        bp.clickLoginCancel();
        bp.clickDepartureCalendar();
        int currentMonthLowestPriceDate = Integer.parseInt(bp.getCurrentMonthLowestPrice());
        System.out.println("Current month lowest price date : " +currentMonthLowestPriceDate);

        int nextMonthLowestPriceDate =Integer.parseInt(bp.getNextMonthLowestPrice());
        System.out.println("Next month lowest price date  : " +nextMonthLowestPriceDate);
    }
}
