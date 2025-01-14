package com.raon.designpattern.chain_of_responsibility;

public class Main {
	public static void main(String[] args) {
		Request request = new Request("Hello");
		RequestHandler handler = new AuthRequestHandler(new LoggingRequestHandler(null));

		handler.handle(request);
	}
}
