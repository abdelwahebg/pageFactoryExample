package pageObject.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebUtil {

    public static final String BASEURL = "https://www.gmail.com";
    public static final String USERNAME = "chocolateMonsterUK@gmail.com";
    public static final String PASSWORD = "6tZ72ZrbmT";

    public WebDriverWait wait(WebDriver driver, String fieldName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(fieldName)));
        return wait;
    }
}