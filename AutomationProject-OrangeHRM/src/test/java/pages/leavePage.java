package pages;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class leavePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// locaters 
	
	By LeaveButton =  By.xpath("//span[text()='Leave']");
	By ApplyButton= By.xpath("//a[text()='Apply']");
	By leavetype  = By.xpath("//label[text()='Leave Type' and contains(@class,'oxd-input-field-required')]/following::div[contains(@class,'oxd-select-text-input')][1]");
	By fromDate   = By.xpath("//label[text()='From Date']/following::div[1]");
	By ToDate    = By.xpath("//label[text()='To Date']/following::div[1]");
	By Commentsfields = By.xpath("//label[text()='Comments']/following::div[1]");
	By Calnderpopup= By.xpath("//div[contains(@class,'oxd-date-input-calendar')]");
	By PartialDays= By.xpath("//label[text()='Partial Days']/following::div[@class='oxd-select-text-input' and text()='All Days']");
    By duration =By.xpath("//label[text()='Duration']/following::div[@class='oxd-select-text-input' and text()='-- Select --']");
	
	
	// constructer
	public  leavePage (WebDriver driver) {
		
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	
	// methods
	
	
	
	public void enterLeavePage() {
			
	wait.until(ExpectedConditions.elementToBeClickable(LeaveButton)).click();
	
	}
	
	
	public void applyLeave() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ApplyButton)).click();
	}
	
	
	
	public void leaveTypelistclick() {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(leavetype)).click();
			}
		
		
			
	
	
	
	// leave list method
	
	public boolean checkLeaveList() {
		leaveTypelistclick(); 
		
		List<WebElement>leavelist=driver.findElements(By.xpath(" //div[@role='option']"));
        if(leavelist.isEmpty())
      		  return false;
        return true;
	}		
	
	public boolean checkLeaveListItems (String listitem) {
		leaveTypelistclick() ;
				
		List<WebElement>leavelist=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));
		
		for( WebElement option :leavelist ) {
			
			if(option.getText().equals(listitem))
				return true;
		}
			return false;			
		
		}
			
	// leave date method
	
	
public void fromleveDateSelect(String day) {
		
		wait.until(ExpectedConditions.elementToBeClickable(ToDate)).click();
		
		WebElement calnder= wait.until(ExpectedConditions.visibilityOfElementLocated(Calnderpopup));
		
		calnder.findElement(By.xpath(".//div[contains(@class,'oxd-calendar-date-wrapper') and not(contains(@class,'offset'))]"
				+ "/div[contains(@class,'oxd-calendar-date')][normalize-space()='"+ day.trim() +"']"))
			.click();
	}
		
		
	
	
	
	public void toleveDateSelect(String day) {
		
wait.until(ExpectedConditions.elementToBeClickable(fromDate)).click();
		
		WebElement calnder= wait.until(ExpectedConditions.visibilityOfElementLocated(Calnderpopup));
		
		calnder.findElement(By.xpath(
				".//div[contains(@class,'oxd-calendar-date-wrapper') and not(contains(@class,'offset'))]"
				+ "/div[contains(@class,'oxd-calendar-date')][normalize-space()='"+ day.trim() +"']"))
			.click();
	}
		
				

	
public String PartialDays(String type) {
	
	WebElement typeleave = driver.findElement(PartialDays);
	typeleave.click();
	typeleave.findElement(By.xpath(".//*[normalize-space()='"+type+"']")).click();
	return typeleave.getAttribute(type);
	
	
}
	//------------------------------------------------------------------------
public boolean PartialDayslist(String Type) {
	
	List <WebElement> PartialDayslist = driver.findElements(PartialDays);
	  for( WebElement type1 :PartialDayslist ) {
		  if (type1.getText().equals(Type))
			  return true;}
        return false;
	  
}


public void duration(String Duration) {
	
	WebElement typeleave = driver.findElement(duration);
	typeleave.click();
	typeleave.findElement(By.xpath(".//*[normalize-space()='"+Duration+"']")).click();
	
	
}
	
public boolean durationlist(String Type) {
	
	List <WebElement> PartialDayslist = driver.findElements(duration);
	  for( WebElement type1 :PartialDayslist ) {
		  if (type1.getText().equals(Type))
			  return true;}
        return false;
	  
}

public String addcomments (String Text) {
	
	WebElement text= driver.findElement(Commentsfields);
	text.sendKeys(Text);
	return text.getAttribute(Text);
}



	}
	
	
	
	






