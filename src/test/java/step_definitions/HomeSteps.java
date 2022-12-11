package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

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
                String.format(XPATH_TEMPLATE_TEXT_CONTAINS, txt)
        )));
      }
    @When("I click link text {string}")
    public void i_click_link_text(String linkText) {
        BrowserUtils.click(BrowserUtils.getDriver().findElement(By.linkText(linkText)));
    }

    @Then("Verify destination window has url as {string}")
    public void verify_destination_window_has_url_as(String URL) {
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), URL);
    }


    @Then("Verify footer {string} is displayed")
    public void verifyFooterIsDisplayed(String footer) {
        //I forced MoveIntoView by Grabbing the Copyright Element - That way if address is wrong, it takes screenshot of the footer in the report
        BrowserUtils.moveIntoView(BrowserUtils.getDriver().findElement(By.xpath("//div[@class='footer-copyright']")));
        //Verification code
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
               String.format(XPATH_TEMPLATE_TEXT_CONTAINS, footer)
        )));
    }

    //----------------------------------------------------------
    @When("I click action button {string}")
    public void iClickActionButton(String joinNowActionBtn) {
        BrowserUtils.click(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, joinNowActionBtn))));
    }

    @Then("Verify button takes user to {string} page")
    public void verify_button_takes_user_to_page(String joinUs) {
        // Verifies the Join Us tab
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT, joinUs))));
        // Verifies the Join Us container (Verifying with PO)
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath("//div//h1[text()='Join Us']")));
    }

    @Then("Verify footer social media link {string} is displayed")
    public void verifyFooterSocialMediaLinkIsDisplayed(String socialMediaFooter) {
        BrowserUtils.sleep(500);
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_CLASS_CONTAINS, socialMediaFooter.toLowerCase())
        )));
    }

    @When("I click navigation bar {string}")
    public void iClickNavigationBar(String navBar) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserUtils.getDriver();
        js.executeScript("window.scrollBy(0, 1000)"); //Scroll vertically down by 1000 pixels

        BrowserUtils.click(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_TEXT2_CONTAINS, navBar)
        )));
    }

    @Then("Verify page navigation bar has url {string}")
    public void verifyPageNavigationBarHasUrl(String URL) {
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getCurrentUrl(), URL);
    }
}


