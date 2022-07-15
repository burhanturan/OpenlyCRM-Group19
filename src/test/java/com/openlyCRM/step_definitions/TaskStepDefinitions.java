package com.openlyCRM.step_definitions;

import com.openlyCRM.pages.BasePage;
import com.openlyCRM.pages.TaskPage;
import com.openlyCRM.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TaskStepDefinitions extends BasePage {

    TaskPage taskPage=new TaskPage();

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

    }
    @Then("user see task created with high priority")
    public void user_see_task_created_with_high_priority() {
        BrowserUtils.waitForClickablility(taskPage.taskCreatedPopup,10);
        Assert.assertTrue(taskPage.taskCreatedPopup.isDisplayed());
    }

}
