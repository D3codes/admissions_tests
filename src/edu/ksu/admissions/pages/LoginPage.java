package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by davidfreeman on 4/27/16.
 */
public class LoginPage {

    private WebDriver driver;

    private By eID = By.id("username");
    private By password = By.id("password");
    private By submit = By.id("submit_button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEID(String username){
        driver.findElement(eID).clear();
        driver.findElement(eID).sendKeys(username);
    }

    public void setPassword(String pswd){
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pswd);
    }

    public void submit(){
        driver.findElement(submit).click();
    }
}