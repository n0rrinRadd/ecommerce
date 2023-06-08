package com.ecommerce.steps;

import com.ecommerce.pages.storefront.discovery.header.Facets;
import io.cucumber.java.en.And;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class FacetSteps {

    WebDriver driver;
    Facets facets;
    SoftAssertions softly;

    private BaseDriver baseDriver;

    public FacetSteps(BaseDriver baseDriver) {
        this.baseDriver = baseDriver;
        this.driver = baseDriver.getDriver();
        this.softly = new SoftAssertions();
    }

    @And("I click the first {string} facet")
    public void i_click_the_first_x_facet(String x) {
        facets = new Facets(driver);
        facets.clickFilterValueInFilterSection(1, x);
    }

    @And("the facet pill {} displays")
    public void the_x_facet_pill_displays(String x){
        facets = new Facets(driver);
        softly.assertThat(facets.getFacetsByName(x)).isNotNull();
        softly.assertAll();
    }
}
