# selenium-framework

## Description
This repo contains the result source code of [automation training (french)](https://www.youtube.com/watch?v=BrR5-HWPjwE&list=PL4BtVtsdnzadpYqpzXNrArRKXiG1MI6nH "Framework de tests automatisés") based on:
- BDD approach using Cucumber.
- Web app testing with Selenium WebDriver.
- Api testing with RestAssured.

## Pre-requisites

###
|  What you intend to do  | What you need  | 
|---|---|
| To write & run predefined tests  | A basic text editor like Notepad++ and the command line  |
| To implement new un-defined tests | Follow the installation guide   |

### Installation
1. Install java JDK from https://www.oracle.com/java/technologies/javase-jdk8-downloads.html
2. Install an IDE like IntelliJ: https://www.jetbrains.com/fr-fr/idea/download/#section=windows
3. Once IntelliJ is installed, open it and go to `File` (top left) &rarr; `Settings` &rarr; `Plugins` &rarr; and search for "Cucumber for Java" (it should prompt you to install "Gherkin" as well, if it doesn't do the same manually and add "Gherkin"), once finished, restart IntelliJ.
4. Clone the solution to your local repository & now you're good to go.

### Writing a test
As we do BDD testing, we use concrete examples to describe the application behavior and what we want the software to do, in other words we specify acceptance criteria tests as written from the point of view of the Product Owner.

That is why we use Cucumber, as it serves two purposes: creating project documentation by writing acceptance criteria, and breaking them into testable steps for our automated tests.

Check Cucumber official documentation to learn how to write your first test scenario [following this link.](https://cucumber.io/docs/guides/10-minute-tutorial/#write-a-scenario) 

And for the test context, we predefined automated steps that can be re-used in order to add more tests to the project, as in the example below:

```Gherkin
Feature: Google Search
  AS a user I want to test google search function

    Background: pre-requisites
        Given I open google search page
        
      @smoke
      Scenario: selenium
        When I lookup the word "selenium"
        Then search results display the word "selenium" 
```

### Runing a test

To run complete set of test, you can either do it through: 
- The IDE by runing the main test class: `modules\TestRunner.java`
- Or the command line by runing this command: `mvn test`

You can also run specified test based on their tags by updating the CucumberOptions in the runner class:

```java
@CucumberOptions(
        ....
        tags = {"@specify_your_tag_here"}
)
```
Or by adding arguments to the command your send through the console: `mvn -D cucumber.options='--tags @specify_your_tag_here' test` 