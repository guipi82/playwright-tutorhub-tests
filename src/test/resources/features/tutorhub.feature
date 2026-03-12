Feature: TutorHub Homepage
  Scenario: Homepage wird korrekt geladen
    Given der Benutzer befindet sich auf der Startseite
    Then sollte "vos examens avec les meilleurs" in dem Oberbegriff enthalten sein
    And ein "Rechercher" Button sollte sichtbar sein
    
