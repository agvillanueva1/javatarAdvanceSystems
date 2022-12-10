package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//li/a[text()='Home']")
    public WebElement homeBtn;

    @FindBy(xpath = "//a[text()='About Us']")
    public WebElement aboutUsBtn;

    @FindBy(xpath = "//a[text()='Services']")
    public WebElement servicesBtn;

    @FindBy(xpath = "//a[text()='Clients']")
    public WebElement clientsBtn;

    @FindBy(xpath = "//a[text()='Join Us']")
    public WebElement joinUsBtn;

    @FindBy(xpath = "//a[text()='Contact Us']")
    public WebElement contactUsBtn;
}
