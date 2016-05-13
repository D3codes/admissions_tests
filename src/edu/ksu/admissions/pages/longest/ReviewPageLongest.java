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
    private By certify = By.id("certificationAgree");

    private ArrayList<String> review = new ArrayList<String>();

    public ReviewPageLongest(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(certify));
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

    public String getRelationship() { return review.get(5).substring(review.get(5).indexOf("applicant") + 10); }

    public String getGender() { return review.get(7).substring(review.get(7).indexOf("Gender") + 7); }

    public String getName() { return review.get(9).substring(review.get(9).indexOf("Name") + 5); }

    public String getDOB() { return review.get(11).substring(review.get(11).indexOf("Birth") + 6); }

    public String getCountryOfBirth() { return review.get(12).substring(review.get(12).indexOf("Birth") + 6); }

    public String getCityOfBirth() { return review.get(13).substring(review.get(13).indexOf("City") + 5); }

    public String getPhoneNumber() { return review.get(15).substring(review.get(15).indexOf("Phone") + 6); }

    public String getEmail() { return review.get(17).substring(review.get(17).indexOf("Address") + 8); }

    public String getUSCitizen() { return review.get(20).substring(review.get(20).indexOf("Citizen") + 8); }

    public String getPermanentResident() { return review.get(21).substring(review.get(21).indexOf("Resident") + 9); }

    public String getInternationalStudent() { return review.get(22).substring(review.get(22).indexOf("Student") + 8); }

    public String getCountryOfCitizenship() { return review.get(23).substring(review.get(23).indexOf("Citizenship") + 12); }

    public String getVisaType() { return review.get(24).substring(review.get(24).indexOf("type") + 5); }

    public String getPermanentAddressCountry() { return review.get(28).substring(review.get(28).indexOf("Country") + 8); }

    public String getPermanentAddress() { return review.get(29).substring(review.get(29).indexOf("Address") + 8); }

    public String getPermanentAddressCity() { return review.get(30); }

    public String getFamilyRelationship() { return review.get(36).substring(review.get(36).indexOf("Relationship") + 13); }

    public String getFamilyName() { return review.get(37).substring(review.get(37).indexOf("Name") + 5); }

    public String getHighSchoolCountry() { return review.get(43).substring(review.get(43).indexOf("country") + 8); }

    public String getHighSchool() { return review.get(44).substring(review.get(44).indexOf("School") + 7); }

    public String getGradDate() { return review.get(45).substring(review.get(45).indexOf("date") + 5); }

    public String getPreviouslyAttendedKState() { return review.get(51).substring(review.get(51).indexOf("K-State") + 8); }

    public String getPreviousCollegeCountry() { return review.get(54).substring(review.get(54).indexOf("Country") + 8); }

    public String getPreviousCollege() { return review.get(55).substring(review.get(55).indexOf("name") + 5); }

    public String getPreviousCreditHours() { return review.get(56).substring(review.get(56).indexOf("hours") + 6); }

    public String getDatesOfAttendance() { return review.get(57).substring(review.get(57).indexOf("Attendance") + 11); }

    public String getActiveMilitary() { return review.get(76).substring(review.get(76).indexOf("Military") + 9); }

    public String getDatesOfService() { return review.get(77).substring(review.get(77).indexOf("service") + 8); }
}


