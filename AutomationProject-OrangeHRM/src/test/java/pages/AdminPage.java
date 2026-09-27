package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminPage {

    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        
    }
    By adminpage=By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");
    By UserManagementtext=By.xpath("//h6[text()='User Management']"); 
    By usernameField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    By userRole = By.xpath("//div[@class=\"oxd-select-text-input\"][1]");
   
    By status = By.xpath("//label[text()='Status']/following::div[contains(@class,'oxd-select-text')][1]");
    By searchButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    By resetButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']");
    By resultUsername = By.xpath("//div[@class='header' and text()='Status']/following-sibling::div[@class='data']");
    By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    By resultEmployeeName = By.xpath("//div[contains(text(),'Jobin Sam')]");
    By resultUserRole = By.xpath(
    		"//div[@class='header' and text()='User Role']/following-sibling::div[@class='data'][1]"
    	);
     By resultStatus = By.xpath("//div[@class='data' and normalize-space()='Enabled']");
     By resultRows = By.xpath("//div[contains(@class,'oxd-table-card')]");
     By addButton = By.xpath("//button[normalize-space()='Add']");
     By userRoleadd = By.xpath(
         "//label[text()='User Role']/following::div[contains(@class,'oxd-select-text')][1]");
     By employeeNameadd = By.xpath("//input[@placeholder='Type for hints...']");
     By statusadd = By.xpath(
         "//label[text()='Status']/following::div[contains(@class,'oxd-select-text')][1]");
     By username = By.xpath(
         "//label[text()='Username']/following::input[1]");
     By password = By.xpath(
         "//label[text()='Password']/following::input[1]");
     By confirmPassword = By.xpath(
         "//label[text()='Confirm Password']/following::input[1]");
By saveButton = By.xpath("//button[@type='submit']");
By editbutton = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space' and @type='button'] [2]");

By deleteButton = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space' and @type='button'] [1]");
By jobTitles = By.xpath("//a[text()='Job Titles']");
By joblist=By.xpath("//span[text()='Job ']");

By jobtext = By.xpath("//h6[normalize-space()='Job Titles']");

By jobTitleAddButton = By.xpath("//button[@type=\"button\" and @class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");

By jobTitleField = By.xpath(
    "//label[normalize-space()='Job Title']/following::input[1]"
);

By jobTitleSaveButton = By.xpath(
    "//button[@type='submit']"
);
By editJobTitleButton = By.xpath("//i[contains(@class,'bi-pencil-fill')]/..");
By jobTitleEditField = By.xpath( "//label[normalize-space()='Job Title']/following::input[1]");

By deleteJobTitleButton = By.xpath("//i[contains(@class,'bi-trash')]/..");




