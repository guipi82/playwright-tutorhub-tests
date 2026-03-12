package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class InscriptionPage {

    // Selektoren für die Inscription Seite
    private final Locator inscriptionTitel;
    private final Locator kontoTypeElevebtn;
    private final Locator kontoTypeRepetiteurbtn;
    private final Locator feldNomutilisateur;
    private final Locator feldEmail;
    private final Locator feldMotDePasse;
    private final Locator feldConfirmMotDePasse;
    private final Locator creerCompteButton;
    private final Locator erreurInscription;

    

    public InscriptionPage (Page page){

        this.inscriptionTitel = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Inscription"));
        this.kontoTypeElevebtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Élève"));
        this.kontoTypeRepetiteurbtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Répétiteur"));
        this.feldNomutilisateur = page.locator("#register-username");
        this.feldEmail = page.locator("#register-email");
        this.feldMotDePasse = page.locator("#register-password");
        this.feldConfirmMotDePasse = page.locator("#register-confirm-password");
        this.creerCompteButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Créer mon Compte"));
        this.erreurInscription = page.getByText("Erreur d'inscription.");

    }


    // Inscription Titel holen
    public String getInscriptionTitelText() {
        return inscriptionTitel.textContent();
    }

    // Konto Type auswählen
    public void selectAccountType(String accountType) {
        if (accountType.equalsIgnoreCase("Élève")) {
            kontoTypeElevebtn.click();
        } else if (accountType.equalsIgnoreCase("Répétiteur")) {
            kontoTypeRepetiteurbtn.click();
        } else {
            throw new IllegalArgumentException("Ungültiger Konto Type: " + accountType);
        }
    }

    // Nom d'utilisateur eingeben
    public void enterNomUtilisateur(String nomUtilisateur) {
        feldNomutilisateur.click();
        feldNomutilisateur.fill(nomUtilisateur);
    }

    // Email eingeben
    public void enterEmail(String email) {
        feldEmail.click();
        feldEmail.fill(email);
    }

    // Mot de Passe eingeben
    public void enterMotDePasse(String motDePasse) {
        feldMotDePasse.click();
        feldMotDePasse.fill(motDePasse);
    }

    // Confirm Mot de Passe eingeben
    public void enterConfirmMotDePasse(String confirmMotDePasse) {
        feldConfirmMotDePasse.click();
        feldConfirmMotDePasse.fill(confirmMotDePasse);
    }

    // "Créer un Compte" Button klicken
    public void clickCreerCompteButton() {
        creerCompteButton.click();
    }

    // Fehlermeldung bei ungültiger Inscription holen
    public String getErreurInscriptionText() {
        return erreurInscription.textContent();
    }



    
}
