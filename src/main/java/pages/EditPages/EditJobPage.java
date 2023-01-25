package pages.EditPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditJobPage {
    WebElement addBtn;

    public EditJobPage(WebDriver driver, int jobNumber) {
        try {
            this.addBtn = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + jobNumber + "]/td[5]/a[1]"));
        }catch (Exception e){
            System.out.println("we cant find this job");
        }
    }

    public void editJobMethod(){
        try {
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("we cant find this button");
        }
    }
}

