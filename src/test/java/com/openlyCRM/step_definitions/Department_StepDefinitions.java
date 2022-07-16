package com.openlyCRM.step_definitions;

import com.openlyCRM.pages.CompanyStructurePage;
import com.openlyCRM.pages.Homepage;
import com.openlyCRM.pages.LoginPage;
import com.openlyCRM.utilities.BrowserUtils;
import com.openlyCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import static org.junit.Assert.*;

public class Department_StepDefinitions {

    Homepage homepage = new Homepage();
    LoginPage loginPage = new LoginPage();
    CompanyStructurePage companyStructurePage = new CompanyStructurePage();

    //------------------AC1----------------


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
        companyStructurePage.addDepartmentButton.click();
    }

    String expectedDepName;

    @When("enters department name {string} and clicks and button")
    public void enters_department_name_and_clicks_and_button(String depName) {
        expectedDepName = depName;
        companyStructurePage.departmentName.sendKeys(depName);
        companyStructurePage.addButton.click();
    }

    @Then("user should see the department in Company Structure")
    public void user_should_see_the_department_in_company_structure() {

        String locator = "//a[.='" + expectedDepName + "']";

        WebElement newDepartment = Driver.getDriver().findElement(By.xpath(locator));

        String actualText = newDepartment.getText();
        assertEquals(expectedDepName, actualText);
    }


    //-----------------AC3---------------------

    @Then("user should be able to select from department dropdown")
    public void user_should_be_able_to_select_fFrom_department_dropdown() {
        Select select = new Select(companyStructurePage.departmentDropDown);
        String firstSelectedDep = select.getFirstSelectedOption().getText();
        select.selectByIndex(2);
        String currentSelectedDep = select.getFirstSelectedOption().getText();
        assertNotEquals(currentSelectedDep, firstSelectedDep);
    }

    //-----------------------AC4 1 ----------------------

    @When("user clicks select from structure link and clicks employee as a supervisor")
    public void user_clicks_select_from_structure_link_and_clicks_employee_as_a_supervisor() {
        BrowserUtils.waitForClickablility(companyStructurePage.selectFromStructure, 10);
        companyStructurePage.selectFromStructure.click();
        companyStructurePage.employeeAsSupervisor.click();
    }

    @Then("user should see the employee is selected")
    public void user_should_see_the_employee_is_selected() {
        assertTrue(companyStructurePage.selectedSupervisor.isDisplayed());
    }

    //-----------------------AC4  2 ----------------------

    @When("user clicks select from structure link ,company button and clicks one of the employee as a supervisor")
    public void user_clicks_select_from_structure_link_company_button_and_clicks_one_of_the_employee_as_a_supervisor() {
        BrowserUtils.waitForClickablility(companyStructurePage.selectFromStructure, 10);
        companyStructurePage.selectFromStructure.click();
        companyStructurePage.selectFromCompany.click();
        companyStructurePage.cyberVet.click();
        BrowserUtils.waitForClickablility(companyStructurePage.employeeFromCyberVet, 10);
        companyStructurePage.employeeFromCyberVet.click();
    }

    //-----------------------AC4  3 ----------------------

    @And("user clicks select from structure link ,search button and search for an employee to click")
    public void user_clicks_select_from_structure_link_search_button_and_search_for_an_employee_to_click() {
        BrowserUtils.waitForClickablility(companyStructurePage.selectFromStructure, 10);
        companyStructurePage.selectFromStructure.click();
        companyStructurePage.searchBoxForSupervisor.sendKeys("helpdesk");
        BrowserUtils.waitForClickablility(companyStructurePage.employeeFromSearch, 10);
        companyStructurePage.employeeFromSearch.click();
    }

    // -----------------------AC  5  ---------------------------

    @And("enters department name {string}")
    public void entersDepartmentName(String depName) {
        expectedDepName = depName;
        companyStructurePage.departmentName.sendKeys(depName);
    }

    @When("user clicks close button before send")
    public void user_clicks_close_button_before_send() {
        companyStructurePage.closeButton.click();
    }

    @Then("user should be able to close add department pop-up at any time before sending")
    public void user_should_be_able_to_close_add_department_pop_up_at_any_time_before_sending() {
        String locatorText = "//a[.='" + expectedDepName + "']";
        boolean resultClosingDepartment = companyStructurePage.isElementPresent(By.xpath(locatorText));
        assertFalse(resultClosingDepartment);
    }

    //--------------------AC  6-1  ------------------------------

    @When("user clicks edit button and changes department name {string}")
    public void user_clicks_edit_button_and_changes_department_name(String depName) {
        expectedDepName = depName;
        BrowserUtils.clickWithJS(companyStructurePage.hr1EditButton);
        companyStructurePage.departmentName.clear();
        companyStructurePage.departmentName.sendKeys(depName);
        companyStructurePage.saveButton.click();
    }

    @Then("user should be edit department")
    public void user_should_be_edit_department() {
        String locator = "//a[.='" + expectedDepName + "']";

        WebElement newDepartment = Driver.getDriver().findElement(By.xpath(locator));

        String actualText = newDepartment.getText();
        assertEquals(expectedDepName, actualText);
    }
    //--------------------AC  6-2  ------------------------------

    @And("user clicks add child button")
    public void user_clicks_add_child_button() {
        BrowserUtils.clickWithJS(companyStructurePage.hr1AddChildButton);
    }


    @Then("user should be able to add child department")
    public void user_should_be_able_to_add_child_department() {
        String locator = "//a[.='" + expectedDepName + "']";

        WebElement newDepartment = Driver.getDriver().findElement(By.xpath(locator));

        String actualText = newDepartment.getText();
        assertEquals(expectedDepName, actualText);
    }

    //--------------------AC  6-3  ------------------------------


    @When("user clicks delete button")
    public void user_clicks_delete_button() {
        BrowserUtils.clickWithJS(companyStructurePage.groupDepDeleteButton);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @Then("user should be able to delete department")
    public void user_should_be_able_to_delete_department() {

        String locator = "//a[.='" + expectedDepName + "']";
        boolean elementPresent = companyStructurePage.isElementPresent(By.xpath(locator));
        assertFalse(elementPresent);

    }
}
