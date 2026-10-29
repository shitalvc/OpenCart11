package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DashboardPage extends BasePage {
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	
	}
	@FindBy(xpath="//*[@title = 'My Account']")
	WebElement accountCTA;
	
	@FindBy(xpath="//*[contains(text(),'Register')]")
	WebElement registerLink;
	
	@FindBy(xpath="//*[contains(text(),'Login')]")
	WebElement loginLink;
	
	@FindBy(xpath="//*[@name='firstname']")
	WebElement firstNameField;
	
	@FindBy(xpath="//*[@name='lastname']")
	WebElement lastNameField;
	
	@FindBy(xpath="//*[@name='email']")
	WebElement emailAddressLink;
	
	@FindBy(xpath="//*[@name='telephone']")
	WebElement telphnoeLink;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement passWordTextBox;
	
	@FindBy(xpath="//*[@name='confirm']")
	WebElement confirmpwTextBox;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement confirmCTA;
	
	@FindBy(xpath="//*[@name='agree']")
	WebElement agreeChkBox;
	
	@FindBy(xpath="//*[@id='content']//child::h1")
	WebElement ConfimationMsg;
	
	
	public void EnterName(String firstName)
	{
		firstNameField.sendKeys(firstName);
	}
	
	public void EnterLastName(String lastName)
	{
		lastNameField.sendKeys(lastName);
	}
	
	public void enterEmai(String email)
	{
		emailAddressLink.sendKeys(email);
	}
	public void phoneNumber(String phoneNumber)
	{
		telphnoeLink.sendKeys(phoneNumber);
	}
	public void enterPassword(String password)
	{
		passWordTextBox.sendKeys(password);
	}
	public void enterConfirmPw(String confirmPw)
	{
		confirmpwTextBox.sendKeys(confirmPw);
	}
	public void clickPrivacy()
	{
		agreeChkBox.click();
	}
	public void clickContinueCTA()
	{
		confirmCTA.click();
	}
	public void accountCTA()
	{
		accountCTA.click();
	}
	public void registerLink()
	{
		registerLink.click();
	}
	public void loginLink()
	{
		loginLink.click();
	}
	public String getMessage()
	{
		try {
			return (ConfimationMsg.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
