package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageObjectModel {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Boolean VerifyThatProductDetailsIsDisplayed() {
        By ProductDetails = By.xpath("//div[@class=\"cart_item\"]");
        return driver.findElement(ProductDetails).isDisplayed();

    }

    public CartPage MovedToCheckOutPage() {
        By Cart = By.id("checkout");
        driver.findElement(Cart).click();
        return this;
    }
}

