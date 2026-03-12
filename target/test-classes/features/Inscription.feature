Feature: Inscription
  
  Background:
    Given der Benutzer befindet sich auf der Startseite
    When der Benutzer klickt auf den Connexion Button
    Then sollte der Titel "Connexion" angezeigt werden

  Scenario: fehlgeschlagene Registrierung
    When der Benutzer auf "Creer un Compte" klickt
    And der Benutzer den Kontotyp "Eleve" auswaehlt
    And der Benutzer den Benuternamen "JohnDoe" eingibt
    And der Benutzer die E-mail "test@exemple" eingibt
    And der Benutzer das Passwort "Monnumero++" eingibt
    And der Benutzer das Passwort "Monnumero++" bestaetigt
    And der Benutzer auf "Creer mon Compte" klickt
    Then sollte die Fehlermeldung "Erreur d'inscription." angezeigt werden

