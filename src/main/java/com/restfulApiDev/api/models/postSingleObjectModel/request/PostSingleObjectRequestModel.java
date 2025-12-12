package com.restfulApiDev.api.models.postSingleObjectModel.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import static com.restfulApiDev.api.utils.dataGenerator.DataGenerator.getFakerFirstName;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class PostSingleObjectRequestModel {

    @JsonProperty("data")
    private DataRequestModel data;

    @JsonProperty("name")
    private String name;


}