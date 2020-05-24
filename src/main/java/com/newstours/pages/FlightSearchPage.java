package com.newstours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement reserveFlightsBtn;

    @FindBy(name = "buyFlights")
    private WebElement buyFlightsBtn;

    public FlightSearchPage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    public void reserveFlights(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.reserveFlightsBtn));
        this.reserveFlightsBtn.click();
    }

    public void buyFlights() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.buyFlightsBtn));
        this.buyFlightsBtn.click();
    }
}
