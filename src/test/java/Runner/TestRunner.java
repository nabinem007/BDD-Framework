package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/main/resources/Features/Login.feature"},
        tags = "@smoke",
        glue = {"stepDefinations"},
        plugin = { "pretty","html:target/CucumberReport.html",
                "json:target/cucumber.json"
                }

)

public class TestRunner {


}

