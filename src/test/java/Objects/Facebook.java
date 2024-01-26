package Objects;

import io.cucumber.cucumberexpressions.RegularExpression;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.annotation.RegEx;
import java.time.Duration;

// Page object model for the facebook page
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
    @FindBy(xpath = "//a[text()='Create new account']")
    WebElement createAccount;


    public void setCreateAccount() {

        try {
            createAccount.click();
        } catch (Exception e) {
            System.out.println("Exception Caught " + e.getMessage());
        }
    }

   public void emailpass(String email, String password){
       try {
           phone.sendKeys(email);
           pass.sendKeys(password);
       } catch (Exception e) {
           System.out.println("Exception Caught " + e.getMessage());
       }

   }
    public void loginFacebook() {
        try {
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
        } catch (Exception e) {
            System.out.println("Exception Caught " + e.getMessage());
        }


    }
}