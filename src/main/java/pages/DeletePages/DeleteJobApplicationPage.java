package pages.DeletePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteJobApplicationPage {
    WebElement addBtn;

    public DeleteJobApplicationPage(WebDriver driver, int jobApplicationNumber) {
        try {
            this.addBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/header/div/table/tbody/tr[" + jobApplicationNumber + "]/td[8]/button"));
        }catch (Exception e){
            System.out.println("We cant find this Application");
        }
    }

    public void deleteJobApplicationMethod(){
        try {
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("We cant find this button");
        }
    }
}

