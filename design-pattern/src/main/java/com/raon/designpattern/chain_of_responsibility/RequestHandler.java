package com.raon.designpattern.chain_of_responsibility;

public abstract class RequestHandler {

	private final RequestHandler next;

	public RequestHandler(RequestHandler next) {
		this.next = next;
	}

	public void handle(Request request) {
		if (next != null) {
			next.handle(request);
		}
	}
}
