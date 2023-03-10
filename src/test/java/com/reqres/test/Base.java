package com.reqres.test;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class Base {

    @BeforeSuite
    public void beforeSuite(){
        RestAssured.baseURI = "https://reqres.in/";
    }
}
