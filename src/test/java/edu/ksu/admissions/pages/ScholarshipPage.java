package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/28/16.
 */
public class ScholarshipPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Set UI Elements
    private By ssn = By.id("nationalId");
    private By activities = By.id("activities");
    private By awards = By.id("awards");
    private By roles = By.id("roles");
    private By descendant1 = By.id("data.descendantAnswers-1");
    private By descendant2 = By.id("data.descendantAnswers-2");
    private By descendant3 = By.id("data.descendantAnswers-3");
    private By descendant4 = By.id("data.descendantAnswers-4");
    private By descendant5 = By.id("data.descendantAnswers-5");
    private By descendant6 = By.id("data.descendantAnswers-6");
    private By employment1 = By.id("data.employmentAnswers-1");
    private By employment2 = By.id("data.employmentAnswers-2");
    private By employment3 = By.id("data.employmentAnswers-3");
    private By general1 = By.id("general_100");
    private By general2 = By.id("general_101");
    private By general3 = By.id("general_102");
    private By general4 = By.id("general_103");
    private By general5 = By.id("general_104");
    private By general6 = By.id("general_105");
    private By general7 = By.id("general_106");
    private By general8 = By.id("general_107");
    private By general9 = By.id("general_108");
    private By general10 = By.id("general_109");
    private By general11 = By.id("general_110");
    private By submit = By.id("undergradForm_next");
    private By skip = By.id("skip");

    public ScholarshipPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void setSSN(String num){
      wait.until(ExpectedConditions.presenceOfElementLocated(ssn));
      wait.until(ExpectedConditions.visibilityOfElementLocated(ssn));
      driver.findElement(ssn).clear();
      driver.findElement(ssn).sendKeys(num);
    }

    public void setActivities(String activ){
      wait.until(ExpectedConditions.presenceOfElementLocated(activities));
      wait.until(ExpectedConditions.visibilityOfElementLocated(activities));
      driver.findElement(activities).clear();
      driver.findElement(activities).sendKeys(activ);
    }

    public void setAwards(String award){
      wait.until(ExpectedConditions.presenceOfElementLocated(awards));
      wait.until(ExpectedConditions.visibilityOfElementLocated(awards));
      driver.findElement(awards).clear();
      driver.findElement(awards).sendKeys(award);
    }

    public void setRoles(String role){
      wait.until(ExpectedConditions.presenceOfElementLocated(roles));
      wait.until(ExpectedConditions.visibilityOfElementLocated(roles));
      driver.findElement(roles).clear();
      driver.findElement(roles).sendKeys(role);
    }

    public void setDescendants(){
      wait.until(ExpectedConditions.presenceOfElementLocated(descendant1));
      wait.until(ExpectedConditions.visibilityOfElementLocated(descendant1));
      driver.findElement(descendant1).click();
      driver.findElement(descendant2).click();
      driver.findElement(descendant3).click();
      driver.findElement(descendant4).click();
      driver.findElement(descendant5).click();
      driver.findElement(descendant6).click();
    }

    public void setEmployers(){
      wait.until(ExpectedConditions.presenceOfElementLocated(employment1));
      wait.until(ExpectedConditions.visibilityOfElementLocated(employment1));
      driver.findElement(employment1).click();
      driver.findElement(employment2).click();
      driver.findElement(employment3).click();
    }

    public void setGeneral(){
      wait.until(ExpectedConditions.presenceOfElementLocated(general1));
      wait.until(ExpectedConditions.visibilityOfElementLocated(general1));
      driver.findElement(general1).click();
      driver.findElement(general2).click();
      driver.findElement(general3).click();
      driver.findElement(general4).click();
      driver.findElement(general5).click();
      driver.findElement(general6).click();
      driver.findElement(general7).click();
      driver.findElement(general8).click();
      driver.findElement(general9).click();
      driver.findElement(general10).click();
      driver.findElement(general11).click();
    }

    public void skip() {
      wait.until(ExpectedConditions.presenceOfElementLocated(skip));
      wait.until(ExpectedConditions.visibilityOfElementLocated(skip));
      driver.findElement(skip).click();
    }

    public void submit(){
      wait.until(ExpectedConditions.presenceOfElementLocated(submit));
      wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
      driver.findElement(submit).click();
    }
}
