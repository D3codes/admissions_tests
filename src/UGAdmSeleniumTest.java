import edu.ksu.admissions.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by davidfreeman on 4/22/16.
 */
public class UGAdmSeleniumTest {

    private static final Logger LOG = Logger.getLogger(UGAdmSeleniumTest.class);

    private String baseURL;
    private WebDriver fireFox;
    private WebDriver chrome;
    private WebDriver safari;
    private List<WebDriver> drivers;
    private ArrayList<String> names;
    private String firstName;
    private static final int SSN_MAX = 999999999;
    private static final int SSN_MIN = 100000000;
    private int SSN;

    @Before
    public void setUp() throws Exception{

        try{
            LOG.info("Setting up Drivers");
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
            LOG.error("ERROR setting up Drivers");
            LOG.error(e);
        }
        baseURL = "https://admissions.test.ome.k-state.edu/app/open/ChooseTerm_open.action";
        Random random = new Random();
        SSN = random.nextInt(SSN_MAX - SSN_MIN + 1) + SSN_MIN;
        ReadIn in = new ReadIn();
        names = in.readFile("src/names.txt");
        firstName = names.get(random.nextInt(names.size()));
    }

    /**
     * Test shortest route end to end
     */
    @Test
    public void testShortestRoute() throws Exception{
        LOG.info("Testing Undergrad Admissions Shortest Route");
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
                testReviewPage(driver, wait);
            }
        } catch(Exception e) {
            LOG.error("ERROR in test script: Undergrad Admissions Shortest Route");
            LOG.error(e);
        }
    }

    /**
     * Test longest route end to end
     */
    @Test
    public void testLongestRoute() throws Exception{
        LOG.info("Testing Undergrad Admissions Longest Route");try{
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
                testReviewPage(driver, wait);
            }

        } catch(Exception e) {
            LOG.error("ERROR in test script: Undergrad Admissions Longest Route");
            LOG.error(e);
        }
    }

    private void testPageOne(WebDriver driver, WebDriverWait wait, Boolean hasEID){
        LOG.info("Testing Page One");
        AdmissionsPageOne admissionsPageOne = new AdmissionsPageOne(driver, wait);
        admissionsPageOne.waitForPageLoad();
        if(hasEID)
            admissionsPageOne.hasID();
        else
            admissionsPageOne.noID();

        admissionsPageOne.submit();
        LOG.info("Page One Test Successful");
    }

    private void testLoginPage(WebDriver driver, WebDriverWait wait){
        LOG.info("Testing Login Page");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.waitForPageLoad();
        loginPage.setEID("dmeierer");
        loginPage.setPassword("23Rt^JHS88");
        loginPage.submit();
        LOG.info("Login Page Test Successful");
    }

    private void testPersonalInformationPageShortest(WebDriver driver, WebDriverWait wait){
        LOG.info("Testing Personal Information Page (Shortest Route)");
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
        LOG.info("Personal Information Page (Shortest Route) Test Successful");
    }

    private void testPersonalInformationPageLongest(WebDriver driver, WebDriverWait wait){
        LOG.info("Testing Personal Information Page (Longest Route)");
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
        LOG.info("Personal Information Page (Longest Route) Test Successful");
    }

    private void testAddressInformationShortest(WebDriver driver, WebDriverWait wait){
        LOG.info("Testing Address Information Page (Shortest Route)");
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
        LOG.info("Address Information Page (Shortest Route) Test Successful");
    }

    private void testAddressInformationLongest(WebDriver driver, WebDriverWait wait){
        LOG.info("Testing Address Information Page (Longest Route)");
        AddressInformationPageLongest aipl = new AddressInformationPageLongest(driver, wait);
        aipl.waitForPageLoad();
        aipl.setCountry();
        aipl.waitForAddress();
        aipl.setAddress("سرک 60 متره میدان هوایی‎");
        aipl.setCity("Kabul");
        aipl.setSameMailingAddress();
        aipl.setSameAddress();
        aipl.setRelationship();
        aipl.setContactFirstName("John");
        aipl.setContactLastName("Doe");
        aipl.setAddAnotherRelationship();
        aipl.submit();
        LOG.info("Address Information Page (Longest Route) Test Successful");
    }

    private void testEducationInformationPageShortest(WebDriver driver, WebDriverWait wait){
        LOG.info("Testing Education Information Page (Shortest Route)");
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
        LOG.info("Education Information Page (Shortest Route) Test Successful");
    }

    private void testEducationInformationPageLongest(WebDriver driver, WebDriverWait wait){
        LOG.info("Testing Education Information Page (Longest Route)");
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
        LOG.info("Testing Education Information Page (Longest Route) Test Sucessful");
    }

    private void testDemographicInformationPageShortest(WebDriver driver, WebDriverWait wait){
        LOG.info("Testing Demographic Information Page (Shortest Route)");
        DemographicInformationPageShortest dips = new DemographicInformationPageShortest(driver, wait);
        dips.waitForPageLoad();
        dips.setPrimaryLanguage();
        dips.setOtherLanguage();
        dips.submit();
        LOG.info("Demographic Information Page (Shortest Route) Test Successful");
    }

    private void testDemographicInformationPageLongest(WebDriver driver, WebDriverWait wait){
        LOG.info("Testing Demographic Information Page (Longest Route)");
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
        LOG.info("Demographic Information Page (Longest Route) Test Successful");
    }

    private void testScholarshipPageShortest(WebDriver driver, WebDriverWait wait){
        LOG.info("Testing Scholarship Page (Shortest Route)");
        ScholarshipPageShortest sps = new ScholarshipPageShortest(driver, wait);
        sps.waitForPageLoad();
        sps.setSSN(Integer.toString(SSN));
        sps.submit();
        LOG.info("Scholarship Page (Shortest Route) Test Successful");
    }

    private void testScholarshipPageLongest(WebDriver driver, WebDriverWait wait){
        LOG.info("Testing Scholarship Page (Longest Route)");
        ScholarshipPageLongest spl = new ScholarshipPageLongest(driver, wait);
        spl.waitForPageLoad();
        spl.skip();
        LOG.info("Scholarship Page (Longest Route) Test Successful");
    }

    private void testReviewPage(WebDriver driver, WebDriverWait wait){
        LOG.info("Testing Review Page");
        ReviewPage reviewPage = new ReviewPage(driver, wait);
        reviewPage.waitForPageLoad();
        reviewPage.getInfo();
        System.out.println(reviewPage.getRelationship());
        LOG.info("Review Page Test Successful");
    }

    @After
    public void tearDown() throws Exception{

//        for(WebDriver driver : drivers)
//            driver.quit();
    }
}
