package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "credentials")
    public static Object dataset(){
        Object[][] objects = {
                {" standard_user", "secret_sauce"},
                {"standard_user", " secret_sauce"},
                {"standard_use", "secret_sauce"},
                {"standard_user", "secret_sauc"},
        };
        return objects;
    }
}
