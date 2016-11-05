package com.chinaweal.auto.ui.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Lain on 2016/11/5.
 */
public class TestAction {
    Locator locator;

    public TestAction(Locator locator) {
        this.locator = locator;
    }


    // �ȴ�ҳ����أ���ͣ10��
//            (new WebDriverWait(ieBrowser, 10)).until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver d) {
//                    return d.getTitle().toLowerCase().startsWith("�ٶ�һ�£����֪��");
//                }
//            });
    public void waitFor() {

    }

    /**
     * ���������input
     * 1.sendKeys�������룬����ΪҪ�����ֵ
     * 2.clear��������������ԭ�е�����
     */
    public void testInput(String identifier, String content) {
        WebElement input = locator.locateByID(identifier);
        input.clear();
        input.sendKeys(content);
        input.clear();
        input.sendKeys(content);
    }

    /**
     * ����������link
     * 1.click���������a����
     */
    public void testLink(String identifier) {
        WebElement link = locator.locateByXpath(identifier);
        link.click();
    }

    /**
     * ���� ������ select
     * 1.��Ҫһ��Select����
     * 2.selectByValue�Ĳ���Ϊoption�е�value����
     * 3.selectByIndex�Ĳ���Ϊoption��˳��
     * 4.selectByVisibleText�Ĳ���Ϊoption��textֵ
     */
    public void testSelect(String identifier, int index) {
        WebElement element = locator.locateByXpath(identifier);
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void testSelect(String identifier, String value) {
        WebElement element = locator.locateByXpath(identifier);
        Select select = new Select(element);
        select.selectByValue(value);
        //select.selectByVisibleText(text);
    }

    /**
     * ������ѡ��ťradioBox
     * 1.click������ѡ�������ѡ��
     * 2.isSelected�����������ѡ����û�б�ѡ��
     */
    public void testRadioBox(String identifier) {
        WebElement radio = locator.locateByXpath(identifier);
        radio.click();
        radio.isSelected();
    }


    /**
     * ���� ��ѡ��checkbox
     * 1.click������ѡ�������ѡ��
     * 2.isSelected�����������ѡ����û�б�ѡ��
     */
    public void testCheckBox(String identifier) {
        WebElement checkbox = locator.locateByXpath(identifier);
        checkbox.click();
        checkbox.isSelected();
    }

    /**
     * ���� ��ťbutton
     * 1.click�����������ť
     * 2.sEnabled�����������ť�ǲ��ǿ��õ�
     */
    public void testButton(String identifier) {
        WebElement submit = locator.locateByXpath(identifier);
        submit.click();
        submit.isEnabled();
    }

    /**
     * ���� �ϴ��ؼ�upload
     * �������� 1.һ���ǰ�·����ֱ��sendKeys������������
     * �������� 2.�������򱻼���readonly���ԣ��������룬����Ҫ��JS��ȥ��readonly���ԣ�
     */
    public void testUpload(String identifier, String path) {
        WebElement load = locator.locateByXpath(identifier);
        load.sendKeys(path);
    }
}
