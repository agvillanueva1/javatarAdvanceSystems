package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class='current']/a[text()='Home']")
    public WebElement homeBtn;

    @FindBy(xpath = "//*[@class='current']/*[text()='About Us']")
    public WebElement aboutUsBtn;

    @FindBy(xpath = "//*[@class='current']/*[text()='Services']")
    public WebElement servicesBtn;

    @FindBy(xpath = "//*[@class='current']/*[text()='Clients']")
    public WebElement clientsBtn;

    @FindBy(xpath = "//*[@class='current']/*[text()='Join Us']")
    public WebElement joinUsBtn;

    @FindBy(xpath = "//*[@class='current']/*[text()='Contact Us']")
    public WebElement contactUsBtn;
}
