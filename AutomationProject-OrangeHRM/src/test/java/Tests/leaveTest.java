package Tests;

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
public class leaveTest extends baseTest {

	leavePage LeaveObject;
	loginPage loginObject;

	@DataProvider(name = "leavelist")
	public Object[][] getdata() {

		return new Object[][] { 
			{ " SAHAR " }

		};
	}

	@DataProvider(name = "checkdate")
	public Object[][] getdate() {

		return new Object[][] { { "1 ", " 3 ", true }, { " 15 ", " 7 ", false }, { " 1 ", " 1 ", true },
				{ "  ", " 11 ", false }, { " 11 ", "  ", false }, { " -1 ", " 1 ", false }

		};
	}
	
	

@DataProvider(name = "COMMENT_LENGTHS")
public Object[][] getCommentLengths() {
    return new Object[][] {
        { "A".repeat(50), 50 },     
        { "A".repeat(500), 500 },   
        { "A".repeat(600), 500 },   
    };
}
	@DataProvider(name = "PartialDays")
	public Object[][] gettyps() {

		return new Object[][] { 
			{ " SAHAR " }

		};
	}
	

	@BeforeMethod
	public void SetupObject() {

		driver.get(Url);
		LeaveObject = new leavePage(driver);

		loginObject = new loginPage(driver);

		loginObject.enterUsername("Admin");
		loginObject.enterPassword("admin123");
		loginObject.clickLogin();

		Assert.assertTrue(loginObject.openNextPage(), "Login failed");

		LeaveObject.enterLeavePage();

	}

	@Test(priority = 1)
	void verifyEnterleavepage() {

		LeaveObject.enterLeavePage();

		Assert.assertTrue(driver.getCurrentUrl().contains("leave"));
		System.out.println("We are in leave page");

	}

	@Test
	void verifyEnterleaveApply() {
		LeaveObject.applyLeave();
		Assert.assertTrue(driver.getCurrentUrl().contains("applyLeave"));
		System.out.println("We are in apply Leave page");

	}

	@Test
	void verifyListLeave() {

		Assert.assertTrue(LeaveObject.checkLeaveList());
		System.out.println(" the list is exist with  list of items ");

	}

	@Test(dataProvider = "leavelist")
	void verifylistleaveitems(String Item) {
		LeaveObject.enterLeavePage();
		LeaveObject.applyLeave();
		LeaveObject.leaveTypelistclick();
		Assert.assertTrue(LeaveObject.checkLeaveListItems(Item));

	}

	@Test(dataProvider = "checkdate")

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
	
	@Test (dataProvider = "PartialDays")
	
	void verifyPartialDayslist(String Type) {
	Assert.assertTrue(LeaveObject.PartialDayslist(Type));
	}
	
	@Test (dataProvider = "Duration")
	void verifydurationlist(String Duration) {
		
		LeaveObject.duration( Duration);
		
		
		Assert.assertTrue(LeaveObject.durationlist(Duration), "not from from duration list ");
		
	}
	
	@Test(dataProvider = "COMMENT_LENGTHS")
	void verifycoomentsfield(String input, int expectedLength) {
		
	String Actual	=LeaveObject.addcomments (input);
	Assert.assertEquals(Actual.length(), expectedLength, "expected max length");
	      
		
		 
	}
	
	
	
	
		
		
	}



