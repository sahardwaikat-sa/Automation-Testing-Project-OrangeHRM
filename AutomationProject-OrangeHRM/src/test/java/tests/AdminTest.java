package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AdminPage;

public class AdminTest extends BaseClass {

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

       // String actualRole = adminPage.getUserRoleResult();

       // Assert.assertEquals(actualRole, "Admin");
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
    
    
    
    @Test
    public void addUser() {

        AdminPage adminPage = new AdminPage(driver);

        adminPage.clickAdminPage();

        adminPage.addUser("SaraAuto66", "Sara@12345");
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
    
    
    
    
}