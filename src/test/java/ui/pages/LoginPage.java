package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import utility.BrowserUtility;

import static org.openqa.selenium.By.xpath;

public class LoginPage extends BrowserUtility
{

    private static final By EMAIL_FIELD_LOCATOR = By.xpath("//input[@placeholder='Enter E-mail Id']");
    private static final By PASSWORD_FIELD_LOCATOR = By.xpath("//input[@placeholder='Enter password']");
    private static final By SIGN_IN_BUTTON_LOCATOR = By.xpath("//button[normalize-space()='Login']");
    private static final String ERROR_MESSAGE = "Error message";
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public MyAccountPage doLoginWith(String emailAddress, String password)
    {
        enterText(EMAIL_FIELD_LOCATOR, emailAddress);
        enterText(PASSWORD_FIELD_LOCATOR, password);
        clickOn(SIGN_IN_BUTTON_LOCATOR);

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        return myAccountPage;
    }

    public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password)
    {
        enterText(EMAIL_FIELD_LOCATOR, emailAddress);
        enterText(PASSWORD_FIELD_LOCATOR, password);
        clickOn(SIGN_IN_BUTTON_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

    public String getErrorMessage()
    {
        return ERROR_MESSAGE;
    }
}
