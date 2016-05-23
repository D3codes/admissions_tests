package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/28/16.
 */
public class DemographicInformationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By englishPrimarytrue = By.id("englishIsPrimarytrue");
    private By otherLanguagefalse = By.id("otherLanguagefalse");
    private By everExpelled = By.id("nonAcademicExpulsionfalse");
    private By parentsDegree = By.id("ksuFirstGentrue");
    private By military = By.id("militaryActivetrue");
    private By militaryMonthStart = By.id("undergradForm_data_militaryFromMonth");
    private By militaryYearStart = By.id("undergradForm_data_militaryFromYear");
    private By militaryMonthEnd = By.id("undergradForm_data_militaryToMonth");
    private By militaryYearEnd = By.id("undergradForm_data_militaryToYear");
    private By felonyCharges = By.id("pendingFelonyChargesfalse");
    private By guiltyPlea = By.id("felonyConvictionfalse");
    private By registeredName = By.id("requireRegisterWithPolicefalse");
    private By submit = By.id("undergradForm_next");

    public DemographicInformationPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hispanicFlagtrue")));
    }

    public void setEnglishPrimarytrue(){
        driver.findElement(englishPrimarytrue).click();
    }

    public void setOtherLanguagefalse(){
        driver.findElement(otherLanguagefalse).click();
    }

    public void setParentsDegree() { driver.findElement(parentsDegree).click(); }

    public void setMilitary() { driver.findElement(military).click(); }

    public void waitForMilitaryMonthStart() { wait.until(ExpectedConditions.visibilityOfElementLocated(militaryMonthStart)); }

    public void setMilitaryStart(String month, String year){
        driver.findElement(militaryMonthStart).click();
        new Select(driver.findElement(militaryMonthStart)).selectByVisibleText(month);
        driver.findElement(militaryYearStart).click();
        new Select(driver.findElement(militaryYearStart)).selectByVisibleText(year);
    }

    public void setMilitaryEnd(String month, String year){
        driver.findElement(militaryMonthEnd).click();
        new Select(driver.findElement(militaryMonthEnd)).selectByVisibleText(month);
        driver.findElement(militaryYearEnd).click();
        new Select(driver.findElement(militaryYearEnd)).selectByVisibleText(year);
    }

    public void waitForConductInformation(){ wait.until(ExpectedConditions.presenceOfElementLocated(everExpelled)); }

    public void setEverExpelled() { driver.findElement(everExpelled).click(); }

    public void setFelonyCharges() { driver.findElement(felonyCharges).click(); }

    public void setGuiltyPlea() { driver.findElement(guiltyPlea).click(); }

    public void setRegisteredName() { driver.findElement(registeredName).click(); }

    public void submit(){
        driver.findElement(submit).click();
    }
}
