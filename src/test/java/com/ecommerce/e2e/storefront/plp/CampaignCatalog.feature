Feature: Campaign Catalog
  Description: Test the functionality of /cc pages

  @qat @dev
  Scenario Outline: Title tags
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to a campaign catalog page
    Then the css title displays

    Examples:
      | device  |
      | desktop |
      | mobile  |

  @qat @dev
  Scenario Outline: Breadcrumbs
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to a campaign catalog page
    And I click the  filter 
    And  displays in the breadcrumbs

    Examples:
      | device  |
      | desktop |

  @qat @dev
  Scenario Outline: H1 tags
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to a campaign catalog page
    Then the css <selector> displays

    Examples:
      | device  | selector                               |
      | desktop | .results-cat-title                     |
      | mobile  | .sfw-plp-search-results--header--title |

  @qat @dev
  Scenario Outline: Facet pill
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to a campaign catalog page
    And I click the  filter <filterName>
    Then the facet pill <filterName> displays
    And at least one product tile displays

    Examples:
      | device  | filterName |
      | desktop |            |

  @qat @dev
  Scenario Outline: Sorting page navigation
    Given I am on a <device> browser
    And I am on the homepage
    And I navigate to a campaign catalog page
    When I click on a sorting <option>
    Then the results header displays

    Examples:
      | device  | option                |
      | desktop | Relevance             |
      | desktop | Newest                |
      | desktop | Bestselling           |
      | desktop | Price: Low to High    |
      | desktop | Price: High to Low    |
      | desktop | Avg. Customer Review  |
      | desktop | Most Reviews          |

  Scenario Outline: CMS Slots
    Given I am on a <device> browser
    When I navigate to a campaign catalog page
    Then the banner displays in slot 20
    And the cms fragment displays in slot 20
    And the cms fragment displays in slot 30

    Examples:
      | device  |
      | desktop |
      | mobile  |

  @qat
  Scenario Outline: Results count
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to a campaign catalog page
    Then <result_count> product tiles display

    Examples:
      | device  | result_count |
      | mobile  | 36           |
      | desktop | 36           |

  Scenario Outline: pagination navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to a campaign catalog page
    When I click on the pagination "next page" button
    Then at least one product tile displays
    When I click on the pagination "previous page" button
    Then 2 product tiles display

    Examples:
      | device  |
      | mobile  |
      | desktop |

  @qat
  Scenario: OOS
    Given I am on a desktop browser
    And I am on the homepage
    When I navigate to a campaign catalog page
    Then the top 4 items are not out of stock campaign catalog search results
