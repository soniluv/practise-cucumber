package pageobjects;

import helpers.WebDriverHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminLoginPage extends BaseClass{

    public AdminLoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(how= How.ID, using="email")
    public static WebElement email;

    @FindBy(how=How.ID, using="password")
    public static WebElement password;

    @FindBy(how=How.TAG_NAME, using="button")
    public static WebElement logon_button;


    public void login(String username,String password)
    {
        email.sendKeys(username);
        this.password.sendKeys(password);
        logon_button.click();
    }

    public void login()
    {
        login("admin@gmail.com","Admin@123");
    }

    public boolean isUserLogged() {
            return WebDriverHelpers.textExists("Dashboard");
    }
}
