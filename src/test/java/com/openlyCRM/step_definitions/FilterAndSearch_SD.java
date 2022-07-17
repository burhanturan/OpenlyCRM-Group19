package com.openlyCRM.step_definitions;

import com.openlyCRM.pages.FilterAndSearchPage;
import com.openlyCRM.pages.LoginPage;
import com.openlyCRM.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class FilterAndSearch_SD {

LoginPage loginPage = new LoginPage();
FilterAndSearchPage filterAndSearchPage = new FilterAndSearchPage();

    @When("user clicks the filter and search box")
    public void user_clicks_the_filter_and_search_box() {

    filterAndSearchPage.filterAndSearchButton.click();

    }
    @When("user can clicks settings item")
    public void user_can_clicks_settings_item() {

        filterAndSearchPage.fsSettingsButton.click();

    }
    @When("user clicks the Reset to default message")
    public void user_clicks_the_reset_to_default_message() {
        BrowserUtils.waitFor(2);
        filterAndSearchPage.resetToDefault.click();
    }
    @When("user clicks the continue button")
    public void user_clicks_the_continue_button() {
        BrowserUtils.waitFor(2);
        filterAndSearchPage.fsContinue.click();

    }
    @Then("user should be able to see default filters")
    public void user_should_be_able_to_see_default_filters(List<String> filters) {

        System.out.println(filters);


    }


}
