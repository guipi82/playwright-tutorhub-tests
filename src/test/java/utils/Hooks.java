package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.TutorHubHomePage;

public class Hooks {
    
    // private TestContext testContext;

    // public Hooks(TestContext context) {
    //     this.testContext = context;
    // }

    // @Before
    // public void setUp() {
    //     PlaywrightFactory.initBrowser();
    //     // testContext.page = PlaywrightFactory.getPage();
    //     // testContext.tutorHubHomePage = new TutorHubHomePage(testContext.page);
    // }
    
    
    @After
    public void tearDown() {
        PlaywrightFactory.closeBrowser();
    }
}
