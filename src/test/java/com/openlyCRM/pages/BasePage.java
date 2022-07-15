package com.openlyCRM.pages;


import com.openlyCRM.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

 OPC-1010_Comment
    //nhlcntrk-common method
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    //nhlcntrk
    public void clickFunction(WebElement clickElement){

        wait.until(ExpectedConditions.elementToBeClickable(clickElement));

        clickElement.click();
    }

    //nlcntrk
    public void sendKeysFunction(WebElement sendKeysElement, String value){

        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));

        sendKeysElement.sendKeys(value);
    }

    //nhlcntrk
    public void selectElementFromDropdown(WebElement dropdown,String element){

        Select slc = new Select(dropdown);

        slc.selectByVisibleText(element);

    }

    //nhlcntrk
    public void Assertion(WebElement actual,String expected){
        wait.until(ExpectedConditions.visibilityOf(actual));
        Assert.assertEquals(actual.getText(),expected);
        System.out.println("My Message :  " + actual.getText());

    }


    @FindBy(xpath = "(//span[@data-role='item-text'])[10]")
    public WebElement employeesButton;


}
