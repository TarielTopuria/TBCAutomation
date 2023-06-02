# Test Automation Project for Test Automation Engineer Vacancy at TBC BANK
This is a test automation project where IntelliJ IDEA, Java 17, Maven, Selenide, TestNG, and Allure is used. 

The purpose of this project is to automate testing for the API.

## Getting Started
To get started with this project, you will need to have the following tools installed on your system:

* JDK;
* Maven;
* Allure;
* Any Integrated Development Environment (IDE);

You can clone the repository from GitHub using the following command:

`git clone https://github.com/TarielTopuria/TBCAutomation.git`

Once you have cloned the repository, you can import the project into your IDEA and start working with it.

## Running Tests
There are several ways to run the tests:

1. Using tesng.xml file.
- Go to project folder and find testng.xml file; 
- Select the testng.xml file, right-click on it, and select Run; 
- The IDE will execute XML file as TestNG suite.

2. Using terminal:
- Open the project;
- Open the terminal;
- use the following command in the terminal: `mvn test`;
- This will run all the tests in the project. 

You can also run a specific test class or test method by specifying the class or method name in the command.

## Generating Reports
This project uses Allure to generate reports for the tests. To generate the reports, you can use the following command:

`allure serve`

This will generate the reports and open them in your default browser. You can also generate the reports in a specific directory using the following command:

`allure report`

This will generate the reports in the "target/site/allure-maven-plugin" directory.

## Conclusion
This project is done for the Test Automation Engineer Vacancy announced by TBC Bank.
