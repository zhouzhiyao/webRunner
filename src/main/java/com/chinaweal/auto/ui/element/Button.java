package com.chinaweal.auto.ui.element;

import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Lain
 * @date 2016-11-17
 * @time 10:24
 */
public class Button implements AutoElement {
    private WebElement webElement;

    public Button(WebElement webElement) {
        this.webElement = webElement;
    }

    public void doTest(String testValue, String expectedValue){
        this.webElement.click();
    }
}
