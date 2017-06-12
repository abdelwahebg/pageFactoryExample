package pageObject.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageFactory.common.PF_WebUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends PF_WebUtil {

    public static final String EMAIL_ITEM = "div[class='y6'] span[id=':2u'] b";
    WebDriver driver;

    @FindBy(css = EMAIL_ITEM)
    @CacheLookup
    public WebElement email_item;

    public InboxPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public static void checkItsInboxPage(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox (1)")));
        Assert.assertTrue("Landing to Inbox Page check point failed!", driver.findElement(By.partialLinkText("Inbox (1)")).isDisplayed());
    }
}