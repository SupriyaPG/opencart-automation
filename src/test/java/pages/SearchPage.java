package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class SearchPage {
    WebDriver driver;

    //constructor
    public SearchPage(WebDriver driver)

    {
        this.driver=driver;
    }

    //Locator
    By searchBox= By.name("search");
    By SearchButton=By.xpath("//i[@class='fa-solid fa-magnifying-glass']");
    By firstProduct=By.xpath("//div[@class='image']//img[@title='MacBook']");
     By productQtyBox=By.xpath("//input[@id='input-quantity']");
     By addToCartButton=By.xpath("//button[@id='button-cart']");
      By successMessage=By.xpath("//div[@id='alert']");
     By alertMsg=By.id("alert");

    //Actions
    public void searchProduct(String productName)
    {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(SearchButton).click();

    }

    public void openFirstProduct()
    {
        WaitHelper.waitJVM(5);
        driver.findElement(firstProduct).click();
    }

    public  void addToCart(String qty)
    {
        WaitHelper.waitJVM(5);
        driver.findElement(addToCartButton).click();
        driver.findElement(productQtyBox).sendKeys(qty);

    }

//    public String alertMessage()
//    {
//        return  driver.findElement(alertMsg).getText();
//    }

    public boolean isProductAdded()
    {
        WaitHelper.waitJVM(5);
    return  driver.findElement(alertMsg).isDisplayed();
    }
}
