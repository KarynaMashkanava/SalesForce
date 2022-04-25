package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WebUrls;

@Log4j
public class AccountsPage extends BasePage{

    private By NEW_BUTTON = By.xpath("//div[text()='New']");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open account tab")
    public void openAccountsTab() {
        driver.get(WebUrls.SALESFORCE_ACCOUNTS_URL);
    }

    @Step("open create account modal window")
    public void openCreateAccountModal() {
        log.info("click new button");
        driver.findElement(NEW_BUTTON).click();
    }
}
