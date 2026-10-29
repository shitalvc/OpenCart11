package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath ="//*[@id='input-email']")
	WebElement emailIdBox;
	
	@FindBy(xpath ="//*[@id='input-password']")
	WebElement passwordTextBox;
	
	@FindBy(xpath ="//*[@value='Login']")
	WebElement loginCTA;
	
	public void enterMail(String email)
	{
		emailIdBox.sendKeys(email);
		
	}
	public void enterPassword(String pw)
	{
		passwordTextBox.sendKeys(pw);
		
	}
	public void clickLoginCTA()
	{
		loginCTA.click();
	}
	
	

}
