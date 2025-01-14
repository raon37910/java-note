package com.raon.designpattern.chain_of_responsibility;

public class AuthRequestHandler extends RequestHandler {
	public AuthRequestHandler(RequestHandler next) {
		super(next);
	}

	@Override
	public void handle(Request request) {
		auth();
		super.handle(request);
	}

	private void auth() {
		System.out.println("Auth");
	}
}
