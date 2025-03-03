package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class NavigationPage {
    private SHAFT.GUI.WebDriver driver;

    public NavigationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By orders = By.xpath("//a[@href='/orders']");
    private final By employees = By.xpath("//a[@href=\"/employees\"]");

    public NavigationPage navigateToOrders() {
        driver.element().click(orders);
        return this;
    }

    public NavigationPage navigateToEmployee() {
        driver.element().click(employees);
        return this;
    }
}
