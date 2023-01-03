@SelectHotel
Feature: Verifying Adactin Select Hotel page details

  Scenario Outline: Verifying Adactin Select Hotel page by Selecting Hotel in the page
    Given User is on the Adactin page
    When User should perform Login "<userName>" and "<password>"
    Then User should verify after login Success message "Hello sivanathan!"
    When User should enter all fields "<locatin>","<hotelName>","<hotelType>","<roomCount>","<checkIn>","<checkOut>","<persons>" and "<child>"
    Then User should verify after Search Hotel Success message "Select Hotel"
    And User should Select Hotel and Continue
    Then User should verify after Select Hotel Success message "Book A Hotel"

    Examples: 
      | userName   | password | locatin | hotelName   | hotelType | roomCount | checkIn    | checkOut   | persons | child    |
      | sivanathan |   732732 | Sydney  | Hotel Creek | Standard  | 2 - Two   | 28/12/2022 | 30/12/2022 | 2 - Two | 0 - None |

  Scenario Outline: Verifying Adactin Select Hotel page Without Selecting the Hotel
    Given User is on the Adactin page
    When User should perform Login "<userName>" and "<password>"
    Then User should verify after login Success message "Hello sivanathan!"
    When User should enter all fields "<locatin>","<hotelName>","<hotelType>","<roomCount>","<checkIn>","<checkOut>","<persons>" and "<child>"
    Then User should verify after Search Hotel Success message "Select Hotel"
    And User should Click continue Without Selecting Hotel
    Then User should verify the Select Hotel error message "Please Select a Hotel"

    Examples: 
      | userName   | password | locatin | hotelName   | hotelType | roomCount | checkIn    | checkOut   | persons | child    |
      | sivanathan |   732732 | Sydney  | Hotel Creek | Standard  | 2 - Two   | 28/12/2022 | 30/12/2022 | 2 - Two | 0 - None |
