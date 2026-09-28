package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pimPage {

	WebDriver driver;
	WebDriverWait wait;
	

	// lOCATER

	By Employeelist = By.xpath("//a[text()='Employee List']");
	By Employeeinfo = By.xpath("//a[text()='Employee Information']");
	By clickupdownbutton = By.xpath("//button[@class='oxd-icon-button']/i[contains(@class,'oxd-icon bi-caret')]");
	By employeename = By.xpath("//label[text()='Employee Name']/following::input[1]");
	By employeeId = By.xpath("//label[text()='Employee Id']/following::input[1]");
	By EmploymentStatus = By.xpath(
			"//label[text()='Employment Status']/following ::div[contains(@class,'oxd-select-text oxd-select')][1]");
	By Include = By
			.xpath("//label[text()='Include']/following ::div[contains(@class,'oxd-select-text oxd-select')][1]");
	By Supervisorname = By.xpath("//label[text()='Supervisor Name']/following ::input");
	By JobTitle = By
			.xpath("//label[text()='Job Title']/following ::div[contains(@class,'oxd-select-text oxd-select')][1] ");
	By Subunit = By
			.xpath("//label[text()='Sub Unit']/following ::div[contains(@class,'oxd-select-text oxd-select')][1]");
	By RestButton = By.xpath("//button[@type='reset']");
	By SearchButton = By.xpath("//button[@type='submit']");
	By AddButton = By.xpath("//button[normalize-space()='Add']");
	By checkBoxAll = By.xpath(
			"//div[@role='columnheader']//span[contains(@class,'oxd-checkbox-input oxd-checkbox-input--active ')]");
	By Firstcheckbox = By.xpath("(//div[@role='rowgroup']//span[contains(@class,'oxd-checkbox-input') and not(ancestor::div[@role='columnheader'])])[1]");
	By EditButton = By.xpath("//div[text()='Amelia ']/following::button[1]");
	By DeleteButton = By.xpath("//div[text()='Amelia ']/following::button[2]");
	By DeleteALL = By.xpath("//button[@type ='button' and text()=' Delete Selected ']");
	By PIMclick = By.xpath("//a[@href='/web/index.php/pim/viewPimModule']");
	By datasearchrecord = By.xpath("//div[@class='orangehrm-container']");
	By addButton   =  By.xpath("//button[normalize-space()='Add']");
	By EmployeefirstName  =By.xpath("//input[@name='firstName']");
	By MiddleName = By.xpath("//input[@name='middleName']");
	By lastname = By.xpath("//input[@name='lastName']");
	By EmployeeID= By.xpath("//label[text()='Employee Id']/following::input[1]");
	By SaveButton= By.xpath("//button[@type='submit']");
	
	
	public pimPage(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	public void enterPimPage() {

		wait.until(ExpectedConditions.elementToBeClickable(PIMclick)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeename));

	}

	public boolean isElementDisplayed(String Path) {

		if (driver.findElement(By.xpath(Path)).isDisplayed())
			return true;
		return false;

	}

	public boolean defaltEmployeeValue() {

	    String value = driver.findElement(employeename)
	                         .getAttribute("value");

	    return value.isEmpty();
	}

	public boolean defaltEmployeeIdValue() {

	    String value = driver.findElement(employeeId)
	                         .getAttribute("value");

	    return value.isEmpty();
	}

	public String defaltEmploymentStatusValue() {
		String Value = driver.findElement( EmploymentStatus).getText();
		return Value;
	}

	public boolean defaltSupervisorNamedValue() {

	    String value = driver.findElement(Supervisorname)
	                         .getAttribute("value");

	    return value.isEmpty();
	}

	public String defaltIncludeValue() {
		String Value = driver.findElement(Include).getText();
		return Value;
	}

	public String defaltJobTitlesValue() {
		String Value = driver.findElement(JobTitle).getText();
		return Value;
	}

	public String defaltSubUnitValue() {
		String Value = driver.findElement(Subunit).getText();
		return Value;
	}

	// Employeename Verification

	public boolean employeeNameValidation(String username) {

		WebElement UserField= wait.until(ExpectedConditions.visibilityOfElementLocated(employeename));
		UserField.sendKeys(username);
		String Actualvalue= UserField.getAttribute("value");
		return Actualvalue.equals(username);
		
		
	
	}

	// Employeeid Vervication

	public boolean employeeIdVerification(String id) {

		WebElement IDField=driver.findElement(employeeId);
		IDField.sendKeys(id);
		String Actualvalue= IDField.getAttribute("value");
		return Actualvalue.equals(id);
	}
	// Supervisornam Vervication

	public boolean supervisorNameValidation(String supervisorname) {

		WebElement SupField=driver.findElement(Supervisorname);
		SupField.sendKeys(supervisorname);
		String Actualvalue= SupField.getAttribute("value");
		return Actualvalue.equals(supervisorname);

	}

	// Validate employee satuts list
	
	public void employmentStatuslistVerification() {

		wait.until(ExpectedConditions.elementToBeClickable(EmploymentStatus)).click();
	}

	// GET ALL ITEMS
	public boolean getEmpoyeeStatusList() {
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));
		List<WebElement>listUnit=driver.findElements(By.xpath(" //div[@role='option']"));
        if(listUnit.isEmpty())
      		  return false;
        return true;
	}

	// GET ONE OPTION
	public boolean getOneitemEmpoyeeStatusList(String Unit) {
		
		
		List<WebElement> listElement = driver.findElements(By.xpath("//div[@role='option']"));

for (WebElement option1 : listElement) {
			
			if (option1.getText() .equals(Unit))
				return true;
				}
		return false;
	}
	
	

	// Validate Include list

	public void includelistVerification() {
		wait.until(ExpectedConditions.elementToBeClickable(Include)).click();
		
	}

	// GET ALL ITEMS
	public boolean getincludsist() {
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));
		List<WebElement>listUnit=driver.findElements(By.xpath(" //div[@role='option']"));
        if(listUnit.isEmpty())
      		  return false;
        return true;

	}

	// GET ONE OPTION
	public boolean getOneitemtIncludeList(String Unit) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));
		List<WebElement> listElement = driver.findElements(By.xpath(" //div[@role='option']"));
         for (WebElement option1 : listElement) {
			if (option1.getText() .equals(Unit))
			return true;
		}
		return false;
	}
	
	

	// Validate Job Title list

	public void jobTitlelistVerification() {

		driver.findElement(JobTitle).click();
	}

	// GET ALL ITEMS
	public void getJobTitleList() {
		driver.findElements(By.xpath(" //div[@role='option']"));

	}

	// GET ONE OPTION
	public boolean getOneitemJobTitleList(String Unit) {
		List<WebElement> listElement = driver.findElements(By.xpath(" //div[@role='option']"));

         for (WebElement option1 : listElement) {
			
			if (option1.getText() .equals(Unit))
				return true;
				}
		return false;
	}
	
	

	// Validate Job Title list Sub Unit

	public void subUnitVerification() {

		wait.until(ExpectedConditions.elementToBeClickable(Subunit)).click();
	}
