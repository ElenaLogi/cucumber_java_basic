package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.NewPersonPage;
import pages_sample.PeopleListPage;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Task2Steps {
    private WebDriver driver;
    static NewPersonPage newPersonPage;
    static PeopleListPage peopleListPage;
    private String name;
    private String surname;

    public Task2Steps() {
        this.driver = Hooks.driver;
        newPersonPage = PageFactory.initElements(driver, NewPersonPage.class);
        peopleListPage = PageFactory.initElements(driver, PeopleListPage.class);
    }

    @Given("^I (?:am on|open) enter people page$")
    public void iAmOnPeoplePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people.html");
    }

    @When("^I click Add person button$")
    public void clickAddPersonTopButton() {
        peopleListPage.clickTopAddPersonButton();
    }

    @And("^I fill in the form:$")
    public void iFillForm(Map<String, String> fieldsToEnter) throws Throwable {
        newPersonPage.enterName(fieldsToEnter.get("name"));
        newPersonPage.enterSurname(fieldsToEnter.get("surname"));
        newPersonPage.enterJob(fieldsToEnter.get("job"));
        newPersonPage.enterDateOfBirth(fieldsToEnter.get("dob"));
        newPersonPage.selectLanguage(fieldsToEnter.get("language"));
        newPersonPage.selectGender(fieldsToEnter.get("gender"));
        newPersonPage.selectOption(fieldsToEnter.get("status"));
    }

    @And("^I click add$")
    public void iClickAdd() {
        newPersonPage.addButtonClick();
    }

    @Then("^I am redirected to home page$")
    public void checkRedirection() {
        String expectedUrl = "https://kristinek.github.io/site/tasks/list_of_people.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @When("^I click on edit button for second record$")
    public void clickEditButton() {
        peopleListPage.clickEditButton();
    }

    @And("^I see edit form$")
    public void checkEditRedirection() {
        String editPageUrl = "https://kristinek.github.io/site/tasks/enter_a_new_person.html?id=1";
        assertEquals(editPageUrl, driver.getCurrentUrl());
    }

    @And("^I change name: \"([^\"]*)\"$")
    public void iChangeName(String name) throws Throwable {
        this.name = name;
        newPersonPage.enterName(name);
    }

    @And("^I change surname: \"([^\"]*)\"$")
    public void iChangeSurname(String surname) throws Throwable {
        this.surname = surname;
        newPersonPage.enterSurname(surname);
    }

    @And("^I click edit$")
    public void clickEdit() {
        newPersonPage.addButtonClick();
    }

    @And("^I see changes for second record$")
    public void checkChanges() {
        peopleListPage.checkNameAndSurname(name, surname);
    }

    @When("^I click on remove button for third record$")
    public void clickRemoveButton() {
        peopleListPage.clickRemoveButton();
    }

    @Then("^I see (\\d+) records in the list$")
    public void checkListAfterRemoval(int count) {
        peopleListPage.checkListAfterRemoval(count);
    }

    @And("^I click reset list button at the top$")
    public void clickResetList() {
        peopleListPage.clickResetListButton();
    }

    @And("^I see (\\d+) initial records$")
    public void checkListAfterReset(int count) {
        peopleListPage.checkListAfterRemoval(count);
    }

    @And("^I see initial name and surname for second record$")
    public void checkInitialNameAndSurname() {
        peopleListPage.checkNameAndSurnameAfterReset();
    }

    @And("^I click clear all fields button$")
    public void clickClearButton() {
        newPersonPage.clearAllFieldsButtonClick();
    }

    @Then("^The form is cleared$")
    public void checkIfFormCleared() {
        newPersonPage.checkAllFieldsAfterClear();
    }

    @When("^I click add person bottom button$")
    public void clickAddPersonBottomButton() {
        peopleListPage.clickBottomAddPersonButton();
    }

    @And("^I am redirected to add new person page$")
    public void checkRedirectionToAddNewPersonPage() {
        String expectedUrl = "https://kristinek.github.io/site/tasks/enter_a_new_person.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @And("^I click cancel button$")
    public void clickCancelButton() {
        newPersonPage.cancelButtonClick();
    }
}
