package org.practice.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookingPage {
    WebDriver driver;
    public BookingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[class ='style_box__dORVf'] img[src *='close']")
    private WebElement loginClose;

    @FindBy(xpath="//div[@aria-label='Departure Date inputbox']" )
    private WebElement departureDateField;

    @FindBy(xpath = "//div[@class='react-datepicker__month-container']")
    private List<WebElement> calendarMonths;

    @FindBy(xpath="//span[@class='custom-day-content lowestPrice']")
    private List<WebElement> lowestPrice;

    @FindBy(css ="[class='bee-popup-col bee-popup-col-1 bee-popup-col-w12'] button")
    private WebElement  bonusPopup;

    public void clickLoginCancel(){
        try {
            if (loginClose.isDisplayed()) {
               loginClose.click();
            }
        } catch (NoSuchElementException| StaleElementReferenceException e) {
            System.out.println("Login Cancel button not present or not visible. Skipping.");
            bonusPopup.click();
        }
    }

    public void clickDepartureCalendar(){
        departureDateField.click();
    }
    public String getCurrentMonthLowestPrice(){
     List<WebElement> lowestPriceDates=calendarMonths.get(0).findElements(By.xpath(".//span[@class='custom-day-content lowestPrice']"));
     String lowestPrice=lowestPriceDates.get(0).getText().replaceAll("[^\\d]","");
     System.out.println(lowestPrice);
     String date= lowestPriceDates.get(0).findElement(By.xpath("..")).getText().replaceAll("[^\\d]", "");
     return date.replace(lowestPrice,"");


    }

    public String getNextMonthLowestPrice() {
        List<WebElement> lowestPriceDates = calendarMonths.get(1).findElements(By.xpath(".//span[@class='custom-day-content lowestPrice']"));
        String lowestPrice=lowestPriceDates.get(0).getText().replaceAll("[^\\d]","");
        System.out.println(lowestPrice);
        String date= lowestPriceDates.get(0).findElement(By.xpath("..")).getText().replaceAll("[^\\d]", "");
        return date.replace(lowestPrice,"");
    }


}
