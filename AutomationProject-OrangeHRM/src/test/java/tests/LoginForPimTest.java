package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.baseTest;
import pages.loginPage;
import pages.pimPage;

public class LoginForPimTest extends baseTest {

    loginPage loginObject;
    pimPage PIMObject;

    @BeforeMethod
    public void setupObject() {
        driver.get(Url);
        loginObject = new loginPage(driver);
        
        PIMObject= new pimPage(driver);
       
        
    }

    @Test
    public void loginForPim() {
        loginObject.enterUsername("Admin");
        loginObject.enterPassword("admin123");
        loginObject.clickLogin();

        Assert.assertTrue(loginObject.openNextPage(), "Login failed");
        System.out.println("LOGIN SUCCESSFUL - READY FOR PIM");
        PIMObject.enterPimPage();
        
        
        
    }
}