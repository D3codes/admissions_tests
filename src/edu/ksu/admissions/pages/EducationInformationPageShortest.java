package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by davidfreeman on 4/28/16.
 */
public class EducationInformationPageShortest {

    private WebDriver driver;

    private By highSchoolCountry = By.id("highSchoolCountry");
    private By schoolType = By.id("highSchoolTypeGED");
    private By plannedGraduationMonth = By.id("highSchoolGradMonth");
    private By plannedGraduationYear = By.id("hihgSchoolGradYear");
    private By previouslyAttendedKSU = By.id("undergradForm_data_academicInfo_readmitfalse");
    private By previouslyTakenClasses = By.id("undergradForm_data_academicInfo_takenCollegefalse");
    private By completeDegree = By.id("undergradForm_data_academicInfo_planCompleteDegreetrue");
    private By completeDegreeAtKSU = By.id("undergradForm_data_academicInfo_planCompleteKStateDegreetrue");
    private By ksuLocation = By.id("campusMAN");
    private By major = By.id("majors");
    private By submit = By.id("undergradForm_next");

    public EducationInformationPageShortest(WebDriver driver){
        this.driver = driver;
    }

    public void setHighSchoolCountry(String country){
        driver.findElement(highSchoolCountry).click();
        new Select(driver.findElement(highSchoolCountry)).selectByVisibleText(country);
    }

    public void setSchoolType(){
        driver.findElement(schoolType).click();
    }

    public void setPlannedGraduationMonth(){
        driver.findElement(plannedGraduationMonth).click();
        new Select(driver.findElement(plannedGraduationMonth)).selectByVisibleText("May");
    }

    public void setPlannedGraduationYear(){
        driver.findElement(plannedGraduationYear).click();
        new Select(driver.findElement(plannedGraduationYear)).selectByVisibleText("2017");
    }

    public void setPreviouslyAttendedKSU(){
        driver.findElement(previouslyAttendedKSU).click();
    }

    public void setPreviouslyTakenClasses(){
        driver.findElement(previouslyTakenClasses).click();
    }

    public void setCompleteDegree(){
        driver.findElement(completeDegree).click();
    }

    public void setCompleteDegreeAtKSU(){
        driver.findElement(completeDegreeAtKSU).click();
    }

    public void setKsuLocation(){
        driver.findElement(ksuLocation).click();
    }

    public void setMajor(String major){
        driver.findElement(this.major).click();
        new Select(driver.findElement(this.major)).selectByVisibleText(major);
    }

    public void submit(){
        driver.findElement(submit).click();
    }
}