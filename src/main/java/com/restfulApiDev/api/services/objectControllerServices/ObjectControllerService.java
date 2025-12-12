package com.restfulApiDev.api.services.objectControllerServices;

import com.restfulApiDev.api.AssertableResponse;
import com.restfulApiDev.api.models.postSingleObjectModel.request.PostSingleObjectRequestModel;
import com.restfulApiDev.api.services.SetupApiService;
import io.qameta.allure.Step;
import io.restassured.response.Response;


public class ObjectControllerService extends SetupApiService {

    @Step("Post Single Object")
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
}
