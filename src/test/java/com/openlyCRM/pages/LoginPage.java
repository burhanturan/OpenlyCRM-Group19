package com.openlyCRM.pages;

import com.openlyCRM.utilities.ConfigurationReader;
import com.openlyCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement username;

    @FindBy(name = "USER_PASSWORD")
    public WebElement password;

    @FindBy(xpath = "//input[@class='login-btn']")
    public WebElement loginButton;

    public void loginWithMarketingUser() {
        Driver.getDriver().get(ConfigurationReader.getProperty("openlyCRM.url2"));
        this.username.sendKeys(ConfigurationReader.getProperty("openlyCRM.email3"));
        this.password.sendKeys(ConfigurationReader.getProperty("openlyCRM.password"));
        this.loginButton.click();
    }

    public void loginWithHRUser() {
        Driver.getDriver().get(ConfigurationReader.getProperty("openlyCRM.url2"));
        this.username.sendKeys(ConfigurationReader.getProperty("openlyCRM.email2"));
        this.password.sendKeys(ConfigurationReader.getProperty("openlyCRM.password"));
        this.loginButton.click();
    }

    public void loginWithHelpDeskUser() {
        Driver.getDriver().get(ConfigurationReader.getProperty("openlyCRM.url2"));
        this.username.sendKeys(ConfigurationReader.getProperty("openlyCRM.email1"));
        this.password.sendKeys(ConfigurationReader.getProperty("openlyCRM.password"));
        this.loginButton.click();
    }

    public void login(String username,String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("openlyCRM.url2"));
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }


}
