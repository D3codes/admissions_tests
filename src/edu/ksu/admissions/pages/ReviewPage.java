package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by davidfreeman on 4/22/16.
 */
public class ReviewPage {
    private WebDriver driver;

    //Set UI Elements
    private By finish = By.cssSelector("input.btn.btn-primary");
    private By alertMessage = By.cssSelector("h3.beginContent");

    public ReviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void finish() {
        driver.findElement(finish).click();
    }

    public String getAlertMessage() {
        return driver.findElement(alertMessage).getText();
    }
}
