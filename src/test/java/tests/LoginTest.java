package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin()
    {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("jini@gmail.com","jinisas");

        //Assert login success (Login link should be visible
        Assert.assertTrue(loginPage.isLoginLinkDisplayed(),"Login Failed");
    }
}
