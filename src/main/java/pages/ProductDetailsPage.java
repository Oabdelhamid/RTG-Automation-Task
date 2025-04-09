package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageObjectModel {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage AddToCart() {
        By AddToCart = By.id("add-to-cart");
        driver.findElement(AddToCart).click();
        return this;
    }
    public String GetAddedProductNumber(){
        By AddedProductNumber = By.xpath("//span[@class=\"shopping_cart_badge\"]");
        return driver.findElement(AddedProductNumber).getText();

    }
    public ProductDetailsPage MovedToCardPage() {
        By Cart = By.id("shopping_cart_container");
        driver.findElement(Cart).click();
        return this;
    }
}
