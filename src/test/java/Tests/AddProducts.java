package Tests;

import Pages.ProductsPage;
import Pages.Register_Login_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AddProducts {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Register_Login_Page login;
    ProductsPage products;
    String URL = "https://automationexercise.com/";
    Actions actions;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        login = new Register_Login_Page(driver);
        products = new ProductsPage(driver);

    }

    @Test
    public void addProduct() {
        String FirstItemPrice = products.getText_firstItemPrice();
        String SecondItemPrice = products.getText_secondItemPrice();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(products.getCurrentURl(), "https://automationexercise.com/", "This isn't the home page");
        products.clickProductButton();
        softAssert.assertEquals(products.verifyProductPageURl(), products.productsUrl);
        products.moveToElement();
        products.addFirstProduct();
        products.firstProductQuantity++;
        softAssert.assertTrue(products.checkFirstItemText(), "Wrong item");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='modal-footer']//button"))));
        products.pressContinueShopping();
//        products.addSecondProduct();
//        products.secondProductQuantity++;
        for (int i = 1; i < 4; i++) { //this loop is to test the last function quantity*price is working correctly
            products.addSecondProduct();
            webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='modal-footer']//button"))));
            products.pressContinueShopping();
            products.secondProductQuantity++;

        }
        softAssert.assertTrue(products.checkSecondItemText(), "Wrong item");
        products.clickViewCart();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='/product_details/1']"))));
        softAssert.assertEquals(products.checkCartFirstItem(), "Blue Top");
        softAssert.assertEquals(products.checkCartSecondItem(), "Men Tshirt");

        softAssert.assertEquals(products.getCartText_firstItemPrice(), FirstItemPrice, "Wrong price they are not the same");
        softAssert.assertEquals(products.getCartText_secondtItemPrice(), SecondItemPrice, "Wrong price they are not the same");

        int firsQuantityNumber = (Integer.parseInt(products.getText_FirstItemQuantity()));
        softAssert.assertEquals(firsQuantityNumber, products.firstProductQuantity, "Not the same quantity");

        int secondQuantityNumber = (Integer.parseInt(products.getText_SecondItemQuantity()));
        softAssert.assertEquals(secondQuantityNumber, products.secondProductQuantity, "Not the same quantity");


        String firstPrice_BeforeTrim = products.getCartText_firstItemPrice();
        int firstPrice_AfterTrim = Integer.parseInt(firstPrice_BeforeTrim.replaceAll("[^0-9]", ""));

        String secondPrice_BeforeTrim = products.getCartText_secondtItemPrice();
        int secondPrice_AfterTrim = Integer.parseInt(secondPrice_BeforeTrim.replaceAll("[^0-9]", ""));

        String total_firstItem = products.checkTotal_firstItem();
        int firstTotal_AfterTrim = Integer.parseInt(total_firstItem.replaceAll("[^0-9]", ""));

        String total_secondItem = products.checkTotal_secondItem();
        int secondTotal_AfterTrim = Integer.parseInt(total_secondItem.replaceAll("[^0-9]", ""));


        softAssert.assertEquals(firstPrice_AfterTrim * firsQuantityNumber, firstTotal_AfterTrim, "Error in calculating the total");
        softAssert.assertEquals(secondPrice_AfterTrim * secondQuantityNumber, secondTotal_AfterTrim, "Error in calculating the total");

        softAssert.assertAll();

    }

}
