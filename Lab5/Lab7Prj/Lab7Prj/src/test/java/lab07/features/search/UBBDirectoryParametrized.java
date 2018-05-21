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

import java.awt.*;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/TestData2.csv")
public class UBBDirectoryParametrized {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @ManagedPages(defaultUrl = "https://www.cs.ubbcluj.ro/")
    public Pages pages;

    public String Username;
    public String Password;
    public String DirectoryName;
    public int DirectoryError;

    @Qualifier
    public String getQualifier() {
        return DirectoryName;
    }

    @Steps
    public UBBLoginSteps steps;

    @Issue("#CreateDirectory")
    @Test
    public void loginUBB() throws InterruptedException, AWTException {
        Boolean shouldError;
        if(DirectoryError == 1)
            shouldError = true;
        else
            shouldError = false;
        steps.startHomePage();
        steps.completeLogin(Username,Password,false);
        steps.createDirectory(DirectoryName,shouldError);
    }
}
