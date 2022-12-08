package step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
}
