package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class DashboardPage {
    private SHAFT.GUI.WebDriver driver;

    public DashboardPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By dashboardTitle = By.xpath("//span[@aria-current='location']//span[text()='Dashboard']");

    public void validateHomePageOpen() {
        driver.verifyThat().element(dashboardTitle).exists();
    }
}
