package com.reqres.test;

import com.reqres.pageobjects.Login;
import com.reqres.pageobjects.Products;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UiTest extends Base{

    @BeforeMethod
    public void launchUrl(){
        getDriver().get("https://www.saucedemo.com/");
    }

    @Test(description = "Login and logout from the application")
    public void loginAndLogout(){

        Login login = new Login(getDriver());
        login.login("standard_user", "secret_sauce");

        Assert.assertTrue(getDriver().getTitle().contains("Swag Labs"));
        login.logOut();
        Assert.assertTrue(getDriver().getTitle().contains("Swag Labs"));
    }

    @Test(description = "click any item and add to basket")
    public void clickAndAddItem(){

        Login login = new Login(getDriver());
        login.login("problem_user", "secret_sauce");
        Products products = new Products(getDriver());
        products.clickAnyAddToCart();
        products.viewBasket();
        login.logOut();
        Assert.assertTrue(getDriver().getTitle().contains("Swag Labs"));
    }
}
