package com.chinaweal.auto.selenium;

import com.chinaweal.auto.ui.element.Locator;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Intellij IDEA
 *
 * @author Lain
 * @date 2016/11/13
 */
public class SeleniumUtils {

    /**
     * 反射获取页面元素
     *
     * @param driver
     * @param byWay
     * @param identifier
     * @return
     */
    public static WebElement locateWebElement(WebDriver driver, String byWay, String identifier) {
        WebElement element = null;
        String byType = StringUtils.capitalize(byWay);
        String methodName = "locateBy" + byType;
        try {
            Class locatorClazz = Class.forName(Locator.class.getName());
            Constructor constructor = locatorClazz.getConstructor(WebDriver.class);
            Method locateMethod = locatorClazz.getMethod(methodName, String.class);
            Locator locator = (Locator) constructor.newInstance(driver);
            element = (WebElement) locateMethod.invoke(locator, identifier);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return element;
    }
}
