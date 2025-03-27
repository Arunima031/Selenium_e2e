package org.practice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.practice.utils.AbstractComponents;

import java.util.List;

public class ProductCatalogPage extends AbstractComponents {
    WebDriver driver;
    public ProductCatalogPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".mb-3")
    private List<WebElement> products;

    @FindBy(css=".ng-animating")
    private WebElement spinner;



By productsBy= By.cssSelector(".mb-3");
By addToCartButton=By.cssSelector(".card-body button:last-of-type");
By toastMessage=By.id("toast-container");


public WebElement getProductList(String productName){
    visibilityOfElements(productsBy);
   return products.stream()
           .filter(product -> product.findElement(By.tagName("b")).getText().equals(productName)).
           findFirst().orElse(null);
}

public void addToCart(String productName){
    WebElement returnedProduct = getProductList(productName);
    returnedProduct.findElement(addToCartButton).click();
    visibilityOfElements(toastMessage);
    invisibilityOfElements(spinner);

}


}

