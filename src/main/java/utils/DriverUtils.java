package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverUtils {
    public static long DEFAULT_WAIT = 20;
     protected static WebDriver driver;


    public static WebDriver getDefaultDriver() {
        if (driver != null) {
            return driver;
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");

        driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            try {
                driver.close();
                driver.quit();
            } catch (NoSuchMethodError nsme) { // in case quit fails
            } catch (NoSuchSessionException nsse) { // in case close fails
            } catch (SessionNotCreatedException snce) {} // in case close fails
            driver = null;
        }
    }
}
