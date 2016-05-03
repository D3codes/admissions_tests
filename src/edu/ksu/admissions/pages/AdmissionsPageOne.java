package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/22/16.
 */
public class AdmissionsPageOne {

    private WebDriver driver;

    //Set UI Elements
    private By hasID = By.id("ChooseTerm_choose_data_haveEidtrue");
    private By noID = By.id("ChooseTerm_choose_data_haveEidfalse");
    private By submit = By.id("ChooseTerm_choose_0");

    public AdmissionsPageOne(WebDriver driver){
        this.driver = driver;
    }

    public void waitForPageLoad(WebDriverWait wait){
        wait.until(ExpectedConditions.presenceOfElementLocated(hasID));;
    }

    public void hasID(){
        driver.findElement(hasID).click();
    }

    public void noID(){
        driver.findElement(noID).click();
    }

    public void submit(){
        driver.findElement(submit).click();
    }
}
