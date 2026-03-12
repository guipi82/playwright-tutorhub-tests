Feature: Navigation to login page

  Background:
    Given der Benutzer befindet sich auf der Startseite

  Scenario: Login Page wird korrekt geladen
    When der Benutzer klickt auf den Connexion Button
    Then sollte der Titel "Connexion" angezeigt werden