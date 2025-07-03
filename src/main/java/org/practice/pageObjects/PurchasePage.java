package org.practice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.utils.AbstractComponents;

import java.util.List;

public class PurchasePage extends AbstractComponents {
    WebDriver driver;
    public  PurchasePage (WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (css="[placeholder='Select Country']")
            private WebElement countryBox;

    @FindBy(css="button.ta-item span")
            private List<WebElement> countries;

    @FindBy(css=".action__submit")
            private WebElement submitButton;


    By countryOptions= By.cssSelector(".ta-results");

    public void selectCountry(){
        visibilityOfElements(submitButton);
        Actions a = new Actions(driver);
        System.out.println(countryBox.isDisplayed()); // Should print true
        System.out.println(countryBox.isEnabled());   // Should print true
//        a.sendKeys(countryBox,"India").build().perform();
        countryBox.sendKeys("India");
        visibilityOfElements(countryOptions);
        WebElement requiredCountry = countries.stream().filter(country -> country.getText().trim().equalsIgnoreCase("India")).findFirst().orElse(null);
        if (requiredCountry != null) {
            a.click(requiredCountry).build().perform();
        }
    }

    public void clickSubmit(){
        submitButton.click();
    }
}
