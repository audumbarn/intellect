package com.intellect.design.service;

import java.util.ArrayList;

public class Response {
	
	private String resMsg;
	private String userId;
	private Error valErrors;
	
	public Response(){}
	public Response(String resMsg, String userId, Error error) {
		super();
		this.resMsg = resMsg;
		this.userId = userId;
		this.valErrors = error;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Error getValErrors() {
		return valErrors;
	}
	public void setValErrors(Error valErrors) {
		this.valErrors = valErrors;
	}

}
