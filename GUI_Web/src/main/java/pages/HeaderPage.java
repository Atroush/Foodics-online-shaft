package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class HeaderPage {
    private SHAFT.GUI.WebDriver driver;

    public HeaderPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By profileDropDown = By.xpath("(//button[contains(@id, 'toggle')])[1]");
    private final String profilePath = "//p[text()=\"value\"]/parent::div";

    public HeaderPage chooseProfile(String profileName) {
        driver.element().click(profileDropDown);
        By profile = By.xpath(profilePath.replace("value", profileName));
        driver.element().click(profile);
        return this;

    }
}
