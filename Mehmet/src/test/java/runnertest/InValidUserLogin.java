package runnertest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FacebookLoginPage;

public class InValidUserLogin {

    WebDriver driver;
    FacebookLoginPage facebookLoginPage;

    @BeforeMethod
    public void EnvSetUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        facebookLoginPage = new FacebookLoginPage(driver);
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void invaliduUserLoginTest(){
        facebookLoginPage.Login("?**", "%$&&");
        Assert.assertEquals(facebookLoginPage.getErrorMessage(),"The email or mobile number you entered isn’t connected to an account. Find your account and log in.");
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
