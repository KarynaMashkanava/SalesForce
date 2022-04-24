package pages;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WebUrls;

@Log4j
public class LoginPage extends BasePage {
    private By USERNAME_INPUT = By.id("username");
    private By PASSWORD_INPUT = By.id("password");
    private By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        log.info("opening salesforce page");
        driver.get(WebUrls.SALESFORCE_URL);
    }

    public void login(String username, String password) {
        log.info("type user name " + username);
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        log.info("type user password " + password);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        log.trace("user is logged in!!");
    }
}
