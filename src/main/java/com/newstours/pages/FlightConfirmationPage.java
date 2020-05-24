package com.newstours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),'Confirmation')]")
    private WebElement flightConfirmationTxt;

    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> priceTxt;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffLnk;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    public String getPriceDetails() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationTxt));
        System.out.println("Flight Confirmation" + flightConfirmationTxt.getText());
        System.out.println("Flight Price" + priceTxt.get(1).getText());

        String getPrice = priceTxt.get(1).getText();
        this.signOffLnk.click();
        return getPrice;
    }
}
