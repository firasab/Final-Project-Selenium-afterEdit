package pages.AddPages;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;

public class AddJobPage {
    WebElement jobName;
    WebElement jobDiscription;
    WebElement jobPosition;
    WebElement jobPayPerHour;
    WebElement jobAddress;
    WebElement image;
    WebElement addBtn;
    TakeScreenShot takeScr;


    public AddJobPage(WebDriver driver) {
        try {
            this.jobName = driver.findElement(By.id("jobName"));
        }catch (Exception e){
            System.out.println("there is a problem with the job name");
        }

        try {
            this.jobDiscription = driver.findElement(By.id("discription"));
        }catch (Exception e){
            System.out.println("there is a problem with the job discription");
        }

        try {
            this.jobPosition = driver.findElement(By.id("position"));
        }catch (Exception e){
            System.out.println("there is a problem with the job position");
        }

        try {
            this.jobPayPerHour = driver.findElement(By.id("payPerHour"));
        }catch (Exception e){
            System.out.println("there is a problem with the job pay per hour");
        }

        try {
            this.jobAddress = driver.findElement(By.id("address"));
        }catch (Exception e){
            System.out.println("there is a problem with the job address");
        }

        try {
            this.image = driver.findElement(By.xpath(Constants.ADD_JOB_XPATH_IMG));
        }catch (Exception e){
            System.out.println("there is a problem with the job image");
        }

        try {
            this.addBtn = driver.findElement(By.xpath(Constants.ADD_JOB_XPATH_BTN));
        }catch (Exception e){
            System.out.println("there is a problem with the add button");
        }

        try {
            takeScr = new TakeScreenShot(driver);
        }catch (Exception e){
            System.out.println("there is a problem with the screenshot");
        }
    }

    public void addNewJobMethod(String jobName, String jobDiscription, String jobPosition, String jobPayPerHour, String jobAddress, String path) throws  IOException {
        try {
            this.jobName.sendKeys(jobName);
        }catch (Exception e){
            System.out.println("there is a problem with the job jobName");
        }
        try {
            this.jobDiscription.sendKeys(jobDiscription);
        }catch (Exception e){
            System.out.println("there is a problem with the job jobDiscription");
        }
        try {
            this.jobPosition.sendKeys(jobPosition);
        }catch (Exception e){
            System.out.println("there is a problem with the job jobPosition");
        }
        try {
            this.jobPayPerHour.sendKeys(jobPayPerHour);
        }catch (Exception e){
            System.out.println("there is a problem with the job jobPayPerHour");
        }
        try {
            this.jobAddress.sendKeys(jobAddress);
        }catch (Exception e){
            System.out.println("there is a problem with the job jobAddress");
        }

        try {
            File file = new File(path);
            this.image.sendKeys(file.getAbsolutePath());
        }catch (Exception e){
            System.out.println("there is a problem with the job image");
        }

        try {
            takeScr.takeScreenShot(Constants.PicturesFolderPath + "jobInformation.png");
        }catch (Exception e){
            System.out.println("there is a problem with the job screenshot");
        }

        try {
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("there is a problem with the add button");
        }
    }
}

