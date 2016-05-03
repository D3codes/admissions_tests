package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/28/16.
 */
public class ScholarshipPageShortest {

    private WebDriver driver;

    private By ssn = By.id("nationalId");
    private By submit = By.id("undergradForm_next");

    public ScholarshipPageShortest(WebDriver driver){
        this.driver = driver;
    }

    public void waitForPageLoad(WebDriverWait wait){
        wait.until(ExpectedConditions.presenceOfElementLocated(ssn));
    }

    public void setSSN(String num){
        driver.findElement(ssn).clear();
        driver.findElement(ssn).sendKeys(num);
    }

    public void submit(){
        driver.findElement(submit).click();
    }
}
