package com.restfulApiDev.api.singleObjectController;

import com.restfulApiDev.api.asserts.postSingleObjectAssert.PostSingleObjectAssert;
import com.restfulApiDev.api.models.postSingleObjectModel.request.DataRequestModel;
import com.restfulApiDev.api.models.postSingleObjectModel.request.PostSingleObjectRequestModel;
import com.restfulApiDev.api.models.postSingleObjectModel.response.PostSingleObjectResponseModel;
import com.restfulApiDev.api.services.objectControllerServices.ObjectControllerService;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.restfulApiDev.api.conditions.Conditions.statusCode;
import static com.restfulApiDev.api.utils.dataGenerator.DataGenerator.getFakerFirstName;

public class PostObjectTest {

    private ObjectControllerService objectControllerService = new ObjectControllerService();

    private PostSingleObjectAssert postSingleObjectAssert = new PostSingleObjectAssert();


    @Test
    public void addSingleObject(){

        String FakerName = getFakerFirstName();

        PostSingleObjectRequestModel postSingleObjectRequestModel = new PostSingleObjectRequestModel()
                .setName(FakerName)
                        .setData(new DataRequestModel()
                        .setYear(2001)
                        .setPrice(123)
                        .setCPU_model("safas asfasf asfa ")
                        .setHard_disk_size("123 fgjfj"));


        PostSingleObjectResponseModel postSingleObjectResponseModel = objectControllerService
                .postObject(postSingleObjectRequestModel)
                .shouldHave(statusCode(200))
                .responseAs(PostSingleObjectResponseModel.class);


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(postSingleObjectRequestModel.getName(), postSingleObjectResponseModel.getName());
        softAssert.assertEquals(postSingleObjectRequestModel.getData().getYear(), postSingleObjectResponseModel.getData().getYear());
        softAssert.assertEquals(postSingleObjectRequestModel.getData().getPrice(), postSingleObjectResponseModel.getData().getPrice());
        softAssert.assertEquals(postSingleObjectRequestModel.getData().getCPU_model(), postSingleObjectResponseModel.getData().getCPU_model());
        softAssert.assertEquals(postSingleObjectRequestModel.getData().getHard_disk_size(), postSingleObjectResponseModel.getData().getHard_disk_size());

        softAssert.assertAll();

    }

    @Test
    public void addSingleObjectWithRandomizerInModel(){

        String FakerName = getFakerFirstName();

        PostSingleObjectRequestModel postSingleObjectRequestModel = new PostSingleObjectRequestModel()
                .setName(FakerName)
                .setData(new DataRequestModel().randomize());


        PostSingleObjectResponseModel postSingleObjectResponseModel = objectControllerService
                .postObject(postSingleObjectRequestModel)
                .shouldHave(statusCode(200))
                .responseAs(PostSingleObjectResponseModel.class);

        postSingleObjectAssert.postSingleObjectAssert(postSingleObjectRequestModel, postSingleObjectResponseModel);


    }


}
