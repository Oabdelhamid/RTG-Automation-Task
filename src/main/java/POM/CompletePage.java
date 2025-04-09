package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends PageObjectModel {

    public CompletePage(WebDriver driver) {
        super(driver);
    }
    public boolean FinishPage() {
        By FinishPage = By.xpath("//h2[@class=\"complete-header\"]");
        return driver.findElement(FinishPage).isDisplayed();
    }
}
