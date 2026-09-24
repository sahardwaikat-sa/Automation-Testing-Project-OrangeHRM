package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class baseTest {

	protected WebDriver driver;

	String Url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@Test
	public void setupPage() {

		driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		
		

	}

}
