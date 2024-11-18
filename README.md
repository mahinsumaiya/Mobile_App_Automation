# Calculator App Automation Using Appium

The project is about a mobile app automation using Appium.Here, I have automated the Google Calculator APK using Selenium, TestNG, and Appium in IntelliJ IDEA. Testing was performed on an Android Studio emulator, and I utilized Allure Reports for comprehensive visualization of the test results.

## Project Description

Here, two tasks are given; These are:

### 1.Series Calculation Method
#### Automate any series for calculator app. Pass the series as a parameter to your test method.
For an example:

100/10*5-10+60

pseudocode for your test function can be look like:

public void doSeries(){
calcuateSeries("100/10*5-10+60");
}

### 2.Series Calculation from CSV file. 
#### Write another function where following series will be calculated from csv file. 
//data.csv
50+40-30/2+20 //assert 95 
10*2/2+10-20 // assert 0 
4pi2^3 // assert 100.53 

## Technologies Used:
•	Selenium with TestNG;
•	Appium;
•	Gradle (Build tool);
•	Allure (Reporting tool);
•	Appium Inspector;
•	Android Studio;
•	Command Prompt to initiate Appium;
•	IntelIJ Idea.

## How to run?

•	Clone this project

•	Open the command prompt and give the following command appium

•	Open calculator apk in Android Studio and start an emulator

•	Open appium inspector and start a session using saved capabilities

•	Open the project in IntelliJ Idea

•	Give the following command in the IntelIiJ terminal: gradle clean test

•	Finally,generate Allure report using command:

   ##### i)	allure generate allure-reports --clean -output
   ##### ii)	allure serve allure-results
## Output


  




