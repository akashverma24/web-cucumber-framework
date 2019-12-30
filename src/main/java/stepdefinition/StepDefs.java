package stepdefinition;

import Helper.stepdefinitionhelper.BaseTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverUtils;

import java.util.concurrent.TimeUnit;

public class StepDefs implements BaseTest {

    final String HOME_PAGE = "HomePage";
    final String LANDING = "LandingPage";
    protected WebDriver driver = DriverUtils.getDefaultDriver();



    @Given("^I navigate to flipkart using URL \"([^\"]*)\"$")
    public void i_navigate_to_flipkart_using_URL(String link) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        navigationObj.navigateTo(link);

    }

    @When("^I close \"([^\"]*)\" on \"([^\"]*)\"$")
    public void i_close_on(String Element, String Screen) {
        // Write code here that turns the phrase above into concrete actions
        navigationObj.clickElement(saxparserObj.xpathGenerator(Element, Screen));
        Assert.assertFalse(assertObj.isElementPresent(saxparserObj.xpathGenerator(Element,Screen)));
    }


    @Then("^I should navigate to flipkart home page$")
    public void i_should_navigate_to_flipkart_home_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        navigationObj.verifyPageTitleHomePage();
    }

    @When("^I input \"([^\"]*)\" in \"([^\"]*)\" on (.+)$")
    public void i_input_in_search_box(String text, String Element, String Screen) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        navigationObj.inputText(text, saxparserObj.xpathGenerator(Element, Screen));


    }

    @When("^I scroll to apply filter ([^\"]*) on \"([^\"]*)\"$")
    public void i_scroll_to_apply(String Element, String Screen) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        navigationObj.scrollToElement(saxparserObj.xpathGenerator(Screen, HOME_PAGE));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        navigationObj.clickElement(saxparserObj.xpathGenerator(Screen, HOME_PAGE));
        //assertObj.checkFilter(saxparserObj.xpathGenerator("Filter", HOME_PAGE), Element);
    }


    @When("^I click on \"([^\"]*)\"$")
    public void i_click_on_search_button(String Element) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        navigationObj.clickElement(saxparserObj.xpathGenerator(Element, HOME_PAGE));
        Thread.sleep(2000);
        assertObj.verifyPageTitleIphone7();
    }

    @When("^I apply filter \"([^\"]*)\" on \"([^\"]*)\"$")
    public void i_apply_filter_on(String Element, String arg2) throws Throwable {
        navigationObj.clickElement(saxparserObj.xpathGenerator(Element, HOME_PAGE));
    }

    @When("^I scroll to apply filter \"([^\"]*)\" on \"([^\"]*)\"$")
    public void i_scroll_to_apply_filter_on(String Element1, String Element2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        navigationObj.scrollToElement(saxparserObj.xpathGenerator(Element2, HOME_PAGE));
        Thread.sleep(2000);
        navigationObj.clickElement(saxparserObj.xpathGenerator(Element2, HOME_PAGE));
        navigationObj.clickElement(saxparserObj.xpathGenerator(Element1, HOME_PAGE));
        //assertObj.checkFilter(saxparserObj.xpathGenerator("Filter", HOME_PAGE),Element1);
    }

    @Then("^Check for the \"([^\"]*)\" and close it$")
    public void Check_for_popup(String Element) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        navigationObj.checkAndClose(saxparserObj.xpathGenerator(Element, LANDING));
    }



    @When("^I select dropdown \"([^\"]*)\" on \"([^\"]*)\"$")
    public void i_select_drop(String text, String Element) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        navigationObj.selectValue(text, saxparserObj.xpathGenerator(Element, HOME_PAGE));
        //assertObj.checkFilter(saxparserObj.xpathGenerator("Filter", HOME_PAGE),Element);

    }

    @Then("^I should read the results that show up on the page$")
    public void i_should_read_the_results_that_show_up_on_the_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
           // navigationObj.productString()
        navigationObj.createProductMap(saxparserObj.xpathGenerator("MobilePrice1","SearchPage"), saxparserObj.xpathGenerator("MobileName1", "SearchPage"), saxparserObj.xpathGenerator("Mobileid1", "SearchPage"));
        navigationObj.createProductMap(saxparserObj.xpathGenerator("MobilePrice2","SearchPage"), saxparserObj.xpathGenerator("MobileName2", "SearchPage"), saxparserObj.xpathGenerator("Mobileid2", "SearchPage"));

    }

    @Then("^Display the results to Customer in ascending order of the price$")
    public void display_the_results_to_Customer_in_ascending_order_of_the_price() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
            navigationObj.naturalSortTreeMap();
    }

    @And("close the browser$")
    public void close_the_browser(){
        DriverUtils.closeDriver();
    }
}
