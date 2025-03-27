package org.practice.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {
WebDriver driver;
public AbstractComponents(WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver,this);
}
    @FindBy(css="[routerlink*=\"cart\"]")
    private WebElement cartElement;

   @FindBy(css="[routerlink*=\"order\"]")
   private WebElement orderElement;

    @FindBy(css=".fa-sign-out")
    private static WebElement signOutButton;

    public void visibilityOfElements(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    public void invisibilityOfElements(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void visibilityOfWebElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void goToCartPage(){
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartElement);
        }
 public void goToOrdersPage(){
     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", orderElement);
 }
public static void clickSignOut(){
    signOutButton.click();
}}



