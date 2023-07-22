# Test automation project for the [trello.com](https://trello.com) website
Trello is a web-based, kanban-style, list-making application
___
## Table of contents

- [Stack of technologies](#computer-stack-of-technologies)
- [List of tests](#list-of-tests)
- [Running tests on a local machine](#running-automated-tests-on-a-local-machine)
- [Running tests in Jenkins](#running-tests-in-jenkins)
- [Test results report in Allure Report](#test-results-report-in-allure-report)
- [Integration with Allure TestOps](#integration-with-allure-testops)
- [Integration with Jira](#integration-with-jira)
- [Telegram notifications using a bot](#telegram-notifications-using-a-bot)
- [Example of test execution in Selenoid](#example-of-test-execution-in-selenoid)


## :computer: Stack of technologies
<div style="text-align: center;">
<a href="https://jetbrains.com/idea/"><img src="media/logo/IntelliJ_IDEA.svg" width="50" height="50"  alt="IntelliJ IDEA"/></a>
<a href="https://java.com/"><img src="media/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://junit.org/junit5/"><img src="media/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://selenide.org/"><img src="media/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="media/logo/Allure_Report.svg" width="50" height="50"  alt="Allure Report"/></a>
<a href="https://aerokube.com/selenoid/"><img src="media/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://qameta.io/"><img src="media/logo/AllureTestOps.svg" width="50" height="50"  alt="Allure Testops"/></a>  
<a href="https://www.atlassian.com/software/jira"><img src="media/logo/Jira.svg" width="50" height="50"  alt="Jira"/></a>  
</div>
In this project, the automated tests are written in <code>Java</code> using the <code>Selenide</code> framework. <code>Gradle</code> is used to build the project. <code>JUnit5</code> is used as the unit testing framework. The tests run from <code>Jenkins</code>. After the run is completed, a notification is sent using a bot on Telegram. <code>Selenoid</code> is used to run browsers in Docker containers. Integration with <code>Allure TestOps</code> and <code>Jira</code> is set up for test reporting and test result analytics.

## List of tests
- [x] Authorization with email and password
- [x] Verification of displayed sub-items for each menu item on the main page (parametrized test)
#### Integrations page
- [x] Check the search of integrations by name
- [x] Verification of the message when no results match the search query
#### Pricing calculator for enterprise teams
- [x] Check the number of users and prices displayed by default
- [x] Check prices for the maximum number of users
- [x] Check the error message when the number of users is less than minimum
- [x] Check the error message when the number of users exceeds the maximum


## Running automated tests on a local machine
To run tests locally on your machine, add the local.properties file to the src/test/resources/config folder and fill in the following properties:

```properties
browser = BROWSER
browserSize = BROWSER_SIZE
baseUrl = BASE_URL
trelloUserEmail = TRELLO_USER_EMAIL
trelloUserPassword = TRELLO_USER_PASSWORD
```
>- <code>BROWSER</code> - browser in which the tests will be run (Chrome is set by default)
>- <code>BROWSER_SIZE</code> - size of the browser window (1920x1080 is set by default)
>- <code>BASE_URL</code> - the base URL for the web application under test
>- <code>TRELLO_USER_EMAIL</code> - test account login
>- <code>TRELLO_USER_PASSWORD</code> - test account password

Then use the following command:
```
gradle clean test -Denv=local
```
Or you can specify the parameters directly in the command to run:
```
gradle clean test 
-Dbrowser=BROWSER 
-DbrowserSize=BROWSER_SIZE
-DbaseUrl=BASE_URL
-DtrelloUserEmail=TRELLO_USER_EMAIL
-DtrelloUserPassword=TRELLO_USER_PASSWORD
```
## Running tests in Jenkins
To run tests in Jenkins, follow these steps:
1. Click on the [provided link](https://jenkins.autotests.cloud/job/C19-CatherineMoko-final_project/)
2. Click the **Build with Parameters** link
3. Modify the parameters as needed
4. Click the **Build** button, and build will be started

<div style="text-align: center;">
  <img src="media/screens/jenkins_1.png" alt="Jenkins">
</div>

Once the build is complete, viewing the Allure report becomes available.
<div style="text-align: left;">
  <img src="media/screens/jenkins_2.png" alt="Jenkins">
</div>

## Test results report in [Allure Report](https://jenkins.autotests.cloud/job/C19-CatherineMoko-final_project/allure/)
The report of the test execution includes:
 - Test steps
 - Screenshot of the page on the last test step
 - Page Source
 - Browser console logs
 - Video of the test run

## Integration with Allure TestOps

## Integration with Jira

## Telegram notifications using a bot

## Example of test execution in Selenoid
