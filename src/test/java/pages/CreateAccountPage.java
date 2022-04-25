package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import models.SalesForceAccountModel;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import salesforceelements.DropDownList;
import salesforceelements.InputField;
import salesforceelements.TextArea;

@Log4j
public class CreateAccountPage extends BasePage {

    private By INPUT_SEARCH = By.xpath("//article[contains(., 'New Account')]//label[contains(., 'Account Name')]/following-sibling::div//input");
    private By SAVE_BUTTON = By.xpath("//button[@title='Save']");
    private final By TOAST_SUCCESS = By.xpath("//div[@role = 'alert' and @data-key = 'success']");

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("fill in account form")
    public void saveNewAccountForm(SalesForceAccountModel accountModel) {
        log.info("type user information");
        driver.findElement(INPUT_SEARCH).sendKeys(accountModel.getAccountName());
        new InputField(driver, "Phone").inputText(accountModel.getPhone());
        new InputField(driver, "Fax").inputText(accountModel.getFax());
        new InputField(driver, "Employees").inputText(accountModel.getEmployees());
        new InputField(driver, "Annual Revenue").inputText(accountModel.getAnnualRevenue());
        new DropDownList(driver, "Type").selectOption(accountModel.getType());
        new DropDownList(driver, "Industry").selectOption(accountModel.getIndustry());
        new InputField(driver, "Website").inputText(accountModel.getWebsite());
        new TextArea(driver, "Description").typeIntoTextArea(accountModel.getDescription());
        new TextArea(driver, "Billing Street").typeIntoTextArea(accountModel.getBillingStreet());
        new TextArea(driver, "Shipping Street").typeIntoTextArea(accountModel.getShoppingStreet());
        new InputField(driver, "Billing City").inputText(accountModel.getBillingCity());
        new InputField(driver, "Billing State/Province").inputText(accountModel.getBillingState());
        new InputField(driver, "Shipping City").inputText(accountModel.getShippingCity());
        new InputField(driver, "Shipping State/Province").inputText(accountModel.getShippingState());
        new InputField(driver, "Billing Zip/Postal Code").inputText(accountModel.getBillingPostalCode());
        new InputField(driver, "Billing Country").inputText(accountModel.getBillingCountry());
        new InputField(driver, "Shipping Zip/Postal Code").inputText(accountModel.getShippingZipCode());
        new InputField(driver, "Shipping Country").inputText(accountModel.getShippingCountry());
        log.info("click save button");
        driver.findElement(SAVE_BUTTON).click();
        log.trace("account form was saved");
    }

    public boolean waitForVisibilityOfToast() {
        log.debug("waiting for toast");
        try {
            driver.findElement(TOAST_SUCCESS);
            return true;
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("Element was not found. We cannot put waiter into assert, that is why I use try-catch. Looks ugly, but anyway");
        }
    }
}
