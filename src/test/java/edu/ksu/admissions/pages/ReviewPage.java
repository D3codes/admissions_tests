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
    private By certification = By.id("certificationAgree");

    private ArrayList<String> review;

    public ReviewPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        review = new ArrayList<String>();
    }

    public void waitForPageLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(certification));
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

    public void printInfo(){
      for(String line : review)
        System.out.println(line);
    }

    public String getRelationship(){ return review.get(5).substring(review.get(5).indexOf("applicant") + 10);}

    public String getSSN() { return review.get(6).substring(review.get(6).indexOf("Number") + 7); }

    public String getGender() { return review.get(7).substring(review.get(7).indexOf("Gender") + 7);}

    public String getName() { return review.get(9).substring(review.get(9).indexOf("Name") + 5);}

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

    public String getPermanentResident() { return review.get(21).substring(review.get(21).indexOf("Resident") + 9); }

    public String getInternationalStudent() { return review.get(22).substring(review.get(22).indexOf("Student") + 8); }

    public String getCountryOfCitizenship() { return review.get(23).substring(review.get(23).indexOf("Citizenship") + 12); }

    public String getVisaType() { return review.get(24).substring(review.get(24).indexOf("type") + 5); }

    public String getPermanentAddressCountry() { return review.get(28).substring(review.get(28).indexOf("Country") + 8); }

    public String getPermanentAddress() { return review.get(29).substring(review.get(29).indexOf("Address") + 8); }

    public String getPermanentAddressCity() { return review.get(30); }

    public String getFamilyRelationship(boolean isShortest) {

        int line = 36;
        if(isShortest)
            line = 31;

        return review.get(line).substring(review.get(line).indexOf("Relationship") + 13);
    }

    public String getFamilyName(boolean isShortest) {

        int line = 37;
        if(isShortest)
            line = 32;

        return review.get(line).substring(review.get(line).indexOf("Name") + 5);
    }

    public String getHighSchoolCountry(boolean isShortest) {

        int line = 43;
        if(isShortest)
            line = 39;

        return review.get(line).substring(review.get(line).indexOf("country") + 8);
    }

    public String getHighSchoolType() { return review.get(40).substring(review.get(40).indexOf("type") + 5); }

    public String getHighSchool() { return review.get(44).substring(review.get(44).indexOf("School") + 7); }

    public String getGradDate(boolean isShortest) {

        int line = 45;
        if(isShortest)
            line = 41;

        return review.get(line).substring(review.get(line).indexOf("date") + 5);
    }

    public String getPreviouslyAttendedKState() { return review.get(51).substring(review.get(51).indexOf("K-State") + 8); }

    public String getPreviousCollegeCountry() { return review.get(54).substring(review.get(54).indexOf("Country") + 8); }

    public String getPreviousCollege() { return review.get(55).substring(review.get(55).indexOf("name") + 5); }

    public String getPreviousCreditHours() { return review.get(56).substring(review.get(56).indexOf("hours") + 6); }

    public String getDatesOfAttendance() { return review.get(57).substring(review.get(57).indexOf("Attendance") + 11); }

    public String getActiveMilitary() { return review.get(76).substring(review.get(76).indexOf("Military") + 9); }

    public String getDatesOfService() { return review.get(77).substring(review.get(77).indexOf("service") + 8); }

    public String getDescendant1() { return review.get(80); }

    public String getDescendant2() { return review.get(81); }

    public String getDescendant3() { return review.get(82); }

    public String getDescendant4() { return review.get(83); }

    public String getDescendant5() { return review.get(84); }

    public String getDescendant6() { return review.get(85); }

    public String getEmployer1() { return review.get(86); }

    public String getEmployer2() { return review.get(87); }

    public String getEmployer3() { return review.get(88); }

    public String getGeneral1() { return review.get(89); }

    public String getGeneral2() { return review.get(90); }

    public String getGeneral3() { return review.get(91); }

    public String getGeneral4() { return review.get(92); }

    public String getGeneral5() { return review.get(93); }

    public String getGeneral6() { return review.get(94); }

    public String getGeneral7() { return review.get(95); }

    public String getGeneral8() { return review.get(96); }

    public String getGeneral9() { return review.get(97); }

    public String getGeneral10() { return review.get(98); }

    public String getGeneral11() { return review.get(99); }
}
