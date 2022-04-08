package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.*;

public class NewPersonPage {
    @FindBy(how = How.ID, using = "addPersonBtn")
    private WebElement clearAllFields;
    @FindBy(how = How.ID, using = "name")
    private WebElement nameField;
    @FindBy(how = How.ID, using = "surname")
    private WebElement surnameField;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobField;
    @FindBy(how = How.ID, using = "dob")
    private WebElement dateOFBirthField;
    @FindBy(how = How.CLASS_NAME, using = "w3-check")
    private List<WebElement> listOfLanguages;
    @FindBy(how = How.CLASS_NAME, using = "w3-radio")
    private List<WebElement> listOfGenders;
    @FindBy(className = "w3-select")
    private WebElement select;
    @FindBy(how = How.XPATH, using = "//div[3]/div/div/div/div/button[1]")
    private WebElement addButton;
    @FindBy(how = How.XPATH, using = "//div[3]/div/div/div/div/button[2]")
    private WebElement cancelButton;
    @FindBy(how = How.XPATH, using = "//div[2]/div/button")
    private WebElement clearAllFieldsButton;
    @FindBy(how = How.XPATH, using = "//div/p[7]/select/option[1]")
    private WebElement defaultOption;

    public void enterName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterSurname(String surname) {
        surnameField.clear();
        surnameField.sendKeys(surname);
    }

    public void enterJob(String job) {
        jobField.clear();
        jobField.sendKeys(job);
    }

    public void enterDateOfBirth(String dob) {
        dateOFBirthField.clear();
        dateOFBirthField.sendKeys(dob);
    }

    public void selectLanguage(String language) {
        for (WebElement lang : listOfLanguages) {
            if (lang.getAttribute("value").equals(language)) {
                lang.click();
                assertTrue(lang.isSelected());
            }
        }
    }

    public void selectGender(String gender) {
        for (WebElement gen : listOfGenders) {
            if (gen.getAttribute("id").equals(gender)) {
                gen.click();
                assertTrue(gen.isSelected());
            }
        }
    }

    public void selectOption(String text) {
        Select dropdown = new Select(select);
        dropdown.selectByVisibleText(text);
    }

    public void addButtonClick() {
        addButton.click();
    }

    public void cancelButtonClick() {
        cancelButton.click();
    }

    public void clearAllFieldsButtonClick() {
        clearAllFields.click();
    }

    public WebElement getSelectedLanguage() {
        for (WebElement lang : listOfLanguages) {
            if (lang.isSelected()) {
                return lang;
            }
        }
        return null;
    }

    public void checkAllFieldsAfterClear() {
        assertTrue(nameField.getAttribute("value").isEmpty());
        assertTrue(surnameField.getAttribute("value").isEmpty());
        assertTrue(jobField.getAttribute("value").isEmpty());
        assertTrue(dateOFBirthField.getAttribute("value").isEmpty());

        String selectedLanguage = getSelectedLanguage().getAttribute("id");
        assertEquals("english", selectedLanguage);

        for (WebElement gender : listOfGenders) {
            assertFalse(gender.isSelected());
        }
        assertEquals("Employee", defaultOption.getText());
    }
}


