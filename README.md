# Test automation project for the [trello.com](https://trello.com) website
Trello is a web-based, kanban-style, list-making application
___
## Table of contents

- [Stack of technologies](#computer-stack-of-technologies)
- [List of tests](#list-of-tests)


## :computer: Stack of technologies
<div style="text-align: center;">
<a href="https://jetbrains.com/idea/"><img src="images/logo/IntelliJ_IDEA.svg" width="50" height="50"  alt="IntelliJ IDEA"/></a>
<a href="https://java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure_Report.svg" width="50" height="50"  alt="Allure Report"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://qameta.io/"><img src="images/logo/AllureTestOps.svg" width="50" height="50"  alt="Allure Testops"/></a>  
<a href="https://www.atlassian.com/software/jira"><img src="images/logo/Jira.svg" width="50" height="50"  alt="Jira"/></a>  
</div>
In this project, the automated tests are written in <code>Java</code> using the <code>Selenide</code> framework. <code>Gradle</code> is used to build the project. <code>JUnit5</code> is used as the unit testing framework. The tests run from <code>Jenkins</code>. After the run is completed, a notification is sent using a bot on Telegram. <code>Selenoid</code> is used to run browsers in Docker containers. Integration with <code>Allure TestOps</code> and <code>Jira</code> is set up for test reporting and test result analytics.

## List of tests
- [x] Authorization with email and password
- [x] Verification of displayed sub-items for each menu item on the main page (parametrized test)
### Integrations page
- [x] Check the search of integrations by name
- [x] Verification of the message when no results match the search query
### Pricing calculator for enterprise teams
- [x] Check the number of users and prices displayed by default
- [x] Check prices for the maximum number of users
- [x] Check the error message when the number of users is less than minimum
- [x] Check the error message when the number of users exceeds the maximum
