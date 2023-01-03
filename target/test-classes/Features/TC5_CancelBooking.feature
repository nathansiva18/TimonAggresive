@CancelBooking
Feature: Verifying Adactin Cancel Booking details

  Scenario Outline: Verifying Adactin Cancel Booking by Cancelling generated Order Id
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
    And User should cancel generated Order id
    Then User should verify after cancel order id success message "The booking has been cancelled."

    Examples: 
      | userName   | password | locatin | hotelName   | hotelType | roomCount | checkIn    | checkOut   | persons | child    | firstName | lastName | billingAddress |
      | sivanathan |   732732 | Sydney  | Hotel Creek | Standard  | 2 - Two   | 28/12/2022 | 30/12/2022 | 2 - Two | 0 - None | Siva      | Nathan   | Chennai/OMR    |

  Scenario Outline: Verifying Adactin Cancel Booking by Cancelling existing Order Id
    Given User is on the Adactin page
    When User should perform Login "<userName>" and "<password>"
    Then User should verify after login Success message "Hello sivanathan!"
    And User should Cancel existing order id "<orderId>"
    Then User should verify after cancel order id success message "The booking has been cancelled."

    Examples: 
      | userName   | password | orderId    |
      | sivanathan |   732732 | 35O9RWL111 |
