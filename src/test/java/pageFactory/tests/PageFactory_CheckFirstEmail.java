package pageFactory.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageFactory.common.PF_BaseTest;
import pageFactory.pages.EmailView;
import pageFactory.pages.LoginPage_Password;
import pageFactory.pages.LoginPage_Username;

import java.util.LinkedHashMap;
import java.util.Map;

import static pageFactory.common.PF_WebUtil.BASEURL;

public class PageFactory_CheckFirstEmail extends PF_BaseTest {
    public static final String USERNAME = "chocolateMonsterUK@gmail.com";
    public static final String PASSWORD = "6tZ72ZrbmT";

    WebDriver driver;

    LoginPage_Username loginPage_username;
    LoginPage_Password loginPage_password;
    InboxPage inboxPage;
    EmailView emailView;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Dev\\chromedriver_win32\\chromedriver.exe");
        final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");
        chromeOptions.addArguments("--start-maximized");
        Map<String, Object> prefs = new LinkedHashMap<>();
        prefs.put("credentials_enable_service", Boolean.valueOf(false));
        prefs.put("profile.password_manager_enabled", Boolean.valueOf(false));
        chromeOptions.setExperimentalOption("prefs", prefs);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver(capabilities);
    }

    @Ignore
    @Test
    public void checkEmail(){

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

        inboxPage.openFirstEmail();

        // PAGE: EmailView
        emailView = new EmailView(driver);
        emailView.checkEmailContent();

        inboxPage.clickInboxLink();
    }

}
