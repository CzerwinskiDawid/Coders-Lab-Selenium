Feature: Adding a new address to account

  Scenario Outline: User can add (and delete) new address.
    Given User is on the main page
    When He logs in with the correct data: email nonorof900@mustbeit.com, password TEST1234
    And Will add address details: Alias <alias>, Address <address>, City <city>, Postal code <postalCode>, Country <country>, Phone <phone>

    Examples:
      | alias         |  | address         |  | city     |  | postalCode |  | country |  | phone     |
      | Kolejny Adres |  | Sloneczna 42/12 |  | Katowice |  | 40-023     |  | Polska  |  | 123123123 |


