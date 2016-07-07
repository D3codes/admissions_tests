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

    //Set UI Elements
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
      wait.until(ExpectedConditions.presenceOfElementLocated(englishPrimarytrue));
      wait.until(ExpectedConditions.visibilityOfElementLocated(englishPrimarytrue));
      driver.findElement(englishPrimarytrue).click();
    }

    public void setOtherLanguagefalse(){
      wait.until(ExpectedConditions.presenceOfElementLocated(otherLanguagefalse));
      wait.until(ExpectedConditions.visibilityOfElementLocated(otherLanguagefalse));
      driver.findElement(otherLanguagefalse).click();
    }

    public void setParentsDegree() {
      wait.until(ExpectedConditions.presenceOfElementLocated(parentsDegree));
      wait.until(ExpectedConditions.visibilityOfElementLocated(parentsDegree));
      driver.findElement(parentsDegree).click();
    }

    public void setMilitary() {
      wait.until(ExpectedConditions.presenceOfElementLocated(military));
      wait.until(ExpectedConditions.visibilityOfElementLocated(military));
      driver.findElement(military).click();
    }

    public void setMilitaryStart(String month, String year){
      wait.until(ExpectedConditions.presenceOfElementLocated(militaryMonthStart));
      wait.until(ExpectedConditions.visibilityOfElementLocated(militaryMonthStart));
      new Select(driver.findElement(militaryMonthStart)).selectByVisibleText(month);
      wait.until(ExpectedConditions.presenceOfElementLocated(militaryYearStart));
      wait.until(ExpectedConditions.visibilityOfElementLocated(militaryYearStart));
      new Select(driver.findElement(militaryYearStart)).selectByVisibleText(year);
    }

    public void setMilitaryEnd(String month, String year){
      wait.until(ExpectedConditions.presenceOfElementLocated(militaryMonthEnd));
      wait.until(ExpectedConditions.visibilityOfElementLocated(militaryMonthEnd));
      new Select(driver.findElement(militaryMonthEnd)).selectByVisibleText(month);
      wait.until(ExpectedConditions.presenceOfElementLocated(militaryYearEnd));
      wait.until(ExpectedConditions.visibilityOfElementLocated(militaryYearEnd));
      new Select(driver.findElement(militaryYearEnd)).selectByVisibleText(year);
    }

    public void waitForConductInformation(){ wait.until(ExpectedConditions.presenceOfElementLocated(everExpelled)); }

    public void setEverExpelled() {
      wait.until(ExpectedConditions.presenceOfElementLocated(everExpelled));
      wait.until(ExpectedConditions.visibilityOfElementLocated(everExpelled));
      driver.findElement(everExpelled).click();
    }

    public void setFelonyCharges() {
      wait.until(ExpectedConditions.presenceOfElementLocated(felonyCharges));
      wait.until(ExpectedConditions.visibilityOfElementLocated(felonyCharges));
      driver.findElement(felonyCharges).click();
    }

    public void setGuiltyPlea() {
      wait.until(ExpectedConditions.presenceOfElementLocated(guiltyPlea));
      wait.until(ExpectedConditions.visibilityOfElementLocated(guiltyPlea));
      driver.findElement(guiltyPlea).click();
    }

    public void setRegisteredName() {
      wait.until(ExpectedConditions.presenceOfElementLocated(registeredName));
      wait.until(ExpectedConditions.visibilityOfElementLocated(registeredName));
      driver.findElement(registeredName).click();
    }

    public void submit(){
      wait.until(ExpectedConditions.presenceOfElementLocated(submit));
      wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
      driver.findElement(submit).click();
    }
}
