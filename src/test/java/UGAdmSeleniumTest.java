import edu.ksu.admissions.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by davidfreeman on 4/22/16.
 */
public class UGAdmSeleniumTest {

    private String baseURL;
    private WebDriver fireFox, chrome, safari;
    private List<WebDriver> drivers;
    private ArrayList<String> names;
    private String firstName;
    private int SSN;
    private static final int SSN_MAX = 999999999;
    private static final int SSN_MIN = 100000000;
    private static final boolean SHORTEST = true;
    private static final boolean LONGEST = false;
    private boolean CONDUCT_QUESTIONS;

    @Before
    public void setUp() throws Exception{

        System.out.println("Setting up Drivers");
        drivers = new ArrayList<WebDriver>();

        //checks the operating system and sets the chromedriver
        if(System.getProperty("os.name").equals("Mac OS X")){
          try{ //if the operating system is OS X, then sets up safaridriver
            System.setProperty("webdriver.chrome.driver", "src/main/resources/mac/chromedriver");
            safari = new SafariDriver();
            drivers.add(safari);
          }catch(Exception e){
            System.err.println("\nERROR setting up Drivers");
            System.err.println("Safari not detected on computer");
            System.err.println("Please install Safari to perform a complete test\n");
          }
        } else if(System.getProperty("os.name").contains("Windows")){
          System.setProperty("webdriver.chrome.driver", "src/main/resources/windows/chromedriver.exe");
        } else {
          System.setProperty("webdriver.chrome.driver", "src/main/resources/linux/chromedriver");
        }

        //tries to set up firefox
        //throws an error if no firefox installation is detected
        //or if there is an incompatable installation of firefox
        try{
          fireFox = new FirefoxDriver();
          drivers.add(fireFox);
        } catch(Exception e){
          System.err.println("\nERROR setting up Drivers");
          System.err.println("Firefox not detected on computer");
          System.err.println("Please install Firefox to perform a complete test\n");
          System.err.println("***KNOWN SELENIUM BUG***");
          System.err.println("Selenium does not work with FireFox 47");
          System.err.println("Must use FireFox 45: https://www.softexia.com/windows/web-browsers/firefox-45\n");
        }

        //tries to set up ChromeDriver
        //throws an error if no chrome installation is detected
        try{
          chrome = new ChromeDriver();
          drivers.add(chrome);
        } catch(Exception e){
          System.err.println("\nERROR setting up Drivers");
          System.err.println("Chrome not detected on computer");
          System.err.println("Please install Chrome to perform a complete test\n");
        }

        baseURL = "https://admissions.test.ome.k-state.edu/app/open/ChooseTerm_open.action";
        Random random = new Random();
        SSN = random.nextInt(SSN_MAX - SSN_MIN + 1) + SSN_MIN; //generates a random SSN
        ReadIn in = new ReadIn();
        names = in.readFile("src/main/resources/names.txt");
        firstName = names.get(random.nextInt(names.size())); //sets firstName to a random name from names.txt
        CONDUCT_QUESTIONS = true;
    }

    /**
     * Test shortest route end to end
     * This test includes scholarship applications
     */
    @Test
    public void testShortestRoute() throws Exception{
        System.out.println("\nTesting Undergrad Admissions Shortest Route\n");
        for(WebDriver driver : drivers){
            String driverType = "Safari Driver";
            if(driver instanceof FirefoxDriver) { driverType = "Firefox Driver"; }
            else if(driver instanceof ChromeDriver) { driverType = "Chrome Driver"; }

            try {
                WebDriverWait wait = new WebDriverWait(driver, 20);
                driver.get(baseURL);
                testPageOne(driver, wait, driverType, true);
                testLoginPage(driver, wait);
                testPersonalInformationPageShortest(driver, wait);
                testAddressInformationShortest(driver, wait);
                testEducationInformationPageShortest(driver, wait);
                testDemographicInformationPageShortest(driver, wait);
                testScholarshipPageShortest(driver, wait);
                testReviewPageShortest(driver, wait);
            } catch(Exception e){
                System.err.println("ERROR in test script: Undergrad Admissions Shortest Route");
                System.err.println("ERROR on page "+driver.getTitle());
                System.err.println("ERROR in " + driverType);
                System.err.println(e);
            }
        }
    }

