package pageFactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageFactory.common.PF_BaseTest;
import pageFactory.common.PF_WebUtil;

public class LoginPage_Password extends PF_WebUtil{

    public static final String PASSWORD_INPUT = "password";

    WebDriver driver;

    @FindBy(name = PASSWORD_INPUT)
    @CacheLookup
    public WebElement password;

    public LoginPage_Password(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PF_BaseTest.InboxPage enterPasswordAndClickLogin(String strPassword){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        password.clear();
        password.sendKeys(strPassword);
        password.sendKeys(Keys.RETURN);
        return new PF_BaseTest.InboxPage(driver);
    }
}
