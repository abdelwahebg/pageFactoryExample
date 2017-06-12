package pageFactory.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageFactory.common.PF_WebUtil;


public class EmailView extends PF_WebUtil {

    public static final String SUBJECT_TEXT = "span[class='go']";
    WebDriver driver;

    @FindBy(css = SUBJECT_TEXT)
    @CacheLookup
    public WebElement subjectText;

    public EmailView(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openEmail(){
    }

    public void checkEmailContent() {
        Assert.assertEquals("<sagepaydevtest@gmail.com>", subjectText.getText());
    }


    public void closeEmail(){
    }

}