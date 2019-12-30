package Helper.stepdefinitionhelper;

import com.sun.org.apache.xpath.internal.operations.Bool;
import cucumber.runtime.junit.Assertions;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class NavigationMethods extends DriverInit implements BaseTest {

    public static List<String> productList = new ArrayList<>();
    public static Map<Integer,String> productMap = new TreeMap<Integer, String>();

    public void navigateTo(String url){
        driver.get(url);
    }

    public void verifyPageTitleHomePage(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public void checkAndClose(String xpathEle){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if(driver.findElements(By.xpath(xpathEle)).size() !=0){
            clickElement(xpathEle);
        }
        else
            System.out.println("No Login Popup");
    }

    public void inputText(String input, String xpathEle){
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathEle)));
            driver.findElement(By.xpath(xpathEle)).sendKeys(input);

    }

    public void clickElement(String xpathEle){
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathEle)));
            driver.findElement(By.xpath(xpathEle)).click();
    }



    public void selectValue(String input, String xpathEle){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathEle)));
            //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Select minValue = new Select(driver.findElement(By.xpath(xpathEle)));
            minValue.selectByValue(input);
    }

    public void scrollToElement(String xpathEle){
            Actions builder = new Actions(driver);
            Action moveToElement = builder.moveToElement(driver.findElement(By.xpath(xpathEle))).build();
            moveToElement.perform();
    }

    public String getHrefValue(String xpathEle){
        return driver.findElement(By.xpath(xpathEle)).getAttribute("href");
    }

    public String getText(String xpathEle){
        return driver.findElement(By.xpath(xpathEle)).getText();

    }

    public String productString(String xpathEle1, String xpathEle2, String xpathEle3){
         String productConcat = null;
         productConcat = "`"+productPrice(xpathEle1)+" | "+getText(xpathEle2)+" | "+getHrefValue(xpathEle3)+"`";
        return productConcat;
    }

    public int productPrice(String xpathEle1){
        String price = getText(xpathEle1).substring(1).replaceAll("[^0-9]","");
        return Integer.parseInt(price);
    }

    public void createProductMap(String xpathEle1, String xpathEle2, String xpathEle3){
        addMap(productPrice(xpathEle1),productString(xpathEle1,xpathEle2,xpathEle3));
    }

    public void addMap(int key, String value){
        productMap.put(key,value);
    }

    public void naturalSortTreeMap(){

        for (Map.Entry<Integer, String> entry : productMap.entrySet()) {
            System.out.println(entry.getValue());
        }

    }

    // Can be implemented with this this approach also

    /* public void seehow() {

        try {
            List<WebElement> webElements = driver.findElements(By.xpath("//*[@class='_31qSD5']"));

            for (WebElement we : webElements) {
                if (we.isDisplayed())
                    System.out.println(we.getText());
            }

        }
        catch (org.openqa.selenium.StaleElementReferenceException ex){
            List<WebElement> webElements = driver.findElements(By.xpath("//*[@class='_31qSD5']"));
            System.out.println("******");
            for (WebElement we : webElements) {
                if (we.isDisplayed())

                    System.out.println(we.getText());
                    System.out.println("******************************");
            }
            }
        }*/



}