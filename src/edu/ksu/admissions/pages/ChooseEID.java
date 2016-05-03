package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/22/16.
 */
public class ChooseEID {
    private WebDriver driver;

    //Create UI Elements
    private By customEID = By.id("eid_**custom**");
    private By eID = By.id("customEid");
    private By submit = By.id("submit_button");

    public ChooseEID(WebDriver driver){
        this.driver = driver;
    }

    public void waitForPageLoad(WebDriverWait wait){
        wait.until(ExpectedConditions.presenceOfElementLocated(customEID));
    }

    public void selectCustomEID(){
        driver.findElement(customEID).click();
    }

    public void clearCustomEID(){
        driver.findElement(eID).clear();
    }

    public void setCustomEID(String id){
        clearCustomEID();
        driver.findElement(eID).sendKeys(id);
    }

    public void submit(){
        driver.findElement(submit).click();
    }
}
