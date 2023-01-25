package pages.SearchPages;

import core.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    WebElement search;




    public SearchPage(WebDriver driver) {
        try {
            this.search = driver.findElement(By.xpath(Constants.SEARCH_FIELD_XPATH));
        }catch (Exception e){
            System.out.println("there is a problem with the search");
        }
    }

    public void searchMethod(String searchText)  {
        try {
            this.search.sendKeys(searchText);
        }catch (Exception e){
            System.out.println("there is a problem with the button");
        }

    }
}

