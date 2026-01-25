package com.restfulApiDev.api.models.getSingleObjectModel.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class GetSingleObjectDataResponseModel {

	@JsonProperty("year")
	private int year;

	@JsonProperty("price")
	private Object price;

	@JsonProperty("CPU model")
	private String CPU_model;

	@JsonProperty("Hard disk size")
	private String Hard_disk_size;

}