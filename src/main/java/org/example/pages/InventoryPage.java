package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    private final WebDriver driver;

    @FindBy(className = "inventory_list")
    private WebElement inventoryContainer;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isInventoryDisplayed() {
        return inventoryContainer.isDisplayed();
    }
}