package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected WebDriver driver;


    @BeforeMethod
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();				
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
     // Login
        By username = By.xpath("//input[@name='username']");
        By password = By.xpath("//input[@type='password']");
        By loginButton = By.xpath("//button[@type='submit']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("Admin");
        driver.findElement(password).sendKeys("admin123");
        driver.findElement(loginButton).click();  
        
        
    }

    @AfterMethod
    public void tearDown() {

      //  driver.quit();
    }
    
}