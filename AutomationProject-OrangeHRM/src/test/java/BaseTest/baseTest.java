package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest {

    protected WebDriver driver;
    protected String Url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeMethod
    public void setupDriver() {
        driver = new ChromeDriver();
        Reporter.log("open the Browser");
        driver.manage().window().maximize();
        Reporter.log("maximize the Browser");
        System.out.println("Browser opened");
    }

   @AfterMethod
   public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    protected void login(String username, String password) {
        driver.get(Url);
        pages.loginPage loginObject = new pages.loginPage(driver);
        loginObject.enterUsername(username);
        Reporter.log("enter user ");
        loginObject.enterPassword(password);
        Reporter.log("enter pass");
        loginObject.clickLogin();
        Reporter.log("click the login page");
        loginObject.openNextPage();
        Reporter.log("next page is open ");
    }
}