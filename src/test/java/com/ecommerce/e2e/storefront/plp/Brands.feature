Feature: Brands Page
  Description: Test the functionality of /brand pages

  @qat @dev
  Scenario Outline: Brand link navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the brands page
    And I click on brand 
    Then the page navigates to /brands/

    Examples:
      | device  |
      | desktop |
      | mobile  |

  @qat @dev
  Scenario Outline: Brand Facet link navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the brands page
    And I click on brand 
    Then the page navigates to /f/

    Examples:
      | device  |
      | desktop |
      | mobile  |

  @qat @dev
  Scenario Outline: Brand Title tags
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /brands/
    Then the css title displays

    Examples:
      | device  |
      | desktop |
      | mobile  |

  @qat @dev
  Scenario Outline: Brand Facet Title tags
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /f/
    Then the css title displays

    Examples:
      | device  |
      | desktop |
      | mobile  |

  @qat @dev
  Scenario Outline: Brand H1 tags
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /brands/
    Then the css <selector> displays

    Examples:
      | device  | selector                               |
      | desktop | .results-cat-title                     |
      | mobile  | .sfw-plp-search-results--header--title |

  @qat @dev
  Scenario Outline: Brand Facet H1 tags
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /f/
    Then the css <selector> displays

    Examples:
      | device  | selector                               |
      | desktop | .results-cat-title                     |
      | mobile  | .sfw-plp-search-results--header--title |

  @qat @dev
  Scenario Outline: Brand Subcategory <variation> <device> page navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /brands/
    And the product tiles contain in the description

    Examples:
      | device  |
      | desktop |
      | mobile  |

  @qat @dev @qat
  Scenario Outline: Brand Facet Subcategory page navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /f/
    And the product tiles contain 

    Examples:
      | device  |
      | desktop |
      | mobile  |

  @qat @dev @qat
  Scenario Outline: Brand page navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /brands/
    Then only  brand results display

    Examples:
      | device  |
      | desktop |
      | mobile  |

  @qat @dev
  Scenario Outline: Brand Facet page navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /f/
    Then only  brand facet results display
    Then the facet pill <brand_facet> displays

    Examples:
      | device  | brand_facet  |
      | desktop |              |
      | mobile  |              |

  @qat @dev
  Scenario Outline: Brand Sorting page navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /brands/
    When I click on a sorting <option>
    Then at least one product tile displays

    Examples:
      | device  | option                |
      | desktop | Relevance             |
      | desktop | Newest                |
      | desktop | Bestselling           |
      | desktop | Price: Low to High    |
      | desktop | Price: High to Low    |
      | desktop | Avg. Customer Review  |
      | desktop | Most Reviews          |

  @qat @dev
  Scenario Outline: Brand Facet Sorting page navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /f/
    When I click on a sorting <option>
    Then at least one product tile displays

    Examples:
      | device  | option                |
      | desktop | Relevance             |
      | desktop | Newest                |
      | desktop | Bestselling           |
      | desktop | Price: Low to High    |
      | desktop | Price: High to Low    |
      | desktop | Avg. Customer Review  |
      | desktop | Most Reviews          |

  @qat
  Scenario Outline: Results count
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /brands/
    Then <result_count> product tiles display

    Examples:
      | device  | result_count |
      | desktop | 36           |
      | mobile  | 36           |

  @qat
  Scenario Outline: Brand pagination navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /brands/
    Then <results_count> product tiles display
    When I click on the pagination "next page" button
    Then at least one product tile displays
    When I click on the pagination "previous page" button
    Then <results_count> product tiles display

    Examples:
      | device  | results_count |
      | desktop | 36            |
      | mobile  | 36            |

  @qat
  Scenario Outline: Brand Facet pagination navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /brands/
    Then <results_count> product tiles display
    When I click on the pagination "next page" button
    Then at least one product tile displays
    When I click on the pagination "previous page" button
    Then <results_count> product tiles display

    Examples:
      | device  | results_count |
      | desktop | 36            |
      | mobile  | 36            |

  @qat @dev
  Scenario Outline: Brand facet pill
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the url /f/
    Then the facet pill A Pet's Life displays

    Examples:
      | device  |
      | desktop |
      | mobile  |

  @qat
  Scenario Outline: OOS
    Given I am on a desktop browser
    And I am on the homepage
    When I navigate to the url <brand_url>
    Then the top 4 items are not out of stock <brand> search results

    Examples:
      | brand_url                     | brand            |
