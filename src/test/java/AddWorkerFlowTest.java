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
import pages.AddPages.AddWorkerPage;
import pages.GoToPages.GoToAddFeatureFormat;
import pages.GoToPages.GoToFeaturePage;
import pages.ViewPages.ViewWorkerPage;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;


public class AddWorkerFlowTest {
    WebElement WorkerName, WorkerId, WorkerAddress, WorkerPhoneNumber, workerEmail, workerCompany;
    TakeScreenShot takeScr;


    @DataProvider
    public static Object[][] addWorkerData() throws Exception{

        List<String[]> lines = ReadCsvFile.readAllLines(Constants.ReadFolderPath+"workerInformation.csv");
        lines.remove(0);
        Object[][] data = new Object[lines.size()][lines.get(0).length];
        int index = 0;
        for(String[] line : lines) {
            data[index] = line;
            index++;
        }
        return data;
    }


    @Test (dataProvider = "addWorkerData")
    public void addWorkerTest(String name, String id, String address, String phoneNumber, String email, String company, String dateOfStartingJob, String dateOfFinishingJob , String path) throws InterruptedException, IOException {
        WebDriver driver = BaseTest.Login();
        takeScr = new TakeScreenShot(driver);
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step3: Go to workers page");
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Workers");
        gotoWorker.gotoFeaturePageMethod();
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"workersBeforeAdd.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step4: Click on create new worker");
        GoToAddFeatureFormat newWorker = new GoToAddFeatureFormat(driver, "Create New Wokrer");
        newWorker.goToAddFeatureFormatMethod();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step5: fill the worker information");
        AddWorkerPage newWorkers = new AddWorkerPage(driver);
        newWorkers.addNewWorkerMethod(name, id, address, phoneNumber, email, company, dateOfStartingJob, dateOfFinishingJob, path);

        driver.switchTo().alert().accept();


        takeScr.takeScreenShot(Constants.PicturesFolderPath+"workersAfterAdd.png");
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step6:assertEquals between the worker information from the csv file and the added worker");
        int workerNumber = 2;

        this.WorkerName = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/th"));
        this.WorkerId = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/td[1]"));
        this.WorkerAddress = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/td[2]"));
        this.WorkerPhoneNumber = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/td[3]"));
        this.workerEmail = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/td[4]"));
        this.workerCompany = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr["+workerNumber+"]/td[5]"));

        assertEquals(name, this.WorkerName.getText());
        assertEquals(id, this.WorkerId.getText());
        assertEquals(address, this.WorkerAddress.getText());
        assertEquals(phoneNumber, this.WorkerPhoneNumber.getText());
        assertEquals(email, this.workerEmail.getText());
        assertEquals(company, this.workerCompany.getText());
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step7:View the new worker profile");

        ViewWorkerPage viewWorker = new ViewWorkerPage(driver, 2);
        viewWorker.viewWorkerMethod();

    }

    @BeforeMethod
    public void beforeTest(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


}


