Feature: Tours smoke tests

Background:
  Given user is in landing page

  @smoke
  Scenario: User can go to invoice page
    When he go to "tours" tab
    And leave the default option and search
    When he select to "Details"
    Then he should see "DETAILS" text
    Then he should see the default price should match the Total USD price
    And then he select to no of "adults"
    And he select to no of "child"
    And he select no of "infant"
    When he select to "Book Now"
    Then he should see "EXTRAS" text
    When he fill the minimum required fields "firstName","lastName","email","confirmEmail"
    And he selects to confirmThisBooking
    Then he should see the "INVOICE" text

  @smoke
    Scenario Outline: User should select the valid mode as Air for transport and he should not see the error message
      When he go to "visa" tab
      And he provides his "<email>" address
      And he provides arrival date in Canada
      And he provides his "<phonenumber>"
      And he provides his own "<homeaddress>"
      And he provides his home "<country>"
      And he should provide valid mode for "<transport>"
      And he provides his "<firstname>" and "<lastname>"
      And he provides his "<nationality>" as in passport
      And he provides his birthday
      And he enters his "<gender>"
      And he provides his "<passportid>" number
      And he provides his passport issued
      And he provides his passport expiration date
      And he provides Canadian visa type
      Then he should see the embassy registration charges
      When he click on next button
      Then he should see the payment revision page



      Examples:
        | email |           | phonenumber | | homeaddress |                | country |          | transport | | firstname | | lastname | | nationality |       | gender | | passportid |
        |mvn123@yahoo.com | |7595881245   | | 123 mvn park,London , E1 2AB||United Kingdom (GB)||Air |        |Chris   |    |Lass   |    |United Kingdom (GB) ||Female   ||12345678   |

  @smoke
      Scenario Outline: User enters incorrect email address format and he should see the error message

        When he go to "visa" tab
        And he provides invalid "<email>" address
        And he provides arrival date in Canada
        And he provides his "<phonenumber>"
        And he provides his own "<homeaddress>"
        And he provides his home "<country>"
        And he should provide valid mode for "<transport>"
        And he provides his "<firstname>" and "<lastname>"
        And he provides his "<nationality>" as in passport
        And he provides his birthday
        And he enters his "<gender>"
        And he provides his "<passportid>" number
        And he provides his passport issued
        And he provides his passport expiration date
        And he provides Canadian visa type
        Then he should see the embassy registration charges
        When he click on next button
        Then he should see the error message "<error>"


        Examples:
          | email |           | phonenumber | | homeaddress |                | country |          | transport | | firstname | | lastname | | nationality |       | gender | | passportid | | error |
          |mvn123 | |7595881245   | | 123 mvn park,London , E1 2AB||United Kingdom (GB)||Air |        |Chris   |    |Lass   |    |United Kingdom (GB) ||Female   ||12345678   |            |Your primary email address appears to be invalid. Please check for typos and extra spaces   |

  @smoke
      Scenario Outline: User do not enter phone number and he should see the error message

        When he go to "visa" tab
        And he provides his "<email>" address
        And he provides arrival date in Canada
        And he do not enter his "<phonenumber>"
        And he provides his own "<homeaddress>"
        And he provides his home "<country>"
        And he should provide valid mode for "<transport>"
        And he provides his "<firstname>" and "<lastname>"
        And he provides his "<nationality>" as in passport
        And he provides his birthday
        And he enters his "<gender>"
        And he provides his "<passportid>" number
        And he provides his passport issued
        And he provides his passport expiration date
        And he provides Canadian visa type
        Then he should see the embassy registration charges
        When he click on next button
        Then he should see the error message as "<error>"

        Examples:
          | email |           | phonenumber | | homeaddress |                | country |          | transport | | firstname | | lastname | | nationality |       | gender | | passportid | | error |
          |mvn123 | |   | | 123 mvn park,London , E1 2AB||United Kingdom (GB)||Air |        |Chris   |    |Lass   |    |United Kingdom (GB) ||Female   ||12345678   |            |Please fill out all required fields (outlined in red above)   |

  @smoke
    Scenario Outline: User enters invalid mode of transport as Land and he should see the error message
      When he go to "visa" tab
      And he provides his "<email>" address
      And he provides arrival date in Canada
      And he provides his "<phonenumber>"
      And he provides his own "<homeaddress>"
      And he provides his home "<country>"
      And he provide invalid mode for "<transport>"
      Then he should see the ETA error message as "<etaDisplayedErrorMsg>"
      And he provides his "<firstname>" and "<lastname>"
      And he provides his "<nationality>" as in passport
      And he provides his birthday
      And he enters his "<gender>"
      And he provides his "<passportid>" number
      And he provides his passport issued
      And he provides his passport expiration date
      And he provides Canadian visa type
      Then he should see the embassy registration charges
      When he click on next button
      Then he should also see the displayed error message as "<displayError>"

    Examples:
      | email |           | phonenumber | | homeaddress |                | country |          | transport | | firstname | | lastname | | nationality |       | gender | | passportid | | displayError | | etaDisplayedErrorMsg |
      |mvn123@yahoo.com | |7595881245   | | 123 mvn park,London , E1 2AB||United Kingdom (GB)||Land |        |Chris   |    |Lass   |    |United Kingdom (GB) ||Female   ||12345678   | | You are not allowed to proceed. See the error message above  | |ETA is only required for arrival via Air   |


