package org.practice.tests;

import org.practice.base.BaseTest;
import org.practice.utils.AbstractComponents;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorValidationsTest extends BaseTest  {
@Test(groups = {"Regression"})
public void invalidLogin() {
    landingPage.loginApp("selenium@gmail.com", "Password@123");
    Assert.assertEquals(landingPage.errorValidation(),"Incorrect email or password.");
}

@Test(groups = {"Smoke"})
    public void productError(){

        String productName ="ADIDAS ORIGINAL";
        landingPage.loginApp("seleniumPractice@gmail.com","Password@123");

        productCatalogPage.addToCart(productName);
        productCatalogPage.goToCartPage();

        Assert.assertFalse(cartPage.validateItemAvailable("ZARACOAT"));


    }
}

