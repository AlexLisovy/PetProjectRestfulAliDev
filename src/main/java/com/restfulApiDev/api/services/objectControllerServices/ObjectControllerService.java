package com.restfulApiDev.api.services.objectControllerServices;

import com.restfulApiDev.api.AssertableResponse;
import com.restfulApiDev.api.models.postSingleObjectModel.request.PostSingleObjectRequestModel;
import com.restfulApiDev.api.services.SetupApiService;
import io.qameta.allure.Step;
import io.restassured.response.Response;


public class ObjectControllerService extends SetupApiService {

    @Step("POST Single Object")
    public AssertableResponse postObject(PostSingleObjectRequestModel postSingleObjectRequestModel) {
        Response response =
                baseSetupHeaders()
                        .when()
                        .body(postSingleObjectRequestModel)
                        .post("/objects")
                        .then()
                        .extract()
                        .response();

        return new AssertableResponse(response);
    }

    @Step("GET Single Object")
    public AssertableResponse getObject(String Object_Id) {
        Response response =
                baseSetupHeaders()
                        .when()
                        .get("/objects/"+ Object_Id)
                        .then()
                        .extract()
                        .response();

        return new AssertableResponse(response);
    }
}
