package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductPage extends PageObjectModel {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage AddProduct1() {
        By AddToCart = By.id("add-to-cart-sauce-labs-fleece-jacket");
        driver.findElement(AddToCart).click();
        return this;
    }

    public ProductPage ScrollToProduct2() {
        By Product2 = By.id("item_2_title_link");
        new Actions(driver)
                .moveToElement(driver.findElement(Product2))
                .perform();
        driver.findElement(Product2).click();
        return this;
    }


}
