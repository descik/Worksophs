Feature: workshops

  Scenario: user can register on the page https://men-men-s-01.codersguru.pl/
    Given there is browser opened with page "https://men-men-s-01.codersguru.pl/"
    When user clicks zaloz konto button
    Then user is on registration page
    When user fills all mandatory fields with values:
      | fos_user_registration_form_email                | wp91333@wp.pl |
      | fos_user_registration_form_name                 | Jan           |
      | fos_user_registration_form_lastname             | Kowalski      |
      | fos_user_registration_form_plainPassword_first  | Password1     |
      | fos_user_registration_form_plainPassword_second | Password1     |
      | form_city                                       | Cracow        |
      | form_postal_code                                | 20-000        |
      | form_street                                     | Centralna     |
      | form_number                                     | 20            |
    And user clicks Zarejestruj button


  Scenario Outline: many users can register
    Given there is browser opened with page "https://men-men-s-01.codersguru.pl/"
    When user clicks zaloz konto button
    Then user is on registration page
    When input field mail is filed with <mailparameter>
    And input field name is filed with <nameparameter>
    And input field lastname is filed with <lastnameparameter>
    And input field password is filed with <passwordparameter>
    And input field secondpassword is filed with <secondpasswordparameter>
    And input field city is filed with <cityparameter>
    And input field zip is filed with <zipparameter>
    And input field street is filed with <streetparameter>
    And input field number is filed with <numberarameter>
    And user select cheackbox
    And user clicks Zarejestruj button
    Examples:
      | mailparameter   | nameparameter | lastnameparameter | passwordparameter | secondpasswordparameter | cityparameter | zipparameter | streetparameter | numberarameter |
      | Jan0@janjan.pl  | Jan           | Kowalski          | Password1         | Password1               | Cracow        | 20-200       | Dluga           | 23             |
      | Jan11@janjan.pl | Janek         | Wozniak           | Password1         | Password1               | Opoczno       | 21-200       | Waska           | 2              |
      | Jan22@janjan.pl | Andrzej       | Kowal             | Password1         | Password1               | Warszawa      | 20-300       | Szeroka         | 3              |
      | Jan33@janjan.pl | Barbara       | Wegier            | Password1         | Password1               | Wroclaw       | 30-300       | Mala            | 11             |
