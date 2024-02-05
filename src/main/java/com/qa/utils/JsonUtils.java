package com.qa.utils;

import com.jayway.restassured.response.Response;
import com.jayway.jsonpath.JsonPath;
public class JsonUtils {

    TestUtils utils = new TestUtils();

    public String getString(Response body, String path) {
        try {
            //return "" + body.jsonPath().getString(path);
            return "" + JsonPath.read(body.asString(), path);
        } catch (Exception e) {
            utils.log().info(String.format("unable to get path %s message from %s", path, body.asString()));
            return null;
        }
    }
}
