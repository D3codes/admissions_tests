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

    //Set UI Elements
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

    public void setTerm(){
      wait.until(ExpectedConditions.presenceOfElementLocated(term));
      wait.until(ExpectedConditions.visibilityOfElementLocated(term));
      driver.findElement(term).click();
    }

    public void setDataForOther(){
      wait.until(ExpectedConditions.presenceOfElementLocated(dataForOther));
      wait.until(ExpectedConditions.visibilityOfElementLocated(dataForOther));
      driver.findElement(dataForOther).click();
    }

    public void setRelationshipFamily(){
      wait.until(ExpectedConditions.presenceOfElementLocated(relationshipFamily));
      wait.until(ExpectedConditions.visibilityOfElementLocated(relationshipFamily));
      driver.findElement(relationshipFamily).click();
    }

    public void setRelationshipCounselor() {
      wait.until(ExpectedConditions.presenceOfElementLocated(relationshipCounselor));
      wait.until(ExpectedConditions.visibilityOfElementLocated(relationshipCounselor));
      driver.findElement(relationshipCounselor).click();
    }

    public void setGender(){
      wait.until(ExpectedConditions.presenceOfElementLocated(gender));
      wait.until(ExpectedConditions.visibilityOfElementLocated(gender));
      driver.findElement(gender).click();
    }

    public void setFirstName(String name){
      wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
      wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
      driver.findElement(firstName).clear();
      driver.findElement(firstName).sendKeys(name);
    }

    public void setLastName(String name){
      wait.until(ExpectedConditions.presenceOfElementLocated(lastName));
      wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
      driver.findElement(lastName).clear();
      driver.findElement(lastName).sendKeys(name);
    }

    public void setAdditionalNames(){
      wait.until(ExpectedConditions.presenceOfElementLocated(additionalNames));
      wait.until(ExpectedConditions.visibilityOfElementLocated(additionalNames));
      driver.findElement(additionalNames).click();
    }

    public void setBirthDate(String month, String day, String year){
      wait.until(ExpectedConditions.presenceOfElementLocated(birthDay));
      wait.until(ExpectedConditions.visibilityOfElementLocated(birthDay));
      driver.findElement(birthDay).click();
      new Select(driver.findElement(birthDay)).selectByVisibleText(day);
      wait.until(ExpectedConditions.presenceOfElementLocated(birthMonth));
      wait.until(ExpectedConditions.visibilityOfElementLocated(birthMonth));
      driver.findElement(birthMonth).click();
      new Select(driver.findElement(birthMonth)).selectByVisibleText(month);
      wait.until(ExpectedConditions.presenceOfElementLocated(birthYear));
      wait.until(ExpectedConditions.visibilityOfElementLocated(birthYear));
      driver.findElement(birthYear).click();
      new Select(driver.findElement(birthYear)).selectByVisibleText(year);
    }

    public void setBirthCountry(String country){
      wait.until(ExpectedConditions.presenceOfElementLocated(birthCountry));
      wait.until(ExpectedConditions.visibilityOfElementLocated(birthCountry));
      driver.findElement(birthCountry).click();
      new Select(driver.findElement(birthCountry)).selectByVisibleText(country);
    }

    public void setBirthPlace(String location){
      wait.until(ExpectedConditions.presenceOfElementLocated(birthPlace));
      wait.until(ExpectedConditions.visibilityOfElementLocated(birthPlace));
      driver.findElement(birthPlace).clear();
      driver.findElement(birthPlace).sendKeys(location);
    }

    public void setPhoneNumber(String number){
      wait.until(ExpectedConditions.presenceOfElementLocated(phoneNumber));
      wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumber));
      driver.findElement(phoneNumber).clear();
      driver.findElement(phoneNumber).sendKeys(number);
    }

    public void setEmailAddress(String email){
      wait.until(ExpectedConditions.presenceOfElementLocated(emailAddress));
      wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddress));
      driver.findElement(emailAddress).clear();
      driver.findElement(emailAddress).sendKeys(email);
    }

    public void setConfirmEmail(String email){
      wait.until(ExpectedConditions.presenceOfElementLocated(confirmEmail));
      wait.until(ExpectedConditions.visibilityOfElementLocated(confirmEmail));
      driver.findElement(confirmEmail).clear();
      driver.findElement(confirmEmail).sendKeys(email);
    }

    public void setUsCitizentrue() {
      wait.until(ExpectedConditions.presenceOfElementLocated(usCitizentrue));
      wait.until(ExpectedConditions.visibilityOfElementLocated(usCitizentrue));
      driver.findElement(usCitizentrue).click();
    }

    public void setUsCitizenfalse(){
      wait.until(ExpectedConditions.presenceOfElementLocated(usCitizenfalse));
      wait.until(ExpectedConditions.visibilityOfElementLocated(usCitizenfalse));
      driver.findElement(usCitizenfalse).click();
    }

    public void setKsResident(){
      wait.until(ExpectedConditions.presenceOfElementLocated(ksResident));
      wait.until(ExpectedConditions.visibilityOfElementLocated(ksResident));
      driver.findElement(ksResident).click();
    }

    public void setInKsSinceBirth(){
      wait.until(ExpectedConditions.presenceOfElementLocated(inKsSinceBirth));
      wait.until(ExpectedConditions.visibilityOfElementLocated(inKsSinceBirth));
      driver.findElement(inKsSinceBirth).click();
    }

    public void setParentsKsResident(){
      wait.until(ExpectedConditions.presenceOfElementLocated(parentsKsResident));
      wait.until(ExpectedConditions.visibilityOfElementLocated(parentsKsResident));
      driver.findElement(parentsKsResident).click();
    }

    public void setPermanentResident(){
      wait.until(ExpectedConditions.presenceOfElementLocated(permanentResident));
      wait.until(ExpectedConditions.visibilityOfElementLocated(permanentResident));
      driver.findElement(permanentResident).click();
    }

    public void setInternationalStudent(){
      wait.until(ExpectedConditions.presenceOfElementLocated(internationalStudent));
      wait.until(ExpectedConditions.visibilityOfElementLocated(internationalStudent));
      driver.findElement(internationalStudent).click();
    }

    public void setCountryOfCitizenship(String country){
      wait.until(ExpectedConditions.presenceOfElementLocated(countryOfCitizenship));
      wait.until(ExpectedConditions.visibilityOfElementLocated(countryOfCitizenship));
      driver.findElement(countryOfCitizenship).click();
      new Select(driver.findElement(countryOfCitizenship)).selectByVisibleText(country);
    }

    public void setCurrentVisa(){
      wait.until(ExpectedConditions.presenceOfElementLocated(currentVisa));
      wait.until(ExpectedConditions.visibilityOfElementLocated(currentVisa));
      driver.findElement(currentVisa).click();
    }

    public void setVisaType(){
      wait.until(ExpectedConditions.presenceOfElementLocated(visaType));
      wait.until(ExpectedConditions.visibilityOfElementLocated(visaType));
      driver.findElement(visaType).click();
      new Select(driver.findElement(visaType)).selectByVisibleText("Student (F1)");
    }

    public void setRequestingVisa(){
      wait.until(ExpectedConditions.presenceOfElementLocated(requestingVisa));
      wait.until(ExpectedConditions.visibilityOfElementLocated(requestingVisa));
      driver.findElement(requestingVisa).click();
      new Select(driver.findElement(requestingVisa)).selectByVisibleText("Not Requesting");
    }

    public void submit(){
      wait.until(ExpectedConditions.presenceOfElementLocated(submit));
      wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
      driver.findElement(submit).click();
    }
}
