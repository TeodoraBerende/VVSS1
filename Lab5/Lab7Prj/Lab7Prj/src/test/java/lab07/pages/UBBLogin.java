package lab07.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBys;

import java.awt.*;
import java.awt.event.KeyEvent;

@DefaultUrl("https://www.cs.ubbcluj.ro/apps/ftp/")
public class UBBLogin extends PageObject {

    @FindBy(name="ftpserver")
    private WebElementFacade serverDropMenu;

    @FindBy(name="username")
    private WebElementFacade usernameField;

    @FindBy(name="password")
    private WebElementFacade passwordField;

    @FindBy(id="LoginButton1")
    private WebElementFacade loginButton;

//    @FindBy(id="smallbutton")
//    private WebElementFacade newDirButton;

    @FindBy(name = "newNames[1]")
    private WebElementFacade inputField;

    Robot robot = new Robot();

    public UBBLogin() throws AWTException {
    }

    public void changeServerTo(String value) {
        serverDropMenu.selectByValue(value);
    }

    public void enterUsername(String text) {
        usernameField.type(text);
    }

    public void enterPassword(String text) {
        passwordField.type(text);
    }

    public void login() {
        loginButton.click();
    }

    public void newDir() {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_ALT);
    }

    public void enterDictName(String text) {
        inputField.type(text);
    }

    public void createDict() throws AWTException, InterruptedException {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_ALT);
    }

    public boolean checkError() {
        return find(By.className("error-box")).isVisible();
    }

    public boolean checkDirectoryError() {
        return find(By.id("NewDirForm")).getText().contains("could not be created.");
    }
}
