package com.openlyCRM.pages;

import com.openlyCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterAndSearchPage {
public FilterAndSearchPage(){PageFactory.initElements(Driver.getDriver(),this);}

    //                     BEYZA

    //-----------------------------| 1 | ---------------------------------

    @FindBy(xpath = "//input[@class='main-ui-filter-search-filter']")
    public WebElement filterAndSearchButton;

    @FindBy(xpath = "//span[@class='main-ui-filter-add-edit']")
    public WebElement fsSettingsButton;

    @FindBy(xpath = "//span[@class='main-ui-filter-field-button-item']")
    public WebElement resetToDefault;

    @FindBy(xpath = "//span[@class='popup-window-button']")
    public WebElement fsContinue;

    //----------------//----------------| 2 |----------------//-------------

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

    //----------------------------| 3 | --------------------------------

    @FindBy(xpath = "(//span[@class='main-ui-delete main-ui-filter-field-delete main-ui-item-icon'])[2]")
    public WebElement clickHideItem;

    @FindBy(xpath = "//span[@class='main-ui-filter-field-restore-items']")
    public  WebElement restoreDefaultFields;

    @FindBy(xpath = "//span[@class='main-ui-select-name']")
    public WebElement dateLine;

    @FindBy(xpath = "//span[.='Any date']")
    public WebElement anyDateClick;

    //---------------------------- | 4 |---------------------------------

        @FindBy(xpath = "//div[@class='main-ui-control main-ui-multi-select']")
        public WebElement clickTypeLine;

        @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[1]")
    public WebElement postsType;

        @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[2]")
    public WebElement announcementsType;

        @FindBy(xpath = "(//div[@class='main-ui-select-inner-label'])[3]")
    public WebElement appreciationsType;

        @FindBy(xpath = "//span[@class='main-ui-item-icon main-ui-search']")
    public WebElement clickSearchButton;

        //--------------------------| 5 |-------------------------

    @FindBy(xpath = "//span[@class='main-ui-filter-add-item']")
    public WebElement saveFilter;

    @FindBy(xpath = "//span[@class='ui-btn ui-btn-success main-ui-filter-field-button main-ui-filter-save']")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@class='main-ui-filter-sidebar-edit-control']")
    public WebElement giveFilterName;

    @FindBy(xpath = "(//span[@class='main-ui-filter-sidebar-item-text'])[8]")
    public WebElement servicesFilterName;














}
