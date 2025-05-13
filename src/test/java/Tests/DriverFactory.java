package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        Map<String, Supplier<WebDriver>> drivers = Map.of(
                "chrome", () -> new ChromeDriver(getChromeOptions()),
                "firefox", () -> new FirefoxDriver(getFirefoxOptions()),
                "edge", () -> new EdgeDriver(getEdgeOptions())
        );

        return drivers.getOrDefault(browser.toLowerCase(), () -> {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }).get();
    }

    private static ChromeOptions getChromeOptions() {
        return new ChromeOptions()
                .addArguments("--incognito", "--disable-popup-blocking",  "--headless" );
    }

    private static FirefoxOptions getFirefoxOptions() {
        return new FirefoxOptions()
                .addArguments("-private", "--disable-popup-blocking", "--headless" );
    }

    private static EdgeOptions getEdgeOptions() {
        return new EdgeOptions()
                .addArguments("--inprivate", "--disable-popup-blocking", "--headless" );
    }
}
