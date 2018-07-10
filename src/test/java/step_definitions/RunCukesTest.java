package step_definitions;//package step_definitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json"},
		tags = {"@smoke"}
		)
public class RunCukesTest{
	public static String browser = "chrome";
	public static boolean remote = false;
}