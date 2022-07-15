package com.openlyCRM.step_definitions;

import com.openlyCRM.pages.CompanyStructurePage;
import com.openlyCRM.pages.Homepage;
import com.openlyCRM.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.Assert.*;

public class Department_StepDefinitions {

    Homepage homepage = new Homepage();
    LoginPage loginPage = new LoginPage();
    CompanyStructurePage companyStructurePage = new CompanyStructurePage();

    @When("user enters {string} and {string} and clicks login button")
    public void user_enters_and_and_clicks_login_button(String username, String password) {
        loginPage.login(username, password);
    }

    @When("user clicks Employees button")
    public void user_clicks_employees_button() {
        homepage.employeesButton.click();
    }

    @Then("user should see Company Structure")
    public void user_should_see_company_structure() {
        String expectedTitle = "Company Structure";
        String actualTitle = companyStructurePage.companyStructureTitle.getText();
        assertEquals(expectedTitle, actualTitle);
    }

    //------------------AC2----------------
    @When("user clicks Add Department button")
    public void user_clicks_add_department_button() {

    }
    @When("enters department name and clicks and button")
    public void enters_department_name_and_clicks_and_button() {

    }
    @Then("user should see the department in Company Structure")
    public void user_should_see_the_department_in_company_structure() {

    }
}
