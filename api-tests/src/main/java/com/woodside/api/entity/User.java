package com.woodside.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@Generated("com.robohorse.robopojogenerator")
public class User{

	@JsonProperty("password")
	private String password;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;
}