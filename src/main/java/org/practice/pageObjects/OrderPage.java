package org.practice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.utils.AbstractComponents;

import java.util.List;

public class OrderPage extends AbstractComponents {
    WebDriver driver;
    public  OrderPage (WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="tbody th")
    private List<WebElement> orderIdList;

 public boolean validateOrderId(String orderID){
     return orderIdList.stream().anyMatch(orderId-> orderId.getText().equals(orderID));
 }
}
