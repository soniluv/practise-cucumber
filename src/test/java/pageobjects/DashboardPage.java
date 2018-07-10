package pageobjects;

import helpers.WebDriverHelpers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BaseClass {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public DriverPage gotoDriverPage() {
        driver.navigate().to("http://se.testersworld.com/User/Drivers");
        Assert.assertTrue(WebDriverHelpers.textExists("Drivers"));
        return new DriverPage(driver);
    }
}
