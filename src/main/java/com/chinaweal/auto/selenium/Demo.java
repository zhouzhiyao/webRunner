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


        //ҳ��Ԫ��ʵ���� action test script


        //�رղ��˳�driver
        driver.close();
        driver.quit();
    }
}
