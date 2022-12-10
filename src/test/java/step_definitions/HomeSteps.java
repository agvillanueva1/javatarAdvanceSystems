package step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

import java.util.Locale;

public class HomeSteps implements CommonPage {

    HomePage page;

    public HomeSteps() {
        page = new HomePage();
    }

    @Given("I open url of homepage")
    public void i_open_url_of_homepage() {
        BrowserUtils.getDriver();
    }
    @Then("Verify title text is {string}")
    public void verify_title_text_is(String titleText) {
        String actualTitleText = BrowserUtils.getDriver().getTitle();
        BrowserUtils.assertEquals(titleText, actualTitleText);
    }

    @Then("Verify address {string} is displayed")
    public void verifyAddressIsDisplayed(String txt) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_TEXT, txt)
        )));
    }

    @Then("Verify phone number {string} is displayed")
    public void verifyPhoneNumberIsDisplayed(String phone) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_TEXT, phone)
        )));

    }
    @Then("Verify Headers {string} is displayed")
    public void verify_headers_is_displayed(String txt) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_TEXT, txt)
        )));
      }


    @Then("Verify footer {string} is displayed")
    public void verifyFooterIsDisplayed(String footer) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_TEXT_CONTAINS, footer)
        )));
    }

    @Then("Verify footer social media link {string} is displayed")
    public void verifyFooterSocialMediaLinkIsDisplayed(String socialMediaFooter) {
        BrowserUtils.sleep(500);
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_CLASS_CONTAINS, socialMediaFooter.toLowerCase())
        )));
    }
}


