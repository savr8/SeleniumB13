package TestNG;

import org.testng.annotations.DataProvider;

public class FullNameDataProvider {

    @DataProvider(name="FullName")
    public Object[][] getData() {
        return new Object[][]{
                {"mehmet", "321"},
                {"malika", "786"},
                {"dalma", "312"},
                {"ion", "665"},
                {"ahmet", "656"}
        };
    }
}
