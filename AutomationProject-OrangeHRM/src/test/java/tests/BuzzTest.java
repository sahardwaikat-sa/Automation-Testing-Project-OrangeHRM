package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.BuzzPage;

public class BuzzTest extends BaseClass {

	
	
	@DataProvider(name = "post")
	public Object[][] getdata() {

		return new Object[][] { 
			{ "This is my automation test post" },{ "2343525" },{},{"&*%%%%%%%"},
			{"\r\n"
					+ "Does OrangeHRM offer a free version?\r\n"
					+ "Yes! The OrangeHRM Starter is our free, open-source version designed for small businesses looking to automate HR tasks like employee management, leave tracking, and reporting.\r\n"
					+ "Is there a free trial?\r\n"
					+ "What is the difference between the OrangeHRM Starter and Advanced?\r\n"
					+ "Is OrangeHRM cloud-based or on-premise?\r\n"
					+ "How is OrangeHRM priced?\r\n"
					+ "What systems does OrangeHRM integrate with?\r\n"
					+ "Can I upgrade from the free version to Advanced?\r\n"
					+ "How do I get started with OrangeHRM?\r\n"
					+ "How long does it take to implement OrangeHRM?\r\n"
					+ "How does OrangeHRM protect my employee data?\r\n"
					+ "Is OrangeHRM GDPR compliant?\r\n"
					+ "Does OrangeHRM have a mobile app?\r\n"
					+ "Does OrangeHRM support AI features?\r\n"
					+ "Is OrangeHRM suitable for small businesses?\r\n"
					+ "Can OrangeHRM be customized for my industry?\r\n"
					+ "Does OrangeHRM support multi-location or global teams?\r\n"
					+ "What kind of customer support does OrangeHRM provide?\r\n"
					+ "How do I contact OrangeHRM support for technical or general inquiries?"}

		};
	}	
	
	

	
	
	 @Test
    public void verifyBuzzPage() {
        BuzzPage buzzPage = new BuzzPage(driver);

        buzzPage.clickBuzz();

        String heading = buzzPage.getBuzzHeading();

        Assert.assertEquals(heading, "Buzz");
    }
    
    @Test(dataProvider="post")
    public void createPost(String text) {
        BuzzPage buzzPage = new BuzzPage(driver);

        buzzPage.clickBuzz();
        buzzPage.createPost(text);

        Assert.assertTrue(driver.getPageSource().contains("This is my automation test post"));
    }
    
    
    @Test
    public void likePost() {
        BuzzPage buzzPage = new BuzzPage(driver);

        buzzPage.clickBuzz();
        buzzPage.likePost();
        
    }
    
    @Test
    public void addComment() {
        BuzzPage buzzPage = new BuzzPage(driver);

        buzzPage.clickBuzz();
        buzzPage.addComment("Great post!");
        Assert.assertTrue(buzzPage.isCommentDisplayed());

    }
    
    
    
    
    
    
    
    
}