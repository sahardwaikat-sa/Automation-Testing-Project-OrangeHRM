package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DirectoryPage {

    WebDriver driver;

    public DirectoryPage(WebDriver driver) {
        this.driver = driver;
    }

    By directoryLink = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[9]/a");

    By directoryHeading = By.xpath("//h6[normalize-space()='Directory']");
    By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    By searchButton = By.xpath("//button[@type='submit']");
    By employeeResult = By.xpath(
    	    "//div[contains(@class,'orangehrm-directory-card')]"
    	);
    By jobTitleFilter = By.xpath(
    	    "//label[normalize-space()='Job Title']/following::div[contains(@class,'oxd-select-text')][1]"
    	);
    By locationFilter = By.xpath(
    	    "//label[normalize-space()='Location']/following::div[contains(@class,'oxd-select-text')][1]"
    	);
    
    By locationValue = By.xpath(
    	    "//label[normalize-space()='Location']/following::div[contains(@class,'oxd-select-text')][1]");
    By resetButton = By.xpath("//button[normalize-space()='Reset']");
    public void clickDirectory() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
            ExpectedConditions.elementToBeClickable(directoryLink)
        ).click();
    }

  public String getDirectoryHeading() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(directoryHeading)
        ).getText();
  
}
  
  public void searchEmployee(String name) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(
	        ExpectedConditions.visibilityOfElementLocated(employeeName)
	    ).sendKeys(name);

	    By employeeOption =
	        By.xpath("//div[@role='option']//span[contains(text(),'Jobin')]");

	    wait.until(
	        ExpectedConditions.elementToBeClickable(employeeOption)
	    ).click();

	    wait.until(
	        ExpectedConditions.elementToBeClickable(searchButton)
	    ).click();
	}
  
  
  

  public String getEmployeeResult() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    return wait.until(
	        ExpectedConditions.visibilityOfElementLocated(employeeResult)
	    ).getText();
	}

  public void searchByJobTitle() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(
	        ExpectedConditions.elementToBeClickable(jobTitleFilter)
	    ).click();

	    By automationTesterOption =
	        By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");

	    wait.until(
	        ExpectedConditions.elementToBeClickable(automationTesterOption)
	    ).click();

	    wait.until(
	        ExpectedConditions.elementToBeClickable(searchButton)
	    ).click();
	}

  public void searchByLocation() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(locationFilter)).click();

	    By locationOption = By.xpath(
	        "//div[@role='option']//span[normalize-space()='New York Sales Office']"
	    );

	    wait.until(ExpectedConditions.elementToBeClickable(locationOption)).click();

	    wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	}

  
  
  public String getLocationValue() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    return wait.until(
	        ExpectedConditions.visibilityOfElementLocated(locationValue)
	    ).getText();
	}
  
  
  public void resetSearch() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(
	        ExpectedConditions.elementToBeClickable(resetButton)
	    ).click();
	}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}