    /**
     * Test longest route end to end
     */
    @Test
    public void testLongestRoute() throws Exception{
        System.out.println("\nTesting Undergrad Admissions Longest Route\n");
        for(WebDriver driver : drivers){
            String driverType = "Safari Driver";
            if(driver instanceof FirefoxDriver) { driverType = "Firefox Driver"; }
            else if(driver instanceof ChromeDriver) { driverType = "Chrome Driver"; }

            try {
                WebDriverWait wait = new WebDriverWait(driver, 20);
                driver.get(baseURL);
                testPageOne(driver, wait, driverType, true);
                testLoginPage(driver, wait);
                testPersonalInformationPageLongest(driver, wait);
                testAddressInformationLongest(driver, wait);
                testEducationInformationPageLongest(driver, wait);
                testDemographicInformationPageLongest(driver, wait);
                testScholarshipPageLongest(driver, wait);
                testReviewPageLongest(driver, wait);
            } catch(Exception e) {
                System.err.println("ERROR in test script: Undergrad Admissions Longest Route");
                System.err.println("ERROR on page "+driver.getTitle());
                System.err.println("ERROR in " + driverType);
                System.err.println(e);
            }
        }
    }

    /**
     * Test shortest route with self reporting
     */
    @Test
    public void testSelfReporting() throws Exception{
        System.out.println("\nTesting Self Reporting\n");
        for(WebDriver driver : drivers){
            String driverType = "Safari Driver";
            if(driver instanceof FirefoxDriver) { driverType = "Firefox Driver"; }
            else if(driver instanceof ChromeDriver) { driverType = "Chrome Driver"; }

            try{
                WebDriverWait wait = new WebDriverWait(driver, 20);
                driver.get(baseURL);
                testPageOne(driver, wait, driverType, true);
                testLoginPage(driver, wait);
                testPersonalInformationPageShortest(driver, wait);
                testAddressInformationShortest(driver, wait);
                testEducationInformationPageWithSelfReporting(driver, wait);
                testDemographicInformationPageShortest(driver, wait);
                testScholarshipPageShortest(driver, wait);
                testReviewPageWithSelfReporting(driver, wait);
            } catch(Exception e) {
                System.err.println("ERROR in test script: Self Reporting");
                System.err.println("ERROR on page "+driver.getTitle());
                System.err.println("ERROR in " + driverType);
                System.err.println(e);
            }
        }
    }

    private void testPageOne(WebDriver driver, WebDriverWait wait, String driverType, Boolean hasEID){
        System.out.println("----------"+driverType+"----------");
        System.out.println("Testing Page One");
        AdmissionsPageOne admissionsPageOne = new AdmissionsPageOne(driver, wait);
        if(hasEID)
            admissionsPageOne.hasID();
        else
            admissionsPageOne.noID(); //unused due to automated eprofile tests already existing

        admissionsPageOne.submit();
        System.out.println("Page One Test Successful\n");
    }

    private void testLoginPage(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Login Page");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.setEID("dmeierer");
        loginPage.setPassword("23Rt^JHS88");
        loginPage.submit();
        System.out.println("Login Page Test Successful\n");
    }

