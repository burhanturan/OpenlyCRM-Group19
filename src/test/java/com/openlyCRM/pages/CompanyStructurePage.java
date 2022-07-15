package com.openlyCRM.pages;


import com.openlyCRM.utilities.Driver;
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


}
