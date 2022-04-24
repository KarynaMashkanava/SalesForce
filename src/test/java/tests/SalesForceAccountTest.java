package tests;


import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.CreateAccountPage;
import pages.LoginPage;
import testdata.GetNewAccountModel;

@Log4j
public class SalesForceAccountTest extends BaseTest{
    private static String USERNAME = "karyna.mashkanava-qhfw@force.com";
    private static String PASSWORD = "Test1234!";

    @Test
    public void createAccountTest() {
        log.info("starting test: create account test");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(USERNAME,PASSWORD);
        AccountsPage accountsPage = new AccountsPage(driver);
        accountsPage.openAccountsTab();
        accountsPage.openCreateAccountModal();
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.saveNewAccountForm(GetNewAccountModel.getAccountWithAllFields());
        Assert.assertTrue(createAccountPage.waitForVisibilityOfToast());
    }

}
