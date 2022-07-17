package com.openlyCRM.step_definitions;

import com.openlyCRM.pages.LoginPage;
import com.openlyCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        loginPage.loginWithHelpDeskUser();
    }


    @Then("user should be able to see homepage")
    public void userShouldBeAbleToSeeHomepage() {

        String expectedHomepageTitle = "Portal";

        String actualHomepageTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualHomepageTitle.contains(expectedHomepageTitle));
    }
}
