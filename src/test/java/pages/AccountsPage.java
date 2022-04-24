package pages;

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

    public void openAccountsTab() {
        driver.get(WebUrls.SALESFORCE_ACCOUNTS_URL);
    }

    public void openCreateAccountModal() {
        log.info("click new button");
        driver.findElement(NEW_BUTTON).click();
    }
}
