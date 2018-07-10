package helpers;

import com.github.nscuro.wdm.binary.BinaryManager;
import com.github.nscuro.wdm.factory.LocalWebDriverFactory;
import com.github.nscuro.wdm.factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import step_definitions.RunCukesTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {


    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            return createBrowserInstance();
        } else
            return driver;
    }

    private static WebDriver createBrowserInstance() {
        if(RunCukesTest.remote){
            if (RunCukesTest.browser.equalsIgnoreCase("chrome")) {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("platform", "macOS 10.13");
                capabilities.setCapability("version", "63.0");
                String url = "http://sangajala55:04d71cd1-2ed2-41bd-9b41-c8376c26f0b5@ondemand.saucelabs.com:80/wd/hub";
                try {
                    return new RemoteWebDriver(new URL(url),capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (RunCukesTest.browser.equalsIgnoreCase("firefox")) {
                DesiredCapabilities caps = DesiredCapabilities.firefox();
                caps.setCapability("platform", "macOS 10.13");
                caps.setCapability("version", "57.0");
                return new RemoteWebDriver(caps);
            } else {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("platform", "macOS 10.13");
                capabilities.setCapability("version", "63.0");
                return new RemoteWebDriver(capabilities);
            }
        }
        else {
            if (RunCukesTest.browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "Windows 7");
                caps.setCapability("version", "67.0");
                try {
                    WebDriver driver = new RemoteWebDriver(new URL("http://ChintuChakli:39043509-1ca3-448e-993f-4d671cc5ed91@ondemand.saucelabs.com:80/wd/hub"),caps);
                    return  driver;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return new ChromeDriver();
            } else if (RunCukesTest.browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            } else {
                return new ChromeDriver();
            }
        }
        return  null;
    }
}
