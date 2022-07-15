package com.openlyCRM.pages;


import com.openlyCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyStructurePage extends BasePage {

    public CompanyStructurePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@id='pagetitle']")
    public WebElement companyStructureTitle;

    @FindBy(xpath = "//span[.='Add department']")
    public WebElement addDepartmentButton;

    @FindBy(xpath = "//span[.='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//input[@id='NAME']")
    public WebElement departmentName;

    @FindBy(xpath = "//select[@id='IBLOCK_SECTION_ID']")
    public WebElement departmentDropDown;

    @FindBy(xpath = "//a[.='Select from structure']")
    public WebElement selectFromStructure;

    @FindBy(xpath = "(//div[@class='finder-box-item-text'])[2]")
    public WebElement employeeAsSupervisor;

    @FindBy(xpath = "//span[@id='uf_head_name']")
    public WebElement selectedSupervisor;

    //ac 4-1
    @FindBy(xpath = "//span[.='Company']")
    public WebElement selectFromCompany;

    @FindBy(xpath = "(//span/div[@class='company-department-arrow'])[1]")
    public WebElement cyberVet;

    @FindBy(xpath = "(//div[@class='company-department-employee-position'])[3]")
    public WebElement employeeFromCyberVet;

    @FindBy(xpath = "//input[contains(@id,'_user_input')]")
    public WebElement searchBoxForSupervisor;

    @FindBy(xpath = "(//div[@class='finder-box-item-text'])[10]")
    public WebElement employeeFromSearch;

    public boolean isElementPresent(By locatorKey) {
        try {
            Driver.getDriver().findElement(locatorKey);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @FindBy(xpath = "//span[.='Close']")
    public WebElement closeButton;




}
