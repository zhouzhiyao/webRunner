package com.chinaweal.auto.ui.element;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ElementDelegate {
    private String elementType;
    private String identifier;
    private String testValue;
    private String expectedValue;

    private WebDriver driver;

    public ElementDelegate(WebDriver driver, String elementType, String identifier, String testValue, String expectedValue) {
        this.driver = driver;
        this.elementType = elementType;
        this.identifier = identifier;
        this.testValue = testValue;
        this.expectedValue = expectedValue;
    }

    public void doTest() {
        Element element = deduceElement(elementType);
        element.doTest(testValue, expectedValue);
    }

    /**
     * 根据元素类型描述推断元素类型
     *
     * @param elementType 元素类型描字符
     * @return
     */
    public Element deduceElement(String elementType) {
        Element element = null;
        WebElement webElement = locate();
        String packageName = Element.class.getPackage().getName();
        String clazzName = StringUtils.capitalize(elementType);
        try {
            Class elementClazz = Class.forName(packageName + "." + clazzName);
            element = (Element) elementClazz.newInstance();
            Constructor constructor = elementClazz.getConstructor(WebElement.class);
            element = (Element)constructor.newInstance(webElement);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        }
        return element;
    }


    /**
     * 定位页面的元素
     *
     * @return
     */
    public WebElement locate() {
        WebElement element = null;
        String byType = StringUtils.capitalize(elementType);
        String methodName = "locateBy" + byType;
        try {
            Class locatorClazz = Class.forName(Locator.class.getName());
            Constructor constructor = locatorClazz.getConstructor(WebDriver.class);
            Method locateMethod = locatorClazz.getMethod(methodName, String.class);
            Locator locator = (Locator) constructor.newInstance(this.driver);
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