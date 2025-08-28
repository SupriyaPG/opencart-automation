package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitHelper {
    WebDriver driver;
    WebDriverWait wait;
    private ExpectedConditions ExcpectectedConditions;

    public WaitHelper(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    public static void waitJVM(int time)
    {
        try{
             Thread.sleep(time);
           }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }

    public static void waitImplicitWait(WebDriver driver,int time)
    {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }


    public void waitForElementVisible(By locator){
        wait.until(ExcpectectedConditions.visibilityOfElementLocated(locator));
    }
}
