package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pageFactory.common.PF_WebUtil.PASSWORD;
import static pageFactory.common.PF_WebUtil.USERNAME;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
    }

    public static void enterUsernameClickNext(WebDriver driver) {
        WebElement usernameTextBox = driver.findElement(By.id("identifierId"));
        usernameTextBox.clear();
        usernameTextBox.sendKeys(USERNAME);
        usernameTextBox.sendKeys(Keys.RETURN);
    }

    public static WebDriverWait enterPasswordAndSignIn(WebDriver driver, WebDriverWait wait) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        WebElement passwordTextBox = driver.findElement(By.name("password"));

        passwordTextBox.sendKeys(PASSWORD);
        passwordTextBox.sendKeys(Keys.RETURN);
        return wait;
    }
}
