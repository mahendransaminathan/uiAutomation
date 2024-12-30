package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility
{
    private static final By USER_NAME_LOCATOR = By.xpath("");
    private static final By SEARCH_TEXT_BOX_LOCATOR = By.id("");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchForProduct(String productName)
    {
        enterText(SEARCH_TEXT_BOX_LOCATOR, productName);
        //enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        return searchResultPage;
    }
}
