package com.qa.apis;

import com.jayway.restassured.response.Response;
import com.qa.utils.JsonUtils;

import static com.jayway.restassured.RestAssured.given;

public class ApiUtil {
    JsonUtils jsonUtil = new JsonUtils();
    private static final String API_URL = "https://gorest.co.in/";
    Response result;

    public Response getUserList() {
        String path ="public/v2/users";
        result = given().baseUri(API_URL).urlEncodingEnabled(false)
                .log().all().when()
                .get(path);
        result.prettyPrint();
        return result;
    }

    public Response getUserById(String id) {
        String path ="public/v2/users"+"/"+id;
        result = given().baseUri(API_URL).urlEncodingEnabled(false)
                .log().all().when()
                .get(path);
        result.prettyPrint();
        return result;
    }

    public String getUserStatus() {
        return jsonUtil.getString(result, "status");
    }

    public Response deleteUserById(String id) {
        String path ="public/v2/users"+"/"+id;
        result = given().baseUri(API_URL).urlEncodingEnabled(false)
                .log().all().when()
                .delete(path);
        result.prettyPrint();
        return result;
    }

    public String getErrMsg() {
        return jsonUtil.getString(result, "message");
    }
}
