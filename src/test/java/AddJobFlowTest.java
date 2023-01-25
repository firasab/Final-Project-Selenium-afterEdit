import core.Constants;
import core.ReadCsvFile;
import core.TakeScreenShot;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddPages.AddJobPage;
import pages.GoToPages.GoToAddFeatureFormat;
import pages.GoToPages.GoToFeaturePage;
import pages.ViewPages.ViewJobPage;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;


public class AddJobFlowTest {
    WebElement Name, Description, Position, PayPerHour, Address;
    TakeScreenShot takeScr;

    @DataProvider
    public static Object[][] getData() throws Exception{

        List<String[]> lines = ReadCsvFile.readAllLines(Constants.ReadFolderPath+"jobInformation.csv");
        lines.remove(0);
        Object[][] data = new Object[lines.size()][lines.get(0).length];
        int index = 0;
        for(String[] line : lines) {
            data[index] = line;
            index++;
        }
        return data;
    }

    @Test(dataProvider = "getData")
    public void addJobTest(String jobName, String jobDiscription, String jobPosition, String jobPayPerHour , String jobAddress, String path) throws InterruptedException, IOException {
        WebDriver driver = BaseTest.Login();
        takeScr = new TakeScreenShot(driver);
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step3: Go to jobs page");
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Jobs");
        gotoWorker.gotoFeaturePageMethod();
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"jobsBeforeAdd.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step4: Click on create new job");
        GoToAddFeatureFormat newJob = new GoToAddFeatureFormat(driver, "Create New Job");
        newJob.goToAddFeatureFormatMethod();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step5: fill the job information");
        AddJobPage newWorkers = new AddJobPage(driver);
        newWorkers.addNewJobMethod(jobName, jobDiscription, jobPosition, jobPayPerHour, jobAddress, path);

        driver.switchTo().alert().accept();


        takeScr.takeScreenShot(Constants.PicturesFolderPath+"jobs.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step6:assertEquals between the job information from the csv file and the added job");

        int jobNumber = 2;

        this.Name = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/th"));
        this.Description = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[1]"));
        this.Position = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[2]"));
        this.PayPerHour = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[3]"));
        this.Address = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+jobNumber+"]/td[4]"));

        assertEquals(jobName, this.Name.getText());
        assertEquals(jobDiscription, this.Description.getText());
        assertEquals(jobPosition, this.Position.getText());
        assertEquals(jobPayPerHour, this.PayPerHour.getText());
        assertEquals(jobAddress, this.Address.getText());
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step7:View the new job profile");

        ViewJobPage viewJob = new ViewJobPage(driver, 2);
        viewJob.viewJobMethod();


    }

    @BeforeMethod
    public void beforeTest(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


}


