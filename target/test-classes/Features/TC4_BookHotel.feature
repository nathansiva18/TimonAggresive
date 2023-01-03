@BookHotel
Feature: Verifying Adactin Book A Hotel page details

  Scenario Outline: Verifying Adactin Book A Hotel page by entering all the fields in the page
    Given User is on the Adactin page
    When User should perform Login "<userName>" and "<password>"
    Then User should verify after login Success message "Hello sivanathan!"
    When User should enter all fields "<locatin>","<hotelName>","<hotelType>","<roomCount>","<checkIn>","<checkOut>","<persons>" and "<child>"
    Then User should verify after Search Hotel Success message "Select Hotel"
    And User should Select Hotel and Continue
    Then User should verify after Select Hotel Success message "Book A Hotel"
    When User should enter all fields "<firstName>","<lastName>" and "<billingAddress>"
      | CardNo           | CardType         | Month    | Year | CVV |
      | 7869541254659756 | American Express | January  | 2018 | 556 |
      | 4576548751236756 | VISA             | February | 2019 | 123 |
      | 1234567896541257 | Master Card      | March    | 2020 | 589 |
      | 5678954125789654 | Other            | April    | 2021 | 789 |
    Then User should verify after Book a Hotel Success message "Booking Confirmation" and save the generated OrderId

    Examples: 
      | userName   | password | locatin | hotelName   | hotelType | roomCount | checkIn    | checkOut   | persons | child    | firstName | lastName | billingAddress |
      | sivanathan |   732732 | Sydney  | Hotel Creek | Standard  | 2 - Two   | 28/12/2022 | 30/12/2022 | 2 - Two | 0 - None | Siva      | Nathan   | Chennai/OMR    |

  Scenario Outline: Verifying Adactin Book a Hotel page Without entering all the fields in the page
    Given User is on the Adactin page
    When User should perform Login "<userName>" and "<password>"
    Then User should verify after login Success message "Hello sivanathan!"
    When User should enter all fields "<locatin>","<hotelName>","<hotelType>","<roomCount>","<checkIn>","<checkOut>","<persons>" and "<child>"
    Then User should verify after Search Hotel Success message "Select Hotel"
    And User should Select Hotel and Continue
    Then User should verify after Select Hotel Success message "Book A Hotel"
    When User should Book Hotel Without entering any of the fields
    Then User should verify error message after Book a Hotel "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName   | password | locatin | hotelName   | hotelType | roomCount | checkIn    | checkOut   | persons | child    |
      | sivanathan |   732732 | Sydney  | Hotel Creek | Standard  | 2 - Two   | 28/12/2022 | 30/12/2022 | 2 - Two | 0 - None |
