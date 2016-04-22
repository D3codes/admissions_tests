import edu.ksu.admissions.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by davidfreeman on 4/22/16.
 */
public class UGAdmSeleniumTest {

    @Before
    public void setUp() throws Exception{

        try{

        }catch(Exception e){
            System.err.println(e);
        }
    }

    /**
     * Test shortest route end to end
     */
    @Test
    public void testShortestRoute() throws Exception{

    }

    /**
     * Test logest route end to end
     */
    @Test
    public void testLongestRoute() throws Exception{

    }

    private void testPageOne(WebDriver driver, Boolean hasEID){
        System.out.println("Testing Page One");
        AdmissionsPageOne admissionsPageOne = new AdmissionsPageOne(driver);
        if(hasEID)
            admissionsPageOne.hasID();
        else
            admissionsPageOne.noID();

        admissionsPageOne.submit();
        System.out.println("Page One Test Successful");
    }

    private void testCreateEID(WebDriver driver){
        System.out.println("Testing CreateEID Page (Name, Birthday, Email");
        CreateEID createEID = new CreateEID(driver);
        createEID.setFirstName("John");
        createEID.setLastName("Doe");
        createEID.setBirthDate("1", "January", "1996");
        createEID.setGender();
        createEID.submit();
        assertEquals("You must enter an Email address.", createEID.getAlertMessage());
        createEID.setEmail("testEmail@ksu.edu");
        createEID.clearFirstName();
        createEID.submit();
        assertEquals("You must enter First name.", createEID.getAlertMessage());
        createEID.setFirstName("John");
        createEID.submit();
        System.out.println("CreateEID Page Test Successful");
    }

    private void testRegisterEID(WebDriver driver){
        System.out.println("Testing RegisterEID Page (Phone Number, Address");
        RegisterEID registerEID = new RegisterEID(driver);
        registerEID.setPhoneNumber("1234567890");
        registerEID.clearAddress();
        registerEID.setCity("Manhattan");
        registerEID.setState("Kansas");
        registerEID.setZipCode("66502");
        registerEID.submit();
        assertEquals("You must enter Address line 1.", registerEID.getAlertMessage());
        registerEID.setAddress("123 Manhattan Ave. #4");
        registerEID.clearZipCode();
        registerEID.submit();
        assertEquals("You must enter ZIP/Postal code.", registerEID.getAlertMessage());
        registerEID.setZipCode("66502");
        registerEID.submit();
        System.out.println("RegisterEID Page Test Successful");
    }

    private void testChooseEID(WebDriver driver){
        System.out.println("Testing ChooseEID Page");
        ChooseEID chooseEID = new ChooseEID(driver);
        chooseEID.selectCustomEID();
        chooseEID.setCustomEID("testuser13");
        chooseEID.submit();
        System.out.println("ChooseEID Page Test Successful");
    }

    private void testChoosePassword(WebDriver driver){
        System.out.println("Testing ChoosePassword Page");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        ChoosePassword choosePassword = new ChoosePassword(driver);
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
        reviewPage.finish();
        assertEquals("Success!", reviewPage.getAlertMessage());
        System.out.println("ReviewPage Test Successful");
    }

    @After
    public void tearDown() throws Exception{

    }
}
