package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 5/9/16.
 */
public class ScholarshipPageLongest {

    private WebDriver driver;
    private WebDriverWait wait;

    private By skip = By.id("skip");

    public ScholarshipPageLongest(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.presenceOfElementLocated(skip));
    }

    public void skip(){ driver.findElement(skip).click(); }
}
