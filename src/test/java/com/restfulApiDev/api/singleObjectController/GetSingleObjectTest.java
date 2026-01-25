package com.restfulApiDev.api.singleObjectController;

import com.restfulApiDev.api.models.getSingleObjectModel.response.GetSingleObjectResponseModel;
import com.restfulApiDev.api.models.postSingleObjectModel.request.PostSingleObjectDataRequestModel;
import com.restfulApiDev.api.models.postSingleObjectModel.request.PostSingleObjectRequestModel;
import com.restfulApiDev.api.models.postSingleObjectModel.response.PostSingleObjectResponseModel;
import com.restfulApiDev.api.services.objectControllerServices.ObjectControllerService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.restfulApiDev.api.conditions.Conditions.statusCode;
import static com.restfulApiDev.api.utils.dataGenerator.DataGenerator.getFakerFirstName;

public class GetSingleObjectTest {



    private ObjectControllerService objectControllerService = new ObjectControllerService();

    private PostSingleObjectRequestModel postSingleObjectRequestModel;
    private PostSingleObjectResponseModel postSingleObjectResponseModel;



    @BeforeClass
    private void preConditions() {

        // TODO Make this as a STEP ------------------------------------------------------------------------------------
        String FakerName = getFakerFirstName();

        postSingleObjectRequestModel = new PostSingleObjectRequestModel()
                .setName(FakerName)
                .setData(new PostSingleObjectDataRequestModel().randomize());

        postSingleObjectResponseModel =
                objectControllerService
                .postObject(postSingleObjectRequestModel)
                .shouldHave(statusCode(200))
                .responseAs(PostSingleObjectResponseModel.class);
        // -------------------------------------------------------------------------------------------------------------
    }

    @Test
    public void getSingleObjectById() {

        GetSingleObjectResponseModel getSingleObjectResponseModel = objectControllerService
                .getObject(postSingleObjectResponseModel.getId())
                .shouldHave(statusCode(200))
                .responseAs(GetSingleObjectResponseModel.class);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(postSingleObjectRequestModel.getName(), getSingleObjectResponseModel.getName());

        softAssert.assertAll();


    }
}
