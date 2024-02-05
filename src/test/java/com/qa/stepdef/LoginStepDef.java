package com.qa.stepdef;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Sleeper;

import static java.lang.Thread.sleep;

public class LoginStepDef {

    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) throws InterruptedException {
        new LoginPage().enterUserName(username);
    }

    @When("I enter password as {string}")
    public void iEnterPasswordAs(String password) {
        new LoginPage().enterPassword(password);
    }

    @When("I login")
    public void iLogin() {
        new LoginPage().pressLoginBtn();
    }

    @Then("login should fail with an error {string}")
    public void loginShouldFailWithAnError(String err) throws InterruptedException {
        sleep(3000);
        String err_msg = new LoginPage().getErrTxt();
        System.out.println("error is: "+err_msg);
        Assert.assertEquals(err_msg, err);
    }

    @Then("I should see Products page with title {string}")
    public void iShouldSeeProductsPageWithTitle(String title) {
        Assert.assertEquals(new ProductsPage().getTitle(), title);
    }
}
