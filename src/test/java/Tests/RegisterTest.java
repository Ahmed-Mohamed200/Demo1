package Tests;

import Pages.Register_Login_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class RegisterTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Register_Login_Page register;
    String URL = "https://automationexercise.com/";

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        register = new Register_Login_Page(driver);
    }

    @Test
    public void Register() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(register.getCurrentUrl(), "https://automationexercise.com/", "This isn't the home page");
        driver.findElement(register.signIn_signOutButton).click();
        softAssert.assertTrue(register.validate_NewUserSignUpPage());
        register.enterName(register.signUpName);
        register.enterEmail(register.signUpEmail);
        register.clickSignUpButton();
        softAssert.assertTrue(register.validate_accountInfoField(), "account info field didn't display successfully");
        register.chooseTitle();
        register.registerFormPassword(register.accPassword);
        register.selectDays();
        register.selectMonth();
        register.selectYear();
        register.clickSignUp_NewsLetter();
        register.clickReceiveSpecialOffersBtn();
        register.enterFirstName_AddressInfo(register.firstName_AddressInfo);
        register.enterLastName_AddressInfo(register.lastName_AddressInfo);
        register.enterCompany_AddressInfo(register.Company_AddressInfo);
        register.enterAddress1_AddressInfo(register.address1_AddressInfo);
        register.enterAddress2_AddressInfo(register.address2_AddressInfo);
        register.selectCountry();
        register.enterState_AddressInfo(register.state_AddressInfo);
        register.enterCity_AddressInfo(register.city_AddressInfo);
        register.enterZipCode_AddressInfo(register.zipCode_AddressInfo);
        register.enterMobileNumber_AddressInfo(register.number_AddressInfo);
        register.clickCreateAccount();
        softAssert.assertTrue(register.validateAccCreatedMessage());
        register.clickContinueButton();
        softAssert.assertEquals(register.getLoggedInText(),"Logged in as "+register.signUpName);
       register.clickDeleteAccount();
        softAssert.assertEquals(register.acc_DeletedSuccessfully_message(),"ACCOUNT DELETED!","Error in deleting the acc");
        register.pressContinue();
        softAssert.assertAll();


    }
}
