package com.openlyCRM.step_definitions;

import com.openlyCRM.pages.Homepage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Event_StepDefinitions {

    Homepage homepage = new Homepage();

    @Given("user clicks {string} tab")
    public void user_clicks_tab(String eventTabButton) {
        homepage.clickTabMenu(eventTabButton);
    }
    @Then("user should see today's date in the event start date box")
    public void user_should_see_today_s_date_in_the_event_start_date_box() {

    }
    @Then("user should see today's date in the event end date box")
    public void user_should_see_today_s_date_in_the_event_end_date_box() {

    }
}
