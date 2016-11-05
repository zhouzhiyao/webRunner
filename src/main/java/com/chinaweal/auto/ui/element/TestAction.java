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


    // 等待页面加载，暂停10秒
//            (new WebDriverWait(ieBrowser, 10)).until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver d) {
//                    return d.getTitle().toLowerCase().startsWith("百度一下，你就知道");
//                }
//            });
    public void waitFor() {

    }

    /**
     * 操作输入框input
     * 1.sendKeys代表输入，参数为要输入的值
     * 2.clear代表清除输入框中原有的数据
     */
    public void testInput(String identifier, String content) {
        WebElement input = locator.locateByID(identifier);
        input.clear();
        input.sendKeys(content);
        input.clear();
        input.sendKeys(content);
    }

    /**
     * 操作超链接link
     * 1.click代表点击这个a链接
     */
    public void testLink(String identifier) {
        WebElement link = locator.locateByXpath(identifier);
        link.click();
    }

    /**
     * 操作 下拉框 select
     * 1.需要一个Select的类
     * 2.selectByValue的参数为option中的value属性
     * 3.selectByIndex的参数为option的顺序
     * 4.selectByVisibleText的参数为option的text值
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
     * 操作单选按钮radioBox
     * 1.click代表点击选中这个单选框
     * 2.isSelected代表检查这个单选框有没有被选中
     */
    public void testRadioBox(String identifier) {
        WebElement radio = locator.locateByXpath(identifier);
        radio.click();
        radio.isSelected();
    }


    /**
     * 操作 复选框checkbox
     * 1.click代表点击选中这个多选框
     * 2.isSelected代表检查这个多选框有没有被选中
     */
    public void testCheckBox(String identifier) {
        WebElement checkbox = locator.locateByXpath(identifier);
        checkbox.click();
        checkbox.isSelected();
    }

    /**
     * 操作 按钮button
     * 1.click代表点击这个按钮
     * 2.sEnabled代表检查这个按钮是不是可用的
     */
    public void testButton(String identifier) {
        WebElement submit = locator.locateByXpath(identifier);
        submit.click();
        submit.isEnabled();
    }

    /**
     * 操作 上传控件upload
     * 　　　　 1.一般是把路他径直接sendKeys到这个输入框中
     * 　　　　 2.如果输入框被加了readonly属性，不能输入，则需要用JS来去掉readonly属性！
     */
    public void testUpload(String identifier, String path) {
        WebElement load = locator.locateByXpath(identifier);
        load.sendKeys(path);
    }
}
