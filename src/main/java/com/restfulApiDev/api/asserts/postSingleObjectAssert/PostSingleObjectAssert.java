package com.restfulApiDev.api.asserts.postSingleObjectAssert;

import com.restfulApiDev.api.models.postSingleObjectModel.request.PostSingleObjectRequestModel;
import com.restfulApiDev.api.models.postSingleObjectModel.response.PostSingleObjectResponseModel;
import org.testng.asserts.SoftAssert;

public class PostSingleObjectAssert {

    public void postSingleObjectAssert(PostSingleObjectRequestModel postSingleObjectRequestModel,  PostSingleObjectResponseModel postSingleObjectResponseModel){

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(postSingleObjectRequestModel.getName(), postSingleObjectResponseModel.getName());
        softAssert.assertEquals(postSingleObjectRequestModel.getData().getYear(), postSingleObjectResponseModel.getData().getYear());
        softAssert.assertEquals(postSingleObjectRequestModel.getData().getPrice(), postSingleObjectResponseModel.getData().getPrice());
        softAssert.assertEquals(postSingleObjectRequestModel.getData().getCPU_model(), postSingleObjectResponseModel.getData().getCPU_model());
        softAssert.assertEquals(postSingleObjectRequestModel.getData().getHard_disk_size(), postSingleObjectResponseModel.getData().getHard_disk_size());

        softAssert.assertAll();
    }



}
