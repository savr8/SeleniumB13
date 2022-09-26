package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

//it runs the same TEST with a different SET of DATA.

//    @DataProvider(name="FullName")
//    public Object[][] getData() {
//        return new Object[][]{
//                {"mehmet", "321"},
//                {"malika", "786"},
//                {"dalma", "312"},
//                {"ion", "665"},
//                {"ahmet", "656"}
//        };
//    }
    @Test(dataProvider = "FullName",dataProviderClass = FullNameDataProvider.class)
    public void test(String userName,String password) {

        System.out.println(userName + password);
    }

}
