package Tests;



import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.baseTest;
import pages.loginPage;
import pages.pimPage;

public class pimTest extends baseTest {

	pimPage PIMObject;
	loginPage loginObject;

	@DataProvider(name = "USERNAME")
	public Object[][] getdata() {

		return new Object[][] {
			{ "", true }, 
			{ "AHAMD",true},
			{ "ghy", true },
			{"123",true},
			{"@#@**",true}

		};
	}
	
	@DataProvider(name = "USERID")
	public Object[][] getID() {

		return new Object[][] {
			{ "", true}, 
			{ "AHAMD",true},
			{ "ghy",true},
			{"123",true},
			{"@#@**",true},
			{"999999999",true},
			{"-123",true}
			

		};
	}
	
	
	@DataProvider(name = "SubUnit")
	public Object[][] getUnit() {

		return new Object[][] {
		{ "Administration"},
			{ "Engineering"},
			{"Development"},
			{"Quality Assurance"}

		};
	}
		
	
		@DataProvider(name = "EmploymentStatusItems")
		public Object[][] getstatus() {

			return new Object[][] {
				{" Freelance" }, 
				{ "Full-Time Contract"},
				{ "Full-Time Permanent"},
				{"Full-Time Probation"},
				{"Part-Time Contract"}

			};
			
		}
		

		@DataProvider(name = "ADDEMPLOYEEDAAT ")
		public Object[][] getinfo() {

			return new Object[][] {
				{"ssss", "fhhf", "gdgcg", "9001"},
				{"Ahmed", "", "Ali", "9002"},
				{"Sara", "fhhf", "gdgcg", "9003"},
				{"ssss", "44", "gdgcg", "9004"},
				{"ssss", "fhhf", "44", "9005"},
				{"Nour", "fhhf", "Mostafa", "9006"},
				{"ssss", "", "gdgcg", "9007"},
				{"Mohammed", "", "Yousef", "9008"}
			};
				

			
			
		}

		@BeforeMethod
		public void SetupObject() {

			driver.get(Url);
			loginObject = new loginPage(driver);
			PIMObject = new pimPage(driver);

			loginObject.enterUsername("Admin");
			loginObject.enterPassword("admin123");
			loginObject.clickLogin();

			Assert.assertTrue(loginObject.openNextPage(), "Login failed");
			PIMObject.enterPimPage();

		}
		
	//public void SetupObject() {

		// login
		//login("Admin", "admin123");

		//PIMObject = new pimPage(driver);

		// go to PIM
		//PIMObject.enterPimPage();
	//}
//----------------------------------------------------------
	//@Test
	//void verifyEnterPimPage() {

		//PIMObject.enterPimPage();

		//Assert.assertTrue(driver.getCurrentUrl().contains("pim"));
	//}
//-----------------------------------------------------------------
	@Test
	void verifySearchFunctin() {

		PIMObject.restClick();
		PIMObject.searchClick();

		Assert.assertTrue(PIMObject.datafound().contains("Records Found"));
		

	}

	@Test(priority = 1, dataProvider = "USERNAME")
	void verifyEmployeeName(String username, boolean expected) {

		boolean actual=PIMObject.employeeNameValidation(username);
	  
		Assert.assertEquals(actual, expected);
		PIMObject.searchClick();
		String Massege =PIMObject.datafound();
		System.out.println(Massege);
		
	
	}
	
	
	@Test(priority = 2,dataProvider = "USERID")
	void verifyEmployeeID(String id , boolean expected) {
		
		boolean actual=PIMObject.employeeIdVerification(id);
		Assert.assertEquals(actual, expected);
		PIMObject.searchClick();
		String Massege =PIMObject.datafound();
		System.out.println(Massege);
		
	}
	
	
	@Test(priority = 3, dataProvider = "USERNAME")
	
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

	@Test(dataProvider = "SubUnit")
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

@Test(dataProvider = "EmploymentStatusItems")
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

@Test(dataProvider ="ADDEMPLOYEEDAAT ")
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



