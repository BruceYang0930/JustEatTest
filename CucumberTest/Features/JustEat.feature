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
