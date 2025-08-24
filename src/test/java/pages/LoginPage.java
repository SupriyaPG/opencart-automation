package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    //Constructor
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;

    }

    //Locators
    By myAccount = By.xpath("//span[normalize-space()='My Account']");
    By logiLink= By.linkText("Login");
    By emailField= By.id("input-email");
    By passwordField=By.id("input-password");
    By loginButton=By.xpath("//button[normalize-space()='Login']");
    By logoutLink=By.linkText("Logout");

    //Actions
    public  void openLoginPage()
    {
        driver.findElement(myAccount).click();
        driver.findElement(logiLink).click();
    }

    public void login(String email,String password)
    {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoginLinkDisplayed()
    {
        return driver.findElement(logiLink).isDisplayed();
    }
}
