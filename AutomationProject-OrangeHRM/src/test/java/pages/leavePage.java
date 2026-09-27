package pages;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class leavePage {
	
	WebDriver driver;
	
	// locaters 
	
	By LeaveButton =  By.xpath("//span[text()='Leave']");
	By ApplyButton= By.xpath("//a[text()='Apply']");
	By leavetype  = By.xpath("//label[text()='Leave Type']/following::div[1]");
	By fromDate   = By.xpath("//label[text()='From Date']/following::div[1]");
	By ToDate    = By.xpath("//label[text()='To Date']/following::div[1]");
	By Commentsfields = By.xpath("//label[text()='Comments']/following::div[1]");
	By Calnderpopup= By.xpath("//div[contains(@class,'oxd-date-input-calendar')]");
	By PartialDays= By.xpath("//label[text()='Partial Days']/following::div[@class='oxd-select-text-input' and text()='All Days']");
    By duration =By.xpath("//label[text()='Duration']/following::div[@class='oxd-select-text-input' and text()='-- Select --']");
	
	
	// constructer
	public  leavePage (WebDriver driver) {
		
		this.driver=driver;
	}
	
	// methods
	
	
	
	public void enterLeavePage() {
		driver.findElement(LeaveButton).click();
	}
	
	
	public void applyLeave() {
		
		driver.findElement(LeaveButton).click();
			}
	
	public void leaveTypelist() {
		
		driver.findElement(leavetype).click();
	}
	
	// leave list method
	
	public boolean checkLeaveList() {
		List<WebElement>leavelist=driver.findElements(By.xpath(" //div[@role='option']"));
        if(leavelist.isEmpty())
      		  return false;
        return true;
				
	}
	
	public boolean checkLeaveListItems (String listitem) {
		
		List<WebElement>leaveList= driver.findElements(By.xpath(" //div[@role='option']"));
		
		for( WebElement option :leaveList ) {
			
			if(option.getText().equals(listitem))
				return true;
		}
			return false;			
		
		}
			
	// leave date method
	
	
	public void fromleveDateSelect(int day) {
		
		LocalDate date = LocalDate.now();

		int dayOfMonth = date.getDayOfMonth();
		
		driver.findElement(fromDate).click();
		
		WebElement calnder= driver.findElement(Calnderpopup);
		calnder.findElement(By.xpath(".//*[normalize-space()='"+ dayOfMonth+ "']")).click();
		
		
		
	}
	
	
	public void toleveDateSelect(int day) {
		
		LocalDate date = LocalDate.now();

		int dayOfMonth = date.getDayOfMonth();
		
		driver.findElement(ToDate).click();
		
		WebElement calnder= driver.findElement(Calnderpopup);
		calnder.findElement(By.xpath(".//*[normalize-space()='"+ dayOfMonth+ "']")).click();
		
				
	}
	
public void PartialDays(String type) {
	
	WebElement typeleave = driver.findElement(PartialDays);
	typeleave.click();
	typeleave.findElement(By.xpath(".//*[normalize-space()='"+type+"']")).click();
	
	
}
	
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

public void addcomments (String Text) {
	
	driver.findElement(Commentsfields).sendKeys(Text);
}



	}
	
	
	
	






