Feature: Film functionality

  @integration
  Scenario:  App received POST request for create new Film
    Given Application started
    And existing Film
      | duration | name            |
      | 3000     | Same            |
  When called POST method for '/films' for create new Film  with request content '/bdd/request/postCreateFilm.json'
    Then response contains status code 201
    And assert that response contains Film
      | duration | name            |
      | 2200     | Vlastelin       |


  @integration
  Scenario: App received GET request for for find Film
    Given Application started
    And existing Film
      | duration | name            |
      | 3000     | Vlastelin       |
    When called GET method for '/films/name/Vlastelin' for find Film
    Then response contains status code 200
    And assert that response contains Film
      | duration | name            |
      | 3000     | Vlastelin       |

  @integration
  Scenario: App received GET request for find Film by id
    Given Application started
    And existing Film
      | duration | name            |
      | 3000     | Same            |
    When called GET method for '/films/4' for find Film
    Then response contains status code 200
    And assert that response contains Film
      | duration | name            |
      | 3000     | Same            |

  @integration
  Scenario:App received GET request for find all Film
    Given Application started
    And existing Film
      | duration | name            |
      | 3000     | Same            |
    When called GET method for '/films' for find Film
    Then response contains status code 200
    And assert that response contains Film
      | duration | name            |
      | 3000     | Same            |

  @integration
  Scenario: App received DELETE request for delete Film by name
    Given Application started
    And existing Film
      | duration | name            |
      | 3000     | Vlastelin       |
    When called DELETE method for '/films/name/Vlastelin' for delete Film
    Then response contains status code 200
    And assert that Film not exists
      | duration | name            |
      | 2200     | Vlastelin       |

#  @integration
#  Scenario: App received GET request for find Film by name
#    When called GET method for '/films/byname/Vlastelin' for find Film by {name}
#    Then response contains status code 404
#    And assert that Film  does not exit
#
#      | duration | name            |
#      | 2200     | Vlastelin       |


