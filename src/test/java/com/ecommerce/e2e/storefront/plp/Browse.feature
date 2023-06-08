Feature: Browse page
  Description: Test the functionality of /b pages

  # https://www.ecommerce.com/b/

  @qat
  Scenario Outline: OOS
    Given I am on a <device> browser
    When I navigate to the url <browse_page>
    Then the top 4 items are not out of stock <browse_page> search results

    Examples:
      | device     | browse_page |
      | desktop    | /b/         |

  @qat @dev
  Scenario Outline: Breadcrumb page navigation
    Given I am on a <device> browser
    When I navigate to the url <browse_page>
    Then <category> displays in the breadcrumbs
    And I click the <facetCategory> filter <filterName>
    Then <category> displays in the breadcrumbs

    Examples:
      | device     | browse_page | category | facetCategory | filterName |
      | desktop    | /b/         | catgegory | brand        | filterName      |

  @qat @dev
  Scenario Outline: Subcategory page navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url <browse_page>
    When I click on the l2 category <subcategory>
    Then displays in the breadcrumbs
    And displays in the breadcrumbs
    And displays in the breadcrumbs
    And displays in the breadcrumbs

    Examples:
      | device  | browse_page | subcategory |
      | desktop | /b/         |             |

