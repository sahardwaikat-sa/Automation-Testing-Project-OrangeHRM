package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DirectoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class DirectoryTest extends BaseClass {
	
       public void verifyDirectoryPage() {

        DirectoryPage directoryPage = new DirectoryPage(driver);

        directoryPage.clickDirectory();

        String heading = directoryPage.getDirectoryHeading();

       Assert.assertEquals(heading, "Directory");
    }
	
	
	
	
	
	public void searchEmployee() {

	    DirectoryPage directoryPage = new DirectoryPage(driver);

	    directoryPage.clickDirectory();

	    directoryPage.searchEmployee("Jobin");

	    String result = directoryPage.getEmployeeResult();

	    Assert.assertTrue(result.contains("Jobin"));
	}
	
	
	

	public void searchByJobTitle() {

	    DirectoryPage directoryPage = new DirectoryPage(driver);

	    directoryPage.clickDirectory();

	    directoryPage.searchByJobTitle();
	}
	
	
	
	public void searchByLocation() {
	    DirectoryPage directoryPage = new DirectoryPage(driver);
	    directoryPage.clickDirectory();
	    directoryPage.searchByLocation();
	}
	
	@Test
	public void resetSearchFilters() {
	    DirectoryPage directoryPage = new DirectoryPage(driver);
	    directoryPage.clickDirectory();
	    directoryPage.searchByLocation();
	    directoryPage.resetSearch();

	    String location = directoryPage.getLocationValue();
	    Assert.assertTrue(location.contains("Select"));
	}
	
	
}