package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BrowserUtils {
    //private constructor to implement Singleton Design Class
    private BrowserUtils(){

    }

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null)
        initializeDriver("chrome");

        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }


    private static void initializeDriver(String browser){
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigReader.readProperty("url"));
    }

    public static void waitForElementClickability(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void moveIntoView(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 2; i++) {
            try {
                if (i % 2 == 0) {
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black;" +
                            "border: 3px solid red; background: yellow");
                    //TODO:apply report screenshot here
                    CucumberLogUtils.logInfo(element.toString(), ConfigReader.readProperty("takeScreenshot"));
                } else {
                    sleep(600);
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendKeys(WebElement element, String inputText){
        //TODO: apply report -> logInfo("Entered the text ", element);
        CucumberLogUtils.logInfo("Entered the text " + element, "false" );
        waitForElementVisibility(element);
        moveIntoView(element);
        highlightElement(element);
        element.sendKeys(inputText);
    }

    public static String getText(WebElement element){
        //TODO: apply report -> logInfo("Retrieved the text ", element);
        CucumberLogUtils.logInfo("Retrieved the text " + element, "false" );
        waitForElementVisibility(element);
        moveIntoView(element);
        highlightElement(element);
        return element.getText();
    }

    public static void click(WebElement element){
        //TODO: apply report -> logInfo("clicked the button ", element);
        CucumberLogUtils.logInfo("clicked the button " + element, "false" );
        waitForElementClickability(element);
        moveIntoView(element);
        highlightElement(element);
        element.click();
    }

    public static void click2(WebElement element){
        //TODO: apply report -> logInfo("clicked the button ", element);
        CucumberLogUtils.logInfo("clicked the button " + element, "false" );
        waitForElementClickability(element);
        highlightElement(element);
        element.click();
    }

    public static void assertEquals(String actual, String expected){
        //TODO: apply report -> logInfo("Expected: " + expected);
        //TODO: apply report -> logInfo("Actual: " + actual);
        CucumberLogUtils.logInfo("Expected: " + expected, "true");
        CucumberLogUtils.logInfo("Actual: " + actual, "true");
        Assert.assertEquals(expected, actual);
    }

    public static void assertFalse(boolean result){
        //TODO: apply report -> logInfo("Expected: " + result);
        CucumberLogUtils.logInfo("Expected: " + result, "false" );
        Assert.assertFalse(result);
    }

    public static void assertTrue(boolean result){
        //TODO: apply report -> logInfo("Expected: " + result);

        CucumberLogUtils.logInfo("Expected: " + result, "false" );
        Assert.assertTrue(result);
    }

    public static void isDisplayed(WebElement element){
        waitForElementVisibility(element);
        moveIntoView(element);
        highlightElement(element);
        Assert.assertTrue(element.isDisplayed());
    }
    public static void isDisplayed2(WebElement element){
        waitForElementVisibility(element);
        highlightElement(element);
        Assert.assertTrue(element.isDisplayed());
    }

    public static boolean isEnabled(WebElement element){
        waitForElementClickability(element);
        moveIntoView(element);
        highlightElement(element);
        return element.isEnabled();
    }

    public static boolean isDisabled(WebElement element){
        moveIntoView(element);
        highlightElement(element);

        if(element.isEnabled()){
            return false;
        }else {
            return true;
        }
    }

    public static void switchToNewWindow(){
        for(String each: driver.getWindowHandles()){
            if (!each.equals(driver.getWindowHandle()))
                driver.switchTo().window(each);
        }
    }

    public static void selectByVisibleText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void scrollDownThePage() {

        JavascriptExecutor js = (JavascriptExecutor) BrowserUtils.getDriver();
        js.executeScript("window.scrollBy(0, 5000)");

    }

    public static void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(BrowserUtils.getDriver(), 30);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

}