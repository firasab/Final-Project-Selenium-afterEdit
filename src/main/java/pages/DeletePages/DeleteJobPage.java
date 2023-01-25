package pages.DeletePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteJobPage {
    WebElement addBtn;

    public DeleteJobPage(WebDriver driver, int jobNumber) {
        try {
            this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + jobNumber + "]/td[5]/button"));
        }catch (Exception e){
            System.out.println("We Cant find this job");
        }
    }

    public void deleteJobMethod(){
        try {
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("We cant find this button");
        }
    }
}

