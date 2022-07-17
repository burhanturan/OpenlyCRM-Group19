package com.openlyCRM.pages;

import com.openlyCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageSectionPage {

    public MessageSectionPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@class='bx-finder-box-tab bx-lm-tab-department']")
    public WebElement departmentButton;

    @FindBy(xpath = "(//div[@class='bx-finder-company-department-text'])[5]")
    public WebElement mentionHrThree;

    @FindBy(xpath = "(//div[@class='bx-finder-company-department-employee-name'])[2]")
    public WebElement mentionEmployees;

    @FindBy(xpath = "//button[@class='ui-btn ui-btn-lg ui-btn-primary']")
    public WebElement sendButton;

    @FindBy(xpath = "//span[@title='Link']/i")
    public WebElement linkButton;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-text']")
    public WebElement textInputBox;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-href']")
    public WebElement linkInputBox;

    @FindBy(xpath = "//input[@class='adm-btn-save']")
    public WebElement linkSaveButton;

    @FindBy(xpath = "//a[@href='https://www.google.com']")
    public WebElement googleVerify;



}

