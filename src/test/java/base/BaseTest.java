package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public  Properties prop;

    @BeforeMethod
    public void setup()
    {
        loadConfig();

        String browser=prop.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome  ")) {
            driver=new ChromeDriver();
            WebDriverManager.chromedriver().setup();

        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void loadConfig()
    {
        prop=new Properties();

        try {
            FileInputStream ip=new FileInputStream("src/test/resources/config.properties");
            prop.load(ip);
           }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown()
    {
        if(driver!=null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
