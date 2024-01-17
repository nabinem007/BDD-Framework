package stepDefinations;

import Objects.Facebook;
import Objects.Search;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class Login {
    WebDriver driver ;
    Facebook facebook ;
    Search pagefactory;


    @Given("I launch the facebook page")
    public void i_launch_the_facebook_page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

    }
    @When("I enter username and password")
    public void i_enter_username_and_password() {
         pagefactory = new Search(driver);
        pagefactory.searchgoogle("Facebook");

    }
    @And("I click on the login")
    public void i_click_on_the_login() {
        facebook = new Facebook(driver);
        facebook.loginFacebook("5103166706","Deepa2014");
    }
    @Then("I am on the home page")
    public void i_am_on_the_home_page() {
        facebook.homePage();

   }
  @And("I close the browser")
   public void i_close_the_browser() {
      driver.quit();
    }

}
