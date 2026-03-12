package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import pages.ConnexionPage;
import pages.InscriptionPage;
import pages.TutorHubHomePage;
import utils.PlaywrightFactory;

public class InscriptionSteps {
    
    private InscriptionPage inscriptionPage;
    private ConnexionPage connexionPage;
    private TutorHubHomePage tutorHubHomePage;


    @When("der Benutzer auf \"Creer un Compte\" klickt")
    public void derBenutzerKlicktAufDenInscriptionButton() {
        connexionPage = new ConnexionPage(PlaywrightFactory.getPage());
        connexionPage.clickCreerUnCompteButton();
    }

    @And("der Benutzer den Kontotyp \"Eleve\" auswaehlt")
    public void andDerBenutzerDenKontotypEleveAuswaehlt() {
        inscriptionPage = new InscriptionPage(PlaywrightFactory.getPage());
        inscriptionPage.selectAccountType("Élève");         
    }

    @And("der Benutzer den Benuternamen \"JohnDoe\" eingibt")
    public void andDerBenutzerDenBenuternamenJohnDoeEingibt() {
        inscriptionPage.enterNomUtilisateur("JohnDoe");
    }

    @And("der Benutzer die E-mail \"test@exemple\" eingibt")
    public void andDerBenutzerDieEMailTestTutorComEingibt() {
        inscriptionPage.enterEmail("test@tutor.com");
    }

    @And("der Benutzer das Passwort \"Monnumero++\" eingibt")
    public void andDerBenutzerDasPasswortMonnumeroEingibt() {
        inscriptionPage.enterMotDePasse("Monnumero++");
    }

    @And("der Benutzer das Passwort \"Monnumero++\" bestaetigt")
    public void andDerBenutzerDasBestaetigteMotDePasseMonnumeroEingibt() {
        inscriptionPage.enterConfirmMotDePasse("Monnumero++");
    }

    @And("der Benutzer auf \"Creer mon Compte\" klickt")
    public void andDerBenutzerAufCreerMonCompteKlickt() {
        inscriptionPage.clickCreerCompteButton();
    }

    @Then("sollte die Fehlermeldung \"Erreur d'inscription.\" angezeigt werden")
    public void thenSollteDieFehlermeldungErreurDInscriptionAngezeigtWerden() {
        String actualErrorMessage = inscriptionPage.getErreurInscriptionText();
        if (!actualErrorMessage.contains("Erreur d'inscription.")) {
            throw new RuntimeException("Die Fehlermeldung ist nicht korrekt. Gefunden: " + actualErrorMessage);
        }
        else {
            System.out.println("Die Fehlermeldung ist korrekt: " + actualErrorMessage);
            Assert.assertTrue(actualErrorMessage.contains("Erreur d'inscription."));
        }   
    }

}
