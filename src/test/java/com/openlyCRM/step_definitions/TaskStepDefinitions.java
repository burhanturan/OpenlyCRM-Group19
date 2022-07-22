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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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


    @And("user click checklist button")
    public void userClickChecklistButton() {
        taskPage.checklistButton.click();

    }

    String duty1 ="finish the project";
    String duty2 ="do review";


    @And("user fill inbox and click tick")
    public void userFillInboxAndClickTick() {
        taskPage.checklistInbox.sendKeys(duty1);
        taskPage.checklistThick.click();
        taskPage.checklistInbox.sendKeys(duty2);
        taskPage.checklistThick.click();
    }

    @Then("user see task created with checklist items")
    public void userSeeTaskCreatedWithChecklistItems() {
        taskPage.goToTaskIframe();
        for (int i = 1; i < taskPage.checklistDuties.size(); i++) {

            System.out.println("taskPage.checklistDuties.get(i).getText() = " + taskPage.checklistDuties.get(i).getText());


            if (taskPage.checklistDuties.get(i).getText().contains(duty1) ||taskPage.checklistDuties.get(i).getText().contains(duty2)){
                Assert.assertTrue(true);
            }else {
                Assert.fail();
            }

        }

    }
    @When("user click Deadline inbox")
    public void user_click_deadline_inbox() {
       taskPage.deadlineInbox.click();

    }
 /*   @Then("should be able to select Deadline and clicks the select button")
    public void should_be_able_to_select_deadline_and_clicks_the_select_button() {
        activeStreamPage.july4.click();
        WebElement deadlineBox = Driver.getDriver().findElement(By.xpath("(//input[@class='task-options-inp'])[1]"));
        BrowserUtils.sleep(2);
        activeStreamPage.selectBtnDeadline.click();
        Assert.assertTrue(deadlineBox.isDisplayed());
//div[@class='bx-calendar-cell-block']/
    }*/

    @And("user select {string}, {string}, {string}, {string}, {string} and {string}")
    public void userSelectAnd(String month, String year, String day, String hour, String minute, String am_pm) {

        BrowserUtils.waitFor(2);
        taskPage.monthDropdown.click();
        BrowserUtils.waitFor(2);
        taskPage.deadlineMonth(month).click();

        BrowserUtils.waitFor(2);
        taskPage.yearDropdown.click();
        BrowserUtils.waitFor(2);
        taskPage.deadlineYear(year).click();

        BrowserUtils.waitFor(2);

        taskPage.deadlineDay(day).click();
        BrowserUtils.waitFor(2);
        //Actions actions = new Actions(Driver.getDriver());
       // actions.doubleClick(taskPage.deadlineHourInbox).perform();
        taskPage.deadlineHourInbox.sendKeys(Keys.BACK_SPACE);
        BrowserUtils.waitFor(2);
        taskPage.deadlineHourInbox.sendKeys(hour);
        BrowserUtils.waitFor(2);
        taskPage.deadlineMinuteInbox.sendKeys(minute);
        BrowserUtils.waitFor(2);
        if(!taskPage.deadline_Am_Pm.getText().equals(am_pm)){
            taskPage.deadline_Am_Pm_Arrow.click();
        }

        BrowserUtils.waitFor(2);
        taskPage.deadlineSelectButton.click();


    }

    @Then("user see the selected deadline as {string}")
    public void userSeeTheSelectedDeadlineAs(String date_time) {
        taskPage.goToTaskIframe();
        Assert.assertEquals( date_time, taskPage.actualDeadline.getText());

    }

    @When("user click Time planning button")
    public void user_click_time_planning_button() {
       taskPage.timePlanningButton.click();
    }

    @When("user fill Start task on inbox")
    public void user_fill_start_task_on_inbox() {
        taskPage.startTaskOnInbox.click();
    }
    
    String duration="10";
    @When("user fill Duration inbox")
    public void user_fill_duration_inbox() {
        taskPage.durationInbox.sendKeys(duration);
        BrowserUtils.waitFor(2);


    }

  /*  @Then("user see the selected {string} and endDate")
    public void userSeeTheSelectedAndEndDate(String startDate) {
        int durationInt = Integer.parseInt(duration);
        LocalDate startDate = ;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String currentDate = date.format(formatter);
        LocalDate endDate = LocalDate.now().plusDays(durationInt);
        String tomorrowDate = tomorrow.format(formatter);

    }*/


    @Then("user see the selected {string} and {string}")
    public void userSeeTheSelectedAnd(String startDate, String endDate) {
        taskPage.goToTaskIframe();

        Assert.assertEquals(startDate, taskPage.actualStartDate.getText());
        Assert.assertEquals(endDate, taskPage.actualEndDate.getText());
    }
}

/*

import java.time.LocalDate;
LocalDate date = LocalDate.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String currentDate = date.format(dateFormatter);

    import java.time.LocalDate;
LocalDate date = LocalDate.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String currentDate = date.format(dateFormatter);

    LocalDate tomorrow = LocalDate.now().plusDays(1);
    String tomorrowDate = tomorrow.format(dateFormatter);

    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
String expectedDate = sdf.format(Calendar.getInstance().getTime());
System.out.println("expectedDate = " + expectedDate);

 */

