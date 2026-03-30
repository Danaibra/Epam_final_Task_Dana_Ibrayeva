# SauceDemo Automation Project

This repository contains automated tests for the **Login Flow** of the [SauceDemo](https://www.saucedemo.com) application.

## Project Task Description
**Focus:** Different login scenarios and error handling.

### Test Cases (User Scenarios)
* **UC-1: Login/Logout Flow (Happy Path)**
    * Login as `standard_user`.
    * Verify inventory visibility.
    * Logout and verify return to login page.
* **UC-2: Locked Out User**
    * Login as `locked_out_user`.
    * Verify error: *"Epic sadface: Sorry, this user has been locked out."*
* **UC-3: Empty Login Test**
    * Leave Username empty.
    * Verify error: *"Epic sadface: Username is required"*.
* **UC-4: Empty Password Test**
    * Enter `standard_user`, leave Password empty.
    * Verify error: *"Epic sadface: Password is required"*.
* **UC-5: Invalid Credentials Test**
    * Enter invalid username/password combination.
    * Verify error: *"Epic sadface: Username and password do not match any user in this service"*.



## Technical Requirements
* **Tools:** Selenium WebDriver
* **Design Pattern:** Page Object Model (POM)
* **Browsers:** Chrome, Edge (Run in Parallel)
* **Locators:** CSS Selectors, XPath



## How to Run Tests and Generate Report
To compile the project and execute all tests and generate report, run the following command from the project root:
```bash
mvn clean test allure:report allure:serve
```

