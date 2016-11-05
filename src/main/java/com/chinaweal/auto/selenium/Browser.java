package com.chinaweal.auto.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Lain on 2016/11/5.
 * <p/>
 * http://www.cnblogs.com/puresoul/p/4251536.html
 */
public class Browser {

    //WebDriver driver = new ChromeDriver(); //这是chrome浏览器的驱动
    // WebDriver driver = new HtmlUnitDriver(); //这是一个无界面测试模式，不用打开浏览器，通过后台输入来判断测试用例是否通过

    /**
     * IE
     * https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver
     * <p/>
     * IE安全保护都去掉：
     * internet选项——安全
     * internet-启用保护模式 勾去掉
     * 本地internet-启用保护模式 勾去掉
     * 可信站点-启用保护模式 勾去掉
     * 受限制站点-启用保护模式 勾去掉
     */
    public static WebDriver ie() {
        System.setProperty("webdriver.ie.driver", "C:/IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver(); //这是IE浏览器的驱动
        driver.manage().window().maximize(); //最大化浏览器
        return driver;
    }

    /**
     * 启动IE浏览器并关闭保护模式
     *
     * @param binPath
     * @return
     */
    public static WebDriver StartIEAndCloseProtectedMode(String binPath) {
        System.setProperty("webdriver.ie.driver", binPath);
        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        dc.setCapability("ignoreProtectedModeSettings", true);
        WebDriver driver = new InternetExplorerDriver(dc);
        return driver;
    }


    /**
     * Firefox
     *
     * @param binPath 火狐浏览器的启动位置
     * @return
     */
    public static WebDriver firefox(String binPath) {
        System.setProperty("webdriver.firefox.bin", binPath);
        WebDriver firefoxDriver = new FirefoxDriver();
        return firefoxDriver;
    }

    /**
     * Firefox 默认安装
     *
     * @return
     */
    public static WebDriver firefox() {
        WebDriver firefoxDriver = new FirefoxDriver();
        return firefoxDriver;
    }
}
