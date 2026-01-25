package com.restfulApiDev.api.models.postSingleObjectModel.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import static com.restfulApiDev.api.utils.dataGenerator.DataGenerator.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class PostSingleObjectDataRequestModel {

    @JsonProperty("year")
    private int year;

    @JsonProperty("price")
    private Object price;

    @JsonProperty("CPU model")
    private String CPU_model;

    @JsonProperty("Hard disk size")
    private String Hard_disk_size;

    public PostSingleObjectDataRequestModel randomize(){
        this.year = getFakerRandomIntNumberBetween(1970, 2025);
        this.price = getFakerRandomDoubleNumberBetween(3, 1, 9999);
        this.CPU_model = randomAlphaNumeric(25);
        this.Hard_disk_size = randomAlphaNumeric(25);

        return this;
    }

}