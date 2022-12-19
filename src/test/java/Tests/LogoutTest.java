package Tests;

import Pages.Register_Login_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LogoutTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Register_Login_Page login;
    String URL = "https://automationexercise.com/";

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        login = new Register_Login_Page(driver);
    }
    @Test
    public void LoggedOutSuccessfully(){

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(login.getCurrentUrl(),"https://automationexercise.com/","This isn't the home page");
        login.clickSignUp_SignInButton();
        login.enterLoginEmail(login.signUpEmail_Static);
        login.enterLoginPassword(login.accPassword);
        login.clickLoginButton();
        softAssert.assertEquals(driver.findElement(login.loggedInButton).getText().toLowerCase(),driver.findElement(login.loggedInButton).getText().toLowerCase().contains(login.firstName_AddressInfo));
        login.clickLoggedoutButton();
        softAssert.assertEquals(login.getCurrentUrl(),"https://automationexercise.com/login");

    }
}
