package Tests;

import Pages.ProductsPage;
import Pages.Register_Login_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SearchProductTests {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Register_Login_Page login;
    ProductsPage products;
    String URL = "https://automationexercise.com/";

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
    public void searchProduct() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(products.getCurrentURl(), "https://automationexercise.com/", "This isn't the home page");
        products.clickProductButton();
        softAssert.assertEquals(products.verifyProductPageURl(), products.productsUrl);
        products.searchProduct("shirt");
        softAssert.assertEquals(products.verifyProductsTitle(), "SEARCHED PRODUCTS","");
        products.validateSearchResultsData("shirt");
        softAssert.assertAll();

    }
}
