package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;

public class Register_Login_Page {
    WebDriver driver;
    Select select;
    WebDriverWait webDriverWait;
    public String URL = "https://automationexercise.com/";
    public By signIn_signOutButton = By.xpath("//header[@id='header']//li[4]");
    public By newUserSignUpText = By.xpath("//div[@class='signup-form'] //h2");
    By enterName = By.xpath("//input[@placeholder='Name']");
    By enterEmail = By.xpath("//input[@data-qa='signup-email']");
    By signUpButton = By.xpath("//button[@data-qa='signup-button']");


    By enterEmail_SignIn = By.xpath("//input[@data-qa='login-email']");
    By enterPassword_SignIn = By.xpath("//input[@placeholder='Password']");
    By signInButton_Click = By.xpath("//button[@data-qa='login-button']");

    public By enterAccInfoField = By.xpath("//div[@class='login-form']//h2//b");

    LocalDateTime x = LocalDateTime.now();
    String Emaail=x.toString().replaceAll(":","");

    public String signUpName = "ahmed";
    public String signUpEmail_Static = "ahmed22000@zoo.com"; //ahmed22000@zoo.com"
    public String signUpEmail=Emaail+"@gmail.com";
    public String accPassword = "btats";

    By registerForm_Title = By.xpath("//input[@id='id_gender1']");
    By registerForm_Password = By.xpath("//input[@type='password']");
    By dateOfBirth_Days = By.xpath("//select[@id='days']");
    By dateOfBirth_Month = By.xpath("//select[@id='months']");
    By dateOfBirth_Years = By.xpath(" //select[@id='years']");
    By signUp_NewsLetter = By.xpath("//input[@type='checkbox']");
    By receiveSpecialOffers = By.xpath("//input[@name='newsletter']");

    By addressInfo_FirstName = By.id("first_name");
    By addressInfo_LastName = By.id("last_name");
    By getAddressInfo_Company = By.id("company");
    By getAddressInfo_Address1 = By.id("address1");
    By getAddressInfo_Address2 = By.id("address2");
    By getAddressInfo_Country = By.id("country");
    By getAddressInfo_State = By.id("state");
    By getAddressInfo_City = By.id("city");
    By getAddressInfo_ZipCode = By.id("zipcode");
    By getAddressInfo_MobileNumber = By.id("mobile_number");
    By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    public By acc_CreatedSuccessfully = By.xpath("//h2[@data-qa='account-created']");
    By continueButton = By.xpath("//*[@data-qa='continue-button']");

    public By loggedInButton = By.xpath("//i[contains(@class,'fa-user')]//parent::a");
    public By loggedOutButton = By.xpath("//a[@href='/logout']");
    By deleteAccButton = By.xpath("//a[@href='/delete_account']");
    public By acc_DeletedSuccessfully = By.xpath("//h2[@data-qa='account-deleted']");

    public By Continue_Button = By.xpath("//a[@data-qa='continue-button']");
    public String firstName_AddressInfo = "Ahmed";
    public String lastName_AddressInfo = "Mohamed";
    public String Company_AddressInfo = "Vodafone";
    public String address1_AddressInfo = "Maddi";
    public String address2_AddressInfo = "Giza";
    public String state_AddressInfo = "Egypt";
    public String city_AddressInfo = "Cairo";
    public String zipCode_AddressInfo = "11322";
    public String number_AddressInfo = "011404451005";


    public By login_ErrorMessage = By.xpath("//form[@action='/login'] //p");
    public By emailErrrorExistMessage = By.xpath("//form[@action='/signup']/p");


    public Register_Login_Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentURl() {
        String currentURl = driver.getCurrentUrl();
        return currentURl;
    }

    public Boolean validate_NewUserSignUpPage() {
        return driver.findElement(newUserSignUpText).getText().contains("New User");
    }

    public void clickSignUp_SignInButton() {
        driver.findElement(signIn_signOutButton).click();
    }

    public Boolean validate_accountInfoField() {
        return driver.findElement(enterAccInfoField).getText().contains("ENTER ACCOUNT");
    }

