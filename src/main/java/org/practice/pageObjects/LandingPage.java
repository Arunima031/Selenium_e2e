package org.practice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.utils.AbstractComponents;

public class LandingPage extends AbstractComponents {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "[formcontrolname=\"userEmail\"]")
    private WebElement getUserEmail;

    @FindBy(css="[formcontrolname=\"userPassword\"]")
    private WebElement getUserPassword;

    @FindBy(id="login")
    private WebElement getLoginButton;

    @FindBy(css="[class*='flyInOut']")
    private WebElement errorMessage;

    public void loginApp(String email,String password){
      getUserEmail.clear();
      getUserEmail.sendKeys(email);
      getUserPassword.clear();
      getUserPassword.sendKeys(password);
      getLoginButton.click();
    }

    public void goTo(String url){
        driver.get(url);
    }

    public String errorValidation(){
        visibilityOfElements(errorMessage);
        return errorMessage.getText();
    }






}
