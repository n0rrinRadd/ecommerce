package com.ecommerce.pages.storefront.discovery.header;

import com.ecommerce.pages.storefront.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Categories extends BasePage {

    public WebDriverWait wait;

    public Categories(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
    }

    //@FindAll({
      //  ,
    //})
    @FindBy(css = ".filter-categories")
    private WebElement list;

    public List<WebElement> getCategoriesList(){
        return list.findElements(By.tagName("li"));
    }

    public WebElement getCategoryByIndex(Integer index){
        return getCategoriesList().get(index);
    }

    public WebElement getCategoryByName(String name){
        int match = 0;
        for (WebElement category : getCategoriesList()){
            String[] words = name.split(" ");
            for (String word : words){
                if (category.getText().toLowerCase().indexOf(word.toLowerCase()) != -1) match++;
            }
            if (match==words.length) return category;
            else match = 0;
        }
        return null;
    }

    public void clickCategoryByIndex(Integer index){
        String preUrl = driver.getCurrentUrl();
        click(getCategoryByIndex(index).findElement(By.tagName("a")));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(preUrl)));
    }

    public void clickCategoryByName(String category, String name){
        String preUrl = driver.getCurrentUrl();
        if (System.getProperty("browserView").contains("desktop")) {
            click(getCategoryByName(name).findElement(By.tagName("a")));
        }
        else{
            Filter filter = new Filter(driver);
            filter.clickFilterButton();
            filter.clickFilter(category, name);
        }
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(preUrl)));
    }

    public void clickCategoryByName(String name){
        String preUrl = driver.getCurrentUrl();
        click(getCategoryByName(name).findElement(By.tagName("a")));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(preUrl)));
    }

}