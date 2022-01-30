# Android - Appium Cucumber Automation Framework

## Environment
- IntelliJ IDEA
- Java 17 (JDK)
- Android sdk
- Appium
- Cucumber
- Maven - build tool
- All the other required dependencies are present in POM.xml

## SetUp
- Install Appium via npm (npm install -g appium)
- Cucumber for Java, Gherkin Plugins installed (IntelliJ -> Preferences -> Plugin)
- Set Android_home and Java_home Env variables in run configuration

## Run
- Before running,
Give your device UDID/Emulator details in appiumSetUp file and
- Run the runner file

## Troubleshoot
With Appium in Mac latest versions facing socket hangup issue.
If facing socket hang up issue -> execute the single tests one by one.

## Bugs noticed. So, below scenarios will fail
 login.feature  --> Scenario: User opens the app again after login
 news.feature   --> Scenario: Images failed to load error

