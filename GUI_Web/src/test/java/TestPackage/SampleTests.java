package TestPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static com.shaft.driver.SHAFT.*;


public class SampleTests {
    private GUI.WebDriver driver;



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
    public void addEmployee() throws InterruptedException {
        new LoginPage(driver).login("skylinedynamics", "@Test123");
        new DashboardPage(driver).validateHomePageOpen();
        new HeaderPage(driver).chooseProfile("Dunkin' Egypt");
        //this wait should be handled in another way and should be removed but letting it for dubbing purpose
        Thread.sleep(10000);

        new NavigationPage(driver).navigateToEmployee();
        new EmployeePage(driver).navigateToAddNewEmp();
        new RegisterNewEmployeePage(driver).addEmployee("test1", "user1", "testAutomation1", "1234567a1!", "test1234@gm.com", "Driver", "El Korba").clickSave();
        new EmployeePage(driver).verifyEmployeeExistence("testAutomation");
    }

    @AfterMethod(description = "Teardown Browser instance.")
    public void afterMethod() {
        driver.quit();
    }
}
