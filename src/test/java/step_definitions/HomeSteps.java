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
        BrowserUtils.sleep(2000);
        String actualTitleText = BrowserUtils.getDriver().getTitle();
        BrowserUtils.assertEquals(titleText, actualTitleText);
    }

    @Then("Verify address {string} is displayed")
    public void verifyAddressIsDisplayed(String txt) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_TEXT, txt)
        )), page.AboutUsTitle);
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
        )), page.AboutUsTitle);

    }

    @Then("Verify Headers {string} is displayed")
    public void verify_headers_is_displayed(String txt) {
        BrowserUtils.isDisplayed(page.sectionItems, page.AboutUsTitle);

    }

    @Then("Verify description {string} is displayed")
    public void verify_description_is_displayed(String txt) {
        BrowserUtils.isDisplayed(page.headerDescription, page.AboutUsTitle);

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
        BrowserUtils.sleep(1000);
        //I forced MoveIntoView by Grabbing the Copyright Element - That way if address is wrong, it takes screenshot of the footer in the report
        BrowserUtils.moveIntoView(BrowserUtils.getDriver().findElement(By.xpath("//div[@class='footer-copyright']")));
        //Verification code
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_TEXT_CONTAINS, footer)
        )), page.AboutUsTitle);
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
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT, joinUs))), page.AboutUsTitle);

    }

    @Then("Verify footer social media link {string} is displayed")
    public void verifyFooterSocialMediaLinkIsDisplayed(String socialMediaFooter) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(
                String.format(XPATH_TEMPLATE_CLASS_CONTAINS, socialMediaFooter.toLowerCase())
        )), page.AboutUsTitle);
    }

    @When("I click navigation bar {string}")
    public void iClickNavigationBar(String navBar) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserUtils.getDriver();
        js.executeScript("window.scrollBy(0, 1000)"); //Scroll vertically down by 1000 pixels

        BrowserUtils.sleep(1000);

        BrowserUtils.click(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_TEXT2_CONTAINS, navBar)
                        ))
        );
    }

    @Then("Verify page navigation bar has correct title {string}")
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

    @Then("Verify header {string} is displayed")
    public void verifyHeaderIsDisplayed(String sectionHeaderTestimonials) {
        String actualTxt = page.headerTestimonials.getText();
        BrowserUtils.assertEquals(actualTxt, sectionHeaderTestimonials);
    }

    @Then("Verify text description is displayed")
    public void verifyTextDescriptionIsDisplayed() {
        BrowserUtils.isDisplayed(page.descriptionTestimonials, page.AboutUsTitle);
    }

    @Then("Verify client name is displayed")
    public void verifyClientNameIsDisplayed() {
        List<WebElement> data = BrowserUtils.getDriver().findElements(By.xpath("//div//div[@class='owl-item active']//div//following-sibling::h3"));
        for (WebElement each : data) {
            BrowserUtils.isDisplayed(each, page.AboutUsTitle);
        }
    }

    @Then("Verify state is displayed")
    public void verifyStateIsDisplayed() {
        List<WebElement> data = BrowserUtils.getDriver().findElements(By.xpath("(//div//div[@class='owl-item active']//div//following-sibling::div)[4]"));
        for (WebElement each : data) {
            BrowserUtils.isDisplayed(each, page.AboutUsTitle);
        }
    }

    @Then("Verify that companies name displayed in one row")
    public void verifyThatCompaniesNameDisplayedInOneRow() {
        BrowserUtils.isDisplayed(page.companiesName, page.AboutUsTitle);
    }

    @Then("Verify navigation bar button {string} is displayed")
    public void verifyNavigationBarButtonIsDisplayed(String navButton) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_LINKTEXT, navButton))),
                page.AboutUsTitle);
    }

    @When("I click a language selection button")
    public void iClickALanguageSelectionButton() {
        BrowserUtils.click(page.languageButton);
    }

    @Then("Verify {string} is displayed")
    public void verify_is_displayed(String txt) {
        BrowserUtils.isDisplayed(page.testimonialName, page.AboutUsTitle);

    }

    @Then("Verify newsletter placeholder {string} is displayed")
    public void verifyNewsletterPlaceholderIsDisplayed(String placeholder) {
        BrowserUtils.sleep(1000);
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_INPUT_FIELD, placeholder))
                ),
                page.AboutUsTitle);
    }

    @Then("Verify a button {string} is enabled")
    public void verifyAButtonIsEnabled(String scrollToTop) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserUtils.getDriver();
        js.executeScript("window.scrollBy(0, 1000)");

        BrowserUtils.sleep(1000);
        BrowserUtils.click(page.scrollToTop);
        BrowserUtils.sleep(1000);
    }

    @Then("Verify header text {string} is displayed")
    public void verifyHeaderTextIsDisplayed(String headerTxt) {
        BrowserUtils.isDisplayed3(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_TEXT_CONTAINS, headerTxt))
                )
        );
    }

    @Then("I click on navBar {string}")
    public void iClickOnNavBar(String AboutUs) {
        BrowserUtils.click(BrowserUtils.getDriver().findElement(By.linkText(AboutUs)));
        BrowserUtils.switchToNewWindow();
        BrowserUtils.sleep(1000);
    }
    @Then("Verify About Us header {string} is displayed")
    public void verifyAboutUsHeaderIsDisplayed(String txt) {
        BrowserUtils.getDriver().findElement(
                By.xpath(String.format(XPATH_TEMPLATE_TEXT, txt)));
    }
    @Then("verify section contain {string} and {string} of the person")
    public void verifySectionContainAndOfThePerson(String txt, String txt2) {
        BrowserUtils.isDisplayed(page.AboutUsName,page.AboutUsTitle);

    }
}



