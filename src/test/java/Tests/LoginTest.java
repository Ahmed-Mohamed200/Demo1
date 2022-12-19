package Tests;

import Pages.Register_Login_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginTest {
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
        driver.findElement(login.signIn_signOutButton).click();
        login.enterName(login.signUpName);
        login.enterEmail(login.signUpEmail);
        login.clickSignUpButton();
        login.chooseTitle();
        login.registerFormPassword(login.accPassword);
        login.selectDays();
        login.selectMonth();
        login.selectYear();
        login.clickSignUp_NewsLetter();
        login.clickReceiveSpecialOffersBtn();
        login.enterFirstName_AddressInfo(login.firstName_AddressInfo);
        login.enterLastName_AddressInfo(login.lastName_AddressInfo);
        login.enterCompany_AddressInfo(login.Company_AddressInfo);
        login.enterAddress1_AddressInfo(login.address1_AddressInfo);
        login.enterAddress2_AddressInfo(login.address2_AddressInfo);
        login.selectCountry();
        login.enterState_AddressInfo(login.state_AddressInfo);
        login.enterCity_AddressInfo(login.city_AddressInfo);
        login.enterZipCode_AddressInfo(login.zipCode_AddressInfo);
        login.enterMobileNumber_AddressInfo(login.number_AddressInfo);
        login.clickCreateAccount();
        login.clickContinueButton();
        login.clickLoggedoutButton();
    }

    @Test
    public void LoginSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(login.getCurrentUrl(), "https://automationexercise.com/login", "This isn't the home page");
        login.clickLogin_LogoutButton();
        login.enterLoginEmail(login.signUpEmail);
        login.enterLoginPassword(login.accPassword);
        login.clickLoginButton();

        login.clickDeleteAccount();
        softAssert.assertTrue(login.checkAccDeletedSuccessfullyMessage(), "Error in deleting the acc");
        login.pressContinue();
        softAssert.assertAll();

    }

    @Test
    public void loginFailed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(login.getCurrentUrl(), "https://automationexercise.com/", "This isn't the home page");
        login.clickLogin_LogoutButton();
        login.enterLoginEmail(login.signUpEmail);
        login.enterLoginPassword("222222");
        login.clickLoginButton();
        softAssert.assertTrue(login.checkErrorMessage(), "Error");
        softAssert.assertAll();


    }
    @AfterMethod
    public void getUrl(){
        driver.get(URL);
    }


}