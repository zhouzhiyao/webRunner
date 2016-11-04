package com.chinaweal.auto.db;

/**
 * Created with IntelliJ IDEA.
 * User: Lain
 * Date: 16/10/29
 * Time: 下午6:26
 */
public class TestCaseModel {
    //定位符
    private String identifier;
    //定位方式
    private String means;
    //Test value
    private String testValue;
    //Expected value
    private String expectedValue;
    //Page
    private String pageLocator;
    //Template
    private String templateLocator;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means;
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
