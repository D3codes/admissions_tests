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

    //Set UI Elements
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

    //saves entire review page to the arraylist "review"
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

    public String getDescendant1(Boolean conductQuestions) {

      int line = 75;
      if(conductQuestions)
        line = 80;

      return review.get(line);
     }

    public String getDescendant2(Boolean conductQuestions) {

      int line = 76;
      if(conductQuestions)
        line = 81;

      return review.get(line);
     }

    public String getDescendant3(Boolean conductQuestions) {

      int line = 77;
      if(conductQuestions)
        line = 82;

      return review.get(line);
    }

    public String getDescendant4(Boolean conductQuestions) {

      int line = 78;
      if(conductQuestions)
        line = 83;

      return review.get(line);
    }

    public String getDescendant5(Boolean conductQuestions) {

      int line = 79;
      if(conductQuestions)
        line = 84;

      return review.get(line);
    }

    public String getDescendant6(Boolean conductQuestions) {

      int line = 80;
      if(conductQuestions)
        line = 85;

      return review.get(line);
    }

    public String getEmployer1(Boolean conductQuestions) {

      int line = 81;
      if(conductQuestions)
        line = 86;

      return review.get(line);
    }

    public String getEmployer2(Boolean conductQuestions) {

      int line = 82;
      if(conductQuestions)
        line = 87;

      return review.get(line);
    }

    public String getEmployer3(Boolean conductQuestions) {

      int line = 83;
      if(conductQuestions)
        line = 88;

      return review.get(line);
    }

    public String getGeneral1(Boolean conductQuestions) {

      int line = 84;
      if(conductQuestions)
        line = 89;

      return review.get(line);
    }

    public String getGeneral2(Boolean conductQuestions) {

      int line = 85;
      if(conductQuestions)
        line = 90;

      return review.get(line);
    }

    public String getGeneral3(Boolean conductQuestions) {

      int line = 86;
      if(conductQuestions)
        line = 91;

      return review.get(line);
    }

    public String getGeneral4(Boolean conductQuestions) {

      int line = 87;
      if(conductQuestions)
        line = 92;

      return review.get(line);
    }

    public String getGeneral5(Boolean conductQuestions) {

      int line = 88;
      if(conductQuestions)
        line = 93;

      return review.get(line);
    }


    public String getGeneral6(Boolean conductQuestions) {

      int line = 89;
      if(conductQuestions)
        line = 94;

      return review.get(line);
    }

    public String getGeneral7(Boolean conductQuestions) {

      int line = 90;
      if(conductQuestions)
        line = 95;

      return review.get(line);
    }

    public String getGeneral8(Boolean conductQuestions) {

      int line = 91;
      if(conductQuestions)
        line = 96;

      return review.get(line);
    }

    public String getGeneral9(Boolean conductQuestions) {

      int line = 92;
      if(conductQuestions)
        line = 97;

      return review.get(line);
    }

    public String getGeneral10(Boolean conductQuestions) {

      int line = 93;
      if(conductQuestions)
        line = 98;

      return review.get(line);
    }

    public String getGeneral11(Boolean conductQuestions) {

      int line = 94;
      if(conductQuestions)
        line = 99;

      return review.get(line);
    }
}
