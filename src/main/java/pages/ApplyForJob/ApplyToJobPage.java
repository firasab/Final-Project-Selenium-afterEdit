package pages.ApplyForJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplyToJobPage {
    WebElement apply;

    public ApplyToJobPage(WebDriver driver, int jobNumber) {
        try {
            this.apply = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/header[" + jobNumber + "]/div/table/a"));
        }catch (Exception e){
            System.out.println("we cant find the job number");
        }
    }

    public void getApplyJobsPage() {
        try {
            this.apply.click();
        }catch (Exception e){
            System.out.println("we cant find the button");
        }
    }
}
