package pages.GoToPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToAddFeatureFormat {
    WebElement Create_New_Feature;

    public GoToAddFeatureFormat(WebDriver driver, String linkTextPath) {
        try {
            this.Create_New_Feature = driver.findElement(By.linkText(linkTextPath));
        }catch (Exception e){
            System.out.println("we cant find the create link");
        }
    }

    public void goToAddFeatureFormatMethod() {
        try {
            this.Create_New_Feature.click();
        }catch (Exception E){
            System.out.println("we cant find the create BUTTON");
        }

    }
}

