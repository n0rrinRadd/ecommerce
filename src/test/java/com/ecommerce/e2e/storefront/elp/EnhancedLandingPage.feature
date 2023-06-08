Feature: Enhanced Landing Page
  Description: Test the functionality of /app/department pages

  @qat @dev
  Scenario Outline: Enhanced Landing Page dotCMS content integration
    Given I am on a <device> browser
    When I navigate to the url <elp_page>
    Then the department page contains sections

    Examples:
      | device     | elp_page           |
      | desktop    | /b/brand-977   |
      | mobile     | /b/brand-977   |
      | desktop    | /b/brand-1663      |

  @qat
  Scenario Outline: Results count
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url <elp_page>
    Then <result_count> product tiles display

    Examples:
      | device  | elp_page           | result_count |
      | desktop | /b/brand-1663      | 36           |
      | mobile  | /b/brand-1663      | 36          |
      | desktop | /b/brand-977   | 36           |
      | mobile  | /b/brand-977   | 36          |

  @qat
  Scenario Outline: OOS
    Given I am on a <device> browser
    When I navigate to the url <elp_page>
    Then the top 4 items are not out of stock <elp_page> search results

    Examples:
      | device     | elp_page           |
      | desktop    | /b/brand-977   |
      | desktop    | /b/brand-1663      |
