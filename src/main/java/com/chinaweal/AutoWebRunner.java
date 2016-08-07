package com.chinaweal;

import com.chinaweal.webrun.dao.impl.TestCaseDaoImpl;
import com.chinaweal.webrun.entity.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class AutoWebRunner {
    private WebDriver browser;

    public void init() {
        if (browser == null) {
            WebDriver browser = IEBrowser();
            webAppLogin();
        }
    }

    /**
     * ����IE�����
     *
     * @return
     */
    public WebDriver IEBrowser() {
        DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
        capability.setCapability(
                InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        WebDriver webdriver = new InternetExplorerDriver(capability);
        return webdriver;
    }

    public void webAppLogin() {
        browser.get("http://172.22.80.31:6888/aicscr/login.do?username=admin@nmgs&password=123456");
        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        browser.navigate().to("http://172.22.80.31:6888/aicscr/index_all.jsp");
    }

    /**
     * �����ض�ҳ��Ĳ���
     *
     * @param pageIndex
     */
    public void runPage(String pageIndex) {
        try {
            init();

            ArrayList<TestCase> testCases = new TestCaseDaoImpl().getTestCases(pageIndex);
            runPage(testCases);

        } catch (Exception e) {
            e.printStackTrace();
            browser.close();
        }
    }


    /**
     * ����������pageΪ��λ���� ·��������Ϣ�� �� ����������Ϣ��
     * ·��������Ϣ����Ϊ����˳�򡢲�����ʽ����һ��·��֮�����Ϣ
     * ����������Ϣ����ҵ�����������
     *
     * @param testCases ����������
     * @return
     */
    public void runPage(ArrayList<TestCase> testCases) {
        for (TestCase testCase : testCases) {
            WebElement element = findElement(browser, testCase.getAttributeType(), testCase.getAttributeValue());
            testElement(element, testCase.getTagName(), testCase.getInputValue());
            logInfo(testCase);
        }
    }


    /**
     * ���ֲ�ͬԪ�صĶ�λ
     *
     * @param browser
     * @param attributeType
     * @param attributeValue
     * @return
     */
    public WebElement findElement(WebDriver browser, String attributeType, String attributeValue) {
        WebElement webElement = null;
        if (attributeType.equalsIgnoreCase("id")) {
            webElement = browser.findElement(By.id(attributeValue));
        } else if (attributeType.equalsIgnoreCase("xpath")) {
            webElement = browser.findElement(By.xpath(attributeValue));
        } else if (attributeType.equalsIgnoreCase("js")) {

        }
        return webElement;
    }

    /**
     * ���ֲ�ͬԪ�صĲ���
     * ��ͬԪ�صĲ��Զ�����һ��
     *
     * @param element
     * @param tagName
     * @param value
     */
    public void testElement(WebElement element, String tagName, String value) {
        if (tagName.equalsIgnoreCase("text")) {
            element.sendKeys(value);
        } else if (tagName.equalsIgnoreCase("button")) {
            element.click();
        }
    }

    //�����б��easyUI��
    public void executeJS(WebDriver browser, TestCase testCase) {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        String script = "";
        if (testCase.getAttributeType().equalsIgnoreCase("id")) {
            String scriptTemplate = " $('#%s').omCombo({ value: %s})";
            script = String.format(scriptTemplate, testCase.getAttributeValue(), testCase.getInputValue());
        }

        js.executeScript(script);
    }

    /**
     * ���Թ���ʵʱ���
     */
    public void logInfo(TestCase testCase) {
        System.out.println(testCase.getDisplayName() + " -> " + testCase.getInputValue());
    }

    /**
     * ��ָ��ҳ��ץȡ��Ϣ
     *
     * @param pageIndex
     * @param testCaseID
     * @return
     */
    public String grabInfoFromPage(String pageIndex, String testCaseID) {
        TestCase testCase = new TestCaseDaoImpl().getTestCaseByID(testCaseID);
        WebElement webElement = findElement(browser, testCase.getAttributeType(), testCase.getAttributeValue());
        String info = webElement.getText();
        return info;
    }
}
