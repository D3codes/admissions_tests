package edu.ksu.admissions.pages.shortest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/28/16.
 */
public class ScholarshipPageShortest {

    private WebDriver driver;
    private WebDriverWait wait;

    private By ssn = By.id("nationalId");
    private By submit = By.id("undergradForm_next");

    public ScholarshipPageShortest(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoad(){
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
