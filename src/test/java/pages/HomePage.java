package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

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

}
