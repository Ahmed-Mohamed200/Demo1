package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ProductsPage {
    WebDriver driver;
    Select select;
    WebDriverWait webDriverWait;
    Actions actions;
    public String URL = "https://automationexercise.com/";
    public String productsUrl = "https://automationexercise.com/products";
    By searchField = By.xpath("//input[@id='search_product']");
    By searchIcon = By.xpath("//i[@class='fa fa-search']");
    By searchedProductsTitle = By.xpath("//div[@class='features_items']/h2");
    public int firstProductQuantity=0;
    public int secondProductQuantity=0;

    By cartTotal_firstItem=By.xpath("//tr[@id='product-1']//td[@class='cart_total']//p");
    By cartTotal_secondItem=By.xpath("//tr[@id='product-2']//td[@class='cart_total']//p");


    By cartFirstItem_Quantity=By.xpath("//tr[@id='product-1']//td[@class='cart_quantity']//button");
    By cartSecondItem_Quantity=By.xpath("//tr[@id='product-2']//td[@class='cart_quantity']//button");

    public String getText_FirstItemQuantity(){
       return driver.findElement(cartFirstItem_Quantity).getText();
    }
    public String getText_SecondItemQuantity(){
        return driver.findElement(cartSecondItem_Quantity).getText();
    }

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    By ProductsButton = By.xpath("//a[@href='/products']");
    By productsDescreptionlist = By.xpath("//div[@class='productinfo text-center']//p");
    By HoveredElement=By.xpath("//div[@class='productinfo text-center']//p[contains(text(),'Blue Top')]");

    By addToCartButton_firstItem=By.xpath("//a[@data-product-id='1']");
    By addToCartButton_secondItem=By.xpath("//a[@data-product-id='2']");
    By firstItemText=By.xpath("//a[@data-product-id='1']//parent::div//p");
    By secondItemText=By.xpath("//a[@data-product-id='2']//parent::div//p");

    By firstItemPrice=By.xpath("//a[@data-product-id='1']//parent::div//h2");
    By secondItemPrice=By.xpath("//a[@data-product-id='2']//parent::div//h2");

    By firstItemCartPrice=By.xpath("//tr[@id=\"product-1\"]/td[3]/p");
    By SecondItemCartPrice=By.xpath("//tr[@id=\"product-2\"]/td[3]/p");


    public String getText_firstItemPrice(){
      return driver.findElement(firstItemPrice).getText();
    }
    public String getText_secondItemPrice(){
        return driver.findElement(secondItemPrice).getText();
    }

    public String getCartText_firstItemPrice(){
        return driver.findElement(firstItemCartPrice).getText();
    }

    public String getCartText_secondtItemPrice(){
        return driver.findElement(SecondItemCartPrice).getText();
    }
    public By continueShoppingButton=By.xpath("//div[@class='modal-footer']//button");
    By viewCartButton=By.xpath("//a[@href='/view_cart']");

    By cartFirstItem=By.xpath("//a[@href='/product_details/1']");
    By cartSecondItem=By.xpath("//a[@href='/product_details/2']");



    public void validateSearchResultsData(String expectedDesc) {
        List<WebElement> list = driver.findElements(productsDescreptionlist);
        SoftAssert softAssert = new SoftAssert();
        for (WebElement webElement : list) {
            String name = webElement.getText();
            softAssert.assertTrue(name.contains(expectedDesc), "Expected: [" + expectedDesc + "] and the actual is: [" + name + "]");
        }
        softAssert.assertAll();
    }

    public void moveToElement() {
        actions=new Actions(driver);
        actions.moveToElement(driver.findElement(HoveredElement)).perform();
  }
    public void clickProductButton() {
        driver.findElement(ProductsButton).click();
    }

    public String verifyProductPageURl() {
        String productUrl = driver.getCurrentUrl();
        return productUrl;
    }

    public void searchProduct(String searchData) {

        driver.findElement(searchField).click();
        driver.findElement(searchField).sendKeys(searchData);
        driver.findElement(searchIcon).click();
    }

    public String verifyProductsTitle() {
        String productTitle = driver.findElement(searchedProductsTitle).getText();
        return productTitle;
    }
    public String getCurrentURl(){
        return driver.getCurrentUrl();
    }

    public void addFirstProduct(){
        driver.findElement(addToCartButton_firstItem).click();
    }
    public void addSecondProduct(){
        driver.findElement(addToCartButton_secondItem).click();
    }
    public void pressContinueShopping(){
        driver.findElement(continueShoppingButton).click();
    }
    public void clickViewCart(){
        driver.findElement(viewCartButton).click();
    }
    public Boolean checkFirstItemText(){
         boolean x= driver.findElement(firstItemText).getText().contains("Blue");
         return x;
    }
    public Boolean checkSecondItemText(){
        Boolean y= driver.findElement(secondItemText).getText().contains("Men");
        return y;
    }
    public String checkCartFirstItem(){
       return driver.findElement(cartFirstItem).getText();
    }
    public String checkCartSecondItem(){
        return driver.findElement(cartSecondItem).getText();
    }
    public String checkTotal_firstItem(){
        return driver.findElement(cartTotal_firstItem).getText();
    }
    public String checkTotal_secondItem(){
        return driver.findElement(cartTotal_secondItem).getText();
    }
}
