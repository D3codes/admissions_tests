package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/28/16.
 */
public class ScholarshipPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By ssn = By.id("nationalId");
    private By submit = By.id("undergradForm_next");
    private By skip = By.id("skip");

    public ScholarshipPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoad(boolean isShortest){

        if(isShortest)
            wait.until(ExpectedConditions.presenceOfElementLocated(ssn));
        else
            wait.until(ExpectedConditions.presenceOfElementLocated(skip));
    }

    public void setSSN(String num){
        driver.findElement(ssn).clear();
        driver.findElement(ssn).sendKeys(num);
    }

    public void skip() { driver.findElement(skip).click(); }

    public void submit(){
        driver.findElement(submit).click();
    }
}
