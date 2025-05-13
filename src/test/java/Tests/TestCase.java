package Tests;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestCase {
    protected WebDriver driver;

   @Parameters("browser")
    @BeforeClass
    public void setup( String browser) {
   driver = DriverFactory.createDriver(browser);
   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));

    }

    @AfterClass
    public void TearDown() {

          driver.quit();

    }
}
