package com.chinaweal.auto.db;

/**
 * Created with IntelliJ IDEA.
 * User: Lain
 * Date: 16/10/29
 * Time: 下午6:26
 */
public class TestCaseModel {
    //元素类型
    private String elementType;
    //定位符
    private String identifier;
    //定位方式
    private String byWay;
    //Test value
    private String testValue;
    //Expected value
    private String expectedValue;
    //Page
    private String pageLocator;
    //Template
    private String templateLocator;

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getByWay() {
        return byWay;
    }

    public void setByWay(String byWay) {
        this.byWay = byWay;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getPageLocator() {
        return pageLocator;
    }

    public void setPageLocator(String pageLocator) {
        this.pageLocator = pageLocator;
    }

    public String getTemplateLocator() {
        return templateLocator;
    }

    public void setTemplateLocator(String templateLocator) {
        this.templateLocator = templateLocator;
    }
}
