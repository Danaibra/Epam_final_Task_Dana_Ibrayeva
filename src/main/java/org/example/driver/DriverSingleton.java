package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.URISyntaxException;



public class DriverSingleton {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverSingleton() {}

    public static WebDriver getDriver(String browser) throws URISyntaxException {
        if (driver.get() == null) {
            if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
            } else {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            }

            if (driver.get() != null) {
                driver.get().manage().window().maximize();
            }
        }
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}