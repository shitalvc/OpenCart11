package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class CommonTcsBaseClass{
public static WebDriver driver;
public Properties pr ;

//public propertie pr;
	
	@BeforeClass(groups= {"Smoke","Regression"})
	@Parameters({"browser"})
	public void launch (String br) throws IOException
	{
		FileReader pp = new FileReader("./src//test//resources//config.properties"); //.//represnt current project path
		pr = new Properties();  //first create object
		pr.load(pp);  //load the protery file
		
		 
		
		
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "default":
			System.out.println("invalid name passed");
			return;
		}

		//driver = new ChromeDriver();
		driver.get(pr.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"Smoke","Regression"})
	public void TearDown()
	{
		driver.quit();
	}
	public String randomString()
	{
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
	public String randomNumber()
	{
		String number = RandomStringUtils.randomNumeric(10);
		return number;
	}
	public String randomeAlphabetic()
	{
		String generateString = RandomStringUtils.randomAlphabetic(3);
		String number = RandomStringUtils.randomNumeric(3);
		String pwField = generateString + "@" + number;
		return pwField;
	}
	public String captureScreenShort(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File SourceFile = ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenShorts\\"+ tname + "_" + timeStamp;
		File targetFile = new File(targetFilePath);
		
		SourceFile.renameTo(targetFile);

	return targetFilePath;
	}

}
