import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestCase {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions()
                .addArguments("--start-maximized")
                .addArguments("--incognito")
                .addArguments("--disable-popup-blocking");

        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void TearDown() {
        driver.quit();
    }
}
