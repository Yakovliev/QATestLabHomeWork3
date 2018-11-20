package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver getDriver(String browser) {

        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir") + "//resourses//geckodriver.exe");
                return new FirefoxDriver();
            case "edge":
            case "microsoft edge":
                System.setProperty("webdriver.edge.driver",
                        System.getProperty("user.dir") + "//resourses//MicrosoftWebDriver.exe");
                return new EdgeDriver();
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//resourses//chromedriver.exe");
                return new ChromeDriver();
        }
    }

    public static EventFiringWebDriver getConfiguredDriver(String browser) {

        EventFiringWebDriver driver;

        switch (browser) {
            case "firefox":
                driver = new EventFiringWebDriver(getDriver("firefox"));
                break;
            case "edge":
            case "microsoft edge":
                driver = new EventFiringWebDriver(getDriver("edge"));
                break;
            case "chrome":
            default:
                driver = new EventFiringWebDriver(getDriver("chrome"));
                break;
        }

        driver.register(new EventHandler());

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }
}
