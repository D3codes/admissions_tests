package edu.ksu.admissions.pages.shortest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/28/16.
 */
public class DemographicInformationPageShortest {

    private WebDriver driver;
    private WebDriverWait wait;

    private By primaryLanguage = By.id("englishIsPrimarytrue");
    private By otherLanguage = By.id("otherLanguagefalse");
    private By submit = By.id("undergradForm_next");

    public DemographicInformationPageShortest(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hispanicFlagtrue")));
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
