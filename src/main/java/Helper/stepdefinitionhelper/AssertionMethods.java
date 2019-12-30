package Helper.stepdefinitionhelper;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AssertionMethods extends DriverInit implements BaseTest {

    public boolean isElementPresent(String xpathEle){
        try {
            driver.findElement(By.xpath(xpathEle));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void verifyPageTitleIphone7(){
        String actulTtle = driver.getTitle();
        //System.out.println("Actual"+actulTtle);
        String expctdTitle = "IPhone 7 - Buy Products Online at Best Price in India - All Categories | Flipkart.com";
        //System.out.println("Expected"+expctdTitle);
        Assert.assertEquals(actulTtle,expctdTitle);
    }

    public void checkFilter(String xpathEle, String text) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathEle)));
        //System.out.println(driver.findElement(By.xpath(xpathEle)).getText());
        Assert.assertTrue(driver.findElement(By.xpath(xpathEle)).getText().contains(text));
    }
}
