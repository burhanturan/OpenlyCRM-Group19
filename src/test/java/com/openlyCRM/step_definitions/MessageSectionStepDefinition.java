package com.openlyCRM.step_definitions;

import com.openlyCRM.pages.BasePage;
import com.openlyCRM.pages.LoginPage;
import com.openlyCRM.pages.MessageSectionPage;
import com.openlyCRM.utilities.BrowserUtils;
import com.openlyCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class MessageSectionStepDefinition extends BasePage {

    LoginPage loginPage = new LoginPage();
    MessageSectionPage messageSectionPage = new MessageSectionPage();



        @When("user clicks the message button on the homepage")
        public void user_clicks_the_message_button_on_the_homepage () {

            loginPage.messageButton.click();


    }


    @And("the user clicks the {string} button")
    public void theUserClicksTheButton(String arg0) {

            BrowserUtils.sleep(1);

            String locator = "(//span[@title='"+arg0+"'])[1]";
            //(//span[@title='Add mention'])[1]
        WebElement addMentionButton = Driver.getDriver().findElement(By.xpath(locator));
        addMentionButton.click();
    }

    @And("the user clicks Department name to open")
    public void theUserClicksDepartmentNameToOpen() {




            messageSectionPage.departmentButton.click();

        }
    @And("user clicks on employee names to mention departments")
    public void userClicksOnEmployeeNamesToMentionDepartments() {
            BrowserUtils.sleep(1);
            messageSectionPage.mentionHrThree.click();
            messageSectionPage.mentionEmployees.click();
    }

    @And("user clicks on the Send button")
    public void userClicksOnTheSendButton() {

            BrowserUtils.sleep(1);

            messageSectionPage.sendButton.click();
    }


    @Then("user should be able to verify url")
    public void userShouldBeAbleToVerifyUrl() {
           BrowserUtils.sleep(1);

            String expectedUrl ="https://login.openlycrm.com/stream/?login=yes";
            String actualUrl = Driver.getDriver().getCurrentUrl();
    }

    @When("user clicks on link button")
    public void userClicksOnLinkButton() {
            loginPage.messageButton.click();
            messageSectionPage.linkButton.click();
            
    }

    @When("user types {string} into text input box")
    public void userTypesIntoTextInputBox(String arg0) {

            messageSectionPage.textInputBox.sendKeys(arg0);
    }

    @And("user types {string} into link inputbox and clicks save button and then clicks send button")
    public void userTypesIntoLinkInputboxAndClicksSaveButtonAndThenClicksSendButton(String arg0) {

            messageSectionPage.linkInputBox.sendKeys(arg0);
            messageSectionPage.linkSaveButton.click();
            messageSectionPage.sendButton.click();

    }


    @Then("user should see verify google link")
    public void userShouldSeeVerifyGoogleLink() {

            BrowserUtils.verifyElementDisplayed(messageSectionPage.googleVerify);
    }
}
