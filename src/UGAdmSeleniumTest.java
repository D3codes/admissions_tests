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
//    @Test
//    public void testShortestRoute() throws Exception{
//        System.out.println("Testing Undergrad Admissions Shortest Route");
//        try{
//            for(int i = 0; i < drivers.size(); i++){
//                drivers.get(i).get(baseURL);
//                testPageOne(drivers.get(i), true);
//                testLoginPage(drivers.get(i));
//                testPersonalInformationPageShortest(drivers.get(i));
//                testAddressInformationShortest(drivers.get(i));
//                testEducationInformationPageShortest(drivers.get(i));
//                testDemographicInformationPageShortest(drivers.get(i));
//                testScholarshipPageShortest(drivers.get(i));
//            }
//        } catch(Exception e) {
//            System.err.println("ERROR in test script: Undergrad Admissions Shortest Route\n"+e);
//        }
//    }

    /**
     * Test longest route end to end
     */
    @Test
    public void testLongestRoute() throws Exception{
        System.out.println("Testing Undergrad Admissions Longest Route");
        try{
            for(int i = 0; i < drivers.size(); i++){
                drivers.get(i).get(baseURL);
                testPageOne(drivers.get(i), false);
                testCreateEID(drivers.get(i));
                testRegisterEID(drivers.get(i));
                testChooseEID(drivers.get(i));
                testChoosePassword(drivers.get(i));
                testSecurityQuestions(drivers.get(i));
                testReviewPage(drivers.get(i));
            }
        } catch(Exception e){
            System.err.println("ERROR in test script: Undergrad Admissions Longest Route");
            System.err.println("ERROR in eprofile");
            System.err.println(e);
        }

        try{
            for(WebDriver driver : drivers){
                driver.get(baseURL);
                testPageOne(driver, true);
                testLoginPage(driver);

            }

        } catch(Exception e) {
            System.err.println("ERROR in test script: Undergrad Admissions Longest Route");
            System.err.println(e);
        }
    }

    private void testPageOne(WebDriver driver, Boolean hasEID){
        System.out.println("Testing Page One");
        AdmissionsPageOne admissionsPageOne = new AdmissionsPageOne(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        admissionsPageOne.waitForPageLoad(wait);
        if(hasEID)
            admissionsPageOne.hasID();
        else
            admissionsPageOne.noID();

        admissionsPageOne.submit();
        System.out.println("Page One Test Successful");
    }

    private void testCreateEID(WebDriver driver){
        System.out.println("Testing CreateEID Page (Name, Birthday, Email)");
        CreateEID createEID = new CreateEID(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        createEID.waitForPageLoad(wait);
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

    private void testRegisterEID(WebDriver driver){
        System.out.println("Testing RegisterEID Page (Phone Number, Address)");
        RegisterEID registerEID = new RegisterEID(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        registerEID.waitForPageLoad(wait);
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

    private void testChooseEID(WebDriver driver){
        System.out.println("Testing ChooseEID Page");
        ChooseEID chooseEID = new ChooseEID(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        chooseEID.waitForPageLoad(wait);
        chooseEID.selectCustomEID();
        chooseEID.setCustomEID("testuser13");
        chooseEID.submit();
        System.out.println("ChooseEID Page Test Successful");
    }

    private void testChoosePassword(WebDriver driver){
        System.out.println("Testing ChoosePassword Page");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        ChoosePassword choosePassword = new ChoosePassword(driver);
        choosePassword.waitForPageLoad(wait);
        choosePassword.setPassword("1234567Ab!");
        choosePassword.checkPassValidation(wait);
        choosePassword.setConfirmPassword("7654321Ab!");
        choosePassword.checkFailValidation(wait);
        choosePassword.submit();
        assertEquals("Password entries do not match.", choosePassword.getAlertMessage());
        choosePassword.setPassword("1234567Ab!");
        choosePassword.checkPassValidation(wait);
        choosePassword.setConfirmPassword("1234567Ab!");
        choosePassword.checkMatchValidation(wait);
        choosePassword.submit();
        System.out.println("ChoosePassword Page Test Successful");
    }

    private void testSecurityQuestions(WebDriver driver){
        System.out.println("Testing SecurityQuestions Page");
        SecurityQuestions securityQuestions = new SecurityQuestions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        securityQuestions.waitForPageLoad(wait);
        securityQuestions.setQuestion("Is this a test?");
        securityQuestions.submit();
        assertEquals("You must enter Securtiy Answer.", securityQuestions.getAlertMessage());
        securityQuestions.setAnswer("yes");
        securityQuestions.submit();
        System.out.println("SecurityQuestions Page Test Successful");
    }

    private void testReviewPage(WebDriver driver){
        System.out.println("Testing ReviewPage");
        ReviewPage reviewPage = new ReviewPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        reviewPage.waitForPageLoad(wait);
        reviewPage.finish();
        assertEquals("Success!", reviewPage.getAlertMessage());
        System.out.println("ReviewPage Test Successful");
    }

    private void testLoginPage(WebDriver driver){
        System.out.println("Testing Login Page");
        LoginPage loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        loginPage.waitForPageLoad(wait);
        loginPage.setEID("dmeierer");
        loginPage.setPassword("23Rt^JHS88");
        loginPage.submit();
        System.out.println("Login Page Test Successful");
    }

    private void testPersonalInformationPageShortest(WebDriver driver){
        System.out.println("Testing Personal Information Page (Shortest Route)");
        PersonalInformationPageShortest pips = new PersonalInformationPageShortest(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        pips.waitForPageLoad(wait);
        pips.setTerm();
        pips.setDataForOther();
        pips.waitForRelationship(wait);
        pips.setRelationship();
        pips.setGender();
        pips.setFirstName(firstName);
        pips.setLastName("Test");
        pips.setAdditionalNames();
        pips.setBirthDate("January","1","1996");
        pips.setBirthCountry("United States");
        pips.setBirthPlace("Manhattan");
        pips.setPhoneNumber("1234567890");
        pips.setEmailAddress("test@ksu.edu");
        pips.setConfirmEmail("test@ksu.edu");
        pips.setUsCitizen();
        pips.waitForKsResident(wait);
        pips.setKsResident();
        pips.waitForInKsSinceBirth(wait);
        pips.setInKsSinceBirth();
        pips.setParentsKsResident();
        pips.submit();
        System.out.println("Personal Information Page (Shortest Route) Test Successful");
    }

    private void testAddressInformationShortest(WebDriver driver){
        System.out.println("Testing Address Information Page (Shortest Route)");
        AddressInformationPageShortest aips = new AddressInformationPageShortest(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        aips.waitForPageLoad(wait);
        aips.setCountry();
        aips.waitForAddress(wait);
        aips.setAddress("123 Manhattan Ave");
        aips.setCity("Manhattan");
        aips.setState();
        aips.setZipCode("66502");
        aips.waitForCounty(wait);
        aips.setCounty("Riley");
        aips.setSameAddress();
        aips.setRelationship();
        aips.setContactFirstName("John");
        aips.setContactLastName("Doe");
        aips.setAddAnotherRelationship();
        aips.submit();
        System.out.println("Address Information Page (Shortest Route) Test Successful");
    }

    private void testEducationInformationPageShortest(WebDriver driver){
        System.out.println("Testing Education Information Page (Shortest Route)");
        EducationInformationPageShortest eips = new EducationInformationPageShortest(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        eips.waitForPageLoad(wait);
        eips.setHighSchoolCountry("United States");
        eips.setSchoolType();
        eips.setPlannedGraduationMonth();
        eips.setPlannedGraduationYear();
        eips.setPreviouslyAttendedKSU();
        eips.setPreviouslyTakenClasses();
        eips.waitForCompleteDegree(wait);
        eips.setCompleteDegree();
        eips.waitForCompleteDegreeAtKSU(wait);
        eips.setCompleteDegreeAtKSU();
        eips.setKsuLocation();
        eips.setMajor();
        eips.submit();
        System.out.println("Education Information Page (Shortest Route) Test Successful");
    }

    private void testDemographicInformationPageShortest(WebDriver driver){
        System.out.println("Testing Demographic Information Page (Shortest Route)");
        DemographicInformationPageShortest dips = new DemographicInformationPageShortest(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        dips.waitForPageLoad(wait);
        dips.setPrimaryLanguage();
        dips.setOtherLanguage();
        dips.submit();
        System.out.println("Demographic Information Page (Shortest Route) Test Successful");
    }

    private void testScholarshipPageShortest(WebDriver driver){
        System.out.println("Testing Scholarship Page (Shortest Route)");
        ScholarshipPageShortest sps = new ScholarshipPageShortest(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        sps.waitForPageLoad(wait);
        sps.setSSN(Integer.toString(SSN));
        sps.submit();
        System.out.println("Scholarship Page (Shortest Route) Test Successful");
    }

    @After
    public void tearDown() throws Exception{

    }
}
