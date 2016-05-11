package edu.ksu.admissions.pages.longest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Created by davidfreeman on 5/11/16.
 */
public class ReviewPageLongest {

    private WebDriver driver;
    private WebDriverWait wait;

    private By main = By.id("ksu-main-content");
    private By payment = By.id("undergradForm_data_fee_payMethodCreditCard");

    private ArrayList<String> review = new ArrayList<String>();

    public ReviewPageLongest(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(payment));
    }

    public void getInfo(){
        String whole = driver.findElement(main).getText();

        String tmp = "";
        for(int i = 0; i < whole.length(); i++) {

            if(whole.charAt(i) == '\n'){
                review.add(tmp);
                tmp = "";
            } else {
                tmp += whole.charAt(i);
            }
        }
    }

    public void print(){
        for(String line : review)
            System.out.println(line);
    }
}
