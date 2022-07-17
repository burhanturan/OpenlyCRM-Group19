package com.openlyCRM.pages;

import com.openlyCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterAndSearchPage {
public FilterAndSearchPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//input[@class='main-ui-filter-search-filter']")
    public WebElement filterAndSearchButton;

@FindBy(xpath = "//span[@class='main-ui-filter-add-edit']")
    public WebElement fsSettingsButton;

@FindBy(xpath = "//span[@class='main-ui-filter-field-button-item']")
    public WebElement resetToDefault;

@FindBy(xpath = "//span[@class='popup-window-button']")
    public WebElement fsContinue;

}
