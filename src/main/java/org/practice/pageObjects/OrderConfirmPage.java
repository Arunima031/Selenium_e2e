package org.practice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.utils.AbstractComponents;

public class OrderConfirmPage extends AbstractComponents {
  WebDriver driver;
    public OrderConfirmPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css="td h1")
    private WebElement confirmTextMessage;

    @FindBy(xpath="(//td/label)[2]")
    private WebElement getorderIdComp;

    public String getConfirmationText(){
       return confirmTextMessage.getText().trim();
    }

    public String getOrderId(){
        return getorderIdComp.getText().split("\\|")[1].trim();
    }
}
