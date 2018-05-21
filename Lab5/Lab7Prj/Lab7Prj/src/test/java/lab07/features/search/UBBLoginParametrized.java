package lab07.features.search;

import lab07.steps.serenity.UBBLoginSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/TestData1.csv")
public class UBBLoginParametrized {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @ManagedPages(defaultUrl = "https://www.cs.ubbcluj.ro/")
    public Pages pages;

    public String Username;
    public String Password;
    public int LoginError;

    @Qualifier
    public String getQualifier() {
        return Username;
    }

    @Steps
    public UBBLoginSteps steps;

    @Issue("#Login")
    @Test
    public void loginUBB() {
        Boolean shouldError;
        if(LoginError == 1)
            shouldError = true;
        else
            shouldError = false;
        steps.startHomePage();
        steps.completeLogin(Username,Password,shouldError);
    }
}
