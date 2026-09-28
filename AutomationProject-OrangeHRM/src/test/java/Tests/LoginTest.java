package Tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.baseTest;
import org.testng.Assert;
import org.testng.Reporter;

import listener.listener;
import pages.loginPage;




@Listeners(listener.class)
public class LoginTest extends baseTest {

    loginPage loginObject;

    @BeforeMethod
    public void setupObject() {
        driver.get(Url);
        loginObject = new loginPage(driver);
    }

    @Test(dataProvider = "LOGINDATA")
    public void verifyLogin(String username, String password, String expected) {
    	 Reporter.log("start login and validation Credentials");
        loginObject.enterUsername(username);
        loginObject.enterPassword(password);
        loginObject.clickLogin();
        Reporter.log("enter dashboard page ");
        if (expected.equals("true")) {
            Assert.assertTrue(loginObject.openNextPage()); 
            System.out.println(" we are in next page");}
                 
        else if (expected.equals("false")) {
            Assert.assertTrue(loginObject.isLoginErrorDisplayed());
            Assert.assertTrue(loginObject.getLoginMessage().contains("Invalid"));
            System.out.println(" we can not login");}
                    
        else {
        	
        	System.out.println("fields is required");
        } 
    }

    @DataProvider(name = "LOGINDATA")
    public Object[][] getdata() {
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