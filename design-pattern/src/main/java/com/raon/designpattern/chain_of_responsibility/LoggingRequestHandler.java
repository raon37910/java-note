package com.raon.designpattern.chain_of_responsibility;

public class LoggingRequestHandler extends RequestHandler {

	public LoggingRequestHandler(RequestHandler next) {
		super(next);
	}

	@Override
	public void handle(Request request) {
		System.out.println("logging");
		super.handle(request);
	}
}
