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

    //----------------//----------------//----------------//-------------

    @FindBy(xpath = "//span[@class='main-ui-filter-field-add-item']")
    public WebElement fsFieldsClick;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[1]")
    public WebElement beforeClickData;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[1]")
    public WebElement afterClickData;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[2]")
    public WebElement beforeClickType;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[2]")
    public WebElement afterClickType;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[3]")
    public WebElement beforeClickAuthor;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[3]")
    public WebElement afterClickAuthor;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[4]")
    public WebElement beforeClickTo;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[4]")
    public WebElement afterClickTo;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[5]")
    public WebElement beforeClickFavorites;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[5]")
    public WebElement afterClickFavorites;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[6]")
    public WebElement beforeClickTag;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[6]")
    public WebElement afterClickTag;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[7]")
    public WebElement beforeClickExtranet;

    @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[7]")
    public WebElement afterClickExtranet;










}
