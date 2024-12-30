package ui.tests;

import org.testng.annotations.Test;
import ui.pojos.User;

public class LoginTest extends TestBase
{

    @Test(description = "To Verify valid user is able to login into application successfully",
            groups = {"e2e", "sanity"}, dataProviderClass = ui.dataprovider.LoginDataProvider.class,
            dataProvider = "LoginTestDataProvider")
    public void loginExcelTest(User user)
    {
        String result = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).toString();
        System.out.println(result);
    }

}
