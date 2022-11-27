@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

	Background:
	Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
   	Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANK YOU FOR YOUR ORDER" message is displayed on ConfirmationPage
        
    Examples: 
      | name  								|  password		    |	productName |
      | standard_user |  secret_sauce    | Sauce Labs Onesie | 
      | standard_user |  secret_sauce    | Sauce Labs Bolt T-Shirt| 
      | standard_user |  secret_sauce    |Sauce Labs Fleece Jacket|