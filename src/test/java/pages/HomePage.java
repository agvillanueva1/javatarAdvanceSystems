package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import javax.xml.xpath.XPath;

public class HomePage {

    public HomePage(){

        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//div/h2[text()='Words from our Clients']")
    public WebElement headerTestimonials;

    @FindBy(xpath = "(//div//div[@class='owl-item active']//div/div)[1]")
    public WebElement descriptionTestimonials;

    @FindBy(xpath = "//div//div[@class='owl-item active']//div//following-sibling::h3")
    public WebElement clientNameTestimonials;

}
