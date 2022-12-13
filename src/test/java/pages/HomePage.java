package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import javax.xml.xpath.XPath;

public class HomePage {

    public HomePage() {

        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//div/h2[text()='Words from our Clients']")
    public WebElement headerTestimonials;

    @FindBy(xpath = "(//div//div[@class='owl-item active']//div/div)[1]")
    public WebElement descriptionTestimonials;

    @FindBy(xpath = "//div//div[@class='owl-item active']//div//following-sibling::h3")
    public WebElement clientNameTestimonials;

    @FindBy(xpath = "(//div[@class='tp-mask-wrap'])[1]")
    public WebElement parallaxHeader;

    @FindBy(xpath = "(//div[@class='tp-mask-wrap'])[2]")
    public WebElement parallaxBody;

    @FindBy(xpath = "//*[text()='Read More']")
    public WebElement readMoreBtn1;

    @FindBy(xpath = "(//div[@class='tp-mask-wrap'])[4]")
    public WebElement parallaxHeader2;
    @FindBy(xpath = "(//div[@class='tp-mask-wrap'])[5]")
    public WebElement parallaxBody2;

    @FindBy(xpath = "(//*[text()='Read More'])[2]")
    public WebElement readMoreBtn2;

    @FindBy (xpath = "//*[text()='Home']")
    public WebElement homeBtn;

    @FindBy(xpath = "//*[contains(@class, 'six-item-carousel')]")
    public WebElement companiesName;

    @FindBy(id = "dropdownMenu1")
    public WebElement languageButton;

    @FindBy(xpath = "//div[@class='flex-box']//div//div[2]")
    public WebElement headerDescription;

    @FindBy(xpath = "//div[@class='flex-box']//h3")
    public WebElement sectionItems;



}
