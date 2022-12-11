package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

import java.util.List;
import java.util.Set;

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
        // Verifies the Join Us tab (PO Verified)
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT, joinUs))));
    }

    //----------------------------------------------------------

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

    //----------------------------------------------------------

    @When("I click on social media button {string}")
    public void iClickOnSocialMediaButton(String socialMediaBtn) {
        BrowserUtils.click(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_TEXT3_CONTAINS, socialMediaBtn.toLowerCase()))
                )
        );
        BrowserUtils.sleep(1000);

    }

    @Then("Verify each button takes user to corresponding page with {string}")
    public void verifyEachButtonTakesUserToCorrespondingPageWith(String pageTitle) {
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertTrue(BrowserUtils.getDriver().getTitle().contains(pageTitle));
        BrowserUtils.getDriver().navigate().back();
    }

    @Then("Verify navigation bar button {string} is displayed")
    public void verifyNavigationBarButtonIsDisplayed(String navButton) {
     BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(
            By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, navButton)))
            );
}


    @Then("Verify that companies name displayed in one row")
    public void verifyThatCompaniesNameDisplayedInOneRow() {
        BrowserUtils.isDisplayed(page.companiesName);
    }
}





