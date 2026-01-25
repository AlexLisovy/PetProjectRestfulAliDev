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
public class GetSingleObjectResponseModel {

	@JsonProperty("data")
	private GetSingleObjectDataResponseModel data;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private String id;

}