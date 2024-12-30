package utility;

import com.google.gson.Gson;
import constants.Env;
import ui.pojos.Config;
import ui.pojos.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONUtility
{
    public static String readJSON(Env env) throws FileNotFoundException {
        Gson gson = new Gson();
        File jsonFile = new File(System.getProperty("user.dir") + "//config//config.json");

        FileReader fileReader = null;

        fileReader = new FileReader(jsonFile);

        Config config = gson.fromJson(fileReader, Config.class);
        Environment environment = config.getEnvironments().get("QA");
        return environment.getUrl();
    }
}
