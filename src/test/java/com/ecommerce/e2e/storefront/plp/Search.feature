Feature: Search page
  Description: Test the functionality of /s pages

  @qat @dev
  Scenario Outline: Title tags
    Given I am on a <device> browser
    And I am on the homepage
    And I search by keyword for  
    Then the css title displays

    Examples:
      | device  |
      | desktop |
      | mobile  |

  @qat @dev
  Scenario Outline: Query H1 tags
    Given I am on a <device> browser
    And I am on the homepage
    And I search by keyword for  
    Then the css <selector> displays
    And   displays in the results header


    Examples:
      | device  | selector                               |
      | desktop | .results-cat-title                     |
      | mobile  | .sfw-plp-search-results--header--title |

  @qat @dev
  Scenario Outline: Facet page navigation
    Given I am on a <device> browser
    And I am on the homepage
    And I search by keyword for  
    And I click the <facetCategory> filter <filterName>
    Then the facet pill <filterName> displays
    And the product tiles contain <filterName> in the description

    Examples:
      | device  | facetCategory | filterName |
      | desktop | brand         | Addiction  |

  @qat @dev
  Scenario Outline: Sorting page navigation
    Given I am on a <device> browser
    And I am on the homepage
    And I search by keyword for  
    When I click on a sorting <option>
    Then at least one product tile displays

    Examples:
      | device  | option                |
      | desktop | Newest                |
      | desktop | Price: Low to High    |
      | desktop | Price: High to Low    |
      | desktop | Avg. Customer Review  |
      | desktop | Most Reviews          |
      | desktop | Relevance             |

  @qat @dev
  Scenario Outline: Price point determines shipping message
    Given I am on a <device> browser
    And I am on the homepage
    When I search for the <sorted> priced forza10
    Then I see the configured shipping <message> on the product tile

    Examples:
      | device  | sorted  | message                            |
      | desktop | lowest  | FREE 1-3 day shipping over $49     |
      | desktop | highest | FREE 1-3 day shipping on this item |
      | mobile  | lowest  | FREE 1-3 day shipping over $49     |
      | mobile  | highest | FREE 1-3 day shipping on this item |

  @qat
  Scenario Outline: Dropship items cannot promise 1-2 day shipping
    Given I am on a <device> browser
    And I am on the homepage
    When I search for the <sorted> priced <sku>
    Then I see the following shipping <message> on the product tile

    Examples:
      | device  | sorted  | sku            | message                    |
      | desktop | lowest  | 1234           | FREE shipping over $49     |
      | desktop | highest | 5678           | FREE shipping on this item |
      | desktop | lowest  | 4321           | FREE shipping over $49     |
      | mobile  | lowest  | 1234           | FREE shipping over $49     |
      | mobile  | highest | 5678           | FREE shipping on this item |
      | mobile  | lowest  | 4321           | FREE shipping over $49     |

  @qat @dev
  Scenario Outline: Gift card tiles do not see free shipping
    Given I am on a <device> browser
    And I am on the homepage
    When I search by keyword for ecommerce pet
    Then I should not see the message "FREE shipping over $49" on the "ecommerce eGift Card" tiles

    Examples:
      | device  |
      | desktop |

  @qat
  Scenario Outline: Results count
    Given I am on a <device> browser
    And I am on the homepage
    And I search by keyword for  
    Then <result_count> product tiles display

    Examples:
      | device  | result_count |
      | desktop | 36           |
      | mobile  | 36          |

  @qat
  Scenario Outline: Pagination navigation with expanded mobile results list
    Given I am on a <device> browser
    And I am on the homepage
    And I search by keyword for  
    When I click on the pagination "next page" button
    Then at least one product tile displays
    When I click on the pagination "previous page" button
    Then <result_count> product tiles display

    Examples:
      | device  | result_count |
      | desktop | 36           |
      | mobile  | 36           |

  Scenario Outline: OOS Deprioritization
    Given I am on a desktop browser
    And I am on the homepage
    When I search by keyword for <query>
    Then the top 4 items are not out of stock <query> search results

    Examples:
      | query                    |

  @qat @dev
  Scenario Outline: Virtual Bundling
    Given I am on a desktop browser
    And I am on the homepage
    When I search by keyword for <SKU>
    And the product tiles contain Bundle: in the description

    Examples:
      | SKU  |

