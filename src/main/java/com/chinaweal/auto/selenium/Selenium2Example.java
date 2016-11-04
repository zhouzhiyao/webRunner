package com.chinaweal.auto.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created with IntelliJ IDEA.
 * User: Lain
 * Date: 16/10/29
 * Time: ����11:19
 */
public class Selenium2Example {


        public static void main(String[] args) {
            // ��Firefox driver����һ���µĵ�ʵ��
            //ע��:�����Ĵ��������ڽ���
            //��ִ��

            System.setProperty ( "webdriver.firefox.bin" , "E:/Program Files/Mozilla Firefox/firefox.exe" );
            WebDriver driver = new FirefoxDriver();// �������ǿ���ʹ��firefox�����в�������
            //WebDriver driver = new ChromeDriver(); //����chrome�����������
            //WebDriver driver = new InternetExplorerDriver(); //����IE�����������
            // WebDriver driver = new HtmlUnitDriver(); //����һ���޽������ģʽ�����ô��������ͨ����̨�������жϲ��������Ƿ�ͨ��

            // ��������������ʹȸ�
            driver.get("http://www.google.com");
            // Ҳ����������ķ�ʽ���ʹȸ�
            // driver.navigate().to("http://www.google.com");

            // �ҵ��ı�����Ԫ��������
            WebElement element = driver.findElement(By.name("q"));

            // �������������롰cheese!��
            element.sendKeys("Cheese!");

            // ���ڵݽ����. WebDriver�ᷢ�����ǵ���ʽԪ��
            element.submit();

            // ��̨��ӡ����������ҳ�ı���
            System.out.println("Page title is: " + driver.getTitle());

            // �ȸ����������Ⱦ���Ķ�̬JavaScript. �ȴ�ҳ����أ���ͣ10��
            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("cheese!");
                }
            });

            // Should see: "cheese! - Google Search"
            System.out.println("Page title is: " + driver.getTitle());

            //�ر������
            driver.quit();
        }
    }
