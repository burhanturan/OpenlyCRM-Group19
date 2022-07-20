package com.openlyCRM.step_definitions;

import com.openlyCRM.pages.BasePage;
import com.openlyCRM.pages.LoginPage;
import com.openlyCRM.pages.TaskPage;
import com.openlyCRM.utilities.BrowserUtils;
import com.openlyCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TaskStepDefinitions extends BasePage {

    TaskPage taskPage = new TaskPage();

    @When("user click on Task button")
    public void user_click_on_task_button() {
        taskButton.click();
    }

    @When("user click High priority checkbox")
    public void user_click_checkbox() {
        taskPage.highPriorityButton.click();
    }

    @When("user fill Things To Do inbox")
    public void user_fill_things_to_do_inbox() {
        taskPage.thingsToDoInbox.sendKeys("OPC-1101");

    }

    @When("user click Send button.")
    public void user_click_send_button() {
        taskPage.sendButton.click();
        BrowserUtils.waitFor(3);


    }

    @And("user click task created popup")
    public void userClickTaskCreatedPopup() {
        BrowserUtils.waitForClickablility(taskPage.viewTaskPopup, 10);
        taskPage.viewTaskPopup.click();


    }

    @Then("user see task created with high priority")
    public void user_see_task_created_with_high_priority() {
        BrowserUtils.waitFor(4);
        taskPage.goToTaskIframe();
        Assert.assertTrue(taskPage.dataPriority2Element.isDisplayed());


    }

    @When("user  click on responsible person-add more button")
    public void user_click_on_responsible_person_add_more_button() {
        taskPage.responsiblePerson_addMoreButton.click();


    }

    String employee1 = "hr24@cybertekschool.com";
    String employee2 = "helpdesk78@cybertekschool.com";
    String employee3 ="helpdesk25@cybertekschool.com";
    String employee4 ="marketing68@cybertekschool.com";


    @When("user select two more users")
    public void user_select_two_more_users() {
        taskPage.responsibleEmployeesInbox.sendKeys(employee1);
        taskPage.responsibleEmployeesInbox.sendKeys(Keys.ENTER);


        BrowserUtils.waitFor(1);

        WebElement closePopUp = taskPage.seperatedTasksCreatedPopup;
        if (closePopUp.isEnabled()) {
            closePopUp.click();
        }
        taskPage.responsiblePerson_addMoreButton.click();

        taskPage.responsibleEmployeesInbox.sendKeys(employee2);
        taskPage.responsibleEmployeesInbox.sendKeys(Keys.ENTER);
        if (closePopUp.isEnabled()) {
            closePopUp.click();
        }

    }

    @Then("user see task is created with two responsible users")
    public void user_see_task_is_created_with_three_responsible_users() {
        taskPage.goToTaskIframe();

        for (WebElement responsiblePersonString : taskPage.responsiblePeopleList) {
            System.out.println("each : " + responsiblePersonString.getText());
            if (responsiblePersonString.getText().equals(employee1) || responsiblePersonString.getText().equals(employee2)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }


        }

    }

    @And("user select four more users")
    public void userSelectFourMoreUsers() {
        taskPage.responsibleEmployeesInbox.sendKeys(employee1);
        taskPage.responsibleEmployeesInbox.sendKeys(Keys.ENTER);


        BrowserUtils.waitFor(1);

        WebElement closePopUp = taskPage.seperatedTasksCreatedPopup;
        if (closePopUp.isEnabled()) {
            closePopUp.click();
        }
        taskPage.responsiblePerson_addMoreButton.click();

        taskPage.responsibleEmployeesInbox.sendKeys(employee2);
        taskPage.responsibleEmployeesInbox.sendKeys(Keys.ENTER);
        if (closePopUp.isEnabled()) {
            closePopUp.click();
        }
        taskPage.responsibleEmployeesInbox.sendKeys(employee3);
        taskPage.responsibleEmployeesInbox.sendKeys(Keys.ENTER);


        BrowserUtils.waitFor(1);


        if (closePopUp.isEnabled()) {
            closePopUp.click();
        }
        taskPage.responsiblePerson_addMoreButton.click();
        taskPage.responsibleEmployeesInbox.sendKeys(employee4);
        taskPage.responsibleEmployeesInbox.sendKeys(Keys.ENTER);


        BrowserUtils.waitFor(1);

        if (closePopUp.isEnabled()) {
            closePopUp.click();
        }
        taskPage.responsiblePerson_addMoreButton.click();



    }

    @Then("user see task is not created")
    public void userSeeTaskIsNotCreated() {
        Assert.assertFalse(taskPage.viewTaskPopup.isDisplayed());
    }

    int expectedcounter;
    @And("user read ongoing task counter")
    public void userReadOngoingTaskCounter() {
        System.out.println("taskPage.counterOngoingTasks.getText() = " + taskPage.counterOngoingTasks.getText());
       expectedcounter=taskPage.readCounter(taskPage.counterOngoingTasks.getText())+1;
    }


    @Then("user see it counted on the My Tasks table")
    public void userSeeItCountedOnTheMyTasksTable() {

        int lastCounterInt= taskPage.readCounter(taskPage.counterOngoingTasks.getText());
        Assert.assertEquals(expectedcounter,lastCounterInt);


    }


}



