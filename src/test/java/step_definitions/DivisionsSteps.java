package step_definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.DivisionsPage;
import utils.BrowserUtils;

public class DivisionsSteps implements CommonPage {

    DivisionsPage page;

    public DivisionsSteps() {
        page = new DivisionsPage();
    }

    @Then("Verify {string} are displayed")
    public void verify_are_displayed(String services) {
        BrowserUtils.sleep(1000);
        BrowserUtils.isDisplayed(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_TEXT_CONTAINS, services))
                )
        );
    }
}
