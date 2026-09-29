# OrangeHRM QA Testing Project

Manual and automation testing of the **OrangeHRM** web application, built with **Selenium WebDriver, Java, TestNG, Maven, JIRA and GitHub**.

The project covers **300+ test cases** divided by application module: **Login, PIM, and Leave**.

---

## Table of Contents

- [Overview](#overview)
- [Application Under Test](#application-under-test)
- [Tech Stack](#tech-stack)
- [Test Strategy](#test-strategy)
- [Framework Design](#framework-design)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Running the Tests](#running-the-tests)
- [Key Framework Features](#key-framework-features)
- [Test Management](#test-management)
- [Author](#author)

---

## Overview

OrangeHRM is an open-source Human Resource Management system used to manage employee records, personal information, and leave workflows. It is a realistic, form- and data-heavy target for building a complete QA suite.

This project combines:

- **Manual testing**: test case design, exploratory and functional checks, UI/field validation, edge cases and negative scenarios.
- **Automation testing**: a Selenium + Java framework using the Page Object Model and data-driven TestNG tests.

## Application Under Test

| Module | Scope |
|--------|-------|
| **Login** | Authentication, credential validation, session handling |
| **PIM** | Add / search / edit / delete employee records, field defaults |
| **Leave** | Leave application workflow and approval checks |

## Tech Stack

| Tool | Purpose |
|------|---------|
| Java | Core automation language |
| Selenium WebDriver | Browser interaction and UI automation |
| TestNG | Test execution, annotations, data providers |
| Maven | Dependency and build management |
| Eclipse IDE | Development and debugging |
| JIRA | Test planning and sprint tracking |
| GitHub | Version control and collaboration |
| Page Object Model | Maintainable framework structure |

## Test Strategy

**Manual testing**
- Exploratory and functional coverage
- Test case design in JIRA
- UI / field validation checks
- Edge cases and negative scenarios

**Automation testing**
- Selenium WebDriver + Java
- Page Object Model per module
- Data-driven tests with TestNG
- Regression runs on demand

**Module split**
- Login: authentication flows
- PIM: employee data (CRUD)
- Leave: leave application flow
- Each module has its own Page class and Test class

## Framework Design

Each application module has a dedicated **Page class** (locators + actions) and a matching **Test class**. Tests never touch raw locators directly; they call reusable page methods.

### Page classes (`pages/`)

Hold the `By` locators and action methods, for example:

```java
// LOCATORS (pimPage.java)
By Employeelist = By.xpath("//a[text()='Employee List']");
By employeename = By.xpath("//label[text()='Employee Name']/following::input[1]");
By employeeId   = By.xpath("//label[text()='Employee Id']/following::input[1]");
By SearchButton = By.xpath("//button[@type='submit']");
```

Keeping all locators for a module in one class means a UI change is fixed in a single place.

### Test classes (`Tests/`)

Hold the `@Test` methods, assertions, and `@DataProvider`-driven scenarios.

## Project Structure

```
OrangeHRM-QA/
├── pom.xml                  # Maven dependencies and build config
├── testng.xml               # TestNG suite definition
└── src/
    ├── pages/
    │   ├── loginPage.java   # Login locators + actions
    │   ├── pimPage.java     # PIM locators + actions
    │   └── leavePage.java   # Leave locators + actions
    └── Tests/
        ├── LoginTest.java
        ├── LoginForPimTest.java
        ├── pimTest.java
        └── leaveTest.java
```

> Adjust the folder names above to match your repository layout.

## Getting Started

### Prerequisites

- Java JDK 11 or later
- Maven 3.6+
- A browser and matching driver (e.g. Chrome + ChromeDriver)
- Eclipse IDE (or any Java IDE)
- Access to an OrangeHRM instance (local install or the public demo)

### Setup

```bash
# 1. Clone the repository
git clone <your-repository-url>
cd <your-project-folder>

# 2. Install dependencies
mvn clean install -DskipTests
```

Set the application URL and valid credentials in your test base setup (the `Url` variable used in `@BeforeMethod`).

## Running the Tests

**Run the full suite via TestNG XML:**

```bash
mvn test -DsuiteXmlFile=testng.xml
```

**From Eclipse:** right-click `testng.xml` → *Run As* → *TestNG Suite*.

### Suite configuration

```xml
<suite name="Suite">
  <test name="LoginTestRun">
    <classes>
      <class name="Tests.LoginTest"/>
      <class name="Tests.LoginForPimTest"/>
    </classes>
  </test>
  <test name="PimTestRun">
    <classes>
      <class name="Tests.pimTest"/>
    </classes>
  </test>
</suite>
```

## Key Framework Features

### Data-driven testing

One test method runs against many data rows using TestNG `@DataProvider`. Test data is decoupled from test logic, so coverage scales without duplicating code. The same pattern is used for login IDs, usernames, and employee data.

```java
@DataProvider(name = "ADDEMPLOYEEDAAT")
public Object[][] getinfo() {
    return new Object[][] {
        {"Ahmed", "fhhf", "Ali",     "9002"},
        {"Sara",  "fhhf", "gdgcg",  "9003"},
        {"Nour",  "fhhf", "Mostafa","9006"},
        {"Mohammed", "", "Yousef",  "9008"},
    };
}

@Test(dataProvider = "ADDEMPLOYEEDAAT")
void verifyAddEmployeeData(String First, String Middle, String Last, String id) {
    PIMObject.addEmployeeFirstname(First);
    PIMObject.saveButton();
}
```

### TestNG annotations

`@BeforeMethod` opens the application before each test; `@Test(priority = ..., dataProvider = ...)` controls order and data.

### Waits

- Explicit waits before clicking or reading dynamic elements (dropdowns, save confirmations)
- Page methods such as `searchClick()` and `saveButton()` encapsulate the wait, keeping tests clean
- Prevents flaky failures caused by OrangeHRM's asynchronous UI updates

### Assertions

```java
Assert.assertEquals(actual, expected);
Assert.assertTrue(PIMObject.defaltEmployeeIdValue());
Assert.assertTrue(driver.getCurrentUrl().contains("empNumber"));
Assert.assertFalse(PIMObject.firstRecord());
```

## Test Management

**JIRA**
- Sprint board with epics per test-cycle day (Analysis & Planning, Design, Execution)
- Test plan documentation and app-confirmation tasks tracked as issues
- To Do / In Progress / Done workflow across the QA team

**GitHub**
- Framework hosted with `pages/` and `Tests/` packages, `testng.xml` and `pom.xml`
- Version control for locators, page methods, and test classes
- Enables team review, blame history, and safe collaboration

## Author

**<Your Name>**
QA Engineering Program: Manual & Automation Testing

- GitHub: `<your-github-profile>`
- LinkedIn: `<your-linkedin-profile>`
