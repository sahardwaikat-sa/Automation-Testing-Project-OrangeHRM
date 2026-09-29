package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.BuzzPage;

public class BuzzTest extends BaseClass {

	 @Test
    public void verifyBuzzPage() {
        BuzzPage buzzPage = new BuzzPage(driver);

        buzzPage.clickBuzz();

        String heading = buzzPage.getBuzzHeading();

        Assert.assertEquals(heading, "Buzz");
    }
    
    @Test
    public void createPost() {
        BuzzPage buzzPage = new BuzzPage(driver);

        buzzPage.clickBuzz();
        buzzPage.createPost("This is my automation test post");

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