    private void testPersonalInformationPageShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Personal Information Page (Shortest Route)");
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver, wait);
        personalInformationPage.setTerm();
        personalInformationPage.setDataForOther();
        personalInformationPage.setRelationshipCounselor();
        personalInformationPage.setGender();
        personalInformationPage.setFirstName(firstName);
        personalInformationPage.setLastName("Test");
        personalInformationPage.setAdditionalNames();
        personalInformationPage.setBirthDate("January","1","1996");
        personalInformationPage.setBirthCountry("United States");
        personalInformationPage.setBirthPlace("Manhattan");
        personalInformationPage.setPhoneNumber("1234567890");
        personalInformationPage.setEmailAddress(firstName+"Test@ksu.edu");
        personalInformationPage.setConfirmEmail(firstName+"Test@ksu.edu");
        personalInformationPage.setUsCitizentrue();
        personalInformationPage.setKsResident();
        personalInformationPage.setInKsSinceBirth();
        personalInformationPage.setParentsKsResident();
        personalInformationPage.submit();
        System.out.println("Personal Information Page (Shortest Route) Test Successful\n");
    }

    private void testPersonalInformationPageLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Personal Information Page (Longest Route)");
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver, wait);
        personalInformationPage.setTerm();
        personalInformationPage.setDataForOther();
        personalInformationPage.setRelationshipFamily();
        personalInformationPage.setGender();
        personalInformationPage.setFirstName(firstName);
        personalInformationPage.setLastName("Test");
        personalInformationPage.setAdditionalNames();
        personalInformationPage.setBirthDate("January", "1", "1996");
        personalInformationPage.setBirthCountry("Afghanistan");
        personalInformationPage.setBirthPlace("Kabul");
        personalInformationPage.setPhoneNumber("1234567890");
        personalInformationPage.setEmailAddress(firstName + "Test@ksu.edu");
        personalInformationPage.setConfirmEmail(firstName + "Test@ksu.edu");
        personalInformationPage.setUsCitizenfalse();
        personalInformationPage.setPermanentResident();
        personalInformationPage.setInternationalStudent();
        personalInformationPage.setCountryOfCitizenship("Afghanistan");
        personalInformationPage.setCurrentVisa();
        personalInformationPage.setVisaType();
        personalInformationPage.setRequestingVisa();
        personalInformationPage.submit();
        System.out.println("Personal Information Page (Longest Route) Test Successful\n");
    }

    private void testAddressInformationShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Address Information Page (Shortest Route)");
        AddressInformationPage addressInformationPage = new AddressInformationPage(driver, wait);
        addressInformationPage.setCountryUS();
        addressInformationPage.setAddress("123 Manhattan Ave");
        addressInformationPage.setCity("Manhattan");
        addressInformationPage.setState();
        addressInformationPage.setZipCode("66502");
        addressInformationPage.setCounty("Riley");
        addressInformationPage.setSameAddress();
        addressInformationPage.setRelationship();
        addressInformationPage.setContactFirstName("John");
        addressInformationPage.setContactLastName("Doe");
        addressInformationPage.setAddAnotherRelationship();
        addressInformationPage.submit();
        System.out.println("Address Information Page (Shortest Route) Test Successful\n");
    }

    private void testAddressInformationLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Address Information Page (Longest Route)");
        AddressInformationPage addressInformationPage = new AddressInformationPage(driver, wait);
        addressInformationPage.setCountryAFG();
        addressInformationPage.setAddress("سرک 60 متره میدان هوایی‎");
        addressInformationPage.setCity("Kabul");
        addressInformationPage.setSameMailingAddress();
        addressInformationPage.setSameAddress();
        addressInformationPage.setRelationship();
        addressInformationPage.setContactFirstName("John");
        addressInformationPage.setContactLastName("Doe");
        addressInformationPage.setAddAnotherRelationship();
        addressInformationPage.submit();
        System.out.println("Address Information Page (Longest Route) Test Successful\n");
    }

    private void testEducationInformationPageShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Education Information Page (Shortest Route)");
        EducationInformationPage educationInformationPage = new EducationInformationPage(driver, wait);
        educationInformationPage.setHighSchoolCountry("United States");
        educationInformationPage.setSchoolType();
        educationInformationPage.setPlannedGraduationMonth();
        educationInformationPage.setPlannedGraduationYear();
        educationInformationPage.setPreviouslyAttendedKSUfalse();
        educationInformationPage.setPreviouslyTakenClassesfalse();
        educationInformationPage.setCompleteDegreetrue();
        educationInformationPage.setCompleteDegreeAtKSU();
        educationInformationPage.setKsuLocationMAN();
        educationInformationPage.setMajor();
        educationInformationPage.submit();
        System.out.println("Education Information Page (Shortest Route) Test Successful\n");
    }

    private void testEducationInformationPageLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Education Information Page (Longest Route)");
        EducationInformationPage educationInformationPage = new EducationInformationPage(driver, wait);
        educationInformationPage.setHighSchoolCountry("England");
        educationInformationPage.setHighSchool("Appleton Thorn Primary School");
        educationInformationPage.setPlannedGraduationMonth();
        educationInformationPage.setPlannedGraduationYear();
        educationInformationPage.setPreviouslyAttendedKSUtrue();
        educationInformationPage.setPreviouslyTakenClassestrue();
        educationInformationPage.setCollegeCountry("England");
        educationInformationPage.setCollegeName("King's College");
        educationInformationPage.setCreditHours("15");
        educationInformationPage.setAttendanceMonthStart("January");
        educationInformationPage.setAttendanceYearStart("2016");
        educationInformationPage.setAttendanceMontEnd("May");
        educationInformationPage.setAttendanceYearEnd("2016");
        educationInformationPage.setOfficialTranscript();
        educationInformationPage.setCompleteDegreefalse();
        educationInformationPage.setMinorTrue();
        educationInformationPage.setBaccalaureate();
        educationInformationPage.setKsuLocationDL();
        educationInformationPage.setMinor();
        educationInformationPage.submit();
        System.out.println("Education Information Page (Longest Route) Test Successful\n");
    }

    private void testEducationInformationPageWithSelfReporting(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Education Information Page With Self Reporting");
        EducationInformationPage educationInformationPage = new EducationInformationPage(driver, wait);
        educationInformationPage.setHighSchoolCountry("United States");
        educationInformationPage.setSchoolTypeForSelfReporting();
        educationInformationPage.setHighSchoolState();
        educationInformationPage.setHighSchool("Lansing High School (Lansing)");
        educationInformationPage.setPlannedGraduationMonth();
        educationInformationPage.setPlannedGraduationYear();
        educationInformationPage.setSelfReporting();
        educationInformationPage.setGPAScale();
        educationInformationPage.setGPAWeight();
        educationInformationPage.setGPA();
        educationInformationPage.setRanking();
        educationInformationPage.setTerm();
        educationInformationPage.setNinthGradeTranscript();
        educationInformationPage.setTenthGradeTranscript();
        educationInformationPage.setEleventhGradeTranscript();
        educationInformationPage.setTwelfthGradeTranscript();
        educationInformationPage.setACT();
        educationInformationPage.setCompositeScore("32");
        educationInformationPage.setEnglishScore("32");
        educationInformationPage.setMathScore("32");
        educationInformationPage.setReadingScore("32");
        educationInformationPage.setScienceScore("32");
        educationInformationPage.setPreviouslyAttendedKSUfalse();
        educationInformationPage.setPreviouslyTakenClassesfalse();
        educationInformationPage.setCompleteDegreetrue();
        educationInformationPage.setCompleteDegreeAtKSU();
        educationInformationPage.setKsuLocationMAN();
        educationInformationPage.setMajor();
        educationInformationPage.submit();
        System.out.println("Education Information Page With Self Reporting Test Successful\n");
    }

    private void testDemographicInformationPageShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Demographic Information Page (Shortest Route)");
        DemographicInformationPage demographicInformationPage = new DemographicInformationPage(driver, wait);
        demographicInformationPage.waitForPageLoad();
        demographicInformationPage.setEnglishPrimarytrue();
        demographicInformationPage.setOtherLanguagefalse();
        if(CONDUCT_QUESTIONS) //if the conduct questions are not present, throws an error
          try{
            demographicInformationPage.waitForConductInformation();
            demographicInformationPage.setEverExpelled();
            demographicInformationPage.setFelonyCharges();
            demographicInformationPage.setGuiltyPlea();
            demographicInformationPage.setRegisteredName();
          } catch(Exception e) {
            System.err.println("ERROR in Demographic Information Page: Conduct Questions Not Present");
            CONDUCT_QUESTIONS = false; //sets to false so the test will not check for questions again
          }
        demographicInformationPage.submit();
        System.out.println("Demographic Information Page (Shortest Route) Test Successful\n");
    }

    private void testDemographicInformationPageLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Demographic Information Page (Longest Route)");
        DemographicInformationPage demographicInformationPage = new DemographicInformationPage(driver, wait);
        demographicInformationPage.waitForPageLoad();
        demographicInformationPage.setEnglishPrimarytrue();
        demographicInformationPage.setOtherLanguagefalse();
        demographicInformationPage.setParentsDegree();
        demographicInformationPage.setMilitary();
        demographicInformationPage.setMilitaryStart("July", "2011");
        demographicInformationPage.setMilitaryEnd("June", "2016");
        if(CONDUCT_QUESTIONS) //if the conduct questions are not present, throws an error
          try{
            demographicInformationPage.waitForConductInformation();
            demographicInformationPage.setEverExpelled();
            demographicInformationPage.setFelonyCharges();
            demographicInformationPage.setGuiltyPlea();
            demographicInformationPage.setRegisteredName();
          } catch(Exception e) {
            System.err.println("ERROR in Demographic Information Page: Conduct Questions not Present");
            CONDUCT_QUESTIONS = false; //sets to false so the test will not check for questions again
          }
        demographicInformationPage.submit();
        System.out.println("Demographic Information Page (Longest Route) Test Successful\n");
    }

    private void testScholarshipPageShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Scholarship Page (Shortest Route)");
        ScholarshipPage scholarshipPage = new ScholarshipPage(driver, wait);
        scholarshipPage.setSSN(Integer.toString(SSN));
        scholarshipPage.setActivities("Community activites");
        scholarshipPage.setAwards("Special honors");
        scholarshipPage.setRoles("Leadership roles");
        scholarshipPage.setDescendants(); //selects max number of descendants
        scholarshipPage.setEmployers(); //selects max number of employers
        scholarshipPage.setGeneral(); //selects max number of general questions
        scholarshipPage.submit();
        System.out.println("Scholarship Page (Shortest Route) Test Successful\n");
    }

    private void testScholarshipPageLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Scholarship Page (Longest Route)");
        ScholarshipPage scholarshipPage = new ScholarshipPage(driver, wait);
        scholarshipPage.skip();
        System.out.println("Scholarship Page (Longest Route) Test Successful\n");
    }

    private void testReviewPageShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Review Page (Shortest Route)");
        ReviewPage reviewPage = new ReviewPage(driver, wait);
        reviewPage.waitForPageLoad();
        reviewPage.getInfo();
        assertEquals("Counselor", reviewPage.getRelationship());
        assertEquals(Integer.toString(SSN), reviewPage.getSSN());
        assertEquals("Male", reviewPage.getGender());
        assertEquals(firstName + " Test", reviewPage.getName());
        assertEquals("01/01/96", reviewPage.getDOB());
        assertEquals("United States", reviewPage.getCountryOfBirth());
        assertEquals("Manhattan", reviewPage.getCityOfBirth());
        assertEquals("1234567890", reviewPage.getPhoneNumber());
        assertEquals(firstName+"Test@ksu.edu", reviewPage.getEmail());
        assertEquals("Yes", reviewPage.getUSCitizen());
        assertEquals("Yes", reviewPage.getKansasResident());
        assertEquals("United States", reviewPage.getMailingCountry());
        assertEquals("RL", reviewPage.getMailingCounty());
        assertEquals("123 Manhattan Ave", reviewPage.getMailingAddress());
        assertEquals("Manhattan KS, 66502", reviewPage.getMailingCity());
        assertEquals("Father", reviewPage.getFamilyRelationship(SHORTEST));
        assertEquals("John Doe", reviewPage.getFamilyName(SHORTEST));
        assertEquals("United States", reviewPage.getHighSchoolCountry(SHORTEST));
        assertEquals("GED", reviewPage.getHighSchoolType());
        assertEquals("May 2016", reviewPage.getGradDate(SHORTEST));
        assertEquals("I am a descendant of Gertrude Ely/Edward William Bergmann", reviewPage.getDescendant1(CONDUCT_QUESTIONS));
        assertEquals("I am a descendant of Dr. and Mrs. Fredrick E. Emery", reviewPage.getDescendant2(CONDUCT_QUESTIONS));
        assertEquals("I am a descendant of Ira H. Graham", reviewPage.getDescendant3(CONDUCT_QUESTIONS));
        assertEquals("I am a descendant of William and Melissa Harold", reviewPage.getDescendant4(CONDUCT_QUESTIONS));
        assertEquals("I am a descendant of Gladys M. Heywood", reviewPage.getDescendant5(CONDUCT_QUESTIONS));
        assertEquals("I am a descendant of James B. and L. Roxie Hollinger", reviewPage.getDescendant6(CONDUCT_QUESTIONS));
        assertEquals("My parents are employed by J. H. Bowman Co", reviewPage.getEmployer1(CONDUCT_QUESTIONS));
        assertEquals("My parents are employed by Kice Metal Products", reviewPage.getEmployer2(CONDUCT_QUESTIONS));
        assertEquals("My parents are employed by L & S Machine, Tru-Circle Manufacturing or Hospice of Wichita (parents or grandparents)", reviewPage.getEmployer3(CONDUCT_QUESTIONS));
        assertEquals("  I am currently enrolled in the College of Business and I am interested in working for an Agribusiness Company", reviewPage.getGeneral1(CONDUCT_QUESTIONS));
        assertEquals("  I am or have been a member of FFA", reviewPage.getGeneral2(CONDUCT_QUESTIONS));
        assertEquals("  I am/will be enrolled in the College of Technology and Aviation and am a Schwan employee", reviewPage.getGeneral3(CONDUCT_QUESTIONS));
        assertEquals("  I am a student with an interest in pursuing a career in agribusiness (i.e. farm input supply, food processing, or marketing and distribution)", reviewPage.getGeneral4(CONDUCT_QUESTIONS));
        assertEquals("  I will be employed at least part time throughout the school year and be a full time student.", reviewPage.getGeneral5(CONDUCT_QUESTIONS));
        assertEquals("  I am a single parent.", reviewPage.getGeneral6(CONDUCT_QUESTIONS));
        assertEquals("  I am, or have a family member that is, a member of the American Society of Baking.", reviewPage.getGeneral7(CONDUCT_QUESTIONS));
        assertEquals("  I am from the Dallas/Fort Worth, Texas area.", reviewPage.getGeneral8(CONDUCT_QUESTIONS));
        assertEquals("  I have lost one or both of my parents.", reviewPage.getGeneral9(CONDUCT_QUESTIONS));
        assertEquals("  I have participated on a US FIRST Robotics Team at my high school", reviewPage.getGeneral10(CONDUCT_QUESTIONS));
        assertEquals("  I am a student in the College of Agriculture interested in Dairy.", reviewPage.getGeneral11(CONDUCT_QUESTIONS));
        System.out.println("Review Page (Shortest Route) Test Successful\n");
    }

    private void testReviewPageLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Review Page (Longest Route)");
        ReviewPage reviewPage = new ReviewPage(driver, wait);
        reviewPage.waitForPageLoad();
        reviewPage.getInfo();
        assertEquals("Parent/Guardian", reviewPage.getRelationship());
        assertEquals("Male", reviewPage.getGender());
        assertEquals(firstName + " Test", reviewPage.getName());
        assertEquals("01/01/96", reviewPage.getDOB());
        assertEquals("Afghanistan", reviewPage.getCountryOfBirth());
        assertEquals("Kabul", reviewPage.getCityOfBirth());
        assertEquals("1234567890", reviewPage.getPhoneNumber());
        assertEquals(firstName+"Test@ksu.edu", reviewPage.getEmail());
        assertEquals("No", reviewPage.getUSCitizen());
        assertEquals("No", reviewPage.getPermanentResident());
        assertEquals("Yes", reviewPage.getInternationalStudent());
        assertEquals("AFG", reviewPage.getCountryOfCitizenship());
        assertEquals("Student (F1)", reviewPage.getVisaType());
        assertEquals("Afghanistan", reviewPage.getPermanentAddressCountry());
        assertEquals("سرک 60 متره میدان هوایی", reviewPage.getPermanentAddress());
        assertEquals("Kabul", reviewPage.getPermanentAddressCity());
        assertEquals("Father", reviewPage.getFamilyRelationship(LONGEST));
        assertEquals("John Doe", reviewPage.getFamilyName(LONGEST));
        assertEquals("England", reviewPage.getHighSchoolCountry(LONGEST));
        assertEquals("Appleton Thorn Primary School", reviewPage.getHighSchool());
        assertEquals("May 2016", reviewPage.getGradDate(LONGEST));
        assertEquals("Yes", reviewPage.getPreviouslyAttendedKState());
        assertEquals("England", reviewPage.getPreviousCollegeCountry());
        assertEquals("King's College", reviewPage.getPreviousCollege());
        assertEquals("15.0", reviewPage.getPreviousCreditHours());
        assertEquals("January 2016 to May 2016", reviewPage.getDatesOfAttendance());
        assertEquals("Yes", reviewPage.getActiveMilitary());
        assertEquals("Jul 2011 to Jun 2016", reviewPage.getDatesOfService());
        System.out.println("Review Page (Longest Route) Test Successful\n");
    }

    private void testReviewPageWithSelfReporting(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Review Page (Self Reporting)");
        ReviewPage reviewPage = new ReviewPage(driver, wait);
        reviewPage.waitForPageLoad();
        reviewPage.getInfo();
        assertEquals("Counselor", reviewPage.getRelationship());
        assertEquals(Integer.toString(SSN), reviewPage.getSSN());
        assertEquals("Male", reviewPage.getGender());
        assertEquals(firstName + " Test", reviewPage.getName());
        assertEquals("01/01/96", reviewPage.getDOB());
        assertEquals("United States", reviewPage.getCountryOfBirth());
        assertEquals("Manhattan", reviewPage.getCityOfBirth());
        assertEquals("1234567890", reviewPage.getPhoneNumber());
        assertEquals(firstName+"Test@ksu.edu", reviewPage.getEmail());
        assertEquals("Yes", reviewPage.getUSCitizen());
        assertEquals("Yes", reviewPage.getKansasResident());
        assertEquals("United States", reviewPage.getMailingCountry());
        assertEquals("RL", reviewPage.getMailingCounty());
        assertEquals("123 Manhattan Ave", reviewPage.getMailingAddress());
        assertEquals("Manhattan KS, 66502", reviewPage.getMailingCity());
        assertEquals("Father", reviewPage.getFamilyRelationship(SHORTEST));
        assertEquals("John Doe", reviewPage.getFamilyName(SHORTEST));
        assertEquals("United States", reviewPage.getHighSchoolCountry(SHORTEST));
        assertEquals("High school", reviewPage.getHighSchoolType());
        System.out.println("Review Page (Self Reporting) Test Successful\n");
    }

    @After
    public void tearDown() throws Exception{

       for(WebDriver driver : drivers)
           driver.quit();
    }
}
