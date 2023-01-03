@SearchHotel
Feature: Verifying Adactin Search Hotel page details

  Scenario Outline: Verifying Adactin Search Hotel page by entering all fields in the page
    Given User is on the Adactin page
    When User should perform Login "<userName>" and "<password>"
    Then User should verify after login Success message "Hello sivanathan!"
    When User should enter all fields "<locatin>","<hotelName>","<hotelType>","<roomCount>","<checkIn>","<checkOut>","<persons>" and "<child>"
    Then User should verify after Search Hotel Success message "Select Hotel"

    Examples: 
      | userName   | password | locatin | hotelName   | hotelType | roomCount | checkIn    | checkOut   | persons | child    |
      | sivanathan |   732732 | Sydney  | Hotel Creek | Standard  | 2 - Two   | 28/12/2022 | 30/12/2022 | 2 - Two | 0 - None |

  Scenario Outline: Verifying Adactin Search Hotel page by entering only mandatory fields in the page
    Given User is on the Adactin page
    When User should perform Login "<userName>" and "<password>"
    Then User should verify after login Success message "Hello sivanathan!"
    When User should enter only mandatory fields "<locatin>","<roomCount>","<checkIn>","<checkOut>" and "<persons>"
    Then User should verify after Search Hotel Success message "Select Hotel"

    Examples: 
      | userName   | password | locatin | roomCount | checkIn    | checkOut   | persons |
      | sivanathan |   732732 | Sydney  | 2 - Two   | 28/12/2022 | 30/12/2022 | 2 - Two |

  Scenario Outline: Verifying Adactin Search Hotel page by entering Expired CheckIn and CheckOut Date fields in the page
    Given User is on the Adactin page
    When User should perform Login "<userName>" and "<password>"
    Then User should verify after login Success message "Hello sivanathan!"
    When User should enter all fields "<locatin>","<hotelName>","<hotelType>","<roomCount>","<checkIn>","<checkOut>","<persons>" and "<child>"
    Then User should verify after Search appearance of the date error message "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName   | password | locatin | hotelName   | hotelType | roomCount | checkIn    | checkOut   | persons | child    |
      | sivanathan |   732732 | Sydney  | Hotel Creek | Standard  | 2 - Two   | 30/12/2022 | 01/12/2022 | 2 - Two | 0 - None |

  Scenario Outline: Verifying Adactin Search Hotel page by Without entering all fields in the page
    Given User is on the Adactin page
    When User should perform Login "<userName>" and "<password>"
    Then User should verify after login Success message "Hello sivanathan!"
    When User should go for Search without entering any of the fields
    Then User should verify after Search error message "Please Select a Location"

    Examples: 
      | userName   | password |
      | sivanathan |   732732 |
