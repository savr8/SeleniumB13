package com.test.blaze.tests;

import org.testng.annotations.DataProvider;

public class CustomerDataProvider {

    @DataProvider(name = "validationCustomer")
    public Object[][]provideCustomerInfo(){
        return new Object[][]{
                {"MacBook Pro","Ben","Romania","Cro","9932 8871","09","2025","Thank you for your purchase!"},
                {"MacBook Pro","Savr","USA","Philadelphia","534635","14","2026","Thank you for your purchase!"},
                {"MacBook Pro","Gela","USA","NY","56675687","32","2024","Thank you for your purchase!"}

        };
    }

}
