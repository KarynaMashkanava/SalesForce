package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.CreateAccountPage;
import pages.LoginPage;
import testdata.GetNewAccountModel;

public class SalesForceAccountTest extends BaseTest{
    private static String USERNAME = "karyna.mashkanava-qhfw@force.com";
    private static String PASSWORD = "Test1234!";

    @Test
    public void createAccountTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.makeLogin(USERNAME,PASSWORD);
        AccountsPage accountsPage = new AccountsPage(driver);
        accountsPage.openAccountsTab();
        accountsPage.openCreateAccountModal();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.saveNewAccountForm(GetNewAccountModel.getAccountWithAllFields());
        Assert.assertTrue(createAccountPage.waitForVisibilityOfToast());
    }

}
