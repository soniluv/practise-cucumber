package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import helpers.WebDriverHelpers;
import org.junit.Assert;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;
import pageobjects.ToursPage;
import pageobjects.VisaPage;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class toursStepDefs {

    public WebDriver driver;
    HomePage homePage;
    ToursPage toursPage;
    VisaPage visaPage;

    public toursStepDefs() {
        driver = Hooks.driver;
    }


    @Given("^user is in landing page$")
    public void user_is_in_landing_page() throws Throwable {
        toursPage = new ToursPage(driver);
        toursPage.checkIfUserIsInLandingPage();
    }
    @When("^he go to \"([^\"]*)\" tab$")
    public void he_go_to_tour_tab(String tabName) throws Throwable {

        homePage = new HomePage(driver);
        homePage.gotoToursTab(tabName);
    }
    @When("^fill the destination as \"(.*?)\"$")
    public void fill_the_destination_as(String destination) throws Throwable {
        System.out.println(destination);
        WebDriverHelpers.waitForSecs(3);
        driver.findElement(By.id("s2id_autogen10")).sendKeys(destination);
        WebDriverHelpers.waitForSecs(3);
        driver.findElement(By.className("select2-result-label")).click();
    }

    @When("^leave the default option and search$")
    public void leave_the_default_option_and_search() throws Throwable {

        homePage.waitAndClickOnSearch();
    }

    @When("^he select to \"([^\"]*)\"$")
    public void heSelectTo(String button) throws Throwable {
        toursPage = new ToursPage(driver);
        toursPage.selectOption(button);
    }
    @Then("^he should see \"(.*?)\" text$")
    public void he_should_see_text(String text) throws Throwable {

        System.out.println(text);
        toursPage = new ToursPage(driver);
        toursPage.checkifUserIsInToursPage(text);
    }

    @Then("^then he select to no of \"(.*?)\"$")
    public void then_he_select_to_no_of(String adults) throws Throwable {
        toursPage = new ToursPage(driver);
        toursPage.confirmBookingOptions1(adults);
    }

    @Then("^he select to no of \"(.*?)\"$")
    public void he_select_to_no_of(String child) throws Throwable {
        toursPage = new ToursPage(driver);
        toursPage.confirmBookingOptions2(child);
    }

    @Then("^he select no of \"(.*?)\"$")
    public void he_select_no_of(String infant) throws Throwable {
        toursPage = new ToursPage(driver);
        toursPage.confirmBookingOptions3(infant);
    }

    @When("^he fill the minimum required fields \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void heFillTheMinimumRequiredFieldsAnd(String firstName, String lastName, String email, String confirmEmail) throws Throwable {
        toursPage = new ToursPage(driver);
        toursPage.completePersonalDetails(firstName,lastName,email,confirmEmail);
    }

    @And("^he selects to confirmThisBooking$")
    public void heSelectsTo() throws Throwable {
        toursPage = new ToursPage(driver);
        toursPage.clickConfirmBooking();
    }

    @Then("^he should see the \"([^\"]*)\" text$")
    public void heShouldSeeTheText(String text) throws Throwable {
        Thread.sleep(5000);
       toursPage = new ToursPage(driver);
       toursPage.checkIfUserIsOnInvoicePage(text);
    }


    @Then("^he should see the default price should match the Total USD price$")
    public void heShouldSeeTheDefaultPriceShouldMatchTheTotalUSDPrice() throws Throwable {
        toursPage = new ToursPage(driver);
        toursPage.seeTheDefaultPrice();
    }

    @And("^he provides his \"([^\"]*)\" address$")
    public void heProvidesHisEmailAddress(String email) throws Throwable {
        //WebDriverHelpers.waitForSecs(5);
        visaPage = new VisaPage(driver);
        visaPage.providesHisEmailAdd(email);
    }

    @When("^he provides invalid \"(.*?)\" address$")
    public void he_provides_invalid_address(String email) throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.providesHisEmailAdd(email);
    }

    @And("^he provides arrival date in Canada$")
    public void heProvidesArrivalDateInCanada() throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.providesHisArrivalDateInCanada();
    }

    @And("^he provides his \"([^\"]*)\"$")
    public void heProvidesHisPhonenumber(String phonenumber) throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.providesHisPhoneNumber(phonenumber);
    }

    @And("^he provides his own \"([^\"]*)\"$")
    public void heProvidesHisHomeAddress(String homeAddress) throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.providesHisOwnHomeAdd(homeAddress);
    }

    @And("^he provides his home \"([^\"]*)\"$")
    public void heProvidesHisHomeCountry(String country) throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.providesHisHomeCountry(country);
    }

    @And("^he should provide valid mode for \"([^\"]*)\"$")
    public void heShouldProvideValidModeForTransport(String mode) throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.provideValidModeOfTransport(mode);
    }

    @And("^he provides his \"([^\"]*)\" and \"([^\"]*)\"$")
    public void heProvidesHisFirstNameAndLastName(String firstName, String lastName) throws Throwable {
        Thread.sleep(5000);
        visaPage = new VisaPage(driver);
        visaPage.providesFirstNameLastName(firstName,lastName);
    }

    @And("^he provides his \"([^\"]*)\" as in passport$")
    public void heProvidesHisNationalityAsInPassport(String nationality) throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.providesHisNationalityAsHisPassport(nationality);
    }

    @And("^he provides his birthday$")
    public void heProvidesHisBirthday() throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.providesHisBirthday();
    }

    @And("^he enters his \"([^\"]*)\"$")
    public void heEntersHisGender(String gender) throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.entersHisGender(gender);
    }

    @And("^he provides his \"([^\"]*)\" number$")
    public void heProvidesHisPassportNumber(String passportId) throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.providesHisPassportNumber(passportId);
    }

    @And("^he provides his passport issued$")
    public void heProvidesHisPassportIssued() throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.providesHisPassportIssued();
    }

    @And("^he provides his passport expiration date$")
    public void heProvidesHisPassportExpirationDate() throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.providesHisPassportExpirationDate();

    }

    @And("^he provides Canadian visa type$")
    public void heProvidesCanadianVisaType() throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.providesCanadianVisaType();
    }

    @Then("^he should see the embassy registration charges$")
    public void heShouldSeeTheEmbassyRegistrationCharges() throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.seeTheEmbasseyRegistrationCharges();
    }

    @When("^he click on next button$")
    public void heClickOnNextButton() throws Throwable {
        Thread.sleep(3000);
        visaPage = new VisaPage(driver);
        visaPage.clickOnNextButton();
    }

    @Then("^he should see the payment revision page$")
    public void heShouldSeeThePaymentRevisionPage() throws Throwable {
        visaPage = new VisaPage(driver);
        visaPage.seePaymentRevisionPage();
    }

    @Then("^he should see the error message \"(.*?)\"$")
    public void he_should_see_the_error_message(String errorMsg) throws Throwable {
       WebElement errorText= driver.findElement(By.xpath("//div[@class='col-xs-12']//div[@class='ivisa_submit_error_message']"));
       String displayedError= errorText.getText();
       Assert.assertTrue(displayedError.equalsIgnoreCase(errorMsg));
    }

    @When("^he do not enter his \"(.*?)\"$")
    public void he_do_not_enter_his(String phoneNumber) throws Throwable {
       driver.findElement(By.cssSelector("[class='selected-flag'] [class='iti-arrow']")).click();
       driver.findElement(By.cssSelector("[class='country preferred'] [class='dial-code']")).click();
       driver.findElement(By.xpath("//input[@data-ivisa-validation-type='phone_number']")).sendKeys(phoneNumber);
    }

    @Then("^he should see the error message as \"(.*?)\"$")
    public void he_should_see_the_error_message_as(String phoneError) throws Throwable {
        WebElement displayedErrorMsg= driver.findElement(By.xpath("//div[@class='col-xs-12']//div[@class='ivisa_submit_error_message']"));
        String displayedPhoneErrorMsg= displayedErrorMsg.getText();
        Assert.assertTrue(displayedPhoneErrorMsg.equalsIgnoreCase(phoneError));
    }
    @And("^he provide invalid mode for \"(.*?)\"$")
    public void he_should_provide_invalid_mode_for(String mode) throws Throwable {
        Select select2 = new Select(driver.findElement(By.xpath("//select[@data-ivisa-name='traveling_by']")));
        select2.selectByVisibleText(mode);
    }

    @Then("^he should see the ETA error message as \"(.*?)\"$")
    public void he_should_see_the_ETA_error_message_as(String etaDisplayedErrorMsg) throws Throwable {
        WebElement etaError= driver.findElement(By.xpath("//div[@class='ivisa-prevent-submission-message']"));
        String etaErrorMsg= etaError.getText();
        Assert.assertTrue(etaErrorMsg.equalsIgnoreCase(etaDisplayedErrorMsg));
    }

    @Then("^he should also see the displayed error message as \"(.*?)\"$")
    public void he_should_also_see_the_displayed_error_message_as(String error) throws Throwable {
        WebDriverHelpers.waitForSecs(3);
       WebElement submitError= driver.findElement(By.xpath("//div[@class='col-xs-12']//div[@class='ivisa_submit_error_message']"));
       Assert.assertTrue(submitError.isDisplayed());
    }
}
