package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {
    private SHAFT.GUI.WebDriver driver;

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By userNameInput = By.xpath("//input[@placeholder='Username']");
    private final By passwordInput = By.xpath("//input[@placeholder='Password']");
    private final By signInButton = By.xpath("//button[@type='submit']");
    private final By loginPageTitle = By.xpath("//div[@class='text-center text-muted mb-4']//small");
    private final String url = "https://test-merchant-app.getsolo.io/dashboard";
    private final String title = "Login to your account";

    public LoginPage navigate() {
        driver.browser().navigateToURL(url);
        return this;
    }

    public LoginPage verifyBrowserTitleIsCorrect() {
        driver.verifyThat().browser().title().isEqualTo(title).perform();
        return this;
    }

    public LoginPage login(String userName, String password) {
        driver.element().type(userNameInput, userName);
        driver.element().type(passwordInput, password);
        driver.element().click(signInButton);
        return this;

    }

}