//admin page
    public void clickAdminPage() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	    WebElement adminlink =
    	            wait.until(ExpectedConditions.elementToBeClickable(adminpage));

    	    adminlink.click();
    }
    
    public boolean isAdminDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(

                ExpectedConditions.visibilityOfElementLocated(UserManagementtext)

        ).isDisplayed();

    }
    
    
    //search by username
    public void searchByUsername(String username) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(usernameField)
        ).sendKeys(username);

        wait.until(
            ExpectedConditions.elementToBeClickable(searchButton)).click();
        }
    
    
        
        public String isUsernameDisplayed() {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(resultUsername)
            ).getText();
        }
        
        //SEARCH EMPLOYEENAME
            public void searchByEmployeeName(String name){

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(employeeName)
                ).sendKeys(name);

                By employeeOption = By.xpath("//div[@role='option']//span[text()='" + name + "']");

                wait.until(
                    ExpectedConditions.elementToBeClickable(employeeOption)
                ).click();

                wait.until(
                    ExpectedConditions.elementToBeClickable(searchButton)
                ).click();
            }  
        
        
            public String getEmployeeNameResult() {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(resultEmployeeName)
                ).getText();
            }
        
        
            public void selectUserRoleAdmin() {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                wait.until(
                    ExpectedConditions.elementToBeClickable(userRole)
                ).click();

                By adminOption = By.xpath("//div[@role='option']//span[text()='Admin']");

                wait.until(
                    ExpectedConditions.elementToBeClickable(adminOption)
                ).click();
                
                

                wait.until(
                    ExpectedConditions.elementToBeClickable(searchButton)
                ).click();
            }
        
         /*  public String getUserRoleResult() {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(resultUserRole)
                ).getText();
            }*/
            
            
            
            
            
            public void selectStatusEnabled() {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                wait.until(
                    ExpectedConditions.elementToBeClickable(status)
                ).click();

                By enabledOption = By.xpath("//div[@role='option']//span[text()='Enabled']");

                wait.until(
                    ExpectedConditions.elementToBeClickable(enabledOption)
                ).click();
                
                wait.until(
                        ExpectedConditions.elementToBeClickable(searchButton)
                    ).click();
            }
            public int getResultsCount() {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                wait.until(
                    ExpectedConditions.visibilityOfElementLocated(resultRows)
                );

                return driver.findElements(resultRows).size();
            }
            
            
            public void clickReset() {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                wait.until(
                    ExpectedConditions.elementToBeClickable(resetButton)
                ).click();
                
                
              
            }
            public String getStatusValue() {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(status)
                ).getText();
            }
            
            
            public void addUser(String usernameValue, String passwordValue) {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

                wait.until(ExpectedConditions.elementToBeClickable(userRoleadd)).click();

                By adminOption1 = By.xpath("//div[@role='option']//span[text()='Admin']");
                wait.until(ExpectedConditions.elementToBeClickable(adminOption1)).click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameadd))
                    .sendKeys("Jobin");

                By employeeOption1 =
                    By.xpath("//div[@role='option']//span[text()='Jobin Mathew Sam']");

                wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(employeeOption1)
                )).click();

                wait.until(ExpectedConditions.elementToBeClickable(statusadd)).click();

                By enabledOption =
                    By.xpath("//div[@role='option']//span[text()='Enabled']");

                wait.until(ExpectedConditions.elementToBeClickable(enabledOption)).click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(username))
                    .sendKeys(usernameValue);

                wait.until(ExpectedConditions.visibilityOfElementLocated(password))
                    .sendKeys(passwordValue);

                wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword))
                    .sendKeys(passwordValue);

                wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
            }
            
         
            
            
            
            

                By successMessage = By.xpath(
                	    "//div[contains(@class,'oxd-toast-content')]");

                	public String getSuccessMessage() {

                	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                	    return wait.until(
                	        ExpectedConditions.visibilityOfElementLocated(successMessage)
                	    ).getText();
                	}
                	
                	
                	public void editUser(String usernameValue) {

                	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                	    wait.until(
                	        ExpectedConditions.visibilityOfElementLocated(username)
                	    ).sendKeys(usernameValue);

                	    wait.until(
                	        ExpectedConditions.elementToBeClickable(searchButton)
                	    ).click();
                	    
                	    wait.until(
                    	        ExpectedConditions.elementToBeClickable(editbutton)
                    	    ).click(); 
                	  

                	    By usernameEdit = By.xpath("//label[text()='Username']/following::input[1]");

                	    WebElement usernameField = wait.until(
                	        ExpectedConditions.visibilityOfElementLocated(usernameEdit)
                	    );

                	    usernameField.clear();
                	    usernameField.sendKeys("SaraAuto456");

                	    wait.until(
                	        ExpectedConditions.elementToBeClickable(saveButton)
                	    ).click();
                	    
                	    
                	    
                	}
                	
                	
                	
                	public void deleteUser(String usernameValue) {

                	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                	    wait.until(
                	        ExpectedConditions.visibilityOfElementLocated(username)
                	    ).sendKeys(usernameValue);

                	    wait.until(
                	        ExpectedConditions.elementToBeClickable(searchButton)
                	    ).click();

                	    wait.until(
                	        ExpectedConditions.elementToBeClickable(deleteButton)
                	    ).click();
                	    By yesDeleteButton = By.xpath("//button[normalize-space()='Yes, Delete']");

                	    wait.until(
                	        ExpectedConditions.elementToBeClickable(yesDeleteButton)
                	    ).click();
                	    
                	    
                	}
                	
                	
                	public void clickJobTitles() {

                	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                	    wait.until(
                    	        ExpectedConditions.elementToBeClickable(joblist)
                    	    ).click();
                    	    
                	    wait.until(
                	        ExpectedConditions.elementToBeClickable(jobTitles)
                	    ).click();
                	    
                	    
                	    
                	    
                	    
                	}       	
                	
                	public String getJobTitlesHeading() {

                	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                	    return wait.until(
                	        ExpectedConditions.visibilityOfElementLocated(jobtext)
                	    ).getText();
                	}
                	
                	
                	public void addJobTitle(String title) {

                	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                	    wait.until(
                	        ExpectedConditions.elementToBeClickable(jobTitleAddButton)
                	    ).click();

                	    wait.until(
                	        ExpectedConditions.visibilityOfElementLocated(jobTitleField)
                	    ).sendKeys(title);

                	    wait.until(
                	        ExpectedConditions.elementToBeClickable(jobTitleSaveButton)
                	    ).click();
                	} 	
                	
                	public void editJobTitle(String oldTitle, String newTitle) {

                	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                	    wait.until(
                	        ExpectedConditions.elementToBeClickable( editJobTitleButton)
                	    ).click();

                	    WebElement titleField = wait.until(
                	        ExpectedConditions.visibilityOfElementLocated(jobTitleEditField)
                	    );

                	    titleField.clear();
                	    titleField.sendKeys(newTitle);

                	    wait.until(
                	        ExpectedConditions.elementToBeClickable(jobTitleSaveButton)
                	    ).click();
                	}	
                	
                	public void deleteJobTitle() {

                	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                	    wait.until(
                	        ExpectedConditions.elementToBeClickable(deleteJobTitleButton)
                	    ).click();

                	    By yesDeleteButton =
                	        By.xpath("//button[normalize-space()='Yes, Delete']");

                	    wait.until(
                	        ExpectedConditions.elementToBeClickable(yesDeleteButton)
                	    ).click();
                	}  	
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	
    }
    
    
    
