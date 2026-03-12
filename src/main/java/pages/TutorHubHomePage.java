package pages;


import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TutorHubHomePage {

    private final Page page;

    // URL
    private final String url = "https://tutorhub.software";

    // Selektoren für die Homepage
    private final Locator heading;
    private final Locator navconnexion;
    public final Locator linkespacerepetiteur;
    public final Locator rechercherButton;
    private final Locator navTrouverUnProf;
    private final Locator navTarifs;
    private final Locator navCommentCamarche;
    private final Locator navAPropos;
    private final Locator inputMatiere;
    private final Locator inputQuartier;
    private final Locator linkVoirTousLesProfs;

    public TutorHubHomePage (Page page){

        this.page = page;

        this.heading = page.locator("h1");
        //this.navconnexion = page.locator("nav a[href='/Connexion']");
        this.navconnexion = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Connexion"));
        this.linkespacerepetiteur = page.locator("nav a[href='/espace-repetiteur']");
        this.rechercherButton = page.locator("button:has-text('Rechercher')");
        this.navTrouverUnProf = page.locator("nav a[href='/TrouverUnProf']");
        this.navTarifs = page.locator("nav a[href='/Tarifs']");
        this.navCommentCamarche = page.locator("nav a[href='/CommentCamarche']");
        this.navAPropos = page.locator("nav a[href='/APropos']");
        this.inputMatiere = page.locator("input[placeholder='Matière']");
        this.inputQuartier = page.locator("input[placeholder='Quartier']");
        this.linkVoirTousLesProfs = page.locator("a[href='/recherche']");

    }

    // Seite Öffnen
    public void navigateToHomePage() {
        page.navigate(url);
    }

    // Seitentitel holen
    public String getHeadingText() {
        return heading.textContent();
    }

    // Aktuelle URL holen    
    public String getCurrentUrl() {
        return page.url();
    }

    // Connexion Button klicken
    public void clickNavConnexion() {
        navconnexion.click();
    }

    // Rechercher un répétiteur Button klicken
    public void clickEspacerepetiteurlink() {
        linkespacerepetiteur.click();
    }

    // Rechercher Button klicken
    public void clickRechercherButton() {
        rechercherButton.click();
    }

    // Navigation zu "Trouver un prof"
    public void clickNavTrouverUnProf() {
        navTrouverUnProf.click();
    }

    // Navigation zu "Tarifs"
    public void clickNavTarifs() {
        navTarifs.click();
    }

    // Navigation zu "Comment ça marche"
    public void clickNavCommentCamarche() {
        navCommentCamarche.click();
    }

    // Navigation zu "A propos"
    public void clickNavAPropos() {
        navAPropos.click();
    }

    // Eingabe in das "Matière" Feld
    public void enterMatiere(String matiere) {
        inputMatiere.fill(matiere);
    }

    // Eingabe in das "Quartier" Feld
    public void enterQuartier(String quartier) {
        inputQuartier.fill(quartier);
    }

    // Link "Voir tous les profs" klicken
    public void clickVoirTousLesProfs() {
        linkVoirTousLesProfs.click();
    }

}
