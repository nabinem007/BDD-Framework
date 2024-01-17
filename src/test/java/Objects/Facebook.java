package Objects;

import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class Facebook {
    WebDriver driver;

    public Facebook(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@name='email']")
    WebElement phone;
    @FindBy(xpath = "//*[@name='pass']")
    WebElement pass;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement login_btn;

    public void loginFacebook(String email, String password) {
        try {
            phone.sendKeys(email);
            pass.sendKeys(password);
            login_btn.click();
        } catch (Exception e) {
            System.out.println("Exception Caught " + e.getMessage());
        }

    }

    public void homePage() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            String title = driver.getTitle();
            System.out.println(title);
            Assert.assertEquals(title, "Facebook");
        } catch (Exception e) {
            System.out.println("Exception Caught " + e.getMessage());
        }


    }
}