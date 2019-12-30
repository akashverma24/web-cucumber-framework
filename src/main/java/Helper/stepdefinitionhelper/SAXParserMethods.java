package Helper.stepdefinitionhelper;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class SAXParserMethods implements BaseTest {

    File inputFile = new File(System.getProperty("user.dir")+"/src/test/resource/ObjectMap.xml");
    SAXReader saxReader = new SAXReader();
    Document document = null;
    public static String locator = null;

    public String xpathGenerator(String Element, String Screen){

        try {
            document = saxReader.read(inputFile);
            locator = document.selectSingleNode("//WebpageLocators/"+Screen+"/"+Element).getText();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
     return locator;
    }
}
