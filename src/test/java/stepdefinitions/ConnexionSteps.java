package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Test;

import org.junit.Assert;

import com.microsoft.playwright.Page;
import pages.ConnexionPage;
import pages.TutorHubHomePage;
import utils.PlaywrightFactory;
import utils.TestContext;

public class ConnexionSteps {

    ConnexionPage connexionPage;
    TutorHubHomePage tutorHubHomePage;
    // private TestContext testContext;
    
    // public ConnexionSteps( TestContext context) {
    //     this.testContext = context;
    // }

    @When("der Benutzer klickt auf den Connexion Button")
    public void derBenutzerKlicktAufDenConnexionButton() {
        tutorHubHomePage = new TutorHubHomePage(PlaywrightFactory.getPage());
        // System.out.println("Vor dem Klick auf Connexion");
        // PlaywrightFactory.getPage().pause();
        tutorHubHomePage.clickNavConnexion();

    }

    @Then("sollte der Titel {string} angezeigt werden")
    public void sollteDerConnexionTitelAngezeigtWerden(String expectedTitle) {
        // System.out.println("Vor dem Klick auf Connexion");
        // PlaywrightFactory.getPage().pause();
        connexionPage = new ConnexionPage(PlaywrightFactory.getPage());
        String actualTitle = connexionPage.getConnexionTitelText();
        if (!actualTitle.contains(expectedTitle)) {
            throw new RuntimeException("Der Connexion Titel ist nicht korrekt. Gefunden: " + actualTitle);
        }
        else {
            System.out.println("Der Connexion Titel ist korrekt: " + actualTitle);
            Assert.assertTrue(actualTitle.contains(expectedTitle));
        }
    }

    @When("der Benutzer gibt die E-mail {string} und das Passwort {string} ein")
    public void derBenutzerGibtDieEMailUndDasPasswortEin(String email,  String password) {
        connexionPage = new ConnexionPage(PlaywrightFactory.getPage());
        connexionPage.enterEmail(email);
        connexionPage.enterPassword(password);
    }

    @And("der Benutzer klickt auf \"Se Connecter\"")
    public void derBenutzerKlicktAufDenSeConnecterButton() {
        connexionPage.clickSeConnecterButton();
    }

    @Then("sollte die Fehlermeldung \"Erreur de connexion\" angezeigt werden")
    public void sollteDieFehlermeldungErreurDeConnexionAngezeigtWerden() {
        String actualErrorMessage = connexionPage.getErreurDeConnectionText();
        if (!actualErrorMessage.contains("Erreur de connexion")) {
            throw new RuntimeException("Die Fehlermeldung ist nicht korrekt. Gefunden: " + actualErrorMessage);
        }
        else {
            System.out.println("Die Fehlermeldung ist korrekt: " + actualErrorMessage);
            Assert.assertTrue(actualErrorMessage.contains("Erreur de connexion"));
        }
    }

}
