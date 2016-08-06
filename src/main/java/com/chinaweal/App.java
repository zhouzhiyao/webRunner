package com.chinaweal;

import com.chinaweal.webrun.entity.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        WebDriver browser = IEBrowser();
        try {
            //登录系统
            webAppLogin(browser);

            /**
             * 选取业务
             */


            /**
             * 业务办理结束
             */


            browser.findElement(By.xpath("/html/body/div[3]/div[2]/div/ul/li[1]/ul/li[1]/div/span[4]/a")).click();

            browser.switchTo().frame("content_right_iframe");
            browser.findElement(By.id("chd01")).click();

            //未经过名称登记：选择企业类型
            browser.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[3]/div/div[2]/form/div[2]/div[1]/input")).click();

            browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            browser.findElement(By.id("ch_0")).click();

            browser.switchTo().frame("content_right_iframe");

            browser.findElement(By.id("entTra")).clear();
            browser.findElement(By.id("entTra")).sendKeys("自动");

//            browser.findElement(By.id("nameInd")).clear();
//            browser.findElement(By.id("nameInd")).sendKeys("测试01");
//            browser.findElement(By.id("submit3")).click();
//            browser.findElement(By.id("linkman")).clear();
//            browser.findElement(By.id("linkman")).sendKeys("张三");
//            browser.findElement(By.id("mobTel")).clear();
//            browser.findElement(By.id("mobTel")).sendKeys("15818155632");
//
//            browser.findElement(By.id("cerNo")).clear();
//            browser.findElement(By.id("cerNo")).sendKeys("440222198501251519");
//
//            browser.findElement(By.id("hanMatIdb7ffddfb-0123-1000-e003-638d0a040116")).click();
//            browser.findElement(By.cssSelector("span.l-btn-left.l-btn-icon-left")).click();
//            browser.findElement(By.id("saveOpinionBtn")).click();
        } catch (Exception e) {
            e.printStackTrace();
            browser.close();
        }
    }


    /**
     * 启动IE浏览器
     *
     * @return
     */
    public static WebDriver IEBrowser() {
        DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
        capability.setCapability(
                InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        WebDriver webdriver = new InternetExplorerDriver(capability);
        return webdriver;
    }

    public static void webAppLogin(WebDriver browser) {
        browser.get("http://172.22.80.31:6888/aicscr/login.do?username=admin@nmgs&password=123456");
        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        browser.navigate().to("http://172.22.80.31:6888/aicscr/index_all.jsp");
    }

    /**
     * 测试用例以page为单位，分 路径引导信息集 和 测试用例信息集
     * 路径引导信息集：为操作顺序、操作方式、下一步路径之类的信息
     * 测试用例信息集：业务测试用例集
     *
     * @param browser
     * @param testCases 测试用例集
     * @return
     */
    public static void pageRun(WebDriver browser, ArrayList<TestCase> testCases) {
        for (TestCase testCase : testCases) {
            WebElement element = findElement(browser, testCase.getAttributeType(), testCase.getAttributeValue());
            testElement(element, testCase.getTagName(), testCase.getInputValue());
            logInfo(testCase);
        }
    }


    /**
     * 各种不同元素的定位
     *
     * @param browser
     * @param attributeType
     * @param attributeValue
     * @return
     */
    public static WebElement findElement(WebDriver browser, String attributeType, String attributeValue) {
        WebElement webElement = null;
        if (attributeType.equalsIgnoreCase("id")) {
            webElement = browser.findElement(By.id(attributeValue));
        } else if (attributeType.equalsIgnoreCase("xpath")) {
            webElement = browser.findElement(By.xpath(attributeValue));
        }
        return webElement;
    }

    /**
     * 各种不同元素的测试
     * 不同元素的测试动作不一样
     *
     * @param element
     * @param tagName
     * @param value
     */
    public static void testElement(WebElement element, String tagName, String value) {
        if (tagName.equalsIgnoreCase("text")) {
            element.sendKeys(value);
        } else if (tagName.equalsIgnoreCase("button")) {
            element.click();
        }
    }

    /**
     * 测试过程实时输出
     */
    public static void logInfo(TestCase testCase) {
        System.out.println(testCase.getDisplayName() + " -> " + testCase.getInputValue());
    }
}
