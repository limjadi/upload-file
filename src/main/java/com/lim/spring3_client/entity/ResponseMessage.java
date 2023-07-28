package com.lim.spring3_client.entity;

/**
 * 
 * @author rudy.limjadi
 * @since 7/28/2023
 *
 */
public class ResponseMessage {
	
	private String message;

	public ResponseMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
