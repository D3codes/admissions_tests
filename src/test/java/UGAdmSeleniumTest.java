import edu.ksu.admissions.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

    @Before
    public void setUp() throws Exception{

        try{
            System.out.println("Setting up Drivers");
            drivers = new ArrayList<WebDriver>();
            fireFox = new FirefoxDriver();
            if(System.getProperty("os.name").equals("Mac OS X")) {
                safari = new SafariDriver();
                drivers.add(safari);
                System.setProperty("webdriver.chrome.driver", "src/main/resources/mac/chromedriver");
            } else if(System.getProperty("os.name").startsWith("Windows")){
                System.setProperty("webdriver.chrome.driver", "src/main/resources/windows/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/linux/chromedriver");
            }
            chrome = new ChromeDriver();
            drivers.add(fireFox);
            drivers.add(chrome);
        }catch(Exception e){
            System.err.println("ERROR setting up Drivers");
            System.err.println(e);
        }
        baseURL = "https://admissions.test.ome.k-state.edu/app/open/ChooseTerm_open.action";
        Random random = new Random();
        SSN = random.nextInt(SSN_MAX - SSN_MIN + 1) + SSN_MIN;
        ReadIn in = new ReadIn();
        names = in.readFile("src/main/resources/names.txt");
        firstName = names.get(random.nextInt(names.size()));
    }

    /**
     * Test shortest route end to end
     */
    @Test
    public void testShortestRoute() throws Exception{
        System.out.println("Testing Undergrad Admissions Shortest Route");
        for(WebDriver driver : drivers){
            try {
                WebDriverWait wait = new WebDriverWait(driver, 20);
                driver.get(baseURL);
                testPageOne(driver, wait, true);
                testLoginPage(driver, wait);
                testPersonalInformationPageShortest(driver, wait);
                testAddressInformationShortest(driver, wait);
                testEducationInformationPageShortest(driver, wait);
                testDemographicInformationPageShortest(driver, wait);
                testScholarshipPageShortest(driver, wait);
                testReviewPageShortest(driver, wait);
            } catch(Exception e){
                System.err.println("ERROR in test script: Undergrad Admissions Shortest Route");
                String driverType = "Safari Driver";
                if(driver instanceof FirefoxDriver) { driverType = "Firefox Driver"; }
                else if(driver instanceof ChromeDriver) { driverType = "Chrome Driver"; }
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
        System.out.println("Testing Undergrad Admissions Longest Route");
        for(WebDriver driver : drivers){
            try {
                WebDriverWait wait = new WebDriverWait(driver, 20);
                driver.get(baseURL);
                testPageOne(driver, wait, true);
                testLoginPage(driver, wait);
                testPersonalInformationPageLongest(driver, wait);
                testAddressInformationLongest(driver, wait);
                testEducationInformationPageLongest(driver, wait);
                testDemographicInformationPageLongest(driver, wait);
                testScholarshipPageLongest(driver, wait);
                testReviewPageLongest(driver, wait);
            } catch(Exception e) {
                System.err.println("ERROR in test script: Undergrad Admissions Longest Route");
                String driverType = "Safari Driver";
                if(driver instanceof FirefoxDriver){ driverType = "Firefox Driver"; }
                else if(driver instanceof ChromeDriver) { driverType = "Chrome Driver"; }
                System.err.println("ERROR in " + driverType);
                System.err.println(e);
            }
        }
    }

    private void testPageOne(WebDriver driver, WebDriverWait wait, Boolean hasEID){
        System.out.println("Testing Page One");
        AdmissionsPageOne admissionsPageOne = new AdmissionsPageOne(driver, wait);
        admissionsPageOne.waitForPageLoad();
        if(hasEID)
            admissionsPageOne.hasID();
        else
            admissionsPageOne.noID();

        admissionsPageOne.submit();
        System.out.println("Page One Test Successful");
    }

    private void testLoginPage(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Login Page");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.waitForPageLoad();
        loginPage.setEID("dmeierer");
        loginPage.setPassword("23Rt^JHS88");
        loginPage.submit();
        System.out.println("Login Page Test Successful");
    }

    private void testPersonalInformationPageShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Personal Information Page (Shortest Route)");
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver, wait);
        personalInformationPage.waitForPageLoad();
        personalInformationPage.setTerm();
        personalInformationPage.setDataForOther();
        personalInformationPage.waitForRelationship();
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
        personalInformationPage.waitForKsResident();
        personalInformationPage.setKsResident();
        personalInformationPage.waitForInKsSinceBirth();
        personalInformationPage.setInKsSinceBirth();
        personalInformationPage.setParentsKsResident();
        personalInformationPage.submit();
        System.out.println("Personal Information Page (Shortest Route) Test Successful");
    }

    private void testPersonalInformationPageLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Personal Information Page (Longest Route)");
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver, wait);
        personalInformationPage.waitForPageLoad();
        personalInformationPage.setTerm();
        personalInformationPage.setDataForOther();
        personalInformationPage.waitForRelationship();
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
        personalInformationPage.waitForPermanentResident();
        personalInformationPage.setPermanentResident();
        personalInformationPage.waitForInternationalStudent();
        personalInformationPage.setInternationalStudent();
        personalInformationPage.waitForCountryOfCitizenship();
        personalInformationPage.setCountryOfCitizenship("Afghanistan");
        personalInformationPage.setCurrentVisa();
        personalInformationPage.waitForVisaType();
        personalInformationPage.setVisaType();
        personalInformationPage.setRequestingVisa();
        personalInformationPage.submit();
        System.out.println("Personal Information Page (Longest Route) Test Successful");
    }

    private void testAddressInformationShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Address Information Page (Shortest Route)");
        AddressInformationPage addressInformationPage = new AddressInformationPage(driver, wait);
        addressInformationPage.waitForPageLoad();
        addressInformationPage.setCountryUS();
        addressInformationPage.waitForAddress();
        addressInformationPage.setAddress("123 Manhattan Ave");
        addressInformationPage.setCity("Manhattan");
        addressInformationPage.setState();
        addressInformationPage.setZipCode("66502");
        addressInformationPage.waitForCounty();
        addressInformationPage.setCounty("Riley");
        addressInformationPage.setSameAddress();
        addressInformationPage.setRelationship();
        addressInformationPage.setContactFirstName("John");
        addressInformationPage.setContactLastName("Doe");
        addressInformationPage.setAddAnotherRelationship();
        addressInformationPage.submit();
        System.out.println("Address Information Page (Shortest Route) Test Successful");
    }

    private void testAddressInformationLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Address Information Page (Longest Route)");
        AddressInformationPage addressInformationPage = new AddressInformationPage(driver, wait);
        addressInformationPage.waitForPageLoad();
        addressInformationPage.setCountryAFG();
        addressInformationPage.waitForAddress();
        addressInformationPage.setAddress("سرک 60 متره میدان هوایی‎");
        addressInformationPage.setCity("Kabul");
        addressInformationPage.setSameMailingAddress();
        addressInformationPage.setSameAddress();
        addressInformationPage.setRelationship();
        addressInformationPage.setContactFirstName("John");
        addressInformationPage.setContactLastName("Doe");
        addressInformationPage.setAddAnotherRelationship();
        addressInformationPage.submit();
        System.out.println("Address Information Page (Longest Route) Test Successful");
    }

    private void testEducationInformationPageShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Education Information Page (Shortest Route)");
        EducationInformationPage educationInformationPage = new EducationInformationPage(driver, wait);
        educationInformationPage.waitForPageLoad();
        educationInformationPage.setHighSchoolCountry("United States");
        educationInformationPage.setSchoolType();
        educationInformationPage.setPlannedGraduationMonth();
        educationInformationPage.setPlannedGraduationYear();
        educationInformationPage.setPreviouslyAttendedKSUfalse();
        educationInformationPage.setPreviouslyTakenClassesfalse();
        educationInformationPage.waitForCompleteDegree();
        educationInformationPage.setCompleteDegreetrue();
        educationInformationPage.waitForCompleteDegreeAtKSU();
        educationInformationPage.setCompleteDegreeAtKSU();
        educationInformationPage.setKsuLocationMAN();
        educationInformationPage.setMajor();
        educationInformationPage.submit();
        System.out.println("Education Information Page (Shortest Route) Test Successful");
    }

    private void testEducationInformationPageLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Education Information Page (Longest Route)");
        EducationInformationPage educationInformationPage = new EducationInformationPage(driver, wait);
        educationInformationPage.waitForPageLoad();
        educationInformationPage.setHighSchoolCountry("England");
        educationInformationPage.waitForHighSchool();
        educationInformationPage.setHighSchool("Appleton Thorn Primary School");
        educationInformationPage.setPlannedGraduationMonth();
        educationInformationPage.setPlannedGraduationYear();
        educationInformationPage.setPreviouslyAttendedKSUtrue();
        educationInformationPage.setPreviouslyTakenClassestrue();
        educationInformationPage.waitForCollegeCountry();
        educationInformationPage.setCollegeCountry("England");
        educationInformationPage.waitForCollegeName();
        educationInformationPage.setCollegeName("King's College");
        educationInformationPage.setCreditHours("15");
        educationInformationPage.setAttendanceMonthStart("January");
        educationInformationPage.setAttendanceYearStart("2016");
        educationInformationPage.setAttendanceMontEnd("May");
        educationInformationPage.setAttendanceYearEnd("2016");
        educationInformationPage.setOfficialTranscript();
        educationInformationPage.setCompleteDegreefalse();
        educationInformationPage.waitForMinor();
        educationInformationPage.setMinorTrue();
        educationInformationPage.waitForBaccalaureate();
        educationInformationPage.setBaccalaureate();
        educationInformationPage.setKsuLocationDL();
        educationInformationPage.setMinor();
        educationInformationPage.submit();
        System.out.println("Testing Education Information Page (Longest Route) Test Sucessful");
    }

    private void testDemographicInformationPageShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Demographic Information Page (Shortest Route)");
        DemographicInformationPage demographicInformationPage = new DemographicInformationPage(driver, wait);
        demographicInformationPage.waitForPageLoad();
        demographicInformationPage.setEnglishPrimarytrue();
        demographicInformationPage.setOtherLanguagefalse();
        demographicInformationPage.waitForConductInformation();
        demographicInformationPage.setEverExpelled();
        demographicInformationPage.setFelonyCharges();
        demographicInformationPage.setGuiltyPlea();
        demographicInformationPage.setRegisteredName();
        demographicInformationPage.submit();
        System.out.println("Demographic Information Page (Shortest Route) Test Successful");
    }

    private void testDemographicInformationPageLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Demographic Information Page (Longest Route)");
        DemographicInformationPage demographicInformationPage = new DemographicInformationPage(driver, wait);
        demographicInformationPage.waitForPageLoad();
        demographicInformationPage.setEnglishPrimarytrue();
        demographicInformationPage.setOtherLanguagefalse();
        demographicInformationPage.setParentsDegree();
        demographicInformationPage.setMilitary();
        demographicInformationPage.waitForMilitaryMonthStart();
        demographicInformationPage.setMilitaryStart("July", "2011");
        demographicInformationPage.setMilitaryEnd("June", "2016");
        demographicInformationPage.waitForConductInformation();
        demographicInformationPage.setEverExpelled();
        demographicInformationPage.setFelonyCharges();
        demographicInformationPage.setGuiltyPlea();
        demographicInformationPage.setRegisteredName();
        demographicInformationPage.submit();
        System.out.println("Demographic Information Page (Longest Route) Test Successful");
    }

    private void testScholarshipPageShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Scholarship Page (Shortest Route)");
        ScholarshipPage scholarshipPage = new ScholarshipPage(driver, wait);
        scholarshipPage.waitForPageLoad(SHORTEST);
        scholarshipPage.setSSN(Integer.toString(SSN));
        scholarshipPage.submit();
        System.out.println("Scholarship Page (Shortest Route) Test Successful");
    }

    private void testScholarshipPageLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Scholarship Page (Longest Route)");
        ScholarshipPage scholarshipPage = new ScholarshipPage(driver, wait);
        scholarshipPage.waitForPageLoad(LONGEST);
        scholarshipPage.skip();
        System.out.println("Scholarship Page (Longest Route) Test Successful");
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
        assertEquals("May 2017", reviewPage.getGradDate(SHORTEST));
        System.out.println("Review Page (Shortest Route) Test Successful");
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
        assertEquals("May 2017", reviewPage.getGradDate(LONGEST));
        assertEquals("Yes", reviewPage.getPreviouslyAttendedKState());
        assertEquals("England", reviewPage.getPreviousCollegeCountry());
        assertEquals("King's College", reviewPage.getPreviousCollege());
        assertEquals("15.0", reviewPage.getPreviousCreditHours());
        assertEquals("January 2016 to May 2016", reviewPage.getDatesOfAttendance());
        assertEquals("Yes", reviewPage.getActiveMilitary());
        assertEquals("Jul 2011 to Jun 2016", reviewPage.getDatesOfService());
        System.out.println("Review Page (Longest Route) Test Successful");
    }

    @After
    public void tearDown() throws Exception{

        for(WebDriver driver : drivers)
            driver.quit();
    }
}