package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //locators/////

    @FindBy(how = How.XPATH, using = "//a[@href='#TOURS']")
    private static WebElement tourTab;

    @FindBy(how = How.LINK_TEXT, using = "VISA")
    private static WebElement visaTab;

    @FindBy(how = How.XPATH, using = "//a[@href='#HOTELS']")
    private static WebElement hotelsTab;

    @FindBy(how = How.XPATH, using = "(//button[contains(text(),'Search')])[2]")
    private static WebElement searchTours;

    /////////actions/methods-------//////

    public void gotoToursTab(String tabName) {
        if(tabName.equalsIgnoreCase("tours"))
            tourTab.click();
        else if(tabName.equalsIgnoreCase("visa"))
            visaTab.click();
        else if(tabName.equalsIgnoreCase("hotels"))
            hotelsTab.click();
    }

    public void search(){


    }

    public void waitAndClickOnSearch() {
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Search')])[2]")));
        searchTours.click();
    }
}
