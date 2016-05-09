package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 5/9/16.
 */
public class EducationInformationPageLongest {

    private WebDriver driver;
    private WebDriverWait wait;

    private By highSchoolCountry = By.id("highSchoolCountry");
    private By highSchool = By.id("highSchoolName");
    private By plannedGraduationMonth = By.id("highSchoolGradMonth");
    private By plannedGraduationYear = By.id("highSchoolGradYear");
    private By previouslyAttendedKSU = By.id("undergradForm_data_academicInfo_readmittrue");
    private By previouslyTakenClasses = By.id("undergradForm_data_academicInfo_takenCollegetrue");
    private By collegeCountry = By.id("collegeCountry_0");
    private By collegeName = By.id("collegeName_0");
    private By creditHours = By.id("creditHours_0");
    private By attendanceMonthStart = By.id("undergradForm_data_previousColleges_0__fromMonth");
    private By attendanceYearStart = By.id("undergradForm_data_previousColleges_0__fromYear");
    private By attendanceMonthEnd = By.id("undergradForm_data_previousColleges_0__toMonth");
    private By attendanceYearEnd = By.id("undergradForm_data_previousColleges_0__toYear");
    private By officialTranscript = By.id("requiredCheckbox");
    private By completeDegree = By.id("undergradForm_data_academicInfo_planCompleteDegreefalse");
    private By minor = By.id("undergradForm_data_academicInfo_postDegreeMinortrue");
    private By baccalaureate = By.id("undergradForm_data_academicInfo_completedDegreeFirsttrue");
    private By ksuLocation = By.id("campusDL");
    private By major = By.id("minors");
    private By submit = By.id("undergradForm_next");

    public EducationInformationPageLongest(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.presenceOfElementLocated(highSchoolCountry));
    }

    public void setHighSchoolCountry(String country){
        driver.findElement(highSchoolCountry).click();
        new Select(driver.findElement(highSchoolCountry)).selectByVisibleText(country);
    }

    public void waitForHighSchool(){ wait.until(ExpectedConditions.visibilityOfElementLocated(highSchool)); }

    public void setHighSchool(String hs){
        driver.findElement(highSchool).clear();
        driver.findElement(highSchool).sendKeys(hs);
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

    public void waitForCollegeCountry() { wait.until(ExpectedConditions.presenceOfElementLocated(collegeCountry)); }

    public void setCollegeCountry(String country){
        driver.findElement(collegeCountry).click();
        new Select(driver.findElement(collegeCountry)).selectByVisibleText(country);
    }

    public void waitForCollegeName() { wait.until(ExpectedConditions.visibilityOfElementLocated(collegeName)); }

    public void setCollegeName(String college){
        driver.findElement(collegeName).clear();
        driver.findElement(collegeName).sendKeys(college);
    }

    public void setCreditHours(String hours){
        driver.findElement(creditHours).clear();
        driver.findElement(creditHours).sendKeys(hours);
    }

    public void setAttendanceMonthStart(String month){
        driver.findElement(attendanceMonthStart).click();
        new Select(driver.findElement(attendanceMonthStart)).selectByVisibleText(month);
    }

    public void setAttendanceYearStart(String year){
        driver.findElement(attendanceYearStart).click();
        new Select(driver.findElement(attendanceYearStart)).selectByVisibleText(year);
    }

    public void setAttendanceMontEnd(String month){
        driver.findElement(attendanceMonthEnd).click();
        new Select(driver.findElement(attendanceMonthEnd)).selectByVisibleText(month);
    }

    public void setAttendanceYearEnd(String year){
        driver.findElement(attendanceYearEnd).click();
        new Select(driver.findElement(attendanceYearEnd)).selectByVisibleText(year);
    }

    public void setOfficialTranscript(){
        driver.findElement(officialTranscript).click();
    }

    public void waitForCompleteDegree(){ wait.until(ExpectedConditions.visibilityOfElementLocated(completeDegree)); }

    public void setCompleteDegree(){
        driver.findElement(completeDegree).click();
    }

    public void waitForMinor() { wait.until(ExpectedConditions.visibilityOfElementLocated(minor)); }

    public void setMinor(){
        driver.findElement(minor).click();
    }

    public void waitForBaccalaureate() { wait.until(ExpectedConditions.visibilityOfElementLocated(baccalaureate)); }

    public void setBaccalaureate(){
        driver.findElement(baccalaureate).click();
    }

    public void setKsuLocation(){
        driver.findElement(ksuLocation).click();
    }

    public void setMajor(){
        driver.findElement(major).click();
        new Select(driver.findElement(major)).selectByIndex(5);
    }

    public void submit(){
        driver.findElement(submit).click();
    }
}
