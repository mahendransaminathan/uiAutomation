package ui.tests;

import constants.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.pages.HomePage;
import utility.BrowserUtility;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class TestBase
{
    protected HomePage homePage;

    @BeforeMethod(description = "Load the Homepage of the website")
    public void setup() throws FileNotFoundException {
        homePage = new HomePage(Browser.valueOf("chrome".toUpperCase()), true);
    }

    public BrowserUtility getInstance()
    {
        return homePage;
    }

    @AfterMethod(description = "Tear Down the browser")
    public void tearDown()
    {
        homePage.quit();
    }
}
