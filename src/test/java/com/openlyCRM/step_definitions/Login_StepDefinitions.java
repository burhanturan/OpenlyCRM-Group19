package com.openlyCRM.step_definitions;

import com.openlyCRM.pages.LoginPage;
import io.cucumber.java.en.Given;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        loginPage.loginWithHRUser();
    }


}
