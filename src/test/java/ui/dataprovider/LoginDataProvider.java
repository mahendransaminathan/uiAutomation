package ui.dataprovider;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import ui.pojos.TestData;
import ui.pojos.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider
{

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() throws FileNotFoundException
    {
        Gson gson = new Gson();

        File testDataFile = new File(System.getProperty("user.dir") + "/testData/logindata.json");
        FileReader fileReader = new FileReader(testDataFile);

        TestData data = gson.fromJson(fileReader, TestData.class);

        List<Object[]> dataToReturn = new ArrayList<Object[]>();

        for(User user : data.getData())
        {
        dataToReturn.add(new Object[] {user});
        }

        return dataToReturn.iterator();
    }

    //public Iterator<User> loginExcelDataProvider()
    {
      //  return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
    }

}
