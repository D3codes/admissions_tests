package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 5/6/16.
 */
public class PersonalInformationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By term = By.id("undergradForm_data_application_term2165");
    private By dataForOther = By.id("undergradForm_data_forOthertrue");
    private By relationshipFamily = By.id("undergradForm_data_roleStringFamily");
    private By relationshipCounselor = By.id("undergradForm_data_roleStringCounselor");
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
    private By usCitizentrue = By.id("usCitizentrue");
    private By usCitizenfalse = By.id("usCitizenfalse");
    private By ksResident = By.id("ksResidenttrue");
    private By inKsSinceBirth = By.id("inKsSinceBirthFlagtrue");
    private By parentsKsResident = By.id("ksParentsResidentfalse");
    private By permanentResident = By.id("usPermanentResidentfalse");
    private By internationalStudent = By.id("internationalStudenttrue");
    private By countryOfCitizenship = By.id("citizenCountry");
    private By currentVisa = By.id("currentVisatrue");
    private By visaType = By.id("currentVisaType");
    private By requestingVisa = By.id("admitVisaType");
    private By submit = By.id("undergradForm_next");

    public PersonalInformationPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.presenceOfElementLocated(term));
    }

    public void setTerm(){
        driver.findElement(term).click();
    }

    public void waitForRelationship(){ wait.until(ExpectedConditions.visibilityOf( driver.findElement(relationshipFamily)));}

    public void setDataForOther(){
        driver.findElement(dataForOther).click();
    }

    public void setRelationshipFamily(){
        driver.findElement(relationshipFamily).click();
    }

    public void setRelationshipCounselor() { driver.findElement(relationshipCounselor).click(); }

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

    public void setUsCitizentrue() { driver.findElement(usCitizentrue).click(); }

    public void setUsCitizenfalse(){
        driver.findElement(usCitizenfalse).click();
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

    public void waitForPermanentResident() { wait.until(ExpectedConditions.visibilityOfElementLocated(permanentResident)); }

    public void setPermanentResident(){
       driver.findElement(permanentResident).click();
    }

    public void waitForInternationalStudent() { wait.until(ExpectedConditions.visibilityOfElementLocated(internationalStudent)); }

    public void setInternationalStudent(){
        driver.findElement(internationalStudent).click();
    }

    public void waitForCountryOfCitizenship() { wait.until(ExpectedConditions.visibilityOfElementLocated(countryOfCitizenship)); }

    public void setCountryOfCitizenship(String country){
        driver.findElement(countryOfCitizenship).click();
        new Select(driver.findElement(countryOfCitizenship)).selectByVisibleText(country);
    }

    public void setCurrentVisa(){
        driver.findElement(currentVisa).click();
    }

    public void waitForVisaType(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(visaType));
    }

    public void setVisaType(){
        driver.findElement(visaType).click();
        new Select(driver.findElement(visaType)).selectByVisibleText("Student (F1)");
    }

    public void setRequestingVisa(){

        driver.findElement(requestingVisa).click();
        new Select(driver.findElement(requestingVisa)).selectByVisibleText("Not Requesting");
    }

    public void submit(){
        driver.findElement(submit).click();
    }
}
