package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/22/16.
 */
public class ChoosePassword {
    private WebDriver driver;

    //Create UI Elements
    private By password = By.id("id_password");
    private By confirmPassword = By.id("id_confirm_password");
    private By passValidation = By.cssSelector("span[class='validation pass']");
    private By failValidation = By.cssSelector("span[class='validation fail']");
    private By matchValidation = By.cssSelector("span[class='validation matches']");
    private By submit = By.id("submit_button");
    private By alertMessage = By.cssSelector("div.alert.alert-danger > p");

    public ChoosePassword(WebDriver driver){
        this.driver = driver;
    }

    public void setPassword(String pwd){
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pwd);
    }

    public void setConfirmPassword(String pwd){
        driver.findElement(confirmPassword).clear();
        driver.findElement(confirmPassword).sendKeys(pwd);
    }

    public void submit(){
        driver.findElement(submit).click();
    }

    public String getAlertMessage(){
        return driver.findElement(alertMessage).getText();
    }

    public void checkPassValidation(WebDriverWait wait){
        wait.until(ExpectedConditions.presenceOfElementLocated(passValidation));
    }

    public void checkFailValidation(WebDriverWait wait){
        wait.until(ExpectedConditions.presenceOfElementLocated(failValidation));
    }

    public void checkMatchValidation(WebDriverWait wait){
        wait.until(ExpectedConditions.presenceOfElementLocated(matchValidation));
    }
}
