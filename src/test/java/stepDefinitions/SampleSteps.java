package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    //Sample1
    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }


    @Given("^I am on the locators page$")
    public void iAmOnLocatorsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @Then("^I should see both locators page headers$")
    public void iShouldSeeLocatorHeader() throws Throwable {
        assertEquals("Heading 1",
                driver.findElement(By.id("heading_1")).getText());
        assertEquals("Heading 2",
                driver.findElement(By.id("heading_2")).getText());
    }

    @And("^Buttons in Locators page are clickable$")
    public void iShouldSeeEnabeledLocatorButtons() throws Throwable {
        assertTrue(driver.findElement(By.name("randomButton1")).isEnabled());
        assertTrue(driver.findElement(By.name("randomButton2")).isEnabled());
    }

    //Sample2
    @Then("^I see error: \"([^\"]*)\"$")
    public void iSeAgeError(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("error")).getText());
    }

    @Then("^I am not navigated to age message page$")
    public void iAnNotInAgeMessagePage() throws Throwable {
        assertFalse(driver.getCurrentUrl().contains("https://kristinek.github.io/site/examples/age_2.html"));
    }

    //Sample3
    @Given("^I (?:am on|open) feedback page$")
    public void iAmOnFeedbackPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @When("^I enter name in feedback: \"([^\"]*)\"$")
    public void iEnterNameInFeedback(String name) throws Throwable {
        driver.findElement(By.id("fb_name")).clear();
        driver.findElement(By.id("fb_name")).sendKeys(name);
    }

    @When("^I enter age in feedback: ([^\"]*)$")
    public void iEnterAgeInFeedback(String age) throws Throwable {
        driver.findElement(By.id("fb_age")).clear();
        driver.findElement(By.id("fb_age")).sendKeys(age);
    }

    @When("^I click send feedback$")
    public void iClickSendFeedback() throws Throwable {
        driver.findElement(By.className("w3-btn-block")).clear();
    }

    @Then("^I can see name: \"([^\"]*)\" in feedback check$")
    public void iCanSeeName(String name) throws Throwable {
        assertEquals(name, driver.findElement(By.id("name")).getText());
    }

    @Then("^I can see age: \"([^\"]*)\" in feedback check$")
    public void iCanSeeAge(String age) throws Throwable {
        assertEquals(age, driver.findElement(By.id("age")).getText());
    }

    //Task1_Steps
    @Given("^I am on the page$")
    public void iAmOnTheThePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }


    @When("^I enter number \"([^\"]*)\" in the field$")
    public void iEnterNumberInTheField(String qwerty) {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(qwerty);

    }

    @And("^I click submit button$")
    public void iClickSubmiButton() {
        driver.findElement(By.className("w3-orange")).click();

    }

    @Then("^I see error message: \"([^\"]*)\"$")
    public void iSeeErrorMsg(String msg) throws Throwable {
        assertEquals(msg, driver.findElement(By.id("ch1_error")).getText());
    }

    @Then("^I see alert message: \"([^\"]*)\"$")
    public void iSeeAlertMessage(String message) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(message, alert.getText());
        alert.accept();
    }

    //Sample4
    @When("^I select feedback languages$")
    public void iSelectFeedbackLanguages(List<String> languages) throws Throwable {
        for (String language : languages) {
            driver.findElement(By.xpath("//input[@class='w3-check' and @value='" + language + "']")).click();
        }
    }

    @Then("^I can see languages \"([^\"]*)\" in feedback check$")
    public void iCanSeeLanguagesInFeedbackCheck(String languages) throws Throwable {
        assertEquals(languages, driver.findElement(By.id("language")).getText());
    }

    //Sample5
    @When(("^I enter input in feedback page$"))
    public void iEnterInputInFeedback(Map<String, String> feedbackInput) throws Throwable {
        /*driver.findElement(By.id("fb_name")).clear();
        driver.findElement(By.id("fb_name")).sendKeys(feedbackInput.get("name"));
        driver.findElement(By.id("fb_age")).clear();
        driver.findElement(By.id("fb_age")).sendKeys(feedbackInput.get("age"));*/
        if (feedbackInput.containsKey("name")) {
            iEnterNameInFeedback(feedbackInput.get("name"));
        }
        iEnterAgeInFeedback(feedbackInput.get("age"));
        driver.findElement(By.xpath("//input[@value='" + feedbackInput.get("genre") + "']")).click();
    }

    @When(("^I enter input in feedback page as data table$"))
    public void iEnterInputInFeedback(DataTable inputTable) throws Throwable {
        for (Map<String, String> feedbackInput : inputTable.asMaps(String.class, String.class)) {
            if (feedbackInput.containsKey("name")) {
                iEnterNameInFeedback(feedbackInput.get("name"));
            }
            iEnterAgeInFeedback(feedbackInput.get("age"));
            driver.findElement(By.xpath("//input[@value='" + feedbackInput.get("genre") + "']")).click();
        }
    }
}






