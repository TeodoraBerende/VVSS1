package lab07.features.search;

import lab07.steps.serenity.UBBLoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.awt.*;

@RunWith(SerenityRunner.class)
public class UBBLoginTesting {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public UBBLoginSteps steps;

    @Issue("#ValidLogin")
    @Test
    public void validLoginTest() throws AWTException, InterruptedException {
        steps.startHomePage();
        steps.completeValidLogin();
    }

    @Issue("#InvalidLogin")
    @Test
    public void invalidLoginTest() {
        steps.startHomePage();
        steps.completeInvalidLogin();
    }


    @Issue("#ValidDirectory")
    @Test
    public void validDirectoryTest() throws AWTException, InterruptedException {
        steps.startHomePage();
        steps.completeValidLogin();
        steps.createValidDirectory();
    }

    @Issue("#InvalidDirectory")
    @Test
    public void invalidDirectoryTest() throws AWTException, InterruptedException {
        steps.startHomePage();
        steps.completeValidLogin();
        steps.createInvalidDirectory();
    }
}