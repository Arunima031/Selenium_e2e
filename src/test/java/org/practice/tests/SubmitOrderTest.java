package org.practice.tests;


import org.practice.base.BaseTest;
import org.practice.listeners.Retry;
import org.practice.utils.AbstractComponents;
import org.practice.utils.DataReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    String orderID= null;
   @Test(groups = {"Regression","Smoke","Purchase"},dataProvider = "getData",retryAnalyzer = Retry.class)
   public void submitOrder(HashMap<String,String> map){


        landingPage.loginApp(map.get("email"),map.get("password"));

        productCatalogPage.addToCart(map.get("product"));
        productCatalogPage.goToCartPage();


        Assert.assertTrue(cartPage.validateItemAvailable(map.get("product")));
        cartPage.clickCheckoutButton();


        purchasePage.selectCountry();
        purchasePage.clickSubmit();

        Assert.assertTrue(orderConfirmPage.getConfirmationText().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
          orderID= orderConfirmPage.getOrderId();


   }

   @Test(dependsOnMethods = {"submitOrder"},groups = {"Regression"})
   public void validateOrderItem(){

       landingPage.loginApp("seleniumPrac@gmail.com","Password@123");
       landingPage.goToOrdersPage();
       System.out.println("Validated Order page as well with orderid : "+orderID);
       Assert.assertTrue(orderPage.validateOrderId(orderID));


   }

    @AfterMethod(alwaysRun = true)
    public void signOutApp(){
        if(driver!=null){
            AbstractComponents.clickSignOut();
            System.out.println("Signed out the application");
        }
   }

    @DataProvider
    public Object[][] getData() throws IOException {
       List<HashMap<String,String>> data=DataReader.getJsonToMap(System.getProperty("user.dir") + "\\src\\test\\java\\org\\practice\\testData\\PurchaseOrder.json");
    return new Object[][] {{data.get(0)},{data.get(1)}};
    }


}
