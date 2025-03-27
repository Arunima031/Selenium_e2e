package org.practice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.utils.AbstractComponents;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;
    public  CartPage (WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".cartSection h3")
    private List<WebElement> itemList;

    @FindBy(xpath = "//button[text()=\"Checkout\"]")
    private WebElement checkoutButton;


    public boolean validateItemAvailable(String productName){
        return
                itemList.stream().anyMatch(item -> item.getText().equalsIgnoreCase(productName));
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }


}
