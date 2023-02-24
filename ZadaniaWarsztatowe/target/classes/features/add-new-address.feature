Feature: Adding a new address to account

  Scenario Outline: User can add (and delete) new address.
    Given The user is registered, has the first address added and is on the home page
    When He logs in with the correct data: email nonorof900@mustbeit.com, password TEST1234
    And Will add address details: Alias <alias>, Address <address>, City <city>, Postal code <postalCode>, Country <country>, Phone <phone>
    Then New address should contain "address details": <expectedAlias>, <expectedAddress>, <expectedCity>, <expectedPostalCode>, <expectedCountry>, <expectedPhone>
    Then User can delete this address

    Examples:
      | alias         |  | address         |  | city     |  | postalCode |  | country        |  | phone     | expectedAlias |  | expectedAddress |  | expectedCity |  | expectedPostalCode |  | expectedCountry |  | expectedPhone |
      | Kolejny Adres |  | Sloneczna 42/12 |  | Katowice |  | 40-023     |  | United Kingdom |  | 123123123 | Kolejny Adres |  | Sloneczna 42/12 |  | Katowice     |  | 40-023             |  | United Kingdom  |  | 123123123     |

