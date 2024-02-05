package com.qa.stepdef;

import com.qa.apis.ApiUtil;
import com.qa.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.jayway.restassured.response.Response;
import org.junit.Assert;
public class UserStepDef {

    private Response result;

    ApiUtil apiUtil = new ApiUtil();

    @Given("I get the user list")
    public void iGetTheUserList() {
        result = apiUtil.getUserList();
        Assert.assertEquals(result.getStatusCode(), 200);
    }

    @When("I call user detail API with id {string}")
    public void iCallUserDetailAPIWithId(String id) {
        result = apiUtil.getUserById(id);
        Assert.assertEquals(result.getStatusCode(), 200);
    }

    @Then("I could get related details")
    public void iCouldGetRelatedDetails() {
        Assert.assertEquals(apiUtil.getUserStatus(),"active");
    }

    @When("I call user deletion API for user {string} without AA")
    public void iCallUserDeletionAPIForUserWithoutAA(String id) {
        result=apiUtil.deleteUserById(id);
        Assert.assertEquals(result.getStatusCode(), 401);
    }

    @Then("I could delete failed")
    public void iCouldDeleteFailed() {
        Assert.assertEquals(apiUtil.getErrMsg(),"Authentication failed");
    }

}
