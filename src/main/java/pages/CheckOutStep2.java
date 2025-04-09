package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStep2 extends PageObjectModel {

    public CheckOutStep2(WebDriver driver) {
        super(driver);
    }

    public boolean VerifyThatOrderDetailsIsDisplayed() {
        By ProductDetails = By.xpath("//div[@class=\"cart_item_label\"]");
        return driver.findElement(ProductDetails).isDisplayed();
    }

    public CheckOutStep2 ClickFinish() {
        By FinishButton = By.id("finish");
        driver.findElement(FinishButton).click();
        return this;
    }



}
