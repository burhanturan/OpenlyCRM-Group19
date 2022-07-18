package com.openlyCRM.step_definitions;

import com.openlyCRM.pages.Homepage;
import com.openlyCRM.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.yaml.snakeyaml.introspector.BeanAccess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Event_StepDefinitions {

    Homepage homepage = new Homepage();

    LocalDate dateToday = LocalDate.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String dateTodayString = dateToday.format(dateFormatter);

    LocalDateTime timeNow = LocalDateTime.now();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

//    Date dateTodayDate = new Date();


//    LocalDate parsedDate = LocalDate.parse(text, formatter);

    /**
     * Read the date from a date input box
     * @param eventDateBox WebElement
     * @return String
     */
    public String readEventDateBox(WebElement eventDateBox) {
        BrowserUtils.waitForClickablility(eventDateBox, 5);
        return eventDateBox.getAttribute("value");
    }

//    /**
//     * Finds the time (minutes) between two dates
//     * @param date1 the oldest date
//     * @param date2 the newest date
//     * @param timeUnit the unit in which you want the diff
//     * @return the diff value, in the provided unit
//     */
//    public long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
//        long diffInMillies = date2.getTime() - date1.getTime();
//        return timeUnit.convert(diffInMillies,TimeUnit.MINUTES);
//    }


//  AC1
    @Given("user clicks {string} tab")
    public void user_clicks_tab(String eventTabButton) {
        homepage.clickTabMenu(eventTabButton);
    }

    @Then("user should see today's date in the event start date box")
    public void user_should_see_today_s_date_in_the_event_start_date_box() {
        String actualDate = readEventDateBox(homepage.eventStartDateBox);
        Assert.assertEquals(actualDate, dateTodayString);
    }

    @Then("user should see today's date in the event end date box")
    public void user_should_see_today_s_date_in_the_event_end_date_box() {
        String actualDate = readEventDateBox(homepage.eventEndDateBox);
        Assert.assertEquals(actualDate, dateTodayString);
    }

    @When("user enters Event start date {string}")
    public void user_enters_event_start_date(String string) {
        homepage.eventStartDateBox.clear();
        LocalDate requestedDate = LocalDate.now().plusDays(Integer.parseInt(string));
        String requestedDateAsString = requestedDate.format(dateFormatter);
        homepage.eventStartDateBox.sendKeys(requestedDateAsString);
    }
    @When("user enters Event start time {string}")
    public void user_enters_event_start_time(String string) {
        String eventStartTime = timeNow.plusHours(Integer.parseInt(string)).format(timeFormatter);
        homepage.eventStartTimeBox.clear();
        homepage.eventStartTimeBox.sendKeys(eventStartTime);
    }
    @When("user enters Event end date {string}")
    public void user_enters_event_end_date(String string) {
//        homepage.eventEndDateBox.clear();
        homepage.eventEndDateBox.sendKeys(Keys.CONTROL, "a" + Keys.DELETE);

        LocalDate requestedDate = LocalDate.now().plusDays(Integer.parseInt(string));
        String requestedDateAsString = requestedDate.format(dateFormatter);
        homepage.eventEndDateBox.sendKeys(requestedDateAsString);
    }
    @When("user enters Event end time {string}")
    public void user_enters_event_end_time(String string) {
        String eventEndTime = timeNow.plusHours(Integer.parseInt(string)).format(timeFormatter);
        homepage.eventEndTimeBox.clear();
        homepage.eventEndTimeBox.sendKeys(eventEndTime);
    }
//    @Then("verify expected time to event start \\(minutes) {string}, {string}, {string}")
//    public void verify_expected_time_to_event_start_minutes(String startDate, String startTime, String expected) {
//        int actualTimeToEventStartInMinutes = (int) ChronoUnit.MINUTES.between(dateToday, dateToday.plusDays(Long.parseLong(startDate)))
//                + (int) ChronoUnit.MINUTES.between(timeNow, LocalDateTime.parse(startTime, timeFormatter));
//        int expectedTimeToEventStartInMinutes = Integer.parseInt(expected);
//        Assert.assertEquals(actualTimeToEventStartInMinutes, expectedTimeToEventStartInMinutes);
//    }
//    @Then("verify expected time to event end \\(minutes) {string}, {string}, {string}")
//    public void verify_expected_time_to_event_end_minutes(String endDate, String endTime, String expected) {
//        int actualTimeToEventEndInMinutes = (int) ChronoUnit.MINUTES.between(dateToday, dateToday.plusDays(Long.parseLong(endDate)))
//                + (int) ChronoUnit.MINUTES.between(timeNow, LocalDateTime.parse(endTime, timeFormatter));
//        int expectedTimeToEventEndInMinutes = Integer.parseInt(expected);
//        Assert.assertEquals(actualTimeToEventEndInMinutes, expectedTimeToEventEndInMinutes);
//    }



    @When("user clicks All Day check box")
    public void user_clicks_all_day_check_box() {
//        BrowserUtils.sleep(2);
        homepage.eventAllDayCheckBox.click();
    }
    @Then("user should see the All Day check box is selected")
    public void user_should_see_the_all_day_check_box_is_selected() {
        Assert.assertTrue(homepage.eventAllDayCheckBox.isSelected());
    }
    @Then("user unclicks All Day check box")
    public void user_unclicks_all_day_check_box() {
//        BrowserUtils.sleep(2);
        homepage.eventAllDayCheckBox.click();
    }
    @Then("user should see the All Day check box is NOT selected")
    public void user_should_see_the_all_day_check_box_is_not_selected() {
        Assert.assertFalse(homepage.eventAllDayCheckBox.isSelected());
    }


    @When("user clicks Specify Time Zone link")
    public void user_clicks_specify_time_zone_link() {
        homepage.specifyTimeZoneLink.click();
    }
    @When("user clicks Time Zone From dropdown menu")
    public void user_clicks_time_zone_from_dropdown_menu() {
        homepage.timeZoneFromBox.click();
    }
    @Then("user should be able to select Time Zone From {string}")
    public void user_should_be_able_to_select_time_zone_from(String string) {
       BrowserUtils.selectFromDropdown(homepage.timeZoneFromBox, string);
//        List<String> timeZoneOptions = BrowserUtils.dropdownOptionsAsString(homepage.timeZoneFromBox);
//        System.out.println("timeZoneOptions.size() = " + timeZoneOptions.size());   // 425 time zone options available
    }
    @Then("user clicks Time Zone To dropdown menu")
    public void user_clicks_time_zone_to_dropdown_menu() {
        homepage.timeZoneToBox.click();
    }
    @Then("user should be able to select Time Zone To {string}")
    public void user_should_be_able_to_select_time_zone_to(String string) {
        BrowserUtils.selectFromDropdown(homepage.timeZoneToBox, string);
    }
    @Then("user should see the expected Time Zone From {string}")
    public void user_should_see_the_expected_time_zone_from(String string) {

    }
    @Then("user should see the expected Time Zone To {string}")
    public void user_should_see_the_expected_time_zone_to(String string) {

    }


//  AC2
    @Given("Event set reminder checkbox is checked")
    public void event_set_reminder_checkbox_is_checked() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(homepage.eventSetReminderCheckbox.isDisplayed());
    }
    @When("user clicks Event set reminder checkbox")
    public void user_clicks_event_set_reminder_checkbox() {
//        BrowserUtils.clickWithJS(homepage.eventSetReminderCheckbox);
        homepage.eventSetReminderCheckbox.click();
    }
    @Then("user should see set reminder checkbox is unchecked")
    public void user_should_see_set_reminder_checkbox_is_unchecked() {
        Assert.assertFalse(homepage.eventSetReminderCheckbox.isSelected());
    }
    @Then("user should see set reminder checkbox is checked")
    public void user_should_see_set_reminder_checkbox_is_checked() {
        BrowserUtils.waitForPageToLoad(1);
        Assert.assertTrue(homepage.eventSetReminderCheckbox.isSelected());
    }
    @Given("user should see Event reminder count {string} by default")
    public void user_should_see_event_reminder_count_by_default(String string) {
        BrowserUtils.waitForPageToLoad(1);
        Assert.assertEquals(homepage.eventReminderCount.getAttribute("value"), string);
    }
    @When("user enters {string} into Event reminder count input box")
    public void user_enters_into_event_reminder_count_input_box(String string) {
        homepage.eventReminderCount.clear();
        homepage.eventReminderCount.sendKeys(string);
    }
    @Then("user should see {string} in the Event reminder count input box")
    public void user_should_see_in_the_event_reminder_count_input_box(String string) {
        Assert.assertEquals(homepage.eventReminderCount.getAttribute("value"), string);
    }

    @Given("user should see Event reminder type {string} by default")
    public void userShouldSeeEventReminderTypeByDefault(String string) {
        Select select = new Select(homepage.eventReminderTypeDropdown);
        String actualEventReminderType = select.getFirstSelectedOption().getText();
        Assert.assertEquals(string, actualEventReminderType);
    }
    @When("user clicks Event remind type dropdown menu")
    public void user_clicks_event_remind_type_dropdown_menu() {
        homepage.eventReminderTypeDropdown.click();
    }
    @When("user should see below info in event remind type dropdown")
    public void user_should_see_below_info_in_event_remind_type_dropdown(List<String> expectedRemindTypes) {
        List<String> actualRemindTypes =BrowserUtils.dropdownOptionsAsString(homepage.eventReminderTypeDropdown);
        Assert.assertEquals(actualRemindTypes, expectedRemindTypes);
    }

    @When("user selects {string} in the event remind type dropdown menu")
    public void user_selects_in_the_event_remind_type_dropdown_menu(String string) {
        BrowserUtils.selectFromDropdown(homepage.eventReminderTypeDropdown, string);
    }
    @Then("user should see the {string} in the event remind type box")
    public void user_should_see_the_in_the_event_remind_type_box(String string) {
        Select select = new Select(homepage.eventReminderTypeDropdown);
        Assert.assertEquals(string, select.getFirstSelectedOption().getText());
    }

    @Then("user should see Event start date & time, end date & time {string}, {string}, {string}, {string}")
    public void userShouldSeeEventStartDateTimeEndDateTime(String arg0, String arg1, String arg2, String arg3) {
        Assert.assertEquals(LocalDate.now().plusDays(Integer.parseInt(arg0)).format(dateFormatter), homepage.eventStartDateBox.getAttribute("value"));
        Assert.assertEquals(timeNow.plusHours(Integer.parseInt(arg1)).format(timeFormatter), homepage.eventStartTimeBox.getAttribute("value"));
        Assert.assertEquals(LocalDate.now().plusDays(Integer.parseInt(arg2)).format(dateFormatter), homepage.eventEndDateBox.getAttribute("value"));
        Assert.assertEquals(timeNow.plusHours(Integer.parseInt(arg3)).format(timeFormatter), homepage.eventEndTimeBox.getAttribute("value"));
    }


