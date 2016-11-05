package com.chinaweal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

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
}
