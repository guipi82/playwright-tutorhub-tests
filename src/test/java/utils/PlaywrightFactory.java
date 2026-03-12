package utils;
import java.util.Arrays;

import com.microsoft.playwright.*;


public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static Page page;
    private static BrowserContext context;

    public static Page initBrowser() {
        playwright = Playwright.create();

        // Browser-Fenster maximieren
        // browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        //                                                       .setHeadless(false)
        //                                                       .setArgs(Arrays.asList(  "--start-maximized", 
        //                                                                                "--disable-translate", 
        //                                                                                "--disable-features=TranslateUI")));
        
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                                                             .setHeadless(true)
                                                             .setSlowMo(5000));
    
        PlaywrightFactory.context = browser.newContext(
            new Browser.NewContextOptions()
                .setViewportSize(1920, 1080) // Setzt die Viewport-Größe auf null, um die volle Bildschirmgröße zu nutzen
                .setLocale("fr-FR")); // Setzt die Sprache auf Französisch

       
        page = context.newPage();
        return page;
    }

    public static Page getPage() {
        if (page == null) {
            return initBrowser();
        }
        return page;
    }

    public static void closeBrowser() {
        if (page != null) {
            page.close();
            page = null;
            
        }

        if (context != null) {
            context.close();
            context = null; 
            
        }

        if (browser != null) {
            browser.close();
            browser = null;
            
        }
        
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }


    
}
