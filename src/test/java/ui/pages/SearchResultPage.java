package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BrowserUtility;

import java.util.Arrays;
import java.util.List;

public class SearchResultPage extends BrowserUtility
{

    private static final By SEARCH_BUTTON = By.xpath("//p[normalize-space()='Search']");
    private static final By ALL_PRODUCT_LISTS_NAME = By.xpath("//div[@class=' css-1hwfws3']");
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchTermPresentInProductList(String searchTerm)
    {
        clickOn(SEARCH_BUTTON);
        List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
        List<String> productNameList = getAllVisibleText(ALL_PRODUCT_LISTS_NAME);

        boolean result = productNameList.stream().anyMatch(name ->(keywords.stream().anyMatch(name.toLowerCase()::contains)));
        return result;
    }
}
