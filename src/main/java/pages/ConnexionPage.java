package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ConnexionPage {
    
    // Selektoren für die Connexion Seite
    private final Locator CreerUnCompteButton;
    private final Locator connexionTitel;
    private final Locator inputEmail;
    private final Locator inputPassword;
    private final Locator seConnecterButton;
    private final Locator NouveauSurTutorHubTitel;




    public ConnexionPage (Page page){

        this.CreerUnCompteButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Créer un Compte"));
        this.connexionTitel = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Connexion"));
        this.inputEmail = page.locator("#login-email");
        this.inputPassword = page.locator("#login-password");
        this.seConnecterButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Se Connecter"));
        this.NouveauSurTutorHubTitel = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Nouveau sur TutorHub ?"));
    }

    // "Créer un Compte" Button klicken
    public void clickCreerUnCompteButton() {
        CreerUnCompteButton.click();
    }

    // Connexion Titel holen
    public String getConnexionTitelText() {
        return connexionTitel.textContent();
    }

    // Email eingeben
    public void enterEmail(String email) {
        inputEmail.fill(email);
    }

    // Password eingeben
    public void enterPassword(String password) {
        inputPassword.fill(password);
    }

    // "Se Connecter" Button klicken
    public void clickSeConnecterButton() {
        seConnecterButton.click();
    }

    // "Nouveau sur TutorHub ?" Titel holen
    public String getNouveauSurTutorHubTitelText() {
        return NouveauSurTutorHubTitel.textContent();
    }   
}
