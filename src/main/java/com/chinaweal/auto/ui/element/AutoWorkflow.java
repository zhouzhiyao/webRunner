package com.chinaweal.auto.ui.element;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Created by Intellij IDEA
 *
 * @author Lain
 * @date 2016/11/13
 */
public class AutoWorkflow {
    private WebDriver driver;
    private String workflowIdentifier;

    public AutoWorkflow(WebDriver driver, String workflowIdentifier){
        this.driver = driver;
        this.workflowIdentifier = workflowIdentifier;
    }

    public ArrayList<String> getAutoPagesIdentifiers(String workflowIdentifier){
        ArrayList<String> autoPagesIdentifiers = new ArrayList<String>();
        return autoPagesIdentifiers;
    }

    public void doWorkflowTest(){
        ArrayList<String> autoPagesIdentifiers = getAutoPagesIdentifiers(this.workflowIdentifier);
        for(String pageIdentifier : autoPagesIdentifiers){
            AutoPage autoPage = new AutoPage(this.driver, pageIdentifier);
            autoPage.doPageTest();
        }
    }
}
