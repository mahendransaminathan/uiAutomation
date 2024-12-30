package ui.pages;

import constants.Env;
import constants.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BrowserUtility;
import utility.JSONUtility;

import java.io.FileNotFoundException;

public class HomePage extends BrowserUtility
{

    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[normalize-space()='Sign In']");
    public HomePage(Browser browserName, boolean isHeadless) throws FileNotFoundException {
        super(browserName, isHeadless);
        goToWebSite(JSONUtility.readJSON(Env.QA));
    }

    public HomePage(WebDriver driver) throws FileNotFoundException {
        super(driver);
        goToWebSite(JSONUtility.readJSON(Env.QA));
    }

    public LoginPage goToLoginPage()
    {
        clickOn(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }
}
