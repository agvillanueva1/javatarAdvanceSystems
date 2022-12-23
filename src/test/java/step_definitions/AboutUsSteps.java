package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AboutUsPage;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

import java.util.List;

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
        System.out.println(txt);
    }
    @Then("verify section contain {string} and {string} of the person")
    public void verifySectionContainAndOfThePerson(String txt, String txt2) {
        BrowserUtils.isDisplayed(page.AboutUsName);
        BrowserUtils.isDisplayed((page.AboutUsTitle));

    }

    @Then("Verify picture is displayed")
    public void verifyPictureIsDisplayed() {
        List<WebElement> img = BrowserUtils.getDriver().findElements(
                By.xpath("/html/body/div[1]/section[5]/div/div[2]//img"));
        for(WebElement list : img){
            BrowserUtils.isDisplayed(list);
       }
    }

    @Then("Verify title is displayed")
    public void verifyTitleIsDisplayed() {
        List<WebElement> list = BrowserUtils.getDriver().findElements(
                By.xpath("/html/body/div[1]/section[5]/div/div[2]//div[@class='designation']"));
        for(WebElement title : list){
            BrowserUtils.isDisplayed2(title);
        }
    }

    @Then("verify quote is displayed")
    public void verifyQuoteIsDisplayed() {
        List<WebElement> list = BrowserUtils.getDriver().findElements(
                By.xpath("/html/body/div[1]/section[5]/div/div[2]//div[@class='text']"));
        for(WebElement quote : list){
            BrowserUtils.isDisplayed2(quote);
        }
    }

    @Then("verify social media links is display")
    public void verifySocialMediaLinksIsDisplay() {
        List<WebElement> list = BrowserUtils.getDriver().findElements(
                By.xpath("/html/body/div[1]/section[5]/div/div[2]//ul//a"));
        for(WebElement media : list){
            BrowserUtils.isDisplayed2(media);
        }
    }

    @Then("verify {string} link is functioning")
    public void verifyLinkIsFunctioning(String link) {
            BrowserUtils.click2(BrowserUtils.getDriver().findElement
                    (By.xpath(String.format(XPATH_TEMPLATE_CLASS_CONTAINS, link))));
            BrowserUtils.getDriver().navigate().back();
    }
}
