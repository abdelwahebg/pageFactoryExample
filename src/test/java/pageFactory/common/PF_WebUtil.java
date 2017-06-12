package pageFactory.common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PF_WebUtil {

    public static final String BASEURL = "https://www.gmail.com";
    public static final String USERNAME = "sagepaydevtest@gmail.com";
    public static final String PASSWORD = "5Mz3beJxfv";

    WebDriver driver ;

    public WebDriverWait wait(WebDriver driver, String fieldName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(fieldName)));
        return wait;
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}