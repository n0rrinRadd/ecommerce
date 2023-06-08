Feature: Campaign Landing Page
  Description: Test the functionality of /app/content pages

  @qat
  Scenario Outline: Campaign Landing Page dotCMS content integration
    Given I am on a <device> browser
    When I navigate to the url /app/content/todays-deals
    Then the department page contains sections

    Examples:
      | device     |
      | desktop    |
      | mobile     |

  @qat
  Scenario Outline: Results count
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /app/content/todays-deals
    Then 36 product tiles display

    Examples:
      | device  |
      | desktop |
      | mobile  |
