package pages;

import models.SalesForceAccountModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import salesforceelements.DropDownList;
import salesforceelements.InputField;

public class CreateAccountPage extends BasePage {

    private By INPUT_SEARCH = By.xpath("//article[contains(., 'New Account')]//label[contains(., 'Account Name')]/following-sibling::div//input");
    private By SAVE_BUTTON = By.xpath("//button[@title='Save']");

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void saveNewAccountForm(SalesForceAccountModel accountModel) {
        driver.findElement(INPUT_SEARCH).sendKeys(accountModel.getAccountName());
        new InputField(driver, "Phone").inputText(accountModel.getPhone());
        new InputField(driver, "Fax").inputText("1231231");
        new DropDownList(driver, "Type").selectOption(accountModel.getType());
        driver.findElement(SAVE_BUTTON).click();

    }
}
