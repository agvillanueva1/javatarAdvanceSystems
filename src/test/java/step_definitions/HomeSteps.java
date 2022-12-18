package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;
import utils.Screenshot;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
        BrowserUtils.sleep(1000);
        String actualTitleText = BrowserUtils.getDriver().getTitle();
        BrowserUtils.assertEquals(titleText, actualTitleText);
    }

    @Then("Verify address {string} is displayed")
    public void verifyAddressIsDisplayed(String txt) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_TEXT, txt)
        )));
    }

    @Then("Verify header is displayed")
    public void verify_header_is_displayed() {
        System.out.println(page.parallaxHeader.getText());
        BrowserUtils.isDisplayed2(page.parallaxHeader);
    }

    @Then("Verify description is displayed")
    public void verify_description_is_displayed() {
        BrowserUtils.isDisplayed2(page.parallaxBody);
    }

    @Then("Verify a ReadMore button on first parallax is displayed")
    public void verify_a_read_more_button_on_first_parallax_is_displayed() {
        BrowserUtils.isDisplayed2(page.readMoreBtn1);
    }

    @When("I click a button {string}")
    public void i_click_a_button(String button) {
        switch (button.toLowerCase()) {
            case "read more":
                BrowserUtils.click2(page.readMoreBtn1);
                BrowserUtils.switchToNewWindow();
                break;
            case "read more2":
                BrowserUtils.click2(page.readMoreBtn2);
                BrowserUtils.switchToNewWindow();
                break;
            case "home":
                BrowserUtils.click2(page.homeBtn);
                break;
            default:
                BrowserUtils.click2(BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_BUTTON, button))));
        }
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
        BrowserUtils.sleep(3000);
        BrowserUtils.getDriver().navigate().back();
    }

    @Then("Verify second header is displayed")
    public void verify_second_header_is_displayed() {
        BrowserUtils.isDisplayed2(page.parallaxHeader2);
    }

    @Then("Verify second description is displayed")
    public void verify_second_description_is_displayed() {
        BrowserUtils.isDisplayed2(page.parallaxBody2);
    }

    @Then("Verify a ReadMore button on second parallax is displayed")
    public void verify_a_read_more_button_on_second_parallax_is_displayed() {
        BrowserUtils.isDisplayed2(page.readMoreBtn2);

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

    @When("I click action button {string}")
    public void iClickActionButton(String joinNowActionBtn) {
        //BrowserUtils.sleep(1000);
        BrowserUtils.click(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, joinNowActionBtn))));

    }

    @Then("Verify button takes user to {string} page")
    public void verify_button_takes_user_to_page(String joinUs) {
        //BrowserUtils.sleep(1000);
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT, joinUs))));

    }

    //----------------------------------------------------------

    @Then("Verify footer social media link {string} is displayed")
    public void verifyFooterSocialMediaLinkIsDisplayed(String socialMediaFooter) {
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
                ))
        );
    }

    @Then("Verify page navigation bar has url {string}")
    public void verifyPageNavigationBarHasUrl(String titleText) {
        BrowserUtils.sleep(1000);
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(), titleText);
    }

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

    @Then("Verify that companies name displayed in one row")
    public void verifyThatCompaniesNameDisplayedInOneRow() {
        BrowserUtils.isDisplayed(page.companiesName);
    }

    @Then("Verify navigation bar button {string} is displayed")
    public void verifyNavigationBarButtonIsDisplayed(String navButton) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, navButton)))
        );

    }

    @When("I click a language selection button")
    public void iClickALanguageSelectionButton() {
        BrowserUtils.click(page.languageButton);
    }
}