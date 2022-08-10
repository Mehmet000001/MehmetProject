package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {
    public FacebookLoginPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement Email;
    @FindBy(xpath = "//*[@id=\"pass\"]")
    WebElement Password;
    @FindBy(xpath = "//*[@name=\"login\"]")
    WebElement login;

    @FindBy(xpath = "//*[@class=\"_9ay7\"]")
    WebElement errorMessage;


    public void Login(String email,String password){
        Email.sendKeys(email);
        Password.sendKeys(password);
        login.click();
    }

    public  String getErrorMessage(){
        return  errorMessage.getText().trim();
    }
        }