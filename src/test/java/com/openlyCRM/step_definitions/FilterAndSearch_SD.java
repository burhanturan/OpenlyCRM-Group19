package com.openlyCRM.step_definitions;

import com.github.dockerjava.api.model.Link;
import com.openlyCRM.pages.FilterAndSearchPage;
import com.openlyCRM.pages.LoginPage;
import com.openlyCRM.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class FilterAndSearch_SD {

LoginPage loginPage = new LoginPage();
FilterAndSearchPage filterAndSearchPage = new FilterAndSearchPage();

    //-----------------//---------------- | 1 | ----------------------//

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
        Assert.assertTrue(filterAndSearchPage.fsContinue.isDisplayed());

    }

    //-----------------//---------------- | 2 | ----------------------//

    @When("user clicks add file button")
    public void user_clicks_add_file_button() {
    filterAndSearchPage.fsFieldsClick.click();
    }
    @When("user should be see the fields")
    public void user_should_be_see_the_fields(List<String> fields) {
        System.out.println(fields);
    }


    @Then("user should be able to add and remove fields")
    public void user_should_be_able_to_add_and_remove_fields() {
        BrowserUtils.waitFor(2);
        filterAndSearchPage.beforeClickData.click();

        BrowserUtils.waitFor(2);
        filterAndSearchPage.afterClickData.click();

        BrowserUtils.waitFor(2);
        filterAndSearchPage.beforeClickType.click();

        BrowserUtils.waitFor(2);
        filterAndSearchPage.afterClickType.click();

        BrowserUtils.waitFor(2);
        filterAndSearchPage.beforeClickAuthor.click();

        BrowserUtils.waitFor(2);
        filterAndSearchPage.afterClickAuthor.click();

        BrowserUtils.waitFor(2);
        filterAndSearchPage.beforeClickTo.click();

        BrowserUtils.waitFor(2);
        filterAndSearchPage.afterClickTo.click();

        BrowserUtils.waitFor(2);
        filterAndSearchPage.beforeClickFavorites.click();

        BrowserUtils.waitFor(2);
        filterAndSearchPage.afterClickFavorites.click();

        BrowserUtils.waitFor(2);
        filterAndSearchPage.beforeClickTag.click();

        BrowserUtils.waitFor(2);
        filterAndSearchPage.afterClickTag.click();

        BrowserUtils.waitFor(2);
        filterAndSearchPage.beforeClickExtranet.click();

        BrowserUtils.waitFor(2);
        filterAndSearchPage.afterClickExtranet.click();

        Assert.assertTrue(filterAndSearchPage.afterClickExtranet.isDisplayed());
    }

   //----------------//--------------| 3 | ------------------//-----------


    @When("user clicks the Restore default fields and can see the default fields")
    public void user_clicks_the_restore_default_fields_and_can_see_the_default_fields() {

        filterAndSearchPage.clickHideItem.click();
        BrowserUtils.waitFor(3);
        filterAndSearchPage.restoreDefaultFields.click();

    }
    @When("user clicks Date line")
    public void user_clicks_date_line() {

        filterAndSearchPage.dateLine.click();

    }
    @When("click the Any date or different dates")
    public void click_the_any_date_or_different_dates(List<String> dates) {
        System.out.println(dates);

        filterAndSearchPage.anyDateClick.click();

    }
    @Then("the user should be able to select on which day wants to choose")
    public void the_user_should_be_able_to_select_on_which_day_wants_to_choose() {

        Assert.assertTrue(filterAndSearchPage.anyDateClick.isDisplayed());
    }

//---------------//---------------| 4 |----------------------//------------------------


    @When("user clicks the Type line")
    public void user_clicks_the_type_line() {
    filterAndSearchPage.clickTypeLine.click();
    }
    @When("user can add more then one Types")
    public void user_can_add_more_then_one_types() {
filterAndSearchPage.postsType.click();
filterAndSearchPage.announcementsType.click();
filterAndSearchPage.appreciationsType.click();
    }
    @When("user click the search button")
    public void user_click_the_search_button() {
        BrowserUtils.waitFor(3);
filterAndSearchPage.clickSearchButton.click();
    }
    @Then("user can see the added types on the homepage")
    public void user_can_see_the_added_types_on_the_homepage() {
Assert.assertTrue(filterAndSearchPage.clickSearchButton.isDisplayed());
    }

    //--------------------------| 5 |------------------------------##






}
