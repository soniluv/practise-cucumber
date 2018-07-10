package pageobjects;

import helpers.WebDriverHelpers;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ToursPage extends BaseClass {
    @FindBy(how = How.TAG_NAME, using = "body")
    private static WebElement body;

    @FindBy(how = How.CLASS_NAME, using = "navbar-brand")
    private static WebElement assertUserIsInLandingPage;

    @FindBy(how = How.XPATH, using = "//td[@class='text-center adultPrice']")
    private static WebElement displayedAdultPrice;

    @FindBy(how = How.XPATH, using = "//span[@class='totalCost']")
    private static WebElement displayedTotalPrice;

    @FindBy(how = How.XPATH, using = "//input[@name='firstname']")
    private static WebElement customerFirstName;

    @FindBy(how = How.XPATH, using = "//input[@name='lastname']")
    private static WebElement customerSecondName;

    @FindBy(how = How.XPATH, using = "//input[@name='email']")
    private static WebElement customerEmailId;

    @FindBy(how = How.XPATH, using = "//input[@name='confirmemail']")
    private static WebElement customerToConfirmEmailId;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private static WebElement clickConfirmedBooking;

    @FindBy(how = How.ID, using = "invoiceTable")
    private static WebElement invoicePage;

    public ToursPage(WebDriver driver) {
        super(driver);
    }

    public void checkIfUserIsInLandingPage(){
        driver.get("https://www.phptravels.net/");
        Assert.assertTrue(assertUserIsInLandingPage.isDisplayed());
    }

    public void checkifUserIsInToursPage(String text) {
        Assert.assertTrue(body.getText().contains(text));
    }

    public void selectOption(String button) {
        System.out.println(button);
        driver.findElement(By.xpath("(//button[contains(text(),'" + button + "')])")).click();
    }
    public void seeTheDefaultPrice(){
        WebDriverHelpers.waitForSecs(3);
        WebElement adultPrice = displayedAdultPrice;
        String actualAdultPrice= "USD "+adultPrice.getText();
        WebElement totalPrice= displayedTotalPrice;
        String actualTotalPrice= totalPrice.getText();
        Assert.assertEquals(actualAdultPrice,actualTotalPrice);
    }
    public void completePersonalDetails(String firstName, String lastName, String email, String confirmEmail) {
        customerFirstName.sendKeys("Chris");
        customerSecondName.sendKeys("Lass");
        customerEmailId.sendKeys("mvn123@yahoo.com");
        customerToConfirmEmailId.sendKeys("mvn123@yahoo.com");
    }
    public void clickConfirmBooking(){
        clickConfirmedBooking.click();
    }

    public void confirmBookingOptions1(String adults){
        Select s1 = new Select(driver.findElement(By.cssSelector("#selectedAdults")));
        s1.selectByValue("2");
    }
    public void confirmBookingOptions2(String child){
        Select s2 = new Select(driver.findElement(By.cssSelector("#selectedChild")));
        s2.selectByValue("0");
    }
    public void confirmBookingOptions3(String infant){
        Select s3 = new Select(driver.findElement(By.cssSelector("#selectedInfants")));
        s3.selectByValue("0");
    }

    public void checkIfUserIsOnInvoicePage(String text){
        Assert.assertTrue(invoicePage.getText().contains(text));
    }
}