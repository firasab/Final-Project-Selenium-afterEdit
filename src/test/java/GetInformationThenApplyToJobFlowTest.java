import core.*;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ApplyForJob.ApplyToJobFormatPage;
import pages.ApplyForJob.ApplyToJobPage;
import pages.GetInformation.getJobInformationPage;
import pages.GoToPages.GoToFeaturePage;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GetInformationThenApplyToJobFlowTest {
    TakeScreenShot takeScr;
    WebElement informationParagraph;
    @DataProvider
    public static Object[][] getData() throws Exception{
        List<String[]> lines = ReadCsvFile.readAllLines(Constants.ReadFolderPath+"applyToJobInformation.csv");
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
    public void getAboutUsTest(String name, String jobName, String id, String phone, String address, String email, String description, String path) throws InterruptedException, IOException {
        Allure.step("Step1: Open the browser");
        WebDriver driver = OpenBrowsers.openBrowser("chrome");
        takeScr = new TakeScreenShot(driver);
        Allure.step("Step2: go to the website");
        driver.get(Constants.AboutUS_URL);
        driver.manage().window().maximize();

        //---------------------------------------------------------------------------------------------------------------------------
        Allure.step("Step3: get information about the website");
        informationParagraph = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]"));
        String[] headers = new String[1];
        headers[0] = "Website Information";

        String[] website_data = new String[1];
        website_data[0] = informationParagraph.getText();
        List<String[]> data = new ArrayList<String[]>();
        data.add(website_data);
        WriteCsvFile.writeDataLineByLine(Constants.WriteFolderPath+"webInfo.csv", data, headers);
        WriteCsvFile.attachCsv(Constants.WriteFolderPath+"webInfo.csv","webInfo.csv");

        takeScr.takeScreenShot(Constants.PicturesFolderPath+"AboutUS.png");

        //---------------------------------------------------------------------------------------------------------------------------
        Allure.step("Step4: go to Jobs Page");
        GoToFeaturePage gotoApplyToJob = new GoToFeaturePage(driver, "Jobs");
        gotoApplyToJob.gotoFeaturePageMethod();
        //---------------------------------------------------------------------------------------------------------------------------
        Allure.step("Step5: get information about one of the jobs");

        getJobInformationPage aboutJob = new getJobInformationPage(driver,1);
        aboutJob.getJobsPage();
        takeScr.takeScreenShot(Constants.PicturesFolderPath+"jobInformation.png");
        //---------------------------------------------------------------------------------------------------------------------------
        Allure.step("Step6: Click on apply to one of the jobs");
        ApplyToJobPage apply = new ApplyToJobPage(driver,1);
        apply.getApplyJobsPage();
        //---------------------------------------------------------------------------------------------------------------------------
        Allure.step("Step7: Apply for the job");
        ApplyToJobFormatPage sendApplication =  new ApplyToJobFormatPage(driver);
        sendApplication.applyToJobFormatPageMethod( name,  jobName,  id,  phone,  address,  email,  description,  path);

        driver.switchTo().alert().accept();

    }

    @BeforeMethod
    public void beforeTest(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

}