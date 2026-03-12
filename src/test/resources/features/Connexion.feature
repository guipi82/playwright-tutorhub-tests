Feature: Navigation to login page

  Background:
    Given der Benutzer befindet sich auf der Startseite
    When der Benutzer klickt auf den Connexion Button

 Scenario: Login Page wird korrekt geladen
    Then sollte der Titel "Connexion" angezeigt werden

 Scenario: fehlgeschlagene Connexion
    When der Benutzer gibt die E-mail "tester@exemple" und das Passwort "Monnumero++" ein
    And der Benutzer klickt auf "Se Connecter"
    Then sollte die Fehlermeldung "Erreur de connexion" angezeigt werden 

