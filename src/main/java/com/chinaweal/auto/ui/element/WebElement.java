package com.chinaweal.auto.ui.element;

/**
 * Created with IntelliJ IDEA.
 * User: Lain
 * Date: 16/10/29
 * Time: 下午6:01
 */
public abstract class WebElement {
    //定位方式
    public String byMeans;
    //描述符
    public String specifer;
    //输入值
    public String value;

    //页面元素的默认动作
    public abstract void action();
}
