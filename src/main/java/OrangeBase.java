
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeBase {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(5000);
        
        
       WebElement Username  = driver.findElement(By.xpath("//input[@name='username']"));
        Username.sendKeys("Admin");
        
        WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
        Password.sendKeys("admin123");
        
        WebElement Login = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        Login.click();
        
    }

    }