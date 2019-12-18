# JustEatTest
# READ ME
A sample project for using Cucumber framwork and Selenium Webdriver to perform testing at http://www.just-eat.co.uk/.

# Project Name
**QA Engineer Technical Test**

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Prerequisites](#Prerequisites)
* [Scenarios](#Scenarios)

## General info
Create step definitions to test scenario that on the website http://www.just-eat.co.uk/to, find restaurants in "AR51 1AA" and add two more scenarios, with corresponding step definitions.



## Technologies
* JDK 8
* Cucumber framework
* Selenium Webdriver 3
* Eclipse IDE for Java Developers 2019-09
* Google Chrome Version 79.0.3945.79


## Setup
Clone the repo:

Git:

$ git clone https://github.com/BruceYang0930/JustEatTest

Or download a ZIP of master manually and expand the contents someplace on your system.

## Prerequisites
1. Open the project by using Eclipse IDE;
2. Configure external libraries (included in the Libs folder);
3. Modify the Chrome webdriver location in the StepDefinitions.java


## Scenarios

```Gherkin
Feature: Use the website to find restaurants
           So that I can order food
           As a hungry customer
           I want to be able to find restaurants in my area

  Scenario: Search for restaurants in an area
    Given I want food in "AR51 1AA"
    When I search for restaurants
    Then I should see some restaurants in "AR51 1AA"

  Scenario: Search for restaurants with invalid postcode
    Given I want food in "12345"
    When I search for restaurants
    Then I should see error message

  Scenario: Search for restaurants in an area and click into the first one
    Given I am on the restaurants list page near the area "AR51 1AA"
    When I select the first restaurant on the list
    Then I should see corresponding restaurant details page


