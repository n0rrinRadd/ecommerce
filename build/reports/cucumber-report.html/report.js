$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/com/ecommerce/e2e/storefront/elp/EnhancedLandingPage.feature");
formatter.feature({
  "name": "Enhanced Landing Page",
  "description": "  Description: Test the functionality of /app/department pages",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.step({
  "name": "I am on a \u003cdevice\u003e browser",
  "keyword": "Given "
});
formatter.step({
  "name": "I navigate to the url \u003celp_page\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "the top 4 items are not out of stock \u003celp_page\u003e search results",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "device",
        "elp_page"
      ]
    },
    {
      "cells": [
        "desktop",
        "/b/item-number"
      ]
    },
    {
      "cells": [
        "desktop",
        "/b/horse-1663"
      ]
    }
  ]
});
formatter.scenario({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /b/item-number",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock /b/item-number search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "error_message": "org.assertj.core.api.SoftAssertionError: \nThe following 4 assertions failed:\n1) query:/b/item-number, product tile number:1 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n2) query:/b/item-number, product tile number:2 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n3) query:/b/item-number, product tile number:3 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n4) query:/b/item-number, product tile number:4 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n\n\tat org.assertj.core.api.AbstractSoftAssertions.throwsBestMultipleAssertionsError(AbstractSoftAssertions.java:198)\n\tat org.assertj.core.api.SoftAssertions.assertAll(SoftAssertions.java:131)\n\tat com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:229)\n\tat ✽.the top 4 items are not out of stock /b/item-number search results(file:///Users/cgrandoit/projects/search-test/src/test/java/com/ecommerce/e2e/storefront/elp/EnhancedLandingPage.feature:34)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /b/horse-1663",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock /b/horse-1663 search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "error_message": "org.assertj.core.api.SoftAssertionError: \nThe following 4 assertions failed:\n1) query:/b/horse-1663, product tile number:1 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n2) query:/b/horse-1663, product tile number:2 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n3) query:/b/horse-1663, product tile number:3 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n4) query:/b/horse-1663, product tile number:4 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n\n\tat org.assertj.core.api.AbstractSoftAssertions.throwsBestMultipleAssertionsError(AbstractSoftAssertions.java:198)\n\tat org.assertj.core.api.SoftAssertions.assertAll(SoftAssertions.java:131)\n\tat com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:229)\n\tat ✽.the top 4 items are not out of stock /b/horse-1663 search results(file:///Users/cgrandoit/projects/search-test/src/test/java/com/ecommerce/e2e/storefront/elp/EnhancedLandingPage.feature:34)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/java/com/ecommerce/e2e/storefront/plp/Brands.feature");
formatter.feature({
  "name": "Brands Page",
  "description": "  Description: Test the functionality of /brand pages",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Brand Facet Subcategory page navigation",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@dev"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.step({
  "name": "I am on a \u003cdevice\u003e browser",
  "keyword": "Given "
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.step({
  "name": "I navigate to the url /f/a-pets-life_f1v153040",
  "keyword": "When "
});
formatter.step({
  "name": "the product tiles contain A Pet\u0027s Life in the description",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "device"
      ]
    },
    {
      "cells": [
        "desktop"
      ]
    },
    {
      "cells": [
        "mobile"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Brand Facet Subcategory page navigation",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@dev"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /f/a-pets-life_f1v153040",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the product tiles contain A Pet\u0027s Life in the description",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_product_tile_contain_category_in_the_description(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Brand Facet Subcategory page navigation",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@dev"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a mobile browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /f/a-pets-life_f1v153040",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the product tiles contain A Pet\u0027s Life in the description",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_product_tile_contain_category_in_the_description(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Brand page navigation",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@dev"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.step({
  "name": "I am on a \u003cdevice\u003e browser",
  "keyword": "Given "
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.step({
  "name": "I navigate to the url /brands/american-journey-6422",
  "keyword": "When "
});
formatter.step({
  "name": "only American Journey brand results display",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "device"
      ]
    },
    {
      "cells": [
        "desktop"
      ]
    },
    {
      "cells": [
        "mobile"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Brand page navigation",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@dev"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /brands/american-journey-6422",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "only American Journey brand results display",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.only_x_brand_results_display(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Brand page navigation",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@dev"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a mobile browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /brands/american-journey-6422",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "only American Journey brand results display",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.only_x_brand_results_display(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.step({
  "name": "I navigate to the url \u003cbrand_url\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "the top 4 items are not out of stock \u003cbrand\u003e search results",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "brand_url",
        "brand"
      ]
    },
    {
      "cells": [
        "/brands/american-journey-6422",
        "American Journey"
      ]
    },
    {
      "cells": [
        "/brands/frisco-6767",
        "Frisco"
      ]
    },
    {
      "cells": [
        "/f/purina-pro-plan_f1v330132",
        "Puriuna Pro Plan"
      ]
    },
    {
      "cells": [
        "/brands/royal-canin-7487",
        "Royal Canin"
      ]
    },
    {
      "cells": [
        "/f/wellness_f1v108095",
        "Wellness"
      ]
    },
    {
      "cells": [
        "/brands/nutro-7138",
        "Nutro"
      ]
    },
    {
      "cells": [
        "/brands/hills-6874",
        "Hills"
      ]
    },
    {
      "cells": [
        "/f/instinct_f1v397386",
        "Instinct"
      ]
    },
    {
      "cells": [
        "/brands/merrick-7048",
        "Merrick"
      ]
    }
  ]
});
formatter.scenario({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /brands/american-journey-6422",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock American Journey search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "error_message": "org.assertj.core.api.SoftAssertionError: \nThe following 4 assertions failed:\n1) query:American Journey, product tile number:1 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n2) query:American Journey, product tile number:2 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n3) query:American Journey, product tile number:3 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n4) query:American Journey, product tile number:4 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n\n\tat org.assertj.core.api.AbstractSoftAssertions.throwsBestMultipleAssertionsError(AbstractSoftAssertions.java:198)\n\tat org.assertj.core.api.SoftAssertions.assertAll(SoftAssertions.java:131)\n\tat com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:229)\n\tat ✽.the top 4 items are not out of stock American Journey search results(file:///Users/cgrandoit/projects/search-test/src/test/java/com/ecommerce/e2e/storefront/plp/Brands.feature:224)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /brands/frisco-6767",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock Frisco search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.all({By.cssSelector: .in-stock,By.cssSelector: .out-of-stock})\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027C02YR0CZLVCJ\u0027, ip: \u0027fe80:0:0:0:cde:64d5:abe0:1e99%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.6\u0027, java.version: \u00271.8.0_252\u0027\nDriver info: driver.version: RemoteWebDriver\n\tat org.openqa.selenium.support.pagefactory.ByAll.findElement(ByAll.java:58)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\n\tat com.sun.proxy.$Proxy14.getText(Unknown Source)\n\tat com.ecommerce.pages.storefront.product.ProductDetailPage.productIsAvailable(ProductDetailPage.java:32)\n\tat com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n\tat ✽.the top 4 items are not out of stock Frisco search results(file:///Users/cgrandoit/projects/search-test/src/test/java/com/ecommerce/e2e/storefront/plp/Brands.feature:224)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /f/purina-pro-plan_f1v330132",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock Puriuna Pro Plan search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "error_message": "org.assertj.core.api.SoftAssertionError: \nThe following 4 assertions failed:\n1) query:Puriuna Pro Plan, product tile number:1 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n2) query:Puriuna Pro Plan, product tile number:2 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n3) query:Puriuna Pro Plan, product tile number:3 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n4) query:Puriuna Pro Plan, product tile number:4 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n\n\tat org.assertj.core.api.AbstractSoftAssertions.throwsBestMultipleAssertionsError(AbstractSoftAssertions.java:198)\n\tat org.assertj.core.api.SoftAssertions.assertAll(SoftAssertions.java:131)\n\tat com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:229)\n\tat ✽.the top 4 items are not out of stock Puriuna Pro Plan search results(file:///Users/cgrandoit/projects/search-test/src/test/java/com/ecommerce/e2e/storefront/plp/Brands.feature:224)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /brands/royal-canin-7487",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock Royal Canin search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.all({By.cssSelector: .in-stock,By.cssSelector: .out-of-stock})\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027C02YR0CZLVCJ\u0027, ip: \u0027fe80:0:0:0:cde:64d5:abe0:1e99%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.6\u0027, java.version: \u00271.8.0_252\u0027\nDriver info: driver.version: RemoteWebDriver\n\tat org.openqa.selenium.support.pagefactory.ByAll.findElement(ByAll.java:58)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\n\tat com.sun.proxy.$Proxy14.getText(Unknown Source)\n\tat com.ecommerce.pages.storefront.product.ProductDetailPage.productIsAvailable(ProductDetailPage.java:32)\n\tat com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n\tat ✽.the top 4 items are not out of stock Royal Canin search results(file:///Users/cgrandoit/projects/search-test/src/test/java/com/ecommerce/e2e/storefront/plp/Brands.feature:224)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /f/wellness_f1v108095",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock Wellness search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "error_message": "org.assertj.core.api.SoftAssertionError: \nThe following 4 assertions failed:\n1) query:Wellness, product tile number:1 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n2) query:Wellness, product tile number:2 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n3) query:Wellness, product tile number:3 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n4) query:Wellness, product tile number:4 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n\n\tat org.assertj.core.api.AbstractSoftAssertions.throwsBestMultipleAssertionsError(AbstractSoftAssertions.java:198)\n\tat org.assertj.core.api.SoftAssertions.assertAll(SoftAssertions.java:131)\n\tat com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:229)\n\tat ✽.the top 4 items are not out of stock Wellness search results(file:///Users/cgrandoit/projects/search-test/src/test/java/com/ecommerce/e2e/storefront/plp/Brands.feature:224)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /brands/nutro-7138",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock Nutro search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "error_message": "org.assertj.core.api.SoftAssertionError: \nThe following 4 assertions failed:\n1) query:Nutro, product tile number:1 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n2) query:Nutro, product tile number:2 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n3) query:Nutro, product tile number:3 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n4) query:Nutro, product tile number:4 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n\n\tat org.assertj.core.api.AbstractSoftAssertions.throwsBestMultipleAssertionsError(AbstractSoftAssertions.java:198)\n\tat org.assertj.core.api.SoftAssertions.assertAll(SoftAssertions.java:131)\n\tat com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:229)\n\tat ✽.the top 4 items are not out of stock Nutro search results(file:///Users/cgrandoit/projects/search-test/src/test/java/com/ecommerce/e2e/storefront/plp/Brands.feature:224)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /brands/hills-6874",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock Hills search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.all({By.cssSelector: .in-stock,By.cssSelector: .out-of-stock})\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027C02YR0CZLVCJ\u0027, ip: \u0027fe80:0:0:0:cde:64d5:abe0:1e99%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.6\u0027, java.version: \u00271.8.0_252\u0027\nDriver info: driver.version: RemoteWebDriver\n\tat org.openqa.selenium.support.pagefactory.ByAll.findElement(ByAll.java:58)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\n\tat com.sun.proxy.$Proxy14.getText(Unknown Source)\n\tat com.ecommerce.pages.storefront.product.ProductDetailPage.productIsAvailable(ProductDetailPage.java:32)\n\tat com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n\tat ✽.the top 4 items are not out of stock Hills search results(file:///Users/cgrandoit/projects/search-test/src/test/java/com/ecommerce/e2e/storefront/plp/Brands.feature:224)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /f/instinct_f1v397386",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock Instinct search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "error_message": "org.assertj.core.api.SoftAssertionError: \nThe following 4 assertions failed:\n1) query:Instinct, product tile number:1 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n2) query:Instinct, product tile number:2 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n3) query:Instinct, product tile number:3 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n4) query:Instinct, product tile number:4 was out of stock\nat ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n\n\tat org.assertj.core.api.AbstractSoftAssertions.throwsBestMultipleAssertionsError(AbstractSoftAssertions.java:198)\n\tat org.assertj.core.api.SoftAssertions.assertAll(SoftAssertions.java:131)\n\tat com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:229)\n\tat ✽.the top 4 items are not out of stock Instinct search results(file:///Users/cgrandoit/projects/search-test/src/test/java/com/ecommerce/e2e/storefront/plp/Brands.feature:224)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the url /brands/merrick-7048",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock Merrick search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.all({By.cssSelector: .in-stock,By.cssSelector: .out-of-stock})\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027C02YR0CZLVCJ\u0027, ip: \u0027fe80:0:0:0:cde:64d5:abe0:1e99%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.6\u0027, java.version: \u00271.8.0_252\u0027\nDriver info: driver.version: RemoteWebDriver\n\tat org.openqa.selenium.support.pagefactory.ByAll.findElement(ByAll.java:58)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\n\tat com.sun.proxy.$Proxy14.getText(Unknown Source)\n\tat com.ecommerce.pages.storefront.product.ProductDetailPage.productIsAvailable(ProductDetailPage.java:32)\n\tat com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n\tat ✽.the top 4 items are not out of stock Merrick search results(file:///Users/cgrandoit/projects/search-test/src/test/java/com/ecommerce/e2e/storefront/plp/Brands.feature:224)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/java/com/ecommerce/e2e/storefront/plp/Deals.feature");
formatter.feature({
  "name": "Deals Page",
  "description": "  Description: Test the functionality of /deals pages",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.step({
  "name": "I navigate to the deals page",
  "keyword": "When "
});
formatter.step({
  "name": "I click on the \u003cdeal_type\u003e deal",
  "keyword": "And "
});
formatter.step({
  "name": "the top 4 items are not out of stock \u003cdeal_type\u003e search results",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "deal_type"
      ]
    },
    {
      "cells": [
        "cat food"
      ]
    },
    {
      "cells": [
        "dog food"
      ]
    }
  ]
});
formatter.scenario({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the deals page",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the cat food deal",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.DealsSteps.i_click_on_the_deals_button(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock cat food search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.all({By.cssSelector: .in-stock,By.cssSelector: .out-of-stock})\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027C02YR0CZLVCJ\u0027, ip: \u0027fe80:0:0:0:cde:64d5:abe0:1e99%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.6\u0027, java.version: \u00271.8.0_252\u0027\nDriver info: driver.version: RemoteWebDriver\n\tat org.openqa.selenium.support.pagefactory.ByAll.findElement(ByAll.java:58)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\n\tat com.sun.proxy.$Proxy14.getText(Unknown Source)\n\tat com.ecommerce.pages.storefront.product.ProductDetailPage.productIsAvailable(ProductDetailPage.java:32)\n\tat com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(ResultsSteps.java:226)\n\tat ✽.the top 4 items are not out of stock cat food search results(file:///Users/cgrandoit/projects/search-test/src/test/java/com/ecommerce/e2e/storefront/plp/Deals.feature:125)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the deals page",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.NavigationSteps.i_navigate_to_the_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the dog food deal",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.DealsSteps.i_click_on_the_deals_button(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock dog food search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/java/com/ecommerce/e2e/storefront/plp/Search.feature");
formatter.feature({
  "name": "Search page",
  "description": "  Description: Test the functionality of /s pages",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "OOS Deprioritization",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.step({
  "name": "I search by keyword for \u003cquery\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "the top 4 items are not out of stock \u003cquery\u003e search results",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "query"
      ]
    },
    {
      "cells": [
        "dog food"
      ]
    },
    {
      "cells": [
        "dog treats"
      ]
    },
    {
      "cells": [
        "cat food"
      ]
    },
    {
      "cells": [
        "cat litter"
      ]
    },
    {
      "cells": [
        "dog toys"
      ]
    },
    {
      "cells": [
        "purina pro plan for dogs"
      ]
    },
    {
      "cells": [
        "cat treast"
      ]
    },
    {
      "cells": [
        "dog beds"
      ]
    }
  ]
});
formatter.scenario({
  "name": "OOS Deprioritization",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search by keyword for dog food",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.SearchSteps.i_search_by_keyword_x(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock dog food search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS Deprioritization",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search by keyword for dog treats",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.SearchSteps.i_search_by_keyword_x(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock dog treats search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS Deprioritization",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search by keyword for cat food",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.SearchSteps.i_search_by_keyword_x(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock cat food search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS Deprioritization",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search by keyword for cat litter",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.SearchSteps.i_search_by_keyword_x(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock cat litter search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS Deprioritization",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search by keyword for dog toys",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.SearchSteps.i_search_by_keyword_x(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock dog toys search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS Deprioritization",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search by keyword for purina pro plan for dogs",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.SearchSteps.i_search_by_keyword_x(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock purina pro plan for dogs search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS Deprioritization",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search by keyword for cat treast",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.SearchSteps.i_search_by_keyword_x(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock cat treast search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "OOS Deprioritization",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@release"
    },
    {
      "name": "@qat"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on a desktop browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.ecommerce.steps.BaseSteps.i_am_on_a_x_browser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "And "
});
formatter.match({
  "location": "com.ecommerce.steps.HomeSteps.i_am_on_the_homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search by keyword for dog beds",
  "keyword": "When "
});
formatter.match({
  "location": "com.ecommerce.steps.SearchSteps.i_search_by_keyword_x(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the top 4 items are not out of stock dog beds search results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.ecommerce.steps.ResultsSteps.the_top_x_items_are_not_out_of_stock(int,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});