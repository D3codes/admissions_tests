package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/27/16.
 */
public class PersonalInformationPageShortest {

    private WebDriver driver;
    private WebDriverWait wait;

    private By term = By.id("undergradForm_data_application_term2165");
    private By dataForOther = By.id("undergradForm_data_forOthertrue");
    private By relationship = By.id("undergradForm_data_roleStringCounselor");
    private By gender = By.id("genderM");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By additionalNames = By.id("undergradForm_data_additionalNamesfalse");
    private By birthMonth = By.id("birthMonth");
    private By birthDay = By.id("birthDay");
    private By birthYear = By.id("birthYear");
    private By birthCountry = By.id("birthCountry");
    private By birthPlace = By.id("birthPlace");
    private By phoneNumber = By.id("phone1");
    private By emailAddress = By.id("email");
    private By confirmEmail = By.id("emailConfirm");
    private By usCitizen = By.id("usCitizentrue");
    private By ksResident = By.id("ksResidenttrue");
    private By inKsSinceBirth = By.id("inKsSinceBirthFlagtrue");
    private By parentsKsResident = By.id("ksParentsResidentfalse");
    private By submit = By.id("undergradForm_next");

    public PersonalInformationPageShortest(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.presenceOfElementLocated(term));
    }

    public void setTerm(){
        driver.findElement(term).click();
    }

    public void waitForRelationship(){ wait.until(ExpectedConditions.visibilityOf( driver.findElement(relationship)));}

    public void setDataForOther(){
        driver.findElement(dataForOther).click();
    }

    public void setRelationship(){
        driver.findElement(relationship).click();
    }

    public void setGender(){
        driver.findElement(gender).click();
    }

    public void clearFirstName(){
        driver.findElement(firstName).clear();
    }

    public void setFirstName(String name){
        clearFirstName();
        driver.findElement(firstName).sendKeys(name);
    }

    public void clearLastName(){
        driver.findElement(lastName).clear();
    }

    public void setLastName(String name){
        clearLastName();
        driver.findElement(lastName).sendKeys(name);
    }

    public void setAdditionalNames(){
        driver.findElement(additionalNames).click();
    }

    public void setBirthDate(String month, String day, String year){
        driver.findElement(birthDay).click();
        new Select(driver.findElement(birthDay)).selectByVisibleText(day);
        driver.findElement(birthMonth).click();
        new Select(driver.findElement(birthMonth)).selectByVisibleText(month);
        driver.findElement(birthYear).click();
        new Select(driver.findElement(birthYear)).selectByVisibleText(year);
    }

    public void setBirthCountry(String country){
        driver.findElement(birthCountry).click();
        new Select(driver.findElement(birthCountry)).selectByVisibleText(country);
    }

    public void setBirthPlace(String location){
        driver.findElement(birthPlace).clear();
        driver.findElement(birthPlace).sendKeys(location);
    }

    public void setPhoneNumber(String number){
        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber).sendKeys(number);
    }

    public void setEmailAddress(String email){
        driver.findElement(emailAddress).clear();
        driver.findElement(emailAddress).sendKeys(email);
    }

    public void setConfirmEmail(String email){
        driver.findElement(confirmEmail).clear();
        driver.findElement(confirmEmail).sendKeys(email);
    }

    public void setUsCitizen(){
        driver.findElement(usCitizen).click();
    }

    public void waitForKsResident() { wait.until(ExpectedConditions.visibilityOf(driver.findElement(ksResident))); }

    public void setKsResident(){
        driver.findElement(ksResident).click();
    }

    public void waitForInKsSinceBirth(){ wait.until(ExpectedConditions.visibilityOf(driver.findElement(inKsSinceBirth))); }

    public void setInKsSinceBirth(){
        driver.findElement(inKsSinceBirth).click();
    }

    public void setParentsKsResident(){
        driver.findElement(parentsKsResident).click();
    }

    public void submit(){
        driver.findElement(submit).click();
    }
}
