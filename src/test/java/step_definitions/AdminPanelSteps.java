package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import helpers.BrowserFactory;
import helpers.WebDriverHelpers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageobjects.AdminLoginPage;
import pageobjects.DashboardPage;
import pageobjects.DriverPage;

public class AdminPanelSteps {

    public WebDriver driver;
    public AdminLoginPage adminLoginPage;
    public DashboardPage dashboardPage;
    public DriverPage driverPage;
    public String driverEmail;

    public AdminPanelSteps() {
        driver = Hooks.driver;
    }


    @Given("^admin logged into the admin panel$")
    public void adminLoggedIntoTheAdminPanel() throws Throwable {
        WebDriverHelpers.openAdminPanel(driver);
        adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.login();
        Assert.assertTrue(adminLoginPage.isUserLogged());
    }

    @When("^he create a driver with username \"([^\"]*)\"$")
    public void heCreateADriverWithUsername(String email) throws Throwable {

        driverEmail = email;
        dashboardPage = new DashboardPage(driver);
        driverPage = dashboardPage.gotoDriverPage();
//        driverPage = new DriverPage(driver); //dashboardPage.gotoDriverPage();
        driverPage.gotoCreateDriver();
        driverPage.createDriver(email);
    }

    @Then("^driver should be successfully created$")
    public void driverShouldBeSuccessfullyCreated() throws Throwable {

        driverPage.isDriverCreated();

    }

    @When("^admin view his details$")
    public void adminViewHisDetails() throws Throwable {
        driverPage.searchForString(driverEmail);
        Assert.assertTrue(driverPage.searchResultContainsText(driverEmail));

    }

    @Then("^the details should be as entered$")
    public void theDetailsShouldBeAsEntered() throws Throwable {
        Assert.assertTrue(driverPage.searchResultContainsText("1212121212"));
    }
}
