package com.newstours.tests;

import com.base.BaseTest;
import com.newstours.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {
    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setUpParam(String noOfPassengers, String expectedPrice){
        this.noOfPassengers= noOfPassengers;
        this.expectedPrice= expectedPrice;
    }

    @Test
    public void registrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goToURL();
        registrationPage.enterUserDetails("hello","world");
        registrationPage.enterUserConfirmationDetails("hello@abc.com","123456");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.enterNoOfPassengers(noOfPassengers);
        flightDetailsPage.goToFlightSearchPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void flightSearchPage(){
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        flightSearchPage.reserveFlights();
        flightSearchPage.buyFlights();
    }

    @Test(dependsOnMethods = "flightSearchPage")
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getPriceDetails();

        Assert.assertEquals(actualPrice, expectedPrice);

    }

}
