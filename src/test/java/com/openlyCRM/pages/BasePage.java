package com.openlyCRM.pages;


import com.openlyCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span//span[.='Message']")
    public WebElement messageButton;

    @FindBy(xpath = "//span//span[.='Task']")
    public WebElement taskButton;

    @FindBy(xpath = "//span//span[.='Event']")
    public WebElement eventButton;

    @FindBy(xpath = "//span//span[.='Poll']")
    public WebElement pollButton;

    @FindBy(xpath = "//span//span[.='More']")
    public WebElement moreButton;



}
