Feature: Search
  Test the functionality of storefront search bar & url navigation

  @qat @dev
  Scenario: Search for  
    Given I am on a desktop browser
    And I am on the homepage
    When I type   in the search bar and click submit
    Then I see " " display in results page title

  @qat @dev
  Scenario Outline: Search url returns stuff
    Given I am on a desktop browser
    And I am on the homepage
    When I search by keyword for <keyword>
    Then the url contains "nav-submit-button"

    Examples:
      | keyword        |
      | ecommerce      |
