package InsiderTest.tests;

import InsiderTest.driver.BaseTest;
import InsiderTest.pages.*;
import org.junit.Assert;
import org.testng.annotations.Test;

public class InsiderTest extends BaseTest {

    @Test
    public void testCareerPageNavigation() throws InterruptedException {

        HomePage homePage = new HomePage();
        CareersPage careersPage = new CareersPage();
        ControlPage controlPage = new ControlPage();
        QaJobsPage qaJobsPage = new QaJobsPage();
        ViewRolePage viewRolePage = new ViewRolePage();
        ScreenShotControl screenShotControl = new ScreenShotControl();

        controlPage.HomePageControl();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://useinsider.com/"));


        homePage.clickCompanyMenu();
        careersPage.clickCareers();

        controlPage.clickCareersControl();
        controlPage.careersControlScroll();
        controlPage.careersTamplateControl();

        qaJobsPage.scrollSeeAllTeams();
        qaJobsPage.clickSeeAllQAJobs();

        qaJobsPage.clicFilterByDepartment();
        qaJobsPage.clicFilterByLocation();
        controlPage.verifyJobListContains("Quality Assurance","Quality Assurance","Istanbul, Turkey");

        viewRolePage.clickViewRoleButton();
        controlPage.switchToWindowControl();

    }
}