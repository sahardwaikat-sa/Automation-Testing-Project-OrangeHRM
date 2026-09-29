package Tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.baseTest;
import listener.listener;
import pages.loginPage;
import pages.pimPage;

@Listeners(listener.class)
public class  PimTest extends baseTest {

	pimPage PIMObject;
	loginPage loginObject;



		@BeforeMethod
		public void SetupObject() {

			driver.get(Url);
			loginObject = new loginPage(driver);
			PIMObject = new pimPage(driver);

			
			loginObject.login("Admin", "admin123");
			//loginObject.enterUsername("Admin");
			//loginObject.enterPassword("admin123");
			//loginObject.clickLogin();

			Assert.assertTrue(loginObject.openNextPage(), "Login failed");
			PIMObject.enterPimPage();

		}
		

	@Test
	void verifySearchFunctin() {

		PIMObject.restClick();
		PIMObject.searchClick();

		Assert.assertTrue(PIMObject.datafound().contains("Records Found"));
		

	}

	@Test(priority = 1, dataProvider = "USERNAME",dataProviderClass = DataProvider.class)
	void verifyEmployeeName(String username, boolean expected) {

		boolean actual=PIMObject.employeeNameValidation(username);
	  
		Assert.assertEquals(actual, expected);
		PIMObject.searchClick();
		String Massege =PIMObject.datafound();
		System.out.println(Massege);
		
	
	}
	
	
	@Test(priority = 2,dataProvider = "USERID",dataProviderClass = DataProvider.class)
	void verifyEmployeeID(String id , boolean expected) {
		
		boolean actual=PIMObject.employeeIdVerification(id);
		Assert.assertEquals(actual, expected);
		PIMObject.searchClick();
		String Massege =PIMObject.datafound();
		System.out.println(Massege);
		
	}
	
	
	@Test(priority = 3, dataProvider = "USERNAME",dataProviderClass = DataProvider.class)
	
     void verifySupervisorName(String name , boolean expected) {
		
		boolean actual=PIMObject.supervisorNameValidation(name);
        Assert.assertEquals(actual, expected);
			PIMObject.searchClick();
			String Massege =PIMObject.datafound();
			System.out.println(Massege);
	}
	
	
	@Test
	void verifyFieldDefaltValue() {
		
		PIMObject.restClick();
		Assert.assertTrue(PIMObject.defaltEmployeeIdValue());
		Assert.assertTrue(PIMObject.defaltEmployeeValue());
		Assert.assertTrue(PIMObject.defaltSupervisorNamedValue());
		Assert.assertTrue(PIMObject.defaltEmploymentStatusValue().contains("-- Select --"));
		Assert.assertTrue(PIMObject.defaltJobTitlesValue().contains("-- Select --"));
		Assert.assertTrue(PIMObject.defaltSubUnitValue().contains("-- Select --"));
		Assert.assertTrue(PIMObject.defaltIncludeValue().contains("Current Employees Only"));

	}

	@Test
	void verifyCheckBoxAll() {

		PIMObject.checkBoxAll();

		Assert.assertTrue(PIMObject.diplaydeleteAll());
	}

	@Test
	void verifyfirstCheckBoxl() {

		PIMObject.firstCheckBox();

		Assert.assertTrue(PIMObject.diplaydeleteAll());
	}

	@Test
	void verifyEditButton() {
		PIMObject.clickEditButton();
		Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"));

	}


	@Test
	void verifySubUnitList() {
		
		PIMObject.subUnitVerification();
		Assert.assertTrue(PIMObject.getsubUnitList());

	}

	@Test(dataProvider = "SubUnit",dataProviderClass = DataProvider.class)
	void verifySubUnitItems(String Unit) {

		PIMObject.subUnitVerification();
		Assert.assertTrue(PIMObject.getOneitemsubUnitList(Unit));

	}


//------------------------------------------------
@Test
void verifyEmploymentStatus() {
	
	PIMObject.employmentStatuslistVerification();
	Assert.assertTrue(PIMObject.getEmpoyeeStatusList());

}

@Test(dataProvider = "EmploymentStatusItems",dataProviderClass = DataProvider.class)
void verifyEmploymentStatusItems(String Unit) {

	PIMObject.employmentStatuslistVerification();
	Assert.assertTrue(PIMObject.getOneitemEmpoyeeStatusList(Unit));
	
}
//--------------------------------------

@Test 

void verifyEditButtons(){
	
	PIMObject.clickEditButton();
	Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"));
	System.out.println("Now we are inviewPersonalDetails page for editing ingormation ");
	
}
@Test
void verifyaddEmployee() {
	
	PIMObject.addButton(); 
	driver.getCurrentUrl().contains("addEmployee");
	System.out.println("we are in Add employee page ");
	
}

@Test(dataProvider ="AddEmployeeData",dataProviderClass = DataProvider.class)
void verifyAddEmployeeData( String First , String Midle, String Last, String id) {
	PIMObject.addButton();
	PIMObject.addEmployeeFirstname(First);
	PIMObject.addEmployeeMidletname(Midle);
	PIMObject.addEmployeeLasttname(Last);
	PIMObject.addEmployeeID(id);
	
	PIMObject.saveButton();
	Assert.assertTrue(driver.getCurrentUrl().contains("empNumber"));
	
	
}


@Test
void verifyDeletButton() {

	PIMObject.clickDeleteButton();
	Assert.assertFalse(PIMObject.firstRecord());
}
}



