package com.newstours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNameTxt;

    @FindBy(name = "lastName")
    private WebElement lastNameTxt;

    @FindBy(id = "email")
    private WebElement emailTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "register")
    private WebElement registerBtn;

    public RegistrationPage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    public void goToURL() {
        this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
        this.wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
    }

    public void enterUserDetails(String firstName, String lastName) {
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
    }

    public void enterUserConfirmationDetails(String email, String password) {
        this.emailTxt.sendKeys(email);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(password);
    }

    public void submit(){
        this.registerBtn.click();
    }
}
