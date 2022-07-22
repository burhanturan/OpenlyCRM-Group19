package com.openlyCRM.pages;

import com.openlyCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;
//Yasemin
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

    @FindBy(xpath = "(//input[@class='task-options-inp'])[1]")
    public WebElement deadlineInbox;

    @FindBy(xpath = "//a[@class='bx-calendar-top-month']")
    public WebElement monthDropdown;

    @FindBy(xpath = "//a[@class='bx-calendar-top-year']")
    public WebElement yearDropdown;


    public WebElement deadlineMonth(String month){
        String locator="//div[@class='bx-calendar-month-content']//span[.='"+month+"']";
        return Driver.getDriver().findElement(By.xpath(locator));

    }


    public WebElement deadlineYear(String year){
        String locator="//div[@class='bx-calendar-year-content']/span[.='"+year+"']";
        return Driver.getDriver().findElement(By.xpath(locator));

    }



    public WebElement deadlineDay(String day){
        String locator="//div[@class='bx-calendar-layer']/div//a[.='"+day+"']";
        return Driver.getDriver().findElement(By.xpath(locator));

    }



    @FindBy(xpath = "//div[@class='bx-calendar-layer']/div")
    public WebElement dayDropdown;

    @FindBy(xpath = "(//input[@class='bx-calendar-form-input'])[1]")
    public WebElement deadlineHourInbox;

    @FindBy(xpath = "(//input[@class='bx-calendar-form-input'])[2]")
    public WebElement deadlineMinuteInbox;

    @FindBy(xpath = "//span[@class='bx-calendar-AM-PM-text']")
    public WebElement deadline_Am_Pm;

    @FindBy(xpath = "//a[@class='bx-calendar-form-arrow-bottom']")
    public WebElement deadline_Am_Pm_ArrowDown;

    @FindBy(xpath = "//a[@class='bx-calendar-form-arrow-top']")
    public WebElement deadline_Am_Pm_ArrowUp;

    @FindBy(xpath = "(//span[@class='bx-calendar-button-text'])[1]")
    public WebElement deadlineSelectButton;

    @FindBy(xpath = "//span[.='Task is overdue!']")
    public WebElement taskIsOverdueMessage;

    @FindBy(xpath = "//span[@id='task-detail-deadline']")
    public WebElement actualDeadline;

    @FindBy(xpath = "//span[.='Time planning']")
    public WebElement timePlanningButton;

    @FindBy(xpath = "(//input[@class='task-options-inp'])[2]")
    public WebElement startTaskOnInbox;

    @FindBy(xpath = "(//input[@class='task-options-inp'])[3]")
    public WebElement durationInbox;

    @FindBy(xpath = "//div[@id=\"tasks-content-outer\"]/div[1]/div/div/div[6]/div[2]")
    public WebElement actualStartDate;

    @FindBy(xpath = "//div[@id=\"tasks-content-outer\"]/div[1]/div/div/div[7]/div[2]")
    public WebElement actualEndDate;












    public void goToTaskIframe(){
        Driver.getDriver().switchTo().frame((Driver.getDriver().findElement(By.xpath("//iframe[@class='side-panel-iframe']"))));
    }
    public int readCounter(String counter) {
        counter= counterOngoingTasks.getText();
        return Integer.parseInt(counter);
    }






}
