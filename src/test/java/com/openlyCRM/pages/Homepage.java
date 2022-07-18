package com.openlyCRM.pages;


import com.openlyCRM.utilities.Driver;
import org.bouncycastle.jcajce.provider.symmetric.AES;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Homepage extends BasePage{

    public Homepage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void clickTabMenu(String tabName) {

        String locator = "//span//span[.='" + tabName + "']";
        WebElement Button = Driver.getDriver().findElement(By.xpath(locator));
        Button.click();

    }

    // Event page locators
    @FindBy(name = "DATE_FROM")
    public WebElement eventStartDateBox;

    @FindBy(name = "TIME_FROM_")
    public WebElement eventStartTimeBox;

    @FindBy(name = "DATE_TO")
    public WebElement eventEndDateBox;

    @FindBy(name = "TIME_TO_")
    public WebElement eventEndTimeBox;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(name = "EVENT_FULL_DAY")
    public WebElement eventAllDayCheckBox;

    @FindBy(xpath = "//span[.='Specify time zone']")
    public WebElement specifyTimeZoneLink;

    @FindBy(name = "TZ_FROM")
    public WebElement timeZoneFromBox;

    @FindBy(name = "TZ_TO")
    public WebElement timeZoneToBox;

    @FindBy(name = "EVENT_REMIND")
    public WebElement eventSetReminderCheckbox;

    @FindBy(name = "EVENT_REMIND_COUNT")
    public WebElement eventReminderCount;

    @FindBy(name = "EVENT_REMIND_TYPE")
    public WebElement eventReminderTypeDropdown;

    @FindBy(name = "EVENT_LOCATION")
    public WebElement eventLocationDropdown;

    @FindBy(xpath = "//div[contains(text(),'Meeting Room')]")
    public List<WebElement> eventLocationDropdownOptions;

    @FindBy(xpath = "//div[@class='feed-event-destination-wrap']")
    public WebElement membersInputBox;

    @FindBy(xpath = "//*[text()='Employees and departments']")
    public WebElement employeesAndDepartments;

    @FindBy(xpath = "//div[contains(text(), 'HR')]")
    public List<WebElement> HR_Departments;

//    @FindBy(xpath = "//div[contains(@rel, 'HR')]/preceding-sibling::div")
    @FindBy(xpath = "//div[contains(@rel, 'HR')]")
    public List<WebElement> allDepartmentsCheckboxesUnderHRs;

    @FindBy(xpath = "//div[@class='bx-finder-company-department-employee-name']")
    public List<WebElement> contacts;

    @FindBy(name = "EVENT_NAME")
    public WebElement eventNameInputBox;

    @FindBy(xpath = "(//button[.='Send'])[3]")
    public WebElement eventSendButton;

    @FindBy(xpath = "(//a[contains(@id, 'feed-event-view-link-livefeed')])[1]")
    public WebElement activityStreamEventFeed;
    // Event page locators


}
