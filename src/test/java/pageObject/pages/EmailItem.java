package pageObject.pages;

import pageFactory.common.PF_WebUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailItem extends PF_WebUtil {

    public static final String SUBJECT_TEXT = "span[class='go']";
    WebDriver driver;

    @FindBy(css = SUBJECT_TEXT)
    @CacheLookup
    public WebElement subjectText;

    public EmailItem(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        // Test

        PageFactory.initElements(driver, this);

    }
}