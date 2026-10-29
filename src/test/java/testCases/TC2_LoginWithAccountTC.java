package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.CommonTcsBaseClass;

public class TC2_LoginWithAccountTC extends CommonTcsBaseClass {

	@Test(groups={"Regression"})
	public void verify_Login() {
		

			DashboardPage b = new DashboardPage(driver);
			b.accountCTA();
			b.loginLink();
			LoginPage l = new LoginPage(driver);

			l.enterMail(pr.getProperty("Email"));
			l.enterPassword(pr.getProperty("Password"));
			l.clickLoginCTA();

			AccountPage a = new AccountPage(driver);
			boolean value = a.verifyText();
			Assert.assertEquals(value, true, "no user foud");
			Assert.assertTrue(value);



	}
}
