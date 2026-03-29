package tests;

import base.BaseTest;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.example.pages.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class LoginTests extends BaseTest {

    @Test
    public void validLoginLogoutTest() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        MenuPage menuPage = new MenuPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isInventoryDisplayed(), "Inventory is not displayed!");

        menuPage.logout();

        Assert.assertTrue(
                Objects.requireNonNull(driver.getCurrentUrl()).contains("saucedemo.com"),
                "Logout failed!"
        );
    }

    @Test
    public void testLockedOutUser() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertEquals(
                loginPage.getErrorText(),
                "Epic sadface: Sorry, this user has been locked out."
        );
    }

    @Test
    public void testEmptyUsername() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "secret_sauce");

        Assert.assertEquals(
                loginPage.getErrorText(),
                "Epic sadface: Username is required"
        );
    }

    @Test
    public void testEmptyPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "");

        Assert.assertEquals(
                loginPage.getErrorText(),
                "Epic sadface: Password is required"
        );
    }

    @Test
    public void testInvalidCredentials() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wrong_user", "wrong_pass");

        Assert.assertEquals(
                loginPage.getErrorText(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }
}