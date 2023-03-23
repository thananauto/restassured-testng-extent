package com.reqres.test;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AppTest extends Base {

    @Test(description = "Get the users list App")
    public void get_Users(){
        given()
                .header("accept","application/json")
                .when()
                .get("api/users")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(description = "Get the user id App")
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
