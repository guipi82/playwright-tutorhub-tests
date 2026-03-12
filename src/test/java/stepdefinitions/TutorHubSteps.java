package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TutorHubHomePage;
import utils.PlaywrightFactory;
import org.junit.Assert;
import com.microsoft.playwright.Page;



public class TutorHubSteps {
    
    TutorHubHomePage tutorHubHomePage;
    // private TestContext testContext;

    // public TutorHubSteps(TestContext context) {
    //     this.testContext = context;
    // }

    @Given("der Benutzer befindet sich auf der Startseite")
    public void givenDerBenutzerBefindetSichAufDerStartseite() {

        // Browser starten
         Page page = PlaywrightFactory.initBrowser();

        // Page Object erstellen
        tutorHubHomePage = new TutorHubHomePage(page);

        // URL öffnen
        tutorHubHomePage.navigateToHomePage();

        // Warten bis die Seite vollständig geladen ist
        tutorHubHomePage.getHeadingText();
        

    }

    @Then("sollte {string} in dem Oberbegriff enthalten sein")
    public void sollte_in_dem_oberbegriff_enthalten_sein(String expectedHeading) {
        String headingText = tutorHubHomePage.getHeadingText();
        if (!headingText.contains(expectedHeading)) {
            throw new RuntimeException("Der Oberbegriff ist nicht korrekt. Gefunden: " + headingText);
        }
        else {
            System.out.println("Der Oberbegriff ist korrekt: " + headingText);
            Assert.assertTrue(headingText.contains(expectedHeading));
        }
    }

    @And("ein {string} Button sollte sichtbar sein")
    public void andEinEspaceRepetiteurLinkOderEinRechercherButtonSollteSichtbarSein(String buttonText) {
        //boolean isEspacerepetiteurLinkVisible = tutorHubHomePage.linkespacerepetiteur.isVisible();
        boolean isRechercherButtonVisible = tutorHubHomePage.rechercherButton.isVisible();

        if (!isRechercherButtonVisible) {
            throw new RuntimeException("der Button '" + buttonText + "' ist nicht sichtbar.");
        }
        else {
            System.out.println("'" + buttonText + "' Button sichtbar: " + isRechercherButtonVisible);
            Assert.assertTrue(isRechercherButtonVisible);
        }
    }
}
