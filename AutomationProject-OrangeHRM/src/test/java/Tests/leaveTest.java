package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.baseTest;
import pages.leavePage;

public class leaveTest extends baseTest {
	
	
	leavePage  LeaveObject ;
	
	public void setupObject() {
	LeaveObject = new leavePage (driver);}
	
	
	@Test 
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
		LeaveObject.enterLeavePage();
		LeaveObject.applyLeave();
		LeaveObject.leaveTypelist();
		
		Assert.assertTrue(LeaveObject.checkLeaveList());
		System.out.println(" the list is exist with  list of items ");
		
		
	}
	@Test
	void verifylistleaveitems( String Item ) {
		LeaveObject.enterLeavePage();
		LeaveObject.applyLeave();
		LeaveObject.leaveTypelist();
				Assert.assertTrue(LeaveObject.checkLeaveListItems(Item));
			
	}
	

	void verifyLeavedate(int from, int TO, boolean expected) {
		LeaveObject.fromleveDateSelect(from);
		LeaveObject.toleveDateSelect(TO);
		boolean actual = true;
		Assert.assertEquals(actual,expected);
		
	}

}
