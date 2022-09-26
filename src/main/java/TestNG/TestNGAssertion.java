package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

    public int multiplication(int num1, int num2) {

        return num1 * num2;
    }

    @Test
    public void validateMultiplication() {
        int actualResults = multiplication(3, 4);
        int expectedResult = 12;
        Assert.assertEquals(actualResults, expectedResult);
    }

    @Test
    public void validateZero() {
        int actualResult=multiplication(0,999);
        int expectedResult =0;
        Assert.assertEquals(actualResult,expectedResult);
    }
}
