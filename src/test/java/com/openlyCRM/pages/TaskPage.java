package com.openlyCRM.pages;

import com.openlyCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

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

    @FindBy(xpath = "//span[.='View task']")
    public WebElement viewTaskPopup;

    @FindBy(xpath = "//div[.='Task has been created']")
    public WebElement taskButton;

    @FindBy(xpath = "//a[@class='js-id-tdp-mem-sel-is-open-form task-form-field-when-filled task-form-field-link add']")
    public WebElement responsiblePerson_addMoreButton;

    @FindBy(xpath = "//div[.='hr24@cybertekschool.com']")
    public WebElement responsibleHr24;

    @FindBy(xpath = "//div[.='helpdesk78@cybertekschool.com']")
    public WebElement responsibleHelpdesk78;

    @FindBy(xpath = "//div[.='hr11@cybertekschool.com']")
    public WebElement responsibleHr11;

    @FindBy(xpath = "//div[.='marketing44@cybertekschool.com']")
    public WebElement responsibleHr25;

    @FindBy(xpath = "//a[starts-with(@id,'destDepartmentTab_')]")
    public WebElement employeesAndDepartmentsButton;


    @FindBy(xpath = "//table[@class='task-list-table task-table-hide-first-column']/tbody/tr/td[5]/a")
    public List<WebElement> responsiblePeopleList;

    @FindBy(xpath = "//input[starts-with(@id,'name-selector')]")
    public WebElement responsibleEmployeesInbox;

    @FindBy(xpath = "//span[@class='popup-window-close-icon']")
    public WebElement seperatedTasksCreatedPopup;

    @FindBy(xpath = "//div[@data-priority='2']")
    public WebElement dataPriority2Element;

    @FindBy(xpath = "//span[@class='task-item-index']")
    public WebElement counterOngoingTasks;

    @FindBy(xpath = "//span[.='Checklist']")
    public WebElement checklistButton;

    @FindBy(xpath = "//input[@class='js-id-checklist-is-form-title task-checklist-field-add']")
    public WebElement checklistInbox;

    @FindBy(xpath = "//span[@class='js-id-checklist-is-form-submit block-edit tasks-btn-apply task-field-title-ok']")
    public WebElement checklistThick;

    @FindBy(xpath = "//div[@class='js-id-checklist-is-items js-id-checklist-items-ongoing tasks-checklist-dropzone']/div")
    public List<WebElement> checklistDuties;
















    public void goToTaskIframe(){
        Driver.getDriver().switchTo().frame((Driver.getDriver().findElement(By.xpath("//iframe[@class='side-panel-iframe']"))));
    }
    public int readCounter(String counter) {
        counter= counterOngoingTasks.getText();
        return Integer.valueOf(counter);
    }






}
