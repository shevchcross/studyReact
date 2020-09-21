Feature: Film functionality

  Scenario Outline: As a meneger I want to add a new film.
    Given I can create a new Film
    And I sending post to be created film with duration <duration>, name <name> and filmType <filmType>
    Then I should be able to see my newly created film

    Examples:
      | duration | name           | filmType          |
      | 12345    | New film       | T_3D              |


