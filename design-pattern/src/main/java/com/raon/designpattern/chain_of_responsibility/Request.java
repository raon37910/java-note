package com.raon.designpattern.chain_of_responsibility;

public class Request {
	String body;

	public Request(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}
}
