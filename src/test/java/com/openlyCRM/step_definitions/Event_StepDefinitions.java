package com.openlyCRM.step_definitions;

import com.openlyCRM.pages.Homepage;
import com.openlyCRM.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
    @Then("verify expected time to event start \\(minutes) {string}, {string}, {string}")
    public void verify_expected_time_to_event_start_minutes(String startDate, String startTime, String expected) {
        int actualTimeToEventStartInMinutes = (int) ChronoUnit.MINUTES.between(dateToday, dateToday.plusDays(Long.parseLong(startDate)))
                + (int) ChronoUnit.MINUTES.between(timeNow, LocalDateTime.parse(startTime, timeFormatter));
        int expectedTimeToEventStartInMinutes = Integer.parseInt(expected);
        Assert.assertEquals(actualTimeToEventStartInMinutes, expectedTimeToEventStartInMinutes);
    }
    @Then("verify expected time to event end \\(minutes) {string}, {string}, {string}")
    public void verify_expected_time_to_event_end_minutes(String endDate, String endTime, String expected) {
        int actualTimeToEventEndInMinutes = (int) ChronoUnit.MINUTES.between(dateToday, dateToday.plusDays(Long.parseLong(endDate)))
                + (int) ChronoUnit.MINUTES.between(timeNow, LocalDateTime.parse(endTime, timeFormatter));
        int expectedTimeToEventEndInMinutes = Integer.parseInt(expected);
        Assert.assertEquals(actualTimeToEventEndInMinutes, expectedTimeToEventEndInMinutes);
    }


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


}
