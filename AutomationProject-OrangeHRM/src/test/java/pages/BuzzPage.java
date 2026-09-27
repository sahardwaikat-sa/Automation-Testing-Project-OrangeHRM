package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BuzzPage {

    WebDriver driver;

    public BuzzPage(WebDriver driver) {
        this.driver = driver;
    }

    By buzzLink = By.xpath("//span[normalize-space()='Buzz']");
    By buzzHeading = By.xpath("//h6[normalize-space()='Buzz']");
    By postTextBox = By.xpath("//textarea[@placeholder=\"What's on your mind?\"]");
    By postButton = By.xpath("//button[normalize-space()='Post']");
    By likeButton = By.xpath(
    	    "//*[@id=\"heart\"][1]"
    	);
    By commentResult = By.xpath(
    	    "//span[normalize-space()='Great post!']");
    By commentButton = By.xpath("//i[@class=\"oxd-icon bi-chat-text-fill\"][1]");

    By commentBox = By.xpath(
        "//input[@placeholder='Write your comment...']" );

    By commentPostButton = By.xpath(
        "//button[normalize-space()='Post Comment']");
    
    public void clickBuzz() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buzzLink)).click();
    }

    public String getBuzzHeading() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(buzzHeading)
        ).getText();
    }
    
    
    public void createPost(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(postTextBox))
            .sendKeys(message);

        wait.until(ExpectedConditions.elementToBeClickable(postButton)).click();
    }
    
    
     public void likePost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(likeButton)).click();
    }
     
     public void addComment(String comment) {
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	    wait.until(
    	        ExpectedConditions.elementToBeClickable(commentButton)
    	    ).click();

    	 WebElement box=   wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(commentBox)
    	    );
box.sendKeys(comment)
;
box.sendKeys(Keys.ENTER);
    	   
    	}
     
     public boolean isCommentDisplayed() {
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	    return wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(commentResult)
    	    ).isDisplayed();
    	}
     
     
     
     
     
     
}