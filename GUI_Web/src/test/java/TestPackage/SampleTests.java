package TestPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static com.shaft.driver.SHAFT.*;


public class SampleTests {
    private GUI.WebDriver driver;


    @Test()
    public void checkHomePageTitleIsCorrect() {
        new LoginPage(driver).verifyBrowserTitleIsCorrect();
    }


    @BeforeClass
    public void beforeClass() {
        TestData.JSON testData = new TestData.JSON("simpleJSON.json");
    }

    @BeforeMethod(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver = new GUI.WebDriver();
        new LoginPage(driver).navigate();
    }

    @Test
    public void checkOrder() {
        new LoginPage(driver).login("skylinedynamics", "@Test123");
        new DashboardPage(driver).validateHomePageOpen();
        new HeaderPage(driver).chooseProfile("Dunkin' Egypt");
        new NavigationPage(driver).navigateToOrders().navigateToEmployee();
        new EmployeePage(driver).navigateToAddNewEmp();
        new RegisterNewEmployeePage(driver).addEmployee("test", "user", "testAutomation", "1234567a1!", "test1234@gm.com", "Driver", "El Korba").clickSave();
        new EmployeePage(driver).verifyEmployeeExistence("testAutomation");
    }

    @AfterMethod(description = "Teardown Browser instance.")
    public void afterMethod() {
        driver.quit();
    }
}
