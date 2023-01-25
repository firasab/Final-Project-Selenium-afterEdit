import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPages.GetSearchInformationPage;
import pages.GoToPages.GoToFeaturePage;
import pages.SearchPages.SearchPage;
import java.io.IOException;
import java.time.Duration;


public class SearchTest {
    @Test
    public void searchTest( ) throws InterruptedException, IOException {
        Allure.step("Step1: login to the website");
        WebDriver driver = BaseTest.Login();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step2:  go to worker page");
        GoToFeaturePage gotoWorker = new GoToFeaturePage(driver, "Workers");
        gotoWorker.gotoFeaturePageMethod();
        //--------------------------------------------------------------------------------------------------------------
        Allure.step("Step3: search for the worker");
        SearchPage searchWorkers = new SearchPage(driver);
        searchWorkers.searchMethod("Firas Abu Sneneh");

        //--------------------------------------------------------------------------------------------------------------
        GetSearchInformationPage searchWorker = new GetSearchInformationPage(driver);
        searchWorker.getSearched();
    }
    @BeforeMethod
    public void beforeTest(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


}


