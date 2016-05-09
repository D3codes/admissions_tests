import edu.ksu.admissions.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by davidfreeman on 4/22/16.
 */
public class UGAdmSeleniumTest {

    private String baseURL;
    private WebDriver fireFox;
    private WebDriver chrome;
    private WebDriver safari;
    private List<WebDriver> drivers;
    private static final String alphaChars = "abcdefghijklmnopqrstuvwxyz";
    private String firstName;
    private static final int SSN_MAX = 999999999;
    private static final int SSN_MIN = 100000000;
    private int SSN;

    @Before
    public void setUp() throws Exception{

        try{
            System.out.println("Setting up Drivers");
            drivers = new ArrayList<WebDriver>();
            fireFox = new FirefoxDriver();
            if(System.getProperty("os.name").equals("Mac OS X")) {
                safari = new SafariDriver();
                drivers.add(safari);
                System.setProperty("webdriver.chrome.driver", "src/mac/chromedriver");
            } else if(System.getProperty("os.name").startsWith("Windows")){
                System.setProperty("webdriver.chrome.driver", "src/windows/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "src/linux/chromedriver");
            }
            chrome = new ChromeDriver();
            drivers.add(fireFox);
            drivers.add(chrome);

        }catch(Exception e){
            System.out.println("ERROR setting up Drivers");
            System.err.println(e);
        }
        baseURL = "https://admissions.test.ome.k-state.edu/app/open/ChooseTerm_open.action";
        Random random = new Random();
        SSN = random.nextInt(SSN_MAX - SSN_MIN + 1) + SSN_MIN;
        firstName = "";
        int nameLength = random.nextInt(20 - 3 + 1) + 3;
        for(int i = 0; i < nameLength; i++){
            if(i == 0){
                firstName += Character.toUpperCase(alphaChars.charAt(random.nextInt(alphaChars.length())));
            } else {
                firstName += alphaChars.charAt(random.nextInt(alphaChars.length()));
            }
        }
    }

    /**
     * Test shortest route end to end
     */
    @Test
    public void testShortestRoute() throws Exception{
        System.out.println("Testing Undergrad Admissions Shortest Route");
        try{
            for(WebDriver driver : drivers){
                WebDriverWait wait = new WebDriverWait(driver, 20);
                driver.get(baseURL);
                testPageOne(driver, wait, true);
                testLoginPage(driver, wait);
                testPersonalInformationPageShortest(driver, wait);
                testAddressInformationShortest(driver, wait);
                testEducationInformationPageShortest(driver, wait);
                testDemographicInformationPageShortest(driver, wait);
                testScholarshipPageShortest(driver, wait);
            }
        } catch(Exception e) {
            System.err.println("ERROR in test script: Undergrad Admissions Shortest Route\n"+e);
        }
    }

    /**
     * Test longest route end to end
     */
    @Test
    public void testLongestRoute() throws Exception{
        System.out.println("Testing Undergrad Admissions Longest Route");
//        try{
//            for(WebDriver driver : drivers){
//                WebDriverWait wait = new WebDriverWait(driver, 20);
//                driver.get(baseURL);
//                testPageOne(driver, wait, false);
//                testCreateEID(driver, wait);
//                testRegisterEID(driver, wait);
//                testChooseEID(driver, wait);
//                testChoosePassword(driver, wait);
//                testSecurityQuestions(driver, wait);
//                testReviewPage(driver, wait);
//            }
//        } catch(Exception e){
//            System.err.println("ERROR in test script: Undergrad Admissions Longest Route");
//            System.err.println("ERROR in eprofile");
//            System.err.println(e);
//        }

        try{
            for(WebDriver driver : drivers){
                WebDriverWait wait = new WebDriverWait(driver, 20);
                driver.get(baseURL);
                testPageOne(driver, wait, true);
                testLoginPage(driver, wait);
                testPersonalInformationPageLongest(driver, wait);
                testAddressInformationLongest(driver, wait);
                testEducationInformationPageLongest(driver, wait);
                testDemographicInformationPageLongest(driver, wait);
                testScholarshipPageLongest(driver, wait);
            }

        } catch(Exception e) {
            System.err.println("ERROR in test script: Undergrad Admissions Longest Route");
            System.err.println(e);
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

    private void testCreateEID(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing CreateEID Page (Name, Birthday, Email)");
        CreateEID createEID = new CreateEID(driver, wait);
        createEID.waitForPageLoad();
        createEID.setFirstName(firstName);
        createEID.setLastName("Test");
        createEID.setBirthDate("1", "January", "1996");
        createEID.setGender();
//        createEID.submit();
//        assertEquals("You must enter an Email address.", createEID.getAlertMessage());
        createEID.setEmail("testEmail@ksu.edu");
//        createEID.clearFirstName();
//        createEID.submit();
//        assertEquals("You must enter First name.", createEID.getAlertMessage());
//        createEID.setFirstName(firstName);
        createEID.submit();
        System.out.println("CreateEID Page Test Successful");
    }

    private void testRegisterEID(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing RegisterEID Page (Phone Number, Address)");
        RegisterEID registerEID = new RegisterEID(driver, wait);
        registerEID.waitForPageLoad();
        registerEID.setPhoneNumber("1234567890");
        registerEID.clearAddress();
        registerEID.setCity("Manhattan");
        registerEID.setState("Kansas");
        registerEID.setZipCode("66502");
//        registerEID.submit();
//        assertEquals("You must enter Address line 1.", registerEID.getAlertMessage());
        registerEID.setAddress("123 Manhattan Ave. #4");
//        registerEID.clearZipCode();
//        registerEID.submit();
//        assertEquals("You must enter ZIP/Postal code.", registerEID.getAlertMessage());
//        registerEID.setZipCode("66502");
        registerEID.submit();
        System.out.println("RegisterEID Page Test Successful");
    }

    private void testChooseEID(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing ChooseEID Page");
        ChooseEID chooseEID = new ChooseEID(driver, wait);
        chooseEID.waitForPageLoad();
        chooseEID.selectCustomEID();
        chooseEID.setCustomEID("testuser13");
        chooseEID.submit();
        System.out.println("ChooseEID Page Test Successful");
    }

    private void testChoosePassword(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing ChoosePassword Page");
        ChoosePassword choosePassword = new ChoosePassword(driver, wait);
        choosePassword.waitForPageLoad();
        choosePassword.setPassword("1234567Ab!");
        choosePassword.checkPassValidation();
        choosePassword.setConfirmPassword("7654321Ab!");
        choosePassword.checkFailValidation();
        choosePassword.submit();
        assertEquals("Password entries do not match.", choosePassword.getAlertMessage());
        choosePassword.setPassword("1234567Ab!");
        choosePassword.checkPassValidation();
        choosePassword.setConfirmPassword("1234567Ab!");
        choosePassword.checkMatchValidation();
        choosePassword.submit();
        System.out.println("ChoosePassword Page Test Successful");
    }

    private void testSecurityQuestions(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing SecurityQuestions Page");
        SecurityQuestions securityQuestions = new SecurityQuestions(driver, wait);
        securityQuestions.waitForPageLoad();
        securityQuestions.setQuestion("Is this a test?");
        securityQuestions.submit();
        assertEquals("You must enter Securtiy Answer.", securityQuestions.getAlertMessage());
        securityQuestions.setAnswer("yes");
        securityQuestions.submit();
        System.out.println("SecurityQuestions Page Test Successful");
    }

    private void testReviewPage(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing ReviewPage");
        ReviewPage reviewPage = new ReviewPage(driver, wait);
        reviewPage.waitForPageLoad();
        reviewPage.finish();
        assertEquals("Success!", reviewPage.getAlertMessage());
        System.out.println("ReviewPage Test Successful");
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
        PersonalInformationPageShortest pips = new PersonalInformationPageShortest(driver, wait);
        pips.waitForPageLoad();
        pips.setTerm();
        pips.setDataForOther();
        pips.waitForRelationship();
        pips.setRelationship();
        pips.setGender();
        pips.setFirstName(firstName);
        pips.setLastName("Test");
        pips.setAdditionalNames();
        pips.setBirthDate("January","1","1996");
        pips.setBirthCountry("United States");
        pips.setBirthPlace("Manhattan");
        pips.setPhoneNumber("1234567890");
        pips.setEmailAddress(firstName+"Test@ksu.edu");
        pips.setConfirmEmail(firstName+"Test@ksu.edu");
        pips.setUsCitizen();
        pips.waitForKsResident();
        pips.setKsResident();
        pips.waitForInKsSinceBirth();
        pips.setInKsSinceBirth();
        pips.setParentsKsResident();
        pips.submit();
        System.out.println("Personal Information Page (Shortest Route) Test Successful");
    }

    private void testPersonalInformationPageLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Personal Information Page (Longest Route)");
        PersonalInformationPageLongest pipl = new PersonalInformationPageLongest(driver, wait);
        pipl.waitForPageLoad();
        pipl.setTerm();
        pipl.setDataForOther();
        pipl.waitForRelationship();
        pipl.setRelationship();
        pipl.setGender();
        pipl.setFirstName(firstName);
        pipl.setLastName("Test");
        pipl.setAdditionalNames();
        pipl.setBirthDate("January", "1", "1996");
        pipl.setBirthCountry("Afghanistan");
        pipl.setBirthPlace("Kabul");
        pipl.setPhoneNumber("1234567890");
        pipl.setEmailAddress(firstName + "Test@ksu.edu");
        pipl.setConfirmEmail(firstName + "Test@ksu.edu");
        pipl.setUsCitizen();
        pipl.waitForPermanentResident();
        pipl.setPermanentResident();
        pipl.waitForInternationalStudent();
        pipl.setInternationalStudent();
        pipl.waitForCountryOfCitizenship();
        pipl.setCountryOfCitizenship("Afghanistan");
        pipl.setCurrentVisa();
        pipl.waitForVisaType();
        pipl.setVisaType();
        pipl.setRequestingVisa();
        pipl.submit();
        System.out.println("Personal Information Page (Longest Route) Test Successful");
    }

    private void testAddressInformationShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Address Information Page (Shortest Route)");
        AddressInformationPageShortest aips = new AddressInformationPageShortest(driver, wait);
        aips.waitForPageLoad();
        aips.setCountry();
        aips.waitForAddress();
        aips.setAddress("123 Manhattan Ave");
        aips.setCity("Manhattan");
        aips.setState();
        aips.setZipCode("66502");
        aips.waitForCounty();
        aips.setCounty("Riley");
        aips.setSameAddress();
        aips.setRelationship();
        aips.setContactFirstName("John");
        aips.setContactLastName("Doe");
        aips.setAddAnotherRelationship();
        aips.submit();
        System.out.println("Address Information Page (Shortest Route) Test Successful");
    }

    private void testAddressInformationLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Address Information Page (Longest Route)");
        AddressInformationPageLongest aipl = new AddressInformationPageLongest(driver, wait);
        aipl.waitForPageLoad();
        aipl.setCountry();
        aipl.waitForAddress();
        aipl.setAddress("سرک 60 متره میدان هوایی‎");
        aipl.setCity("Kabul");
        aipl.setSameMailingAddress();
        aipl.setSameAddress();
        aipl.setRelationship();
        aipl.setContactFirstName(firstName);
        aipl.setContactLastName("Test");
        aipl.setAddAnotherRelationship();
        aipl.submit();
        System.out.println("Address Information Page (Longest Route) Test Successful");
    }