//    AC3

    @Given("User should see select meeting room as placeholder in the Event location dropdown input box")
    public void user_should_see_select_meeting_room_as_placeholder_in_the_event_location_dropdown_input_box() {
        BrowserUtils.waitForVisibility(homepage.eventLocationDropdown, 2);
        String  expectedPlaceholder = "select meeting room";
        String actualPlaceholder = homepage.eventLocationDropdown.getAttribute("value");
        Assert.assertEquals(expectedPlaceholder, actualPlaceholder);
    }
    @When("user clicks Event location dropdown")
    public void user_clicks_event_location_dropdown() {
        BrowserUtils.clickWithJS(homepage.eventLocationDropdown);
    }
    @Then("user should see below info in Event location dropdown")
    public void user_should_see_below_info_in_event_location_dropdown(List<String> expectedLocations) {
        List<WebElement> actualLocations = homepage.eventLocationDropdownOptions;
        List<String> actualLocationsString = new ArrayList<>();
        for (WebElement each : actualLocations) {
            actualLocationsString.add(each.getText());
        }
        Assert.assertEquals(expectedLocations, actualLocationsString);
    }
    @Then("user selects {string} in the Event location dropdown")
    public void user_selects_in_the_event_location_dropdown(String string) {
        List<WebElement> actualLocations = homepage.eventLocationDropdownOptions;
        for (WebElement each : actualLocations) {
            if (each.getText().equals(string)){
                each.click();
            }
        }
    }
    @Then("user should see the expected Event location {string}")
    public void user_should_see_the_expected_event_location(String string) {
        Assert.assertEquals(homepage.eventLocationDropdown.getAttribute("value"), string);
    }


