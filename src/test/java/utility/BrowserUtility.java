package utility;

import constants.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtility
{
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    
    public WebDriver getDriver()
    {
        return driver.get();
    }
    
    public BrowserUtility(WebDriver driver)
    {
        super();
        this.driver.set(driver);
    }

    public BrowserUtility(Browser browserName)
    {

        if(browserName == Browser.CHROME)
        {
            driver.set(new ChromeDriver());
        }
        else if(browserName == Browser.EDGE)
        {
            driver.set(new EdgeDriver());
        }
        else if (browserName == Browser.FIREFOX)
        {
            driver.set(new FirefoxDriver());
        }
    }

    public BrowserUtility(Browser browserName, boolean isHeadless)
    {

        if (browserName == Browser.CHROME)
        {
            driver.set(new ChromeDriver());
        }
        else if(browserName == Browser.EDGE)
        {
            driver.set(new EdgeDriver());
        } else if (browserName == Browser.FIREFOX) {
            driver.set(new FirefoxDriver());
        }
    }

    public void goToWebSite(String url)
    {
        driver.get().get(url);
    }

    public void maximizeWindow()
    {
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator)
    {
        WebElement element = driver.get().findElement(locator);
        element.click();
    }

    public void enterText(By locator, String textToEnter)
    {
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(textToEnter);
    }

    public void clearText(By textBoxLocator)
    {
        WebElement element = driver.get().findElement(textBoxLocator);
        element.clear();
    }

    public void selectFromDropDown(By dropDownLocator, String optionToSelect)
    {
        WebElement element = driver.get().findElement(dropDownLocator);

        Select select = new Select(element);
        select.selectByVisibleText(optionToSelect);
    }

    public void enterSpecialKey(By locator, Keys keyToEnter)
    {
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(keyToEnter);
    }

    public String getVisibleText(By locator)
    {
        WebElement element = driver.get().findElement(locator);
        return element.getText();
    }

    public String getVisibleText(WebElement element)
    {
        return element.getText();
    }

    public List<String> getAllVisibleText(By locator)
    {
        List<WebElement> elementList = driver.get().findElements(locator);

        List<String> visibleTextList = new ArrayList<>();

        for (WebElement element: elementList)
        {
            visibleTextList.add(getVisibleText(element));
        }
        return visibleTextList;
    }

    public boolean isElementPresent(By locator)
    {
        return !driver.get().findElements(locator).isEmpty();
    }

    public String takeScreenShot(String name)
    {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();

        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);

        String path = "./screenshots/" + name + " - " + timeStamp + ".png";

        File screenshotFile = new File(path);

        //FileUtils.copyFile(screenshotData, screenshotFile);

        return path;
     }
    public void quit()
    {
        driver.get().quit();
    }
}
