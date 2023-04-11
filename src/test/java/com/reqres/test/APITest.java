package com.reqres.test;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {

    @BeforeMethod
    public void beforeSuite(){
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test(description = "Get the users list Home")
    public void get_Users_Home(){
        given()
                .header("accept","application/json")
                .when()
                .get("api/users")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(description = "Get the user id Home")
    public void get_User_Id_Home(){
        given()
                .header("accept","application/json")
                .when()
                .get("api/users/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test(description = "Get the users list App with details")
    public void get_Users(){
        given()
                .header("accept","application/json")
                .when()
                .get("api/users")
                .then()
                .assertThat()
                .statusCode(200);
    }


    @Test(description = "Get the user id App of particluar")
    public void get_User_Id(){
        given()
                .header("accept","application/json")
                .when()
                .get("api/users/1")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
