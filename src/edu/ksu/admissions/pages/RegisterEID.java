package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by davidfreeman on 4/22/16.
 */
public class RegisterEID {
    private WebDriver driver;

    //Create UI Elements
    private By phoneNumber = By.id("id_phone");
    private By address = By.id("id_address");
    private By cityName = By.name("address.city");
    private By stateName = By.id("id_state");
    private By zipCode = By.name("address.postalCode");
    private By submit = By.id("submit_button");
    private By alertMessage = By.cssSelector("div.alert.alert-danger > p");

    public RegisterEID(WebDriver driver){
        this.driver = driver;
    }

    public void setPhoneNumber(String number){
        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber).sendKeys(number);
    }

    public void clearAddress(){
        driver.findElement(address).clear();
    }

    public void setAddress(String addr){
        clearAddress();
        driver.findElement(address).sendKeys(addr);
    }

    public void setCity(String city){
        driver.findElement(cityName).clear();
        driver.findElement(cityName).sendKeys(city);
    }

    public void setState(String state){
        driver.findElement(stateName).clear();
        driver.findElement(stateName).sendKeys(state);
    }

    public void clearZipCode(){
        driver.findElement(zipCode).clear();
    }

    public void setZipCode(String zip){
        clearZipCode();
        driver.findElement(zipCode).sendKeys(zip);
    }

    public void submit(){
        driver.findElement(submit).click();
    }

    public String getAlertMessage(){
        return driver.findElement(alertMessage).getText();
    }
}
