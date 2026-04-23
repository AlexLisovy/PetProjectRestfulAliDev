package com.restfulApiDev.api.singleObjectController;

import com.restfulApiDev.api.models.getSingleObjectModel.response.GetSingleObjectDataResponseModel;
import com.restfulApiDev.api.models.getSingleObjectModel.response.GetSingleObjectResponseModel;
import com.restfulApiDev.api.models.postSingleObjectModel.request.PostSingleObjectDataRequestModel;
import com.restfulApiDev.api.models.postSingleObjectModel.request.PostSingleObjectRequestModel;
import com.restfulApiDev.api.models.postSingleObjectModel.response.PostSingleObjectResponseModel;
import com.restfulApiDev.api.services.objectControllerServices.ObjectControllerService;
import com.restfulApiDev.api.steps.ObjectSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;

import static com.restfulApiDev.api.conditions.Conditions.*;
import static com.restfulApiDev.api.utils.dataGenerator.DataGenerator.getFakerFirstName;
import static org.hamcrest.Matchers.containsString;

public class GetSingleObjectTest {


    private ObjectControllerService objectControllerService = new ObjectControllerService();

    private ObjectSteps objectSteps = new ObjectSteps();

    private PostSingleObjectResponseModel objectId;

    private PostSingleObjectRequestModel postSingleObjectRequestModel;
    private PostSingleObjectResponseModel postSingleObjectResponseModel;


    @BeforeClass
    private void preConditions() {

        // Create object step
        objectId = objectSteps.postSingleObject();

        // Create object request
        String FakerName = getFakerFirstName();

        postSingleObjectRequestModel = new PostSingleObjectRequestModel()
                .setName(FakerName)
                .setData(new PostSingleObjectDataRequestModel().randomize());

        postSingleObjectResponseModel =
                objectControllerService
                        .postObject(postSingleObjectRequestModel)
                        .shouldHave(statusCode(200))
                        .responseAs(PostSingleObjectResponseModel.class);
    }

    @Test
    public void getSingleObjectById() {

        GetSingleObjectResponseModel getSingleObjectResponseModel = objectControllerService
                .getObject(postSingleObjectResponseModel.getId())
                .shouldHave(statusCode(200))
                .responseAs(GetSingleObjectResponseModel.class);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(postSingleObjectRequestModel.getName(), getSingleObjectResponseModel.getName());
        softAssert.assertEquals(postSingleObjectResponseModel.getData().getPrice(), getSingleObjectResponseModel.getData().getPrice());

        softAssert.assertAll();

    }

    @Test
    public void getSingleObjectByIdWithStep() {

        GetSingleObjectResponseModel getSingleObjectResponseModel = objectControllerService
                .getObject(objectId.getId())
                .shouldHave(statusCode(200))
                .responseAs(GetSingleObjectResponseModel.class);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(objectId.getName(), getSingleObjectResponseModel.getName());
        softAssert.assertEquals(objectId.getData().getPrice(), getSingleObjectResponseModel.getData().getPrice());

        softAssert.assertAll();

    }

//    @Test
//    public void getSingleObjectByNonExistId() {
//
//        String nonExistObjectId = "0";
//
//        objectControllerService
//                .getObject(nonExistObjectId)
//                .shouldHave(statusCode(404),
//                        bodyField("error", containsString("Oject with id=" + nonExistObjectId + " was not found.")));
//
//
//    }

}