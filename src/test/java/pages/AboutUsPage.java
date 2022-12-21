package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class AboutUsPage {

    public AboutUsPage() {

        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }
    @FindBy(xpath = "//div[@class='author-information']/h4")
    public WebElement AboutUsName;

    @FindBy(xpath = "//div[@class='author-information']/div")
    public WebElement AboutUsTitle;
}

