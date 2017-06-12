package pageObject.tests;

import org.junit.Ignore;
import pageFactory.common.PF_BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.pages.InboxPage;
import pageObject.pages.LoginPage;

import static pageFactory.common.PF_WebUtil.BASEURL;

public class EmailTest extends PF_BaseTest {

    @Ignore
    @Test
    public void sdftest(){
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(BASEURL);

        LoginPage.enterUsernameClickNext(driver);

        wait = LoginPage.enterPasswordAndSignIn(driver, wait);

//        InboxPage.checkItsInboxPage(driver, wait);

        WebElement newMandateEmail = driver.findElement(By.cssSelector("div[class='y6'] span[id] b"));
        newMandateEmail.click();

        WebElement subjectText = driver.findElement(By.cssSelector("span[class='go']"));
        Assert.assertEquals("<sagepaydevtest@gmail.com>", subjectText.getText());


    }

}
