package com.openlyCRM.pages;


import com.openlyCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage{

    public Homepage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void clickTabMenu(String tabName) {

        String locator = "//span//span[.='" + tabName + "']";
        WebElement Button = Driver.getDriver().findElement(By.xpath(locator));
        Button.click();

    }

 //OPC-1102-FilterAndSearch
    /*@FindBy(xpath = "//span[.='Task']/span")
    public WebElement taskButton;*/

    // OPC-1006_event
    @FindBy(xpath = "(//span[.='Event'])[2]")
    public WebElement eventTab;


    @FindBy(xpath = "//div[@id='feed-add-buttons-blockblogPostForm']//button[@class='ui-btn ui-btn-lg ui-btn-primary']")
    public WebElement sendButton;


    @FindBy(xpath = "//div[.='Task has been created']")
    public WebElement taskButton;
}
