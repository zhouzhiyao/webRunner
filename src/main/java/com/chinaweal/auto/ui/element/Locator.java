package com.chinaweal.auto.ui.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Lain on 2016/11/5.
 */
public class Locator {
    private WebDriver driver;

    public Locator(WebDriver driver) {
        this.driver = driver;
    }

    //ʹ��ID��ȡԪ��
    public WebElement locateByID(String ID) {
        WebElement element = driver.findElement(By.id(ID));
        return element;
    }

    //ʹ��xpath��ȡԪ�ض���
    public WebElement locateByXpath(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element;
    }

    //ʹ��CSS��ȡԪ�ض���
    public WebElement locateByCss(String locator) {
        WebElement element = driver.findElement(By.cssSelector(locator));
        return element;
    }
}
