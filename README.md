# SauceDemo Automation Project (EPAM Final Task)

## Description
This project automates 5 login scenarios for the [SauceDemo](https://www.saucedemo.com/) website. It uses **Selenium WebDriver**, **TestNG**, and the **Page Object Model (POM)** pattern to ensure clean and maintainable code.

## Tech Stack
- **Java 17**
- **Selenium 4.18.1**
- **TestNG** (with Parallel Execution)
- **Maven**
- **Allure & AspectJ Weaver** (Reporting)

## Prerequisites
- **Java 17** installed and configured.
- **Maven** installed.
- **Microsoft Edge** browser.
- **Google Chrome** browser.


## How to Run Tests and Generate Report
To compile the project and execute all tests and generate report, run the following command from the project root:
```bash
mvn clean test allure:report allure:serve
```

