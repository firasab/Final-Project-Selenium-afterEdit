package pages.ApplyForJob;

import core.Constants;
import core.TakeScreenShot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;

public class ApplyToJobFormatPage {
    WebElement name;
    WebElement jobName;
    WebElement id;
    WebElement phone;
    WebElement address;
    WebElement email;
    WebElement description;
    WebElement image;
    WebElement addBtn;
    TakeScreenShot takeScr;


    public ApplyToJobFormatPage(WebDriver driver) {
        try {
            this.name = driver.findElement(By.id("name"));
        }catch (Exception e){
            System.out.println("there is a problem with the applier name");
        }
        try {
            this.jobName = driver.findElement(By.id("jobName"));
        }catch (Exception e){
            System.out.println("there is a problem with the applier jobName");
        }
        try {
            this.id = driver.findElement(By.id("id"));
        }catch (Exception e){
            System.out.println("there is a problem with the applier id");
        }
        try {
            this.phone = driver.findElement(By.id("phone"));
        }catch (Exception e){
            System.out.println("there is a problem with the applier phone");
        }
        try {
            this.address = driver.findElement(By.id("address"));
        }catch (Exception e){
            System.out.println("there is a problem with the applier address");
        }
        try {
            this.email = driver.findElement(By.id("email"));
        }catch (Exception e){
            System.out.println("there is a problem with the applier email");
        }
        try {
            this.description = driver.findElement(By.id("description"));
        }catch (Exception e){
            System.out.println("there is a problem with the applier description");
        }
        try {
            this.image = driver.findElement(By.xpath(Constants.APPLY_TO_JOB_XPATH_IMG));
        }catch (Exception e){
            System.out.println("there is a problem with the applier image");
        }
        try {
            this.addBtn = driver.findElement(By.xpath(Constants.APPLY_TO_JOB_XPATH_BTN));
        }catch (Exception e){
            System.out.println("there is a problem with the applier addBtn");
        }
        try {
            takeScr = new TakeScreenShot(driver);
        }catch (Exception e){
            System.out.println("there is a problem with the applier TakeScreenShot");
        }
    }

    public void applyToJobFormatPageMethod(String name, String jobName, String id, String phone, String address, String email, String description, String path) throws InterruptedException, IOException {
        try {
            this.name.sendKeys(name);
        }catch (Exception e){
            System.out.println("there is a problem with the applier name");
        }
        try {
            this.jobName.sendKeys(jobName);
        }catch (Exception e){
            System.out.println("there is a problem with the applier jobName");
        }
        try {
            this.id.sendKeys(id);
        }catch (Exception e){
            System.out.println("there is a problem with the applier id");
        }
        try {
            this.phone.sendKeys(phone);
        }catch (Exception e){
            System.out.println("there is a problem with the applier phone");
        }
        try {
            this.address.sendKeys(address);
        }catch (Exception e){
            System.out.println("there is a problem with the applier address");
        }
        try {
            this.email.sendKeys(email);
        }catch (Exception e){
            System.out.println("there is a problem with the applier email");
        }
        try {
            this.description.sendKeys(description);
        }catch (Exception e){
            System.out.println("there is a problem with the applier description");
        }
        try {
            File file = new File(path);
            this.image.sendKeys(file.getAbsolutePath());
        }catch (Exception e){
            System.out.println("there is a problem with the applier image");
        }

        try {
            takeScr.takeScreenShot(Constants.PicturesFolderPath + "jobApplyingInformation.png");
        }catch (Exception e){
            System.out.println("there is a problem with the applier takeScreenShot");
        }
        try {
            this.addBtn.click();
        }catch (Exception e){
            System.out.println("there is a problem with the applier addBtn");
        }
    }
}

