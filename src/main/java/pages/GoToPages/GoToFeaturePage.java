package pages.GoToPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToFeaturePage {
    WebElement Feature;
    WebDriver driver;

    public GoToFeaturePage(WebDriver driver , String pagePath) {
        this.driver = driver;
        try {
            this.Feature = driver.findElement(By.linkText(pagePath));
        }catch (Exception e){
            System.out.println("there is a problem with the feature");
        }
    }

    public void gotoFeaturePageMethod() throws InterruptedException {
        try {
            this.Feature.click();
        }catch (Exception e){
            System.out.println("there is a problem with the button");
        }

    }
}

