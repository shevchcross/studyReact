Feature: Film functionality

  @integration
  Scenario:  App received POST request for create new Film
  When called POST method for '/films' for create new Film  with request content '/bdd/request/postCreateFilm.json'
    Then response contains status code 201
    And assert that response contains Film

      | duration | name            |
      | 2200     | Vlastelin       |


  @integration
  Scenario: App received GET request for for find Film
    When called GET method for '/films/byname/Vlastelin' for find Film
    Then response contains status code 200
    And assert that Film has

      | duration | name            |
      | 2200     | Vlastelin       |

  @integration
  Scenario:App received GET request for find all Film
    When called GET method for '/films' for find Film
    Then response contains status code 200
    And assert that list<Film>  contains Film

      | duration | name            |
      | 2200     | Vlastelin       |

  @integration
  Scenario: App received DELETE request for delete Film by name
    When alled DELETE method for '/films/Vlastelin' for find Film
    Then response contains status code 200
    And assert that Film does not exit

      | duration | name            |
      | 2200     | Vlastelin       |

  @integration
  Scenario: App received GET request for find Film by name
    When called GET method for '/films/byname/Vlastelin' for find Film by {name}
    Then response contains status code 404
    And assert that Film  does not exit

      | duration | name            |
      | 2200     | Vlastelin       |


