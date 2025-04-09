package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageObjectModel {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

     Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public LoginPage Navigate(){
        driver.navigate().to("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage EnterUserName(String username){
         By UserName = By.id("user-name");
        driver.findElement(UserName).sendKeys(username);
        return this;
    }
    public LoginPage EnterPassword(String password){
        By Password = By.id("password");
        driver.findElement(Password).sendKeys(password);
        return this;
    }
    public LoginPage ClickLoginButton(){
        By LoginButton = By.id("login-button");
        driver.findElement(LoginButton).click();
        By Title = By.xpath("//span[@data-test=\"title\"]");
        //wait.until(driver -> driver.findElement(Title).isDisplayed());

        return this;
    }


}
