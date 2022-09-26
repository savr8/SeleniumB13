package SoftAssert;

import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertPractice {
    @Test
    public int sum(int num1,int num2){
        return num1+num2;
    }
    @Test
    public void test1(){
        System.out.println("");
        Assert.assertEquals(sum(2,6),8);
        System.out.println("Ahmet");
        Assert.assertEquals(sum(3,8),12);//fail
        System.out.println("Gelana");
        Assert.assertEquals(sum(0,0),0);
        System.out.println("Savr");
    }
    @Test
    public void test2(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(sum(2,6),8);
        System.out.println("Gela");
        softAssert.assertEquals(sum(3,8),12);//fail
        System.out.println("Olya");
        softAssert.assertEquals(sum(0,0),0);
        System.out.println("Anna");
        softAssert.assertAll();

    }

}
