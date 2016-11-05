package com.chinaweal.auto.ui.element;

import org.openqa.selenium.WebElement;

/**
 * Created by Lain on 2016/11/5.
 */
public class Text implements Element {

    private WebElement element;

    public Text(WebElement element) {
        this.element = element;
    }

    public void doTest(String testValue, String expectedValue){
        input(testValue);
    }

    public void input(String testValue) {
        element.clear();
        element.sendKeys(testValue);
    }

}
