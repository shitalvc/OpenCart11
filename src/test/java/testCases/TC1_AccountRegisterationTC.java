package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import testBase.CommonTcsBaseClass;

public class TC1_AccountRegisterationTC extends CommonTcsBaseClass{
	

	@Test(groups={"Regression"})
	public void verify_Account_Registeration()
	{
		try {
		
		DashboardPage d = new DashboardPage(driver);
		d.accountCTA();
		d.registerLink();
		d.EnterName(randomString());
		d.EnterLastName(randomString());
		d.enterEmai(randomString() + "@gmail.com");
		d.phoneNumber(randomNumber());
		String pw=randomeAlphabetic();
		d.enterPassword(pw);
		d.enterConfirmPw(pw);
		d.clickPrivacy();
		d.clickContinueCTA();
		String msg = d.getMessage();
		Assert.assertEquals(msg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
	

}
