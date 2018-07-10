package pageobjects;

import helpers.WebDriverHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DriverPage extends BaseClass{


    @FindBy(how=How.ID, using="phone")
    public static WebElement phone;

    @FindBy(how=How.XPATH, using="//input[@value='Create Driver']")
    public static WebElement createDriverButton;

    @FindBy(how=How.ID, using="email")
    public static WebElement email;

    @FindBy(how=How.ID, using="lname")
    public static WebElement lname;

    @FindBy(how=How.ID, using="fname")
    public static WebElement fname;

    @FindBy(how=How.XPATH, using="//div[@id='datatable_filter']//input")
    public static WebElement searchBox;


    @FindBy(how=How.ID, using="datatable")
    public static WebElement resultTable;


    public DriverPage(WebDriver driver) {
        super(driver);
    }

    public void gotoCreateDriver(){
        WebDriverHelpers.openButton("Create Driver");
        WebDriverHelpers.textExists("Create Driver");
    }

    public void createDriver(String email) {

        fname.sendKeys("Atul");
        lname.sendKeys("Kaisia");
        this.email.sendKeys(email);
        phone.sendKeys("1212121212");
        createDriverButton.click();
    }

    public void isDriverCreated() {
        WebDriverHelpers.textExists("Driver Created Successfully");
    }

    public void searchForString(String driverEmail) {

        searchBox.sendKeys(driverEmail);
        WebDriverHelpers.waitForSecs(3);


    }

    public boolean searchResultContainsText(String driverEmail) {
        return resultTable.getText().contains(driverEmail);
    }
}
