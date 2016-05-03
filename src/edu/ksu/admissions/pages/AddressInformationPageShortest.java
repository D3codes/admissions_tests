package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/28/16.
 */
public class AddressInformationPageShortest {

    private WebDriver driver;

    private By country = By.id("mailing_country_1");
    private By address = By.id("mailing_address1_1");
    private By city = By.id("mailing_city_1");
    private By state = By.id("mailing_state_1");
    private By zipCode = By.id("mailingZip_1");
    private By county = By.id("county_1");
    private By sameAddress = By.id("undergradForm_data_contact1_sameAddresstrue");
    private By relationship = By.id("contact1_relationship");
    private By contactFirstName = By.id("contact1_firstName");
    private By contactLastName = By.id("contact1_lastName");
    private By addAnotherRelationship = By.id("undergradForm_data_hasContact2false");
    private By submit = By.id("undergradForm_next");

    public AddressInformationPageShortest(WebDriver driver){
        this.driver = driver;
    }

    public void waitForPageLoad(WebDriverWait wait){
        wait.until(ExpectedConditions.presenceOfElementLocated(country));
    }

    public void setCountry(){
        driver.findElement(country).click();
        new Select(driver.findElement(country)).selectByVisibleText("United States");
    }

    public void setAddress(String addr){
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(addr);
    }

    public void setCity(String city){
        driver.findElement(this.city).clear();
        driver.findElement(this.city).sendKeys(city);
    }

    public void setState(){
        driver.findElement(state).click();
        new Select(driver.findElement(state)).selectByVisibleText("Kansas");
    }

    public void setZipCode(String zip){
        driver.findElement(zipCode).clear();
        driver.findElement(zipCode).sendKeys(zip);
    }

    public void setCounty(String county){
        driver.findElement(this.county).clear();
        driver.findElement(this.county).sendKeys(county);
    }

    public void setSameAddress(){
        driver.findElement(sameAddress).click();
    }

    public void setRelationship(){
        driver.findElement(relationship).click();
        new Select(driver.findElement(relationship)).selectByVisibleText("Father");
    }

    public void  setContactFirstName(String name){
        driver.findElement(contactFirstName).clear();
        driver.findElement(contactFirstName).sendKeys(name);
    }

    public void setContactLastName(String name){
        driver.findElement(contactLastName).clear();
        driver.findElement(contactLastName).sendKeys(name);
    }

    public void setAddAnotherRelationship(){
        driver.findElement(addAnotherRelationship).click();
    }

    public void submit(){
        driver.findElement(submit).click();
    }
}
