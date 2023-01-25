import core.Constants;
import core.TakeScreenShot;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DeletePages.DeleteJobApplicationPage;
import pages.GoToPages.GoToFeaturePage;
import pages.SendEmail.EmailSenderPage;
import pages.SendEmail.SendAcceptEmailPage;
import pages.SendEmail.SendRejectEmailPage;
import pages.ViewPages.ViewJobApplicationPage;
import java.io.IOException;
import java.time.Duration;


public class SendAcceptEmailThenRejectEmailThenDeleteJobAppFlowTest {
    TakeScreenShot takeScr;
    @Test
    public void viewJobApplicationTest() throws InterruptedException, IOException {
        WebDriver driver = BaseTest.Login();
        takeScr = new TakeScreenShot(driver);
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step3: Go to Check Jobs Forms page");
        GoToFeaturePage gotoJobApp = new GoToFeaturePage(driver, "Check Jobs Forms");
        gotoJobApp.gotoFeaturePageMethod();
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"jobForms.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step4: get the applier information");

        ViewJobApplicationPage viewJobApp = new ViewJobApplicationPage(driver , 1);
        viewJobApp.getJobsApplicationPageMethod();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step5: send accept email");
        SendAcceptEmailPage sendAcceptEmail = new SendAcceptEmailPage(driver, 1);
        sendAcceptEmail.sendAcceptEmailPageMethod();

        EmailSenderPage AcceptSender = new EmailSenderPage(driver);
        AcceptSender.emailSenderPageMethod();

        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step6: Go to Check Jobs Forms page");
        GoToFeaturePage gotoJobApplication = new GoToFeaturePage(driver, "Check Jobs Forms");
        gotoJobApplication.gotoFeaturePageMethod();

        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step7: send reject email");
        SendRejectEmailPage sendRejectEmail = new SendRejectEmailPage(driver, 1);
        sendRejectEmail.SendRejectEmailPageMethod();

        EmailSenderPage RejectSender = new EmailSenderPage(driver);
        RejectSender.emailSenderPageMethod();

        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step8: Go to Check Jobs Forms page");
        GoToFeaturePage gotoJobApplications = new GoToFeaturePage(driver, "Check Jobs Forms");
        gotoJobApplications.gotoFeaturePageMethod();

        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step9: delete the application");
        DeleteJobApplicationPage deleteApplicationJob = new DeleteJobApplicationPage(driver, 1);
        deleteApplicationJob.deleteJobApplicationMethod();

        driver.switchTo().alert().accept();
    }

    @BeforeMethod
    public void beforeTest(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


}


