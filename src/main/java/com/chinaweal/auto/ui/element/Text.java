package com.chinaweal.auto.ui.element;

import org.openqa.selenium.WebElement;

/**
 * Created by Lain on 2016/11/5.
 */
public class Text implements AutoElement {

    private WebElement webElement;

    public Text(WebElement webElement) {
        this.webElement = webElement;
    }

    public void doTest(String testValue, String expectedValue){
        input(testValue);
    }

    public void input(String testValue) {
        this.webElement.clear();
        this.webElement.sendKeys(testValue);
    }

}
