package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class EmployeePage {
    private SHAFT.GUI.WebDriver driver;

    public EmployeePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By addEmployeeButton = By.id("newEmployee");
    private final String employeePath = "//div[text()='value']";
    private final By loaderlocator = By.xpath("//div[@class=\"el-loading-spinner\"]");

    public EmployeePage navigateToAddNewEmp() {
        driver.element().click(addEmployeeButton);
        return this;
    }

    public EmployeePage verifyEmployeeExistence(String userName) {
        driver.verifyThat().element(By.xpath(employeePath.replace("value", userName))).exists().perform();
        return this;
    }

}
