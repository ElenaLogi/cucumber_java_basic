package pages_sample;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.junit.Assert.*;

public class PeopleListPage {
    @FindBy(how = How.XPATH, using = "//div[2]/button[1]")
    private WebElement addPersonTopButton;
    @FindBy(how = How.XPATH, using = "//div[4]/button[1]")
    private WebElement addPersonBottomButton;
    @FindBy(how = How.XPATH, using = "//div[2]/button[2]")
    private WebElement resetListTopButton;
    @FindBy(how = How.XPATH, using = "//div[4]/button[2]")
    private WebElement resetListBottomButton;
    @FindBy(how = How.XPATH, using = "//div[2]/li/span[2]")
    private WebElement editButton;
    @FindBy(how = How.XPATH, using = "//div[3]/li/span[1]")
    private WebElement removeButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/div/span[1]")
    private WebElement nameField;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/div/span[2]")
    private WebElement surnameField;
    @FindBy(how = How.CLASS_NAME, using = "w3-padding-16")
    private List<WebElement> listOfPeople;

    private String oldName;
    private String oldSurname;

    public void clickTopAddPersonButton() {
        addPersonTopButton.click();
    }

    public void clickEditButton() {
        oldName = nameField.getText();
        oldSurname = surnameField.getText();
        editButton.click();
    }

    public void checkNameAndSurname(String name, String surname) {
        assertEquals(name, nameField.getText());
        assertEquals(surname, surnameField.getText());
    }

    public void checkListAfterRemoval(int count) {
        assertEquals(count, listOfPeople.size());
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public void clickResetListButton() {
        resetListTopButton.click();
    }

    public void checkNameAndSurnameAfterReset() {
        assertEquals(oldName, nameField.getText());
        assertEquals(oldSurname, surnameField.getText());
    }

    public void clickBottomAddPersonButton() {
        addPersonBottomButton.click();
    }
}
