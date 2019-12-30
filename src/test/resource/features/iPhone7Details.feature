@GenerateIPhone7Data
Feature: As a customer of flipkart
  I want to be able to search iPhone 7
  Apply price range, brand and availability filters
  In order to see search results related to applied filter


  Background: Customer navigates to flipkart home page without login
    Given I navigate to flipkart using URL "https://www.flipkart.com"
    #Then Check for the "LoginPopup" and close it
    When I close "LoginPopup" on "LandingPage"
    Then I should navigate to flipkart home page

  Scenario: Successful login
    When I input "iPhone 7" in "SearchBox" on HomePage
    And I click on "SearchBtn"
    And I apply filter "MobileCategory" on "Categories"
    And I select dropdown "30000" on "MinimumPrice"
    And I scroll to apply filter Apple on "Brand"
    And I scroll to apply filter "ExcludeOutOfStack" on "Availability"
    Then I should read the results that show up on the page
    And Display the results to Customer in ascending order of the price
    And close the browser