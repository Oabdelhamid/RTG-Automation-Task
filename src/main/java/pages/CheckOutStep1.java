package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStep1 extends PageObjectModel {

    public CheckOutStep1(WebDriver driver) {
        super(driver);
    }

    public CheckOutStep1 EnterFirstName(String FirstName) {
        By FirstNameField = By.id("first-name");
        driver.findElement(FirstNameField).sendKeys(FirstName);
        return this;
    }

    public CheckOutStep1 EnterLastName(String LastName) {
        By LastNameField = By.id("last-name");
        driver.findElement(LastNameField).sendKeys(LastName);
        return this;
    }

    public CheckOutStep1 EnterPostalCode(String PostalCode) {
        By PostalCodeField = By.id("postal-code");
        driver.findElement(PostalCodeField).sendKeys(PostalCode);
        return this;
    }

    public CheckOutStep1 ClickContinue() {
        By ContinueButton = By.id("continue");
        driver.findElement(ContinueButton).click();
        return this;
    }

}
