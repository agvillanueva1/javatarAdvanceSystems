package pages;

public interface CommonPage {
    String XPATH_TEMPLATE_BUTTON = "//button[text()='%s']";
    String XPATH_TEMPLATE_LINKTEXT = "//a[text()='%s']";
    String XPATH_TEMPLATE_TEXT = "//*[text()='%s']";
    String XPATH_TEMPLATE_TEXT_CONTAINS = "//*[contains(text(), '%s')]";
    String XPATH_TEMPLATE_INPUT_FIELD = "//input[@placeholder='%s']";
    String XPATH_TEMPLATE_INPUT_INFO = "//input[@name='%s']";
    String XPATH_TEMPLATE_CLASS_CONTAINS = "//span[contains(@class, '%s')]";
    String XPATH_TEMPLATE_TEXT2_CONTAINS = "(//a[contains(text(), '%s')])[2]";
    String XPATH_TEMPLATE_TEXT3_CONTAINS = "(//*[contains(@class, '%s')])[1]";
    String XPATH_TEMPLATE_TEXT4_CONTAINS = "(//div[@class='thumb-content']/*[contains(text(), '%s')])[1]";

//    String XPATH_TEMPLATE_CLASS_CONTAINS = "//span[contains(@class, '%s')]";
}
