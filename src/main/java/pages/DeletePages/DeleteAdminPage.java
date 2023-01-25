package pages.DeletePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteAdminPage {
    WebElement deleteAdmin;

    public DeleteAdminPage(WebDriver driver, int adminNumber) {
        try {
            this.deleteAdmin = driver.findElement(By.xpath("//*[@id=\"table-to-xls\"]/tbody/tr[" + adminNumber + "]/td[2]/button"));
        }catch (Exception e){
            System.out.println("We cant find this admin");
        }
    }

    public void deleteAdminMethod(){
        try {
            this.deleteAdmin.click();
        }catch (Exception e){
            System.out.println("We cant find this button");
        }
    }
}

