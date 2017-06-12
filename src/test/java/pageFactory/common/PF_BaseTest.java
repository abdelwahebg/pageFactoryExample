package pageFactory.common;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageFactory.pages.EmailView;
import pageFactory.pages.LoginPage_Password;
import pageFactory.pages.LoginPage_Username;

public class PF_BaseTest {

//    public static final String GEKHO_DRIVER="webdriver.gecko.driver";
//    public static final String GEKHO_DRIVER_LOCATION = "C:\\dev\\geckodriver-v0.16.1-win64\\geckodriver.exe";
WebDriver driver;


    public static class InboxPage extends PF_WebUtil {

        public static final String EMAIL_ITEM = "div[class='y6'] span[id=':2u'] b";
        public static final String INBOX_LINK_ONE = "Inbox (1)";
        public static final String INBOX_LINK = "Inbox";

        WebDriver driver;
        LoginPage_Username loginPage_username;
        LoginPage_Password loginPage_password;
        InboxPage inboxPage;
        EmailView emailView;

        @FindBy(css = EMAIL_ITEM)
        @CacheLookup
        public WebElement email_item;

        @FindBy(partialLinkText = INBOX_LINK_ONE)
        @CacheLookup
        public WebElement inbox_link_one;

        @FindBy(partialLinkText = INBOX_LINK)
        @CacheLookup
        public WebElement inbox_link;

        public InboxPage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void loginToGmail() {

            driver.get(BASEURL);

            // PAGE : Enter Username
            loginPage_username = new LoginPage_Username(driver);
            loginPage_username.enterUsernameAndClickNext(USERNAME);

            // PAGE : Enter password
            loginPage_password = new LoginPage_Password(driver);
            loginPage_password.enterPasswordAndClickLogin(PASSWORD);

            // PAGE : Inbox
            inboxPage = new InboxPage(driver);
            inboxPage.checkItsInboxPage();
        }

        public boolean verifyInboxPageTitle() {
            String expectedPageTitle="Gmail";
            return getPageTitle().contains(expectedPageTitle);
        }

        public String getPageTitle(){
            String title = driver.getTitle();
            return title;
        }

        public void checkItsInboxPage(){
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf((inbox_link_one)));
            Assert.assertTrue("Landing to Inbox Page check point failed!", (inbox_link_one).isDisplayed());
        }

        public WebElement openFirstEmail(){
            email_item.click();
            return email_item;
        }

        public void clickInboxLink(){
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(inbox_link));
        }
    }
}