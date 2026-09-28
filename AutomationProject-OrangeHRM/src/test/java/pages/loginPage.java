package pages;

import java.time.Duration;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {

    WebDriver driver;
    WebDriverWait wait;

    By Username = By.name("username");
    By Password = By.name("password");
    By loginButton = By.xpath("//button[@type='submit']");
    By LoginMessage = By.xpath(
            "//p[contains(concat(' ', normalize-space(@class), ' '), ' oxd-alert-content-text ')]");

    public loginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void enterUsername(String username) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(Username));
        field.clear();
        field.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
        field.clear();
        field.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean openNextPage() {
        try {
            wait.until(ExpectedConditions.urlContains("dashboard"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginErrorDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getLoginMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginMessage)).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}