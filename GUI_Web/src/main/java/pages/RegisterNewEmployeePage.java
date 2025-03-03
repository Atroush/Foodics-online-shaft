package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class RegisterNewEmployeePage {
    private SHAFT.GUI.WebDriver driver;

    public RegisterNewEmployeePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By firstNameInput = By.xpath("//label[text()=\"First Name\"]/parent::div//input");
    private final By lastNameInput = By.xpath("//label[text()=\"Last Name\"]/parent::div//input");
    private final By userNameInput = By.xpath("//label[text()=\"Username\"]/parent::div//input");
    private final By passwordInput = By.xpath("//label[text()=\"Password\"]/parent::div//input");
    private final By emailInput = By.xpath("//label[text()=\"Email\"]/parent::div//input");
    private final By roleDropDownButton = By.xpath("//label[text()=\"Roles\"]/parent::div//input");
    private final By locationsDropDownButtonLocator = By.xpath("//label[text()=\"Locations\"]/parent::div//div[@class='el-select__tags']//input");
    private final By saveButtonLocator = By.xpath("//button[text()=\"Save\"]");
    private String roleLocatorPath = "//li[@name=\"value\"]";
    private String locationPath = "//li[@name='value']";

    public RegisterNewEmployeePage addEmployee(String firstName, String lastName, String userName, String password, String email, String role, String location) {
        driver.element().type(firstNameInput, firstName);
        driver.element().type(lastNameInput, lastName);
        driver.element().type(userNameInput, userName);
        driver.element().type(passwordInput, password);
        driver.element().type(emailInput, email);
        driver.element().click(roleDropDownButton);
        driver.element().click(By.xpath(roleLocatorPath.replace("value", role)));
        driver.element().click(locationsDropDownButtonLocator);
        driver.element().click(By.xpath(locationPath.replace("value", location)));
        return this;
    }

    public RegisterNewEmployeePage clickSave() {
        driver.element().click(saveButtonLocator);
        return this;
    }
}