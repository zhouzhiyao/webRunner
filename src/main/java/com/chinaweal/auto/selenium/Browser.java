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

    //WebDriver driver = new ChromeDriver(); //����chrome�����������
    // WebDriver driver = new HtmlUnitDriver(); //����һ���޽������ģʽ�����ô��������ͨ����̨�������жϲ��������Ƿ�ͨ��

    /**
     * IE
     * https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver
     * <p/>
     * IE��ȫ������ȥ����
     * internetѡ�����ȫ
     * internet-���ñ���ģʽ ��ȥ��
     * ����internet-���ñ���ģʽ ��ȥ��
     * ����վ��-���ñ���ģʽ ��ȥ��
     * ������վ��-���ñ���ģʽ ��ȥ��
     */
    public static WebDriver ie() {
        System.setProperty("webdriver.ie.driver", "C:/IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver(); //����IE�����������
        driver.manage().window().maximize(); //��������
        return driver;
    }

    /**
     * ����IE��������رձ���ģʽ
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
     * @param binPath ��������������λ��
     * @return
     */
    public static WebDriver firefox(String binPath) {
        System.setProperty("webdriver.firefox.bin", binPath);
        WebDriver firefoxDriver = new FirefoxDriver();
        return firefoxDriver;
    }

    /**
     * Firefox Ĭ�ϰ�װ
     *
     * @return
     */
    public static WebDriver firefox() {
        WebDriver firefoxDriver = new FirefoxDriver();
        return firefoxDriver;
    }
}
