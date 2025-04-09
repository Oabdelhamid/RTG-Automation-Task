import POM.LoginPage;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RtgTaskTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void TearDown() {
        driver.quit();
    }

   @Test
    public void NavigateToLoginPage(){
    new LoginPage(driver).Navigate()
            .EnterUserName("standard_user")
            .EnterPassword("secret_sauce")
            .ClickLoginButton();


    }




}
