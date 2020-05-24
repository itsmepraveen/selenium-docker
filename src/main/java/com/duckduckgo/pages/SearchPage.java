package com.duckduckgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "search_form_input_homepage")
    private WebElement searchKeywordTxt;

    @FindBy(id = "search_button_homepage")
    private WebElement searchBtn;

    @FindBy(linkText = "Videos")
    private WebElement videosLnk;

    @FindBy(className = "tile--c--w")
    private List<WebElement> allVideos;


    public SearchPage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    public void goToURL(){
        this.driver.get("https://duckduckgo.com/");
    }

    public void enterSearchKeyword(String searchKeyword){
        this.searchKeywordTxt.sendKeys(searchKeyword);
        this.searchBtn.click();
    }

    public int countNoOfVideos(){
        this.videosLnk.click();
        By by = By.className("tile--c--w");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        int count = this.allVideos.size();
        return count;
    }
}
