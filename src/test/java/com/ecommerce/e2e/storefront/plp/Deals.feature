Feature: Deals Page
  Description: Test the functionality of /deals pages

  @qat @dev
  Scenario Outline: Title tags
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the deals page
    And I click on the dog food deal
    Then the css title displays

    Examples:
      | device  |
      | desktop |
      | mobile  |

  @qat @dev
  Scenario Outline: Breadcrumbs
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the deals page
    And I click on the <category> deal
    And I click the <facetCategory> filter <filterName>
    Then Today's Deals displays in the breadcrumbs
    And Dog Deals displays in the breadcrumbs

    Examples:
      | device  | category | facetCategory | filterName |

  @qat @dev
  Scenario Outline: H1 tags
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the deals page
    And I click on the dog food deal
    Then the css <selector> displays

    Examples:
      | device  | selector                               |
      | desktop | .results-cat-title                     |
      | mobile  | .sfw-plp-search-results--header--title |

  @qat @dev
  Scenario Outline: Facet pill
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the deals page
    And I click on the <category> deal
    And I click the <facetCategory> filter <filterName>
    Then the facet pill <filterName> displays

    Examples:
      | device  | category | facetCategory | filterName |

  @qat @dev
  Scenario Outline: Subcategory page navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the deals page
    And I click on the <button> deal
    And the product tiles contain <category> in the description

    Examples:
    | device  | button   |
    | desktop | dog food |

  @qat @dev
  Scenario Outline: Sorting page navigation
    Given I am on a <device> browser
    And I am on the homepage
    When I navigate to the deals page
    And I click on the <category> deal
    When I click on a sorting <option>
    Then at least one product tile displays

    Examples:
      | device  | option                | category  |
      | desktop | Relevance             | dog food  |
      | desktop | Newest                | dog food  |
      | desktop | Bestselling           | dog food  |
      | desktop | Price: Low to High    | dog food  |
      | desktop | Price: High to Low    | dog food  |
      | desktop | Avg. Customer Review  | dog food  |
      | desktop | Most Reviews          | dog food  |

  @qat
  Scenario Outline: Results count
    Given I am on a <device> browser
    And I am on the homepage
    And I navigate to the deals page
    When I click on the cat food deal
    Then <result_count> product tiles display

    Examples:
      | device  | result_count |
      | desktop | 36           |
      | mobile  | 36          |

  @qat
  Scenario Outline: pagination navigation
    Given I am on a <device> browser
    And I am on the homepage
    And I navigate to the deals page
    When I click on the cat food deal
    When I click on the pagination "next page" button
    Then at least one product tile displays
    When I click on the pagination "previous page" button
    Then <result_count> product tiles display

    Examples:
      | device  | result_count |
      | desktop | 36           |
      | mobile  | 36          |

  @qat
  Scenario Outline: OOS
    Given I am on a desktop browser
    And I am on the homepage
    When I navigate to the deals page
    And I click on the <deal_type> deal
    Then the top 4 items are not out of stock <deal_type> search results

    Examples:
      | deal_type |