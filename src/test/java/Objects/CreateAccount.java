package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

    WebDriver driver;

    public CreateAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@name=\"firstname\"]")
    WebElement firstname;
    @FindBy(xpath = "//*[@name=\"lastname\"]")
    WebElement lastname;
    @FindBy(xpath = "//*[@name=\"reg_email__\"]")
    WebElement Mobilenumber;
    @FindBy(xpath = "//*[@name=\"reg_passwd__\"]")
    WebElement newPassword;
    @FindBy(xpath = "//*[@name='birthday_month']")
    WebElement month;
    @FindBy(xpath = "//*[@name='birthday_day']")
    WebElement day;
    @FindBy(xpath = "//*[@name='birthday_year']")
    WebElement year;
    @FindBy(xpath = "(//*[@name='sex'])[1]")
    WebElement female;
    @FindBy(xpath = "(//*[@name='sex'])[2]")
    WebElement male;
    @FindBy(xpath = "(//div/button[@type='submit' and contains(text(),'Sign Up')])[1]")
    WebElement signUp;


    public void signUp(String fname,String lname,String Mname, String nPass,String bt_month,String bt_day,String bt_year){

        firstname.sendKeys(fname);
        lastname.sendKeys(lname);
        Mobilenumber.sendKeys(Mname);
        newPassword.sendKeys(nPass);
        month.sendKeys(bt_month);
        day.sendKeys(bt_day);
        year.sendKeys(bt_year);

    }

    public void clickMale(){
        male.click();
    }

    public void clickFemale(){

        female.click();
    }

    public void clickSignup()
    {
        signUp.click();

    }
}
