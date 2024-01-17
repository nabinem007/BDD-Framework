package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
    WebDriver driver ;
    public Search(WebDriver driver)
    {
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@name='q']")
    WebElement search ;
    @FindBy(xpath = "(//input[@aria-label='Google Search'])[1]")
    WebElement search_btn;
    @FindBy(xpath = "//h3[text()='Facebook - log in or sign up']")
    WebElement Facebook_link;

    public void searchgoogle(String Searchinput)
    {
        try {
            search.sendKeys(Searchinput);
            search_btn.click();
            Facebook_link.click();

        }catch (Exception e){
            System.out.println("Exception Caught "+e.getMessage());
        }

    }


}
