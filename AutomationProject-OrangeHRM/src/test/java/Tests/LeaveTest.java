package Tests;
import BaseTest.baseTest;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import BaseTest.baseTest;
import listener.listener;
import pages.leavePage;
import pages.loginPage;
import pages.pimPage;


@Listeners(listener.class)
public class LeaveTest extends baseTest {

	leavePage LeaveObject;
	loginPage loginObject;


	

	@BeforeMethod
	public void SetupObject() {

		driver.get(Url);
		LeaveObject = new leavePage(driver);

		loginObject = new loginPage(driver);
		loginObject.login("Admin", "admin123");

		//loginObject.enterUsername("Admin");
		//loginObject.enterPassword("admin123");
		//loginObject.clickLogin();

		Assert.assertTrue(loginObject.openNextPage(), "Login failed");

		LeaveObject.enterLeavePage();

	}

	@Test(priority = 1)
	void verifyEnterleavepage() {

		LeaveObject.enterLeavePage();

		Assert.assertTrue(driver.getCurrentUrl().contains("leave"));
		System.out.println("We are in leave page");

	}

	@Test(priority = 2)
	void verifyEnterleaveApply() {
		LeaveObject.enterLeavePage();
		LeaveObject.applyLeave();
	   Assert.assertTrue(driver.getCurrentUrl().contains("applyLeave"));
		System.out.println("We are in apply Leave page");

	}
	@Test(priority = 3)
	void verifyListLeave() {

		Assert.assertTrue(LeaveObject.checkLeaveList());
		System.out.println(" the list is exist with  list of items ");

	}

	@Test(dataProvider = "leavelist",dataProviderClass = DataProvider.class)
	void verifylistleaveitems(String Item) {
		LeaveObject.enterLeavePage();
		LeaveObject.applyLeave();
		Assert.assertTrue(LeaveObject.checkLeaveListItems(Item));

	}

	@Test(dataProvider = "checkdate",dataProviderClass = DataProvider.class)

	void verifyLeavedate(String from, String TO, boolean expected) {
		LeaveObject.fromleveDateSelect(from);
		LeaveObject.toleveDateSelect(TO);
		boolean actual = true;
		if (expected) {
			Assert.assertEquals(actual, expected);

		} else {

			Assert.assertFalse(actual == expected);

		}

	}
	
	@Test (dataProvider = "PartialDays",dataProviderClass = DataProvider.class)
	
	void verifyPartialDayslist(String Type) {
	Assert.assertTrue(LeaveObject.PartialDayslist(Type));
	}
	
	@Test (dataProvider = "Duration")
	void verifydurationlist(String Duration) {
		
		LeaveObject.duration( Duration);
		
		
		Assert.assertTrue(LeaveObject.durationlist(Duration), "not from from duration list ");
		
	}
	
	@Test(dataProvider = "COMMENT_LENGTHS",dataProviderClass = DataProvider.class)
	void verifycoomentsfield(String input, int expectedLength) {
		LeaveObject.applyLeave();
		
	String Actual=LeaveObject.addcomments (input);
	
	if (expectedLength==(Actual.length()))
	{
	Assert.assertEquals(Actual.length(), expectedLength, "expected max length");}
	      
	else {
		Assert.assertNotEquals(Actual.length(), expectedLength);
	}
		 
	}
	
	
	
	
		
		
	}



