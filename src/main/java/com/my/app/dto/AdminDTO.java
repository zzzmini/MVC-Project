package com.my.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminDTO {
	private String a_id;
	private String a_pw;
	private String a_name;
	private String a_phone;
	private int a_approval;
}
