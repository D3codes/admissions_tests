package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/22/16.
 */
public class SecurityQuestions {
    WebDriver driver;
    WebDriverWait wait;

    //Create UI Elements
    private By question = By.id("id_passwordQuestion");
    private By answer = By.id("id_passwordAnswer");
    private By submit = By.id("submit_button");
    private By alertMessage = By.cssSelector("div.alert.alert-danger > p");

    public SecurityQuestions(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.presenceOfElementLocated(question));
    }

    public void setQuestion(String q){
        driver.findElement(question).clear();
        driver.findElement(question).sendKeys(q);
    }

    public void setAnswer(String a){
        driver.findElement(answer).clear();
        driver.findElement(answer).sendKeys(a);
    }

    public void submit(){
        driver.findElement(submit);
    }

    public String getAlertMessage(){
        return driver.findElement(alertMessage).getText();
    }
}
