package com.openlyCRM.pages;

import com.openlyCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
    public TaskPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "tasks-task-priority-cb")
    public WebElement highPriorityButton;

    @FindBy(xpath = "//input[@data-bx-id='task-edit-title']")
    public WebElement thingsToDoInbox;

    @FindBy(xpath = "//div[@id='feed-add-buttons-blockblogPostForm']//button[@class='ui-btn ui-btn-lg ui-btn-primary']")
    public WebElement sendButton;

    @FindBy(xpath = "//div[.='Task has been created']")
    public WebElement taskCreatedPopup;

    @FindBy(xpath = "//div[.='Task has been created']")
    public WebElement taskButton;

}
