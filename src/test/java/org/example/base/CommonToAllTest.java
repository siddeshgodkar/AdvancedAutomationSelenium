package org.example.base;

import org.example.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.example.driver.DriverManager.driver;

public class CommonToAllTest {

    //beforeMethod TestNG Annotation helps u to test the test case onto fresh browser

    @BeforeMethod
    public void setUp(){

        DriverManager.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }
}
