package edu.ksu.admissions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Created by davidfreeman on 5/10/16.
 */
public class ReviewPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By main = By.id("ksu-main-content");
    private By payment = By.id("undergradForm_data_fee_payMethodCreditCard");

    private ArrayList<String> review = new ArrayList<String>();

    public ReviewPage(WebDriver driver, WebDriverWait wait){
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

    public String getRelationship(){ return review.get(5).substring(review.get(5).indexOf("applicant") + 10); }

    public String getSSN() { return review.get(6).substring(review.get(6).indexOf("Number") + 7); }

    public String getGender() { return review.get(7).substring(review.get(7).indexOf("Gender") + 7); }

    public String getName() { return review.get(9).substring(review.get(9).indexOf("Name") + 5); }

    public String getDOB() { return review.get(11).substring(review.get(11).indexOf("Birth") + 6); }

    public String getCountryOfBirth() { return review.get(12).substring(review.get(12).indexOf("Birth") + 6); }

    public String getCityOfBirth() { return review.get(13).substring(review.get(13).indexOf("City") + 5); }

    public String getPhoneNumber() { return review.get(15).substring(review.get(15).indexOf("Phone") + 6); }

    public String getEmail() { return review.get(17).substring(review.get(17).indexOf("Address") + 8); }

    public String getUSCitizen() { return review.get(20).substring(review.get(20).indexOf("Citizen") + 8); }

    public String getKansasResident() { return review.get(21).substring(review.get(21).indexOf("Resident") + 9); }

    public String getMailingCountry() { return review.get(26).substring(review.get(26).indexOf("Country") + 8); }

    public String getMailingCounty() { return review.get(27).substring(review.get(27).indexOf("County") + 7); }

    public String getMailingAddress() { return review.get(28).substring(review.get(28).indexOf("Address") + 8); }

    public String getMailingCity() { return review.get(29); }

    public String getFamilyRelationship() { return review.get(31).substring(review.get(31).indexOf("Relationship") + 13); }

    public String getFamilyName() { return review.get(32).substring(review.get(32).indexOf("Name") + 5); }

    public String getHighSchoolCountry() { return review.get(39).substring(review.get(39).indexOf("country") + 8); }

    public String getHighSchoolType() { return review.get(40).substring(review.get(40).indexOf("type") + 5); }

    public String getGradDate() { return review.get(41).substring(review.get(41).indexOf("date") + 5); }
}
