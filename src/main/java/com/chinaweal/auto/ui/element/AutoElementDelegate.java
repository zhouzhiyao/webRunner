package com.chinaweal.auto.ui.element;

import com.chinaweal.auto.db.TestCaseModel;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AutoElementDelegate {
    private WebElement webElement;
    private TestCaseModel elementTestCase;

    public AutoElementDelegate(WebElement webElement, TestCaseModel elementTestCase) {
        this.webElement = webElement;
        this.elementTestCase = elementTestCase;
    }

    public void doTest() {
        AutoElement autoElement = deduceAutoElement(this.webElement, this.elementTestCase.getElementType());
        autoElement.doTest(this.elementTestCase.getTestValue(), this.elementTestCase.getExpectedValue());
    }

    /**
     * 根据元素类型描述推断元素类型
     *
     * @param elementType 元素类型描字符
     * @return
     */
    public AutoElement deduceAutoElement(WebElement webElement, String elementType) {
        AutoElement element = null;
        String packageName = AutoElement.class.getPackage().getName();
        String clazzName = StringUtils.capitalize(elementType);
        try {
            Class elementClazz = Class.forName(packageName + "." + clazzName);
            element = (AutoElement) elementClazz.newInstance();
            Constructor constructor = elementClazz.getConstructor(WebElement.class);
            element = (AutoElement) constructor.newInstance(webElement);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return element;
    }
}