    private void testEducationInformationPageShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Education Information Page (Shortest Route)");
        EducationInformationPageShortest eips = new EducationInformationPageShortest(driver, wait);
        eips.waitForPageLoad();
        eips.setHighSchoolCountry("United States");
        eips.setSchoolType();
        eips.setPlannedGraduationMonth();
        eips.setPlannedGraduationYear();
        eips.setPreviouslyAttendedKSU();
        eips.setPreviouslyTakenClasses();
        eips.waitForCompleteDegree();
        eips.setCompleteDegree();
        eips.waitForCompleteDegreeAtKSU();
        eips.setCompleteDegreeAtKSU();
        eips.setKsuLocation();
        eips.setMajor();
        eips.submit();
        System.out.println("Education Information Page (Shortest Route) Test Successful");
    }

    private void testEducationInformationPageLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Education Information Page (Longest Route)");
        EducationInformationPageLongest eipl = new EducationInformationPageLongest(driver, wait);
        eipl.waitForPageLoad();
        eipl.setHighSchoolCountry("England");
        eipl.waitForHighSchool();
        eipl.setHighSchool("Appleton Thorn Primary School");
        eipl.setPlannedGraduationMonth();
        eipl.setPlannedGraduationYear();
        eipl.setPreviouslyAttendedKSU();
        eipl.setPreviouslyTakenClasses();
        eipl.waitForCollegeCountry();
        eipl.setCollegeCountry("England");
        eipl.waitForCollegeName();
        eipl.setCollegeName("King's College");
        eipl.setCreditHours("15");
        eipl.setAttendanceMonthStart("January");
        eipl.setAttendanceYearStart("2016");
        eipl.setAttendanceMontEnd("May");
        eipl.setAttendanceYearEnd("2016");
        eipl.setOfficialTranscript();
        eipl.setCompleteDegree();
        eipl.waitForMinor();
        eipl.setMinor();
        eipl.waitForBaccalaureate();
        eipl.setBaccalaureate();
        eipl.setKsuLocation();
        eipl.setMajor();
        eipl.submit();
        System.out.println("Testing Education Information Page (Longest Route) Test Sucessful");
    }

    private void testDemographicInformationPageShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Demographic Information Page (Shortest Route)");
        DemographicInformationPageShortest dips = new DemographicInformationPageShortest(driver, wait);
        dips.waitForPageLoad();
        dips.setPrimaryLanguage();
        dips.setOtherLanguage();
        dips.submit();
        System.out.println("Demographic Information Page (Shortest Route) Test Successful");
    }

    private void testDemographicInformationPageLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Demographic Information Page (Longest Route)");
        DemographicInformationPageLongest dipl = new DemographicInformationPageLongest(driver, wait);
        dipl.waitForPageLoad();
        dipl.setPrimaryLanguage();
        dipl.setOtherLanguage();
        dipl.setParentsDegree();
        dipl.setMilitary();
        dipl.waitForMilitaryMonthStart();
        dipl.setMilitaryStart("July", "2011");
        dipl.setMilitaryEnd("June", "2016");
        dipl.submit();
        System.out.println("Demographic Information Page (Longest Route) Test Successful");
    }

    private void testScholarshipPageShortest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Scholarship Page (Shortest Route)");
        ScholarshipPageShortest sps = new ScholarshipPageShortest(driver, wait);
        sps.waitForPageLoad();
        sps.setSSN(Integer.toString(SSN));
        sps.submit();
        System.out.println("Scholarship Page (Shortest Route) Test Successful");
    }

    private void testScholarshipPageLongest(WebDriver driver, WebDriverWait wait){
        System.out.println("Testing Scholarship Page (Longest Route)");
        ScholarshipPageLongest spl = new ScholarshipPageLongest(driver, wait);
        spl.waitForPageLoad();
        spl.skip();
        System.out.println("Scholarship Page (Longest Route) Test Successful");
    }

    @After
    public void tearDown() throws Exception{

        for(WebDriver driver : drivers)
            driver.quit();
    }
}
