package pages;

import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class DivisionsPage {
    public DivisionsPage() {

        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }
}
