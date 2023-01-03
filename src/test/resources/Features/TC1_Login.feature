@Login
Feature: Verifying Adactin Hotel Login details

  Scenario Outline: Verifying Adactin Hotel Login Valid with valid credentials
    Given User is on the Adactin page
    When User should perform Login "<userName>" and "<password>"
    Then User should verify after login Success message "Hello sivanathan!"

    Examples: 
      | userName   | password |
      | sivanathan |   732732 |

  Scenario Outline: Verifying Adactin Hotel Login using Enter with valid credentials
    Given User is on the Adactin page
    When User should perform Login "<userName>" and "<password>" with Enter Key
    Then User should verify after login Success message "Hello sivanathan!"

    Examples: 
      | userName   | password |
      | sivanathan |   732732 |

  Scenario Outline: Verifying Adactin Hotel Login with Invalid Credentials
    Given User is on the Adactin page
    When User should perform Login "<userName>" and "<password>"
    Then User should verify after login with Invalid Credential error message contains "Invalid Login details or Your Password might have expired"

    Examples: 
      | userName | password |
      | sivan    |      732 |
