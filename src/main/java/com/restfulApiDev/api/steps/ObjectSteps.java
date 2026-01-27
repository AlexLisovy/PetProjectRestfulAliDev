package com.restfulApiDev.api.steps;

import com.restfulApiDev.api.models.postSingleObjectModel.request.PostSingleObjectDataRequestModel;
import com.restfulApiDev.api.models.postSingleObjectModel.request.PostSingleObjectRequestModel;
import com.restfulApiDev.api.models.postSingleObjectModel.response.PostSingleObjectResponseModel;
import com.restfulApiDev.api.services.objectControllerServices.ObjectControllerService;
import io.qameta.allure.Step;

import static com.restfulApiDev.api.conditions.Conditions.statusCode;
import static com.restfulApiDev.api.utils.dataGenerator.DataGenerator.getFakerFirstName;

public class ObjectSteps {

    private ObjectControllerService objectControllerService = new ObjectControllerService();

    @Step("")
    public PostSingleObjectResponseModel postSingleObject(){

        String FakerName = getFakerFirstName();

        PostSingleObjectRequestModel postSingleObjectRequestModel = new PostSingleObjectRequestModel()
                .setName(FakerName)
                .setData(new PostSingleObjectDataRequestModel().randomize());


        PostSingleObjectResponseModel postSingleObjectResponseModel = objectControllerService
                .postObject(postSingleObjectRequestModel)
                .shouldHave(statusCode(200))
                .responseAs(PostSingleObjectResponseModel.class);

        return postSingleObjectResponseModel;
    }
}
