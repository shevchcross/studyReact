package studyReact;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"classpath:studyReact"},
        stepNotifications = true,
        tags = "not @ignore",
        plugin = {"pretty", "json:target/cucumber.json"},
        features = "classpath:features"
)
public class CucumberRunnerTest {
}