//  AC4
    @When("user clicks Members input box")
    public void user_clicks_members_input_box() {
        homepage.membersInputBox.click();
    }
    @When("user clicks Employees And Departments link")
    public void user_clicks_employees_and_departments_link() {
        homepage.employeesAndDepartments.click();
    }
    @When("user clicks {string} department")
    public void user_clicks_department(String string) {
        List<WebElement> HR_Departments = homepage.HR_Departments;
        for (WebElement each : HR_Departments) {
            if(each.getText().equals(string)){
                each.click();
            }
        }
    }
    @When("user clicks All department and subdepartment employees checkbox under {string}")
    public void user_clicks_All_department_and_subdepartment_employees_checkbox_under(String string) {
        List<WebElement> allDepartmentsCheckboxes = homepage.allDepartmentsCheckboxesUnderHRs;
        for (WebElement each : allDepartmentsCheckboxes) {
            if(each.getAttribute("Rel").contains(string)){
                each.click();
            }
        }
    }
    @Then("user selects following contacts")
    public void user_selects_following_contacts(List<String> contactsToSelect) {
        List<WebElement> contacts = homepage.contacts;
        for (WebElement each : contacts) {
            for (String contactToSelect : contactsToSelect) {
                if (each.getAttribute("textContent").equals(contactToSelect)){
                    each.click();
                }
            }
        }
    }
//    Running process is waiting about 10 seconds after selecting contacts!
//    It waits even when I deleted the following assertion..
//    Try to find out the reason and a faster solution.

    @Then("user should see the selected departments and contacts in the Members input box")
    public void user_should_see_the_selected_departments_and_contacts_in_the_members_input_box(List<String> expectedContacts) {
        for (String each : expectedContacts) {
            Assert.assertTrue(homepage.membersInputBox.getAttribute("textContent").contains(each));
        }
    }

//  AC5
    @When("user enter Event name {string} in the Event name input box")
    public void user_enter_event_name_in_the_event_name_input_box(String string) {
        homepage.eventNameInputBox.sendKeys(string);
    }
    @When("user clicks on the Event Send button")
    public void user_clicks_on_the_event_send_button() {
        homepage.eventSendButton.click();
    }
    @Then("user should see the created event with name {string} in the Activity Stream")
    public void user_should_see_the_created_event_with_name_in_the_activity_stream(String expectedEventName) {
        BrowserUtils.waitForPageToLoad(2);
        String actualEventName = homepage.activityStreamEventFeed.getAttribute("textContent");
        Assert.assertEquals(expectedEventName, actualEventName);
    }


}
