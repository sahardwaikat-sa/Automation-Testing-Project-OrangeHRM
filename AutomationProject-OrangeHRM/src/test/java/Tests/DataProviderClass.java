package Tests;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	
	@DataProvider(name = "USERNAME")
	public Object[][] getdata3() {

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
	            { "Full-Time Contract"},
				{ "Full-Time Permanent"},
				{"Full-Time Probation"}
				};
					}
		
		@DataProvider(name = "AddEmployeeData")
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
	
		@DataProvider(name = "leavelist")
		public Object[][] getdata1() {

			return new Object[][] { 
				{ "Casual" }

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
				{"Start Day Only "},
				{"End Day Only"},
				{"Start and End Day"},

			};
		}
		
		@DataProvider(name = "Duration")
		public Object[][] getdu() {

			return new Object[][] { 
				{"Half Day - Morning"},
				{"Half Day - Afternoon"},
				{"Specify Time"},

			};
		}
		
	    @DataProvider(name = "LOGINDATA")
	    public Object[][] getdata44() {
	        return new Object[][] {
	                { "Admin", "admin123", "true" },
	                { "admin1", "pass123", "false" },
	                { "admin", "123", "false" },
	                { "", "pass123", "empty" },
	                { "admin", "", "empty" },
	                { "", "", "empty" },
	                { "admin", "-123", "false" },
	                { "Admin", "%&*#@", "false" }
	        };
	    }
	}
	






