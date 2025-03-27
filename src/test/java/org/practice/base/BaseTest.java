package org.practice.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.practice.pageObjects.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {


        public WebDriver driver;
        protected  Properties prop;
        protected LandingPage landingPage;
        protected ProductCatalogPage productCatalogPage;
        protected CartPage cartPage;
        protected PurchasePage purchasePage;
        protected OrderConfirmPage orderConfirmPage;
        protected  OrderPage orderPage;

        @BeforeMethod(alwaysRun = true)
        public void setup() throws IOException {

            prop=new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\practice\\resources\\global.properties");
            prop.load(fis);
            String browserName=
                    System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
            if(browserName.equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver=new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver=new EdgeDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            // Initialize Page Objects
            initializePages();

            //launch the app
            launchApp();
        }

        public void initializePages() {
            landingPage = new LandingPage(driver);
            productCatalogPage = new ProductCatalogPage(driver);
            cartPage = new CartPage(driver);
            purchasePage = new PurchasePage(driver);
            orderConfirmPage = new OrderConfirmPage(driver);
            orderPage= new OrderPage(driver);
        }

        public void launchApp(){
            landingPage.goTo(prop.getProperty("appUrl"));
        }

        @AfterMethod(alwaysRun = true)
        public void tearDown() {
                driver.quit();
        }

    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        Path destPath = Path.of(System.getProperty("user.dir"), "reports", testCaseName + ".png");
        Files.createDirectories(destPath.getParent());
        Files.copy(src.toPath(),destPath, StandardCopyOption.REPLACE_EXISTING);
        return destPath.toString();


    }
    }