    public void enterName(String username) {
        driver.findElement(enterName).sendKeys(username);

    }

    public void enterEmail(String email) {
        driver.findElement(enterEmail).sendKeys(email);

    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void chooseTitle() {
        driver.findElement(registerForm_Title).click();
    }

    public void registerFormPassword(String accPassword) {
        driver.findElement(registerForm_Password).sendKeys(accPassword);
    }

    public void selectDays() {
        select = new Select(driver.findElement(dateOfBirth_Days));
        select.selectByVisibleText("23");

    }

    public void selectMonth() {
        select = new Select(driver.findElement(dateOfBirth_Month));
        select.selectByVisibleText("February");

    }

    public void selectYear() {
        select = new Select(driver.findElement(dateOfBirth_Years));
        select.selectByValue("2000");

    }

    public void clickSignUp_NewsLetter() {
        driver.findElement(signUp_NewsLetter).click();
    }

    public void clickReceiveSpecialOffersBtn() {
        driver.findElement(receiveSpecialOffers).click();
    }

    public void enterFirstName_AddressInfo(String name) {
        driver.findElement(addressInfo_FirstName).sendKeys(name);

    }

    public void enterLastName_AddressInfo(String name) {
        driver.findElement(addressInfo_LastName).sendKeys(name);

    }

    public void enterCompany_AddressInfo(String name) {
        driver.findElement(getAddressInfo_Company).sendKeys(name);

    }

    public void enterAddress1_AddressInfo(String name) {
        driver.findElement(getAddressInfo_Address1).sendKeys(name);

    }

    public void enterAddress2_AddressInfo(String name) {
        driver.findElement(getAddressInfo_Address2).sendKeys(name);

    }

    public void selectCountry() {
        select = new Select(driver.findElement(getAddressInfo_Country));
        select.selectByVisibleText("Canada");

    }

    public void enterState_AddressInfo(String name) {
        driver.findElement(getAddressInfo_State).sendKeys(name);

    }

    public void enterCity_AddressInfo(String name) {
        driver.findElement(getAddressInfo_City).sendKeys(name);

    }

    public void enterZipCode_AddressInfo(String zipcode) {
        driver.findElement(getAddressInfo_ZipCode).sendKeys(zipcode);

    }

    public void enterMobileNumber_AddressInfo(String mobNumber) {
        driver.findElement(getAddressInfo_MobileNumber).sendKeys(mobNumber);

    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();

    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();

    }

    public boolean validateAccCreatedMessage() {
        return driver.findElement(acc_CreatedSuccessfully).getText().contains("CREATED");
    }

    public boolean checkAccDeletedSuccessfullyMessage() {
        return driver.findElement(acc_DeletedSuccessfully).getText().contains("DELETED");
    }

    public void clickDeleteAccount() {
        driver.findElement(deleteAccButton).click();
    }

    public void pressContinue() {
        driver.findElement(Continue_Button).click();
    }

    //Login
    public void enterLoginEmail(String signUpEmail) {
        driver.findElement(enterEmail_SignIn).sendKeys(signUpEmail);

    }

    public void enterLoginPassword(String accPassword) {
        driver.findElement(enterPassword_SignIn).sendKeys(accPassword);

    }

    public void clickLogin_LogoutButton() {
        driver.findElement(signIn_signOutButton).click();
    }

    public void clickLoginButton() {

        driver.findElement(signInButton_Click).click();
    }

    public boolean checkErrorMessage() {
        return driver.findElement(login_ErrorMessage).getText().contains("incorrect");

    }

    public void clickLoggedoutButton() {
        driver.findElement(loggedOutButton).click();
    }

    public String getCurrentUrl() {
        String checker = driver.getCurrentUrl();
        return checker;
    }

    public String getEmailErrorExistMessage() {
        String message = driver.findElement(emailErrrorExistMessage).getText();
        return message;
    }
    public  String getLoggedInText(){
        return driver.findElement(loggedInButton).getText();
    }
    public String acc_DeletedSuccessfully_message(){
        return driver.findElement(acc_DeletedSuccessfully).getText();
    }
}