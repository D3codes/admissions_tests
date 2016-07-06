package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/27/16.
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Set UI Elements
    private By eID = By.id("username");
    private By password = By.id("password");
    private By submit = By.id("submit_button");

    public LoginPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void setEID(String username){
      wait.until(ExpectedConditions.presenceOfElementLocated(eID));
      wait.until(ExpectedConditions.visibilityOfElementLocated(eID));
      driver.findElement(eID).clear();
      driver.findElement(eID).sendKeys(username);
    }

    public void setPassword(String pswd){
      wait.until(ExpectedConditions.presenceOfElementLocated(password));
      wait.until(ExpectedConditions.visibilityOfElementLocated(password));
      driver.findElement(password).clear();
      driver.findElement(password).sendKeys(pswd);
    }

    public void submit(){
      wait.until(ExpectedConditions.presenceOfElementLocated(submit));
      wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
      driver.findElement(submit).click();
    }
}
