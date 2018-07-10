package pageobjects;

import helpers.WebDriverHelpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class VisaPage extends BaseClass {


    @FindBy(how = How.XPATH, using = "//input[@data-ivisa-label='Email address']")
    private static WebElement emailAdd;

    @FindBy(how = How.CSS, using = "[class='selected-flag'] [class='iti-arrow']")
    private static WebElement clickArrow;

    @FindBy(how = How.CSS, using = "[class='country preferred'] [class='dial-code']")
    private static WebElement countryDialCode;

    @FindBy(how = How.XPATH, using = "//input[@data-ivisa-validation-type='phone_number']")
    private static WebElement countryPhoneNumber;

    @FindBy(how = How.XPATH, using = "//input[@data-ivisa-label='Home Address (include city & ZIP code)']")
    private static WebElement countryHomeAddress;

    public VisaPage(WebDriver driver) { super(driver);}

   // public void goToVisaTab(){
    //    visaTab.click();
   // }
    public void providesHisEmailAdd(String email){
        emailAdd.sendKeys(email);
    }
    public void providesHisArrivalDateInCanada(){
        driver.findElement(By.xpath("//input[@data-ivisa-name='arrival_date']")).click();
        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='switch']")).getText().contains("August")){
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }
        List<WebElement> dates= driver.findElements(By.cssSelector(".day"));
        int count= driver.findElements(By.cssSelector(".day")).size();
        for(int i=0; i<count; i++){
            String text= driver.findElements(By.cssSelector(".day")).get(i).getText();
            if(text.equalsIgnoreCase("23")){
                driver.findElements(By.cssSelector(".day")).get(i).click();
                break;
            }
        }
    }
    public void providesHisPhoneNumber(String phonenumber){
        clickArrow.click();
        countryDialCode.click();
        countryPhoneNumber.sendKeys(phonenumber);
    }

    public void providesHisOwnHomeAdd(String homeAddress){
        countryHomeAddress.sendKeys(homeAddress);
    }
    public void providesHisHomeCountry(String country){
        Select select= new Select(driver.findElement(By.xpath("//select[@data-ivisa-name='home_country']")));
        select.selectByVisibleText(country);
    }
    public void provideValidModeOfTransport(String mode){
        Select select2 = new Select(driver.findElement(By.xpath("//select[@data-ivisa-name='traveling_by']")));
        select2.selectByVisibleText(mode);
    }
    public void providesFirstNameLastName(String firstName, String lastName){

        driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[1]/span/div/div[4]/section[2]/div[2]/div[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[1]/span/div/div[4]/section[2]/div[2]/div[1]/input")).sendKeys(firstName);
        driver.findElement(By.xpath("//html//section[2]/div[2]/div[2]/input[1]")).click();
        driver.findElement(By.xpath("//html//section[2]/div[2]/div[2]/input[1]")).sendKeys(lastName);
    }
    public void providesHisNationalityAsHisPassport(String nationality){
        Select select3= new Select(driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[1]/span/div/div[4]/section[2]/div[2]/div[3]/select")));
        select3.selectByVisibleText(nationality);
    }
    public void providesHisBirthday(){
        driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[1]/span/div/div[4]/section[2]/div[2]/div[4]/input")).click();
        Select select4= new Select(driver.findElement(By.xpath("//select[@id='dp_month']")));
        WebDriverHelpers.waitForSecs(3);
        select4.selectByVisibleText("2 - February");
        Select select5= new Select(driver.findElement(By.xpath("//select[@id='dp_day']")));
        WebDriverHelpers.waitForSecs(3);
        select5.selectByVisibleText("1");
        Select select6= new Select(driver.findElement(By.xpath("//select[@id='dp_year']")));
        WebDriverHelpers.waitForSecs(3);
        select6.selectByVisibleText("1980");
    }
    public void entersHisGender(String gender){
        Select select7= new Select(driver.findElement(By.xpath("//html//section[2]/div[2]/div[5]/select[1]")));
        WebDriverHelpers.waitForSecs(2);
        select7.selectByVisibleText(gender);
    }
    public void providesHisPassportNumber(String passportId){
        WebDriverHelpers.waitForSecs(3);
        driver.findElement(By.xpath("//html//section[2]/div[2]/div[6]/input[1]")).click();
        driver.findElement(By.xpath("//html//section[2]/div[2]/div[6]/input[1]")).sendKeys(passportId);
    }
    public void providesHisPassportIssued(){
        driver.findElement(By.xpath("//html//section[2]/div[2]/div[7]/input[1]")).click();
        Select select4= new Select(driver.findElement(By.xpath("//select[@id='dp_month']")));
        WebDriverHelpers.waitForSecs(3);
        select4.selectByVisibleText("2 - February");
        Select select5= new Select(driver.findElement(By.xpath("//select[@id='dp_day']")));
        WebDriverHelpers.waitForSecs(3);
        select5.selectByVisibleText("1");
        Select select6= new Select(driver.findElement(By.xpath("//select[@id='dp_year']")));
        WebDriverHelpers.waitForSecs(3);
        select6.selectByVisibleText("2011");
        driver.findElement(By.xpath("//button[@id='dp_save']")).click();
    }
    public void providesHisPassportExpirationDate(){
        WebDriverHelpers.waitForSecs(3);
        driver.findElement(By.xpath("//html//section[2]/div[2]/div[8]/input[1]")).click();
        Select select4= new Select(driver.findElement(By.xpath("//select[@id='dp_month']")));
        WebDriverHelpers.waitForSecs(3);
        select4.selectByVisibleText("2 - February");
        Select select5= new Select(driver.findElement(By.xpath("//select[@id='dp_day']")));
        WebDriverHelpers.waitForSecs(3);
        select5.selectByVisibleText("1");
        Select select6= new Select(driver.findElement(By.xpath("//select[@id='dp_year']")));
        WebDriverHelpers.waitForSecs(3);
        select6.selectByVisibleText("2035");
        driver.findElement(By.xpath("//button[@id='dp_save']")).click();
    }
    public void providesCanadianVisaType(){
        Select select8= new Select(driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[1]/span/div/div[4]/section[2]/div[3]/div[1]/select")));
        select8.selectByVisibleText("ETA - 180 days, 99 Entries");
    }
    public void seeTheEmbasseyRegistrationCharges(){
        driver.findElement(By.xpath("//*[@id=\"ivisa-subtotal-section\"]/div[2]/div[2]/div/div[1]/span")).isDisplayed();
    }
    public void clickOnNextButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"ivisa-subtotal-section\"]/div[3]/div/div[3]/button"))).doubleClick().build().perform();
        WebDriverHelpers.waitForSecs(3);
    }
    public void seePaymentRevisionPage(){
        System.out.println(driver.findElement(By.xpath("//u[contains(text(),'Calculate Visa Cost Before Applying')]")).isDisplayed());
        WebElement revisionPage= driver.findElement(By.xpath("//u[contains(text(),'Calculate Visa Cost Before Applying')]"));
        Assert.assertTrue(revisionPage.isDisplayed());
    }
}
