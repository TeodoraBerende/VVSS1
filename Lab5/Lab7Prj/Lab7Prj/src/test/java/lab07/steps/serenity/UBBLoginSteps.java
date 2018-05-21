package lab07.steps.serenity;

import lab07.pages.UBBLogin;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UBBLoginSteps {

    UBBLogin ubbLogin;

    @Step
    public void startHomePage() {
        ubbLogin.open();
    }

    @Step
    public void changeServer(String value) {
        ubbLogin.changeServerTo(value);
    }

    @Step
    public void completeLogin(String username, String password, Boolean shouldError) {
        changeServer("linux.scs.ubbcluj.ro");
        completeUsername(username);
        completePassword(password);
        login();
        checkError(shouldError);
    }

    @Step
    public void completeValidLogin() throws AWTException, InterruptedException {
        changeServer("linux.scs.ubbcluj.ro");
        completeUsername("btir1815");
        completePassword("c@stor11");
        login();
        checkError(false);
    }

    @Step
    public void createValidDirectory() throws AWTException, InterruptedException {
        createDirectory("pinguin12306",false);

    }

    @Step
    public void createInvalidDirectory() throws AWTException, InterruptedException {
        createDirectory("mail",true);
    }

    @Step
    public void createDirectory(String name, boolean shouldError) throws AWTException, InterruptedException {
        ubbLogin.newDir();
        ubbLogin.enterDictName(name);
        ubbLogin.createDict();
        checkDirectoryError(shouldError);
    }
    @Step
    public void completeInvalidLogin() {
        changeServer("linux.scs.ubbcluj.ro");
        completeUsername("a");
        completePassword("a");
        login();
        checkError(true);
    }

    @Step
    private void completeUsername(String text) {
        ubbLogin.enterUsername(text);
    }

    @Step
    private void completePassword(String text) {
        ubbLogin.enterPassword(text);
    }

    @Step
    private void login() {
        ubbLogin.login();
    }

    @Step
    public void checkError(boolean shouldError) {
        if(ubbLogin.checkError()!=shouldError) {
            assert false;
        } else {
            assert true;
        }
    }

    @Step
    public void checkDirectoryError(boolean shouldError) {
        if(ubbLogin.checkDirectoryError()!=shouldError) {
            assert false;
        } else {
            assert true;
        }
    }


}
