package com.woodside.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@Generated("com.robohorse.robopojogenerator")
public class User{

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("password")
	private String password;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;
}