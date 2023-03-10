package com.reqres.test;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HomeTest extends Base {

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

}
