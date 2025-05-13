package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        // Find the element
        WebElement element = driver.findElement(Product2);

        // Use JavaScript executor for both scrolling and clicking
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to element
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        // Small delay to let page settle


        // Use JavaScript click instead of Selenium click
        js.executeScript("arguments[0].click();", element);

        return this;
    }



}
