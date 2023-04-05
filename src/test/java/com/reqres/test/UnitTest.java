package com.reqres.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTest {


    @Test
    public void add(){
        Assert.assertTrue( 5 >3, "successfully met");
    }

    @Test
    public void sub(){
        Assert.assertTrue( 100 > 13, "successfully met");
    }
}
