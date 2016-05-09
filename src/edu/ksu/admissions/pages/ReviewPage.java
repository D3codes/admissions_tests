package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/22/16.
 */
public class ReviewPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Set UI Elements
    private By finish = By.cssSelector("input.btn.btn-primary");
    private By alertMessage = By.cssSelector("h3.beginContent");

    public ReviewPage(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.presenceOfElementLocated(finish));
    }

    public void finish() {
        driver.findElement(finish).click();
    }

    public String getAlertMessage() {
        return driver.findElement(alertMessage).getText();
    }
}
