package com.co.kr.vo;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ToString
@Getter
@AllArgsConstructor
public class LoginVO {

	private String seq;
	private String id;
	private String pw;
	private String admin;
	private String level;
}