//-------------------------------------------------------------------------------------------
	// GET ALL ITEMS
	public boolean getsubUnitList() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));
		List<WebElement> listUnit = driver.findElements(By.xpath("//div[@role='option']"));
		if (listUnit.isEmpty())
			return false;
		return true;
	}
//---------------------------------------------------------------------------------------------
	// GET ONE OPTION
	public  boolean  getOneitemsubUnitList(String Unit) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));
		
		List<WebElement> listElement = driver.findElements(By.xpath("//div[@role='option']"));

		for (WebElement option1 : listElement) {
			
			if (option1.getText().trim().equals(Unit))
				return true;
		
		}
		return false;
	}
	
	

	public void searchClick() {

		wait.until(ExpectedConditions.elementToBeClickable(SearchButton)).click();
	}

	public void restClick() {

		wait.until(ExpectedConditions.elementToBeClickable(RestButton)).click();
	
	}

	// validate datafound

	public String datafound() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(normalize-space(),' Found')]"))).getText();
		
	}

	// Validate search Record

	public void searchRecord() {

		driver.findElement(datasearchrecord);

	}

	// checkboxall

	public void checkBoxAll() {

		wait.until(ExpectedConditions.elementToBeClickable(checkBoxAll)).click();
	}

	// delete all

	public void deleteAll() {

		driver.findElement(DeleteALL).click();
	}

	public boolean diplaydeleteAll() {

		return driver.findElement(DeleteALL).isDisplayed();
	}
	
	//edit Button 
	
	public void clickEditButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(EditButton)).click();
		wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));
	}
	
	
	public void clickDeleteButton()
	{
		driver.findElement(DeleteButton).click();
	}
	// first Reored result table 
	public boolean firstRecord() {
		
		if(driver.findElement(By.xpath("//div[@role='rowgroup']/div[@class='oxd-table-card'][1]")).isDisplayed())
			return true;
		return false;
	}
	
public void firstCheckBox() {
	
	wait.until(ExpectedConditions.elementToBeClickable(Firstcheckbox)).click();
}

//  add Employee page 
public void addButton() {
	

wait.until(ExpectedConditions.elementToBeClickable(AddButton)).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(EmployeefirstName));
	
}
 
public void addEmployeeFirstname(String name) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(EmployeefirstName)).sendKeys(name);
		
}
public void addEmployeeMidletname(String name) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(MiddleName)).sendKeys(name);
		
}
public void addEmployeeLasttname(String name) {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(lastname)).sendKeys(name);
	
	
}
public void addEmployeeID(String id) {
	
 wait.until(ExpectedConditions.visibilityOfElementLocated(EmployeeID)).sendKeys(id);
	
	
		
}

public void saveButton() {
	
	wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
	wait.until(ExpectedConditions.urlContains("empNumber"));
}


}








	




