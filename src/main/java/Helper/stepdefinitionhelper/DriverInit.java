package Helper.stepdefinitionhelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;

public class DriverInit {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public DriverInit() {
        driver = DriverUtils.getDefaultDriver();
        wait = new WebDriverWait(driver, 30);
    }
}
