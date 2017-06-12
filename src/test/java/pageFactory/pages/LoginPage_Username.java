package pageFactory.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageFactory.common.PF_WebUtil;

public class LoginPage_Username extends PF_WebUtil {

    public static final String USERNAME_INPUT = "identifierId";

    WebDriver driver;

    @FindBy(id = USERNAME_INPUT)
    @CacheLookup
    public WebElement username;

    public LoginPage_Username(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsernameAndClickNext(String strUserName){
        username.clear();
        username.sendKeys(strUserName);
        username.sendKeys(Keys.RETURN);
    }

}
