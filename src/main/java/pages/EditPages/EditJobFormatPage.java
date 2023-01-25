package pages.EditPages;

import core.ClearField;
import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;

public class EditJobFormatPage {
    WebElement jobName;
    WebElement discription;
    WebElement position;
    WebElement payPerHour;
    WebElement address;
    WebElement image;
    WebElement addBtn;
    WebDriver driver;
    TakeScreenShot takeScr;

    public EditJobFormatPage(WebDriver driver) {
        try {
            this.driver = driver;
        }catch (Exception e){
            System.out.println("there is a problem with the driver");
        }
        try {
            jobName = driver.findElement(By.id("jobName"));
        }catch (Exception e){
            System.out.println("there is a problem with the jobName");
        }
        try {
            discription = driver.findElement(By.id("discription"));
        }catch (Exception e){
            System.out.println("there is a problem with the discription");
        }
        try {
            position = driver.findElement(By.id("position"));
        }catch (Exception e){
            System.out.println("there is a problem with the position");
        }
        try {
            payPerHour = driver.findElement(By.id("payPerHour"));
        }catch (Exception e){
            System.out.println("there is a problem with the payPerHour");
        }
        try {
            address = driver.findElement(By.id("address"));
        }catch (Exception e){
            System.out.println("there is a problem with the address");
        }
        try {
            image = driver.findElement(By.xpath(Constants.EDIT_JOB_XPATH_IMG));
        }catch (Exception e){
            System.out.println("there is a problem with the image");
        }
        try {
            addBtn = driver.findElement(By.xpath(Constants.EDIT_JOB_XPATH_BTN));
        }catch (Exception e){
            System.out.println("there is a problem with the addBtn");
        }
        try {
            takeScr = new TakeScreenShot(driver);
        }catch (Exception e){
            System.out.println("there is a problem with the TakeScreenShot");
        }
    }

    public void editJobMethod(String jobName, String discription, String position, String payPerHour, String address, String path) throws InterruptedException, IOException {
        ClearField clear = new ClearField();
        try {
            clear.ClearCompanyField(this.jobName, driver);
            this.jobName.sendKeys(jobName);
        }catch (Exception e){
            System.out.println("there is a problem with clear the jobname");
        }

        try {
            clear.ClearCompanyField(this.discription, driver);
            this.discription.sendKeys(discription);
        }catch (Exception e){
            System.out.println("there is a problem with clear the discription");
        }

        try {
            clear.ClearCompanyField(this.position, driver);
            this.position.sendKeys(position);
        }catch (Exception e){
            System.out.println("there is a problem with clear the position");
        }

        try {
            clear.ClearCompanyField(this.payPerHour, driver);
            this.payPerHour.sendKeys(payPerHour);
        }catch (Exception e){
            System.out.println("there is a problem with clear the payPerHour");
        }

        try {
            clear.ClearCompanyField(this.address, driver);
            this.address.sendKeys(address);
        }catch (Exception e){
            System.out.println("there is a problem with clear the address");
        }

        try {
            File file = new File(path);
            image.sendKeys(file.getAbsolutePath());
        }catch (Exception e){
            System.out.println("there is a problem with clear the image");
        }


        try {
            takeScr.takeScreenShot(Constants.PicturesFolderPath + "jobInformation.png");
        }catch (Exception e){
            System.out.println("there is a problem with clear the takeScreenShot");
        }
        try {
            addBtn.click();
        }catch (Exception e){
            System.out.println("there is a problem with clear the addBtn");
        }
    }
}

