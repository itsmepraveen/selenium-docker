package com.newstours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    private WebElement passengersCount;

    @FindBy(name = "findFlights")
    private WebElement findFlightsBtn;

    public FlightDetailsPage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    public void enterNoOfPassengers(String passengerCount) {
        this.wait.until(ExpectedConditions.elementToBeClickable(passengersCount));
        Select select = new Select(this.passengersCount);
        select.selectByValue(passengerCount);
    }

    public void goToFlightSearchPage(){
        this.findFlightsBtn.click();
    }
}
