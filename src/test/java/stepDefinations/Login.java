package stepDefinations;

import Objects.CreateAccount;
import Objects.Facebook;
import Objects.Search;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.Map;


public class Login {
    WebDriver driver;
    Facebook facebook;
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
        pagefactory = new Search(driver);
        pagefactory.searchgoogle("Facebook");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @When("I click Create new account")
    public void i_click_create_new_account() {
        facebook = new Facebook(driver);
        facebook.setCreateAccount();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @And("I click on the login")
    public void i_click_on_the_login() {
        facebook = new Facebook(driver);
        facebook.emailpass("510-316-6706","Deepa2014");
        facebook.loginFacebook();

    }

    @Then("I am on the home page")
    public void i_am_on_the_home_page() {
        facebook.homePage();

    }

    @And("I close the browser")
    public void i_close_the_browser() {

        driver.quit();
    }


    @Then("enter the details on the page")
    public void enterTheDetailsOnThePage(DataTable dataTable) {
       // List<Map<String, String>> userMap = dataTable.asMaps(String.class, String.class);
//        System.out.println(userMap);
//        System.out.println(userMap.get(0).get("First name"));
//        System.out.println(userMap.get(0).get("Last name"));
//        for (Map<String, String> e : userMap) {
//            System.out.println(e.get("First name"));
//            System.out.println(e.get("Last name"));
//            System.out.println(e.get("Mobile number"));
//            System.out.println(e.get("New Password"));
//        }

        List<List<String>> data = dataTable.cells();
        CreateAccount ca = new CreateAccount(driver);
        String fname = data.get(1).get(0);
        String lname = data.get(1).get(1);
        String mnumber = data.get(1).get(2);
        String npass = data.get(1).get(3);
        String month = data.get(1).get(4);
        String day = data.get(1).get(5);
        String year = data.get(1).get(6);
        ca.signUp(fname,lname,mnumber,npass,month,day,year);
        ca.clickMale();
        ca.clickSignup();
    }
    @And("I enter username as {string} and password as {string}")
    public void iEnterUsernameAsAndPasswordAs(String username, String password) {
        facebook = new Facebook(driver);
        facebook.emailpass(username, password);
    }

    @And("I click on the login tab")
    public void iClickOnTheLoginTab() {
        facebook = new Facebook(driver);
        facebook.loginFacebook();
    }

    @When("user enter credentials using DataTable")
    public void userEnterCredentialsUsingDataTable(DataTable dataTable) {
        System.out.println("User enters email/phone and password");
        List<List<String>> data = dataTable.cells();
        facebook = new Facebook(driver);
        String username = data.get(0).get(0);
        String password = data.get(0).get(1);
        facebook.emailpass(username,password);

    }
}


