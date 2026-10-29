package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

	public AccountPage(WebDriver driver) {
		super(driver);
	}
		
		@FindBy(xpath= "//h2[contains(text(),'My Account')]")
		WebElement myAccountText;
	
	public boolean verifyText()
	{
			return(myAccountText.isDisplayed());
		
	}
	

}
