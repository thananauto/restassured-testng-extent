package com.reqres.test;

import com.reqres.drivers.BrowserManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Base {


    protected static
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();


    @BeforeMethod
    public void Setup(){
        WebDriver driver = BrowserManager.doBrowserSetup("chrome");
        //set driver
        threadLocalDriver.set(driver);
        System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());

    }

    //get thread-safe driver
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }


    @AfterMethod
    public void tearDown(){
        getDriver().quit();
        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());
        threadLocalDriver.remove();
    }
}
