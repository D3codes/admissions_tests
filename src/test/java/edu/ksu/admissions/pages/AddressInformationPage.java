package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/28/16.
 */
public class AddressInformationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By country = By.id("mailing_country_1");
    private By address = By.id("mailing_address1_1");
    private By city = By.id("mailing_city_1");
    private By state = By.id("mailing_state_1");
    private By zipCode = By.id("mailingZip_1");
    private By county = By.id("county_1");
    private By sameAddress = By.id("undergradForm_data_contact1_sameAddresstrue");
    private By sameMailingAddress = By.id("intlAddrSametrue");
    private By relationship = By.id("contact1_relationship");
    private By contactFirstName = By.id("contact1_firstName");
    private By contactLastName = By.id("contact1_lastName");
    private By addAnotherRelationship = By.id("undergradForm_data_hasContact2false");
    private By submit = By.id("undergradForm_next");

    public AddressInformationPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void setCountryUS(){
      wait.until(ExpectedConditions.presenceOfElementLocated(country));
      wait.until(ExpectedConditions.visibilityOfElementLocated(country));
      driver.findElement(country).click();
      new Select(driver.findElement(country)).selectByVisibleText("United States");
    }

    public void setCountryAFG(){
      wait.until(ExpectedConditions.presenceOfElementLocated(country));
      wait.until(ExpectedConditions.visibilityOfElementLocated(country));
      driver.findElement(country).click();
      new Select(driver.findElement(country)).selectByVisibleText("Afghanistan");
    }

    public void setAddress(String addr){
      wait.until(ExpectedConditions.presenceOfElementLocated(address));
      wait.until(ExpectedConditions.visibilityOfElementLocated(address));
      driver.findElement(address).clear();
      driver.findElement(address).sendKeys(addr);
    }

    public void setCity(String city){
      wait.until(ExpectedConditions.presenceOfElementLocated(this.city));
      wait.until(ExpectedConditions.visibilityOfElementLocated(this.city));
      driver.findElement(this.city).clear();
      driver.findElement(this.city).sendKeys(city);
    }

    public void setState(){
      wait.until(ExpectedConditions.presenceOfElementLocated(state));
      wait.until(ExpectedConditions.visibilityOfElementLocated(state));
      driver.findElement(state).click();
      new Select(driver.findElement(state)).selectByVisibleText("Kansas");
    }

    public void setZipCode(String zip){
      wait.until(ExpectedConditions.presenceOfElementLocated(zipCode));
      wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode));
      driver.findElement(zipCode).clear();
      driver.findElement(zipCode).sendKeys(zip);
    }

    public void setCounty(String county){
      wait.until(ExpectedConditions.presenceOfElementLocated(this.county));
      wait.until(ExpectedConditions.visibilityOfElementLocated(this.county));
      driver.findElement(this.county).click();
      new Select(driver.findElement(this.county)).selectByVisibleText(county);
    }

    public void setSameAddress(){
      wait.until(ExpectedConditions.presenceOfElementLocated(sameAddress));
      wait.until(ExpectedConditions.visibilityOfElementLocated(sameAddress));
      driver.findElement(sameAddress).click();
    }

    public void setSameMailingAddress() {
      wait.until(ExpectedConditions.presenceOfElementLocated(sameMailingAddress));
      wait.until(ExpectedConditions.visibilityOfElementLocated(sameMailingAddress));
      driver.findElement(sameMailingAddress).click();
    }

    public void setRelationship(){
      wait.until(ExpectedConditions.presenceOfElementLocated(relationship));
      wait.until(ExpectedConditions.visibilityOfElementLocated(relationship));
      driver.findElement(relationship).click();
      new Select(driver.findElement(relationship)).selectByVisibleText("Father");
    }

    public void  setContactFirstName(String name){
      wait.until(ExpectedConditions.presenceOfElementLocated(contactFirstName));
      wait.until(ExpectedConditions.visibilityOfElementLocated(contactFirstName));
      driver.findElement(contactFirstName).clear();
      driver.findElement(contactFirstName).sendKeys(name);
    }

    public void setContactLastName(String name){
      wait.until(ExpectedConditions.presenceOfElementLocated(contactLastName));
      wait.until(ExpectedConditions.visibilityOfElementLocated(contactLastName));
      driver.findElement(contactLastName).clear();
      driver.findElement(contactLastName).sendKeys(name);
    }

    public void setAddAnotherRelationship(){
      wait.until(ExpectedConditions.presenceOfElementLocated(addAnotherRelationship));
      wait.until(ExpectedConditions.visibilityOfElementLocated(addAnotherRelationship));
      driver.findElement(addAnotherRelationship).click();
    }

    public void submit(){
      wait.until(ExpectedConditions.presenceOfElementLocated(submit));
      wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
      driver.findElement(submit).click();
    }
}
