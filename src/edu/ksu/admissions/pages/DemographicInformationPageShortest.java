package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by davidfreeman on 4/28/16.
 */
public class DemographicInformationPageShortest {

    private WebDriver driver;

    private By primaryLanguage = By.id("englishIsPrimary");
    private By otherLanguage = By.id("otherLanguagefalse");
    private By submit = By.id("undergradForm_next");

    public DemographicInformationPageShortest(WebDriver driver){
        this.driver = driver;
    }

    public void setPrimaryLanguage(){
        driver.findElement(primaryLanguage).click();
    }

    public void setOtherLanguage(){
        driver.findElement(otherLanguage).click();
    }

    public void submit(){
        driver.findElement(submit).click();
    }
}