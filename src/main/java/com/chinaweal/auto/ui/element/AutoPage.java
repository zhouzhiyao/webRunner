package com.chinaweal.auto.ui.element;

import com.chinaweal.auto.db.TestCaseModel;
import com.chinaweal.auto.selenium.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Created by Intellij IDEA
 *
 * @author Lain
 * @date 2016/11/13
 */
public class AutoPage {
    private WebDriver driver;
    private String pageIdentifier;

    public AutoPage(WebDriver driver, String pageIdentifier) {
        this.driver = driver;
        this.pageIdentifier = pageIdentifier;
    }

    private ArrayList<TestCaseModel> getElementTestCases(String pageIdentifier) {
        ArrayList<TestCaseModel> elementTestCases = new ArrayList<TestCaseModel>();
        return elementTestCases;
    }

    public void doPageTest() {
        ArrayList<TestCaseModel> elementTestCases = getElementTestCases(this.pageIdentifier);
        for (TestCaseModel elementTestCaseModel : elementTestCases) {
            WebElement webElement = SeleniumUtils.locateWebElement(this.driver,
                    elementTestCaseModel.getByWay(),
                    elementTestCaseModel.getIdentifier());
            AutoElementDelegate delegate = new AutoElementDelegate(webElement, elementTestCaseModel);
            delegate.doTest();
        }
    }
}
