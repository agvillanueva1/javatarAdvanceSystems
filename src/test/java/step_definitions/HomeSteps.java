package step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    public void verify_title_text_is(String string) {
        System.out.println(BrowserUtils.getDriver().getTitle());
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


}
