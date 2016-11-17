package com.chinaweal.auto.selenium;

import org.openqa.selenium.WebDriver;

/**
 * Created by Lain on 2016/11/5.
 */
public class Demo {
    public static void main(String[] args) {
        WebDriver driver = Browser.ie();
        driver.get("http://localhost:9888/cops/");

        String elementType = "text";
        String identifierType = "id";
        String identifier = "username";
        String testValue = "admin";
        String expectedValue = "";


        //页面元素实体类 action test script


        //关闭并退出driver
        driver.close();
        driver.quit();
    }
}
