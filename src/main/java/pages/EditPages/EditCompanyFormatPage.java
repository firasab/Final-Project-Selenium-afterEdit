package pages.EditPages;

import core.ClearField;
import core.Constants;
import core.TakeScreenShot;
import groovy.xml.StreamingDOMBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;

public class EditCompanyFormatPage {
    WebElement companyName;
    WebElement field;
    WebElement numberOfWorker;
    WebElement address;
    WebElement image;
    WebElement addBtn;
    WebDriver driver;
    TakeScreenShot takeScr;

    public EditCompanyFormatPage(WebDriver driver) {
        this.driver = driver;
        companyName = driver.findElement(By.id("companyName"));
        field = driver.findElement(By.id("field"));
        numberOfWorker = driver.findElement(By.id("numberOfWorker"));
        address = driver.findElement(By.id("address"));
        image = driver.findElement(By.xpath(Constants.EDIT_COMPANY_XPATH_IMG));
        addBtn = driver.findElement(By.xpath(Constants.EDIT_COMPANY_XPATH_BTN));
        takeScr = new TakeScreenShot(driver);
    }


    public void editCompanyMethod(String companyName, String field, String numberOfWorker, String address, String path) throws InterruptedException, IOException {
        ClearField clear = new ClearField();
        try {
            clear.ClearCompanyField(this.companyName, driver);
            this.companyName.sendKeys(companyName);
        }catch (Exception e){
            System.out.println("there is a problem in cleaning company name");
        }

        try {
            clear.ClearCompanyField(this.field, driver);
            this.field.sendKeys(field);
        }catch (Exception e){
            System.out.println("there is a problem in cleaning company field");
        }

        try {
            clear.ClearCompanyField(this.numberOfWorker, driver);
            this.numberOfWorker.sendKeys(numberOfWorker);
        }catch (Exception e){
            System.out.println("there is a problem in cleaning company number of workers");
        }

        try {
            clear.ClearCompanyField(this.address, driver);
            this.address.sendKeys(address);
        }catch (Exception e){
            System.out.println("there is a problem in cleaning company address");
        }

        try {
            File file = new File(path);
            image.sendKeys(file.getAbsolutePath());
        }catch (Exception e){
            System.out.println("there is a problem in cleaning company picture");
        }

        try {
            takeScr.takeScreenShot(Constants.PicturesFolderPath + "companyInformation.png");
        }catch (Exception e){
            System.out.println("there is a problem in cleaning company takeScreenShot");
        }

        try {
            addBtn.click();
        }catch (Exception e){
            System.out.println("there is a problem in cleaning company addBtn");
        }
    }
}

