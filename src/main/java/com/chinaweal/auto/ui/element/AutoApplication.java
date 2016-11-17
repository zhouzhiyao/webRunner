package com.chinaweal.auto.ui.element;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Created by Intellij IDEA
 *
 * @author Lain
 * @date 2016/11/13
 */
public class AutoApplication {
    private WebDriver driver;
    private String appIdentifier;

    public AutoApplication(WebDriver driver, String appIdentifier) {
        this.driver = driver;
        this.appIdentifier = appIdentifier;
    }

    public ArrayList<String> getWorkflowIdentifier(String appIdentifier) {
        ArrayList<String> appIdentifiers = new ArrayList<String>();
        return appIdentifiers;
    }

    public void doAppTest() {
        ArrayList<String> workflowIdentifiers = getWorkflowIdentifier(appIdentifier);
        for (String workflowIdentifier : workflowIdentifiers) {
            AutoWorkflow autoWorkflow = new AutoWorkflow(this.driver, workflowIdentifier);
            autoWorkflow.doWorkflowTest();
        }
    }
}
