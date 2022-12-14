package step_definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.AboutUsPage;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

public class AboutUsSteps implements CommonPage {

        AboutUsPage page;

        public AboutUsSteps() {page = new AboutUsPage();}
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
        BrowserUtils.isDisplayed(page.AboutUsName);
        BrowserUtils.isDisplayed((page.AboutUsTitle));

    }
}
