package base;

import org.example.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;
import java.net.URISyntaxException;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) throws URISyntaxException {
        driver = DriverSingleton.getDriver(browser);
        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}