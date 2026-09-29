package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AdminPage;

public class AdminTest extends BaseClass {

	
	 @DataProvider(name = "addUser")
	   	public Object[][] getdu() {

	   		return new Object[][] { 
	   			{"SaraAuto688", "Sara12346"},
	   			{"aghhhhhhhhhhhhhjhlohllllllllllllllllllllllll/","1234567"},
	   			{"fg", "Sara12346"},
	   			{"124556777", "Sara12346"},{"SaraAuto688", "5"}

	   		};
	   	}
	
	
	 @DataProvider(name = "jobtitel")
		public Object[][] getdata() {

			return new Object[][] { 
				{ "Automation Tester1" },{ "2343525" },{},{"ss"},{"saradfghjklyjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj"}

			};
		}
	
	
	
	
	
	
	
	
	
	
	
	 @Test
    public void verifyAdminPageDisplayed() {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        Assert.assertTrue(adminPage.isAdminDisplayed());
    }
	
	
	
    @Test
    public void searchValidUsername() {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.searchByUsername("Admin");
   
    
        String actualUsername = adminPage.isUsernameDisplayed();

        Assert.assertEquals(actualUsername, "Admin");
    }
    
    
    
    @Test
    public void searchInvalidUsername() {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.searchByUsername("ss");

        String actualResult = adminPage.isUsernameDisplayed();

        Assert.assertEquals(actualResult, "No Records Found");
    } 
    
    
   
    
    @Test
    public void searchByEmployeeName() {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.searchByEmployeeName("Jobin Mathew Sam");
        String actualEmployeeName = adminPage.getEmployeeNameResult();

        Assert.assertEquals(actualEmployeeName, "Jobin Sam");
    }
    
    
    @Test
    public void searchByUserRole() throws InterruptedException {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.selectUserRoleAdmin();

        Thread.sleep(2000);

      String actualRole = adminPage.getUserRoleResult();

       Assert.assertEquals(actualRole, "Admin");
    }
    
    @Test
    public void searchByStatus() {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.selectStatusEnabled();
        int resultsCount = adminPage.getResultsCount();

        Assert.assertTrue(resultsCount > 0);
    }
    
    
    @Test
    public void resetSearchFilters() {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.selectStatusEnabled();



        adminPage.clickReset();
        String statusValue = adminPage.getStatusValue();

        

        Assert.assertEquals(statusValue, "-- Select --");
    }
    
   
    
    @Test(dataProvider="addUser")
    public void addUser(String username,String password) {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.addUser(username,  password);
        String message = adminPage.getSuccessMessage();

        Assert.assertTrue(message.contains("Successfully Saved"));
    }
    
    
    
    @Test
    public void editUser() {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.editUser("SaraAuto123");
        
        By usernameEdit = By.xpath("//label[text()='Username']/following::input[1]");

        String message = adminPage.getSuccessMessage();
        
        Assert.assertTrue(message.contains("Successfully Updated"));
    }
    
    @Test
    public void deleteUser() {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.deleteUser("SaraAuto456");
        String message = adminPage.getSuccessMessage();

        Assert.assertTrue(message.contains("Successfully Deleted"));
    }
    
    @Test
    public void searchWithMultipleFilters() {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.selectUserRoleAdmin();

        adminPage.selectStatusEnabled();

    

        int resultsCount = adminPage.getResultsCount();

        Assert.assertTrue(resultsCount > 0);
    }
    
   //job
    
    @Test
    public void verifyJobTitlesPage() {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.clickJobTitles();
        String heading = adminPage.getJobTitlesHeading();

        Assert.assertEquals(heading, "Job Titles");
    }
    @Test(dataProvider="jobtitel")
    public void addJobTitle(String titel) {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.clickJobTitles();

        adminPage.addJobTitle(titel);
        String message = adminPage.getSuccessMessage();

        Assert.assertTrue(message.contains("Successfully Saved"));
    } 
    
    
    
    @Test
    public void editJobTitle() {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.clickJobTitles();

        adminPage.editJobTitle(
            "Automation Tester",
            "Automation QA Tester"
   );

        String message = adminPage.getSuccessMessage();

        Assert.assertTrue(message.contains("Successfully Updated"));
    }
    
    
    
    @Test
    public void deleteJobTitle() {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.clickJobTitles();

        adminPage.deleteJobTitle();

        String message = adminPage.getSuccessMessage();

        Assert.assertTrue(message.contains("Successfully Deleted"));
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}