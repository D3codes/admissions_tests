package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/22/16.
 */
public class CreateEID {

    private WebDriver driver;
    private WebDriverWait wait;

    //Create UI Elements
    private By firstName = By.id("id_first_name");
    private By lastName = By.id("id_last_name");
    private By birthMonth = By.id("id_birthdate_month");
    private By birthDay = By.id("id_birthdate_day");
    private By birthYear = By.id("id_birthdate_year");
    private By gender = By.id("id_male");
    private By emailAddress = By.id("id_email");
    private By submit = By.id("submit_button");
    private By alertMessage = By.cssSelector("div.alert.alert-danger > p");

    public CreateEID(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
    }

    public void clearFirstName() {
        driver.findElement(firstName).clear();
    }

    public void setFirstName(String f_name){
        clearFirstName();
        driver.findElement(firstName).sendKeys(f_name);
    }

    public void clearLastName(){
        driver.findElement(lastName).clear();
    }

    public void setLastName(String l_name){
        clearLastName();
        driver.findElement(lastName).sendKeys(l_name);
    }

    public void setBirthDate(String day, String month, String year){
        driver.findElement(birthDay).click();
        new Select(driver.findElement(birthDay)).selectByVisibleText(day);
        driver.findElement(birthMonth).click();
        new Select(driver.findElement(birthMonth)).selectByVisibleText(month);
        driver.findElement(birthYear).click();
        new Select(driver.findElement(birthYear)).selectByVisibleText(year);
    }

    public void setGender(){
        driver.findElement(gender).click();
        driver.findElement(gender).click();
    }

    public void setEmail(String email){
        driver.findElement(emailAddress).sendKeys(email);
    }

    public void submit(){
        driver.findElement(submit).click();
    }

    public String getAlertMessage(){
        return driver.findElement(alertMessage).getText();
    }
}
