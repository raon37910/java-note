package com.raon.designpattern.chain_of_responsibility;

public class ThrottlingMiddleWare extends Middleware {

	private int requestPerMinute;
	private int request;
	private long currentTime;

	public ThrottlingMiddleWare(int requestPerMinute) {
		this.requestPerMinute = requestPerMinute;
		this.currentTime = System.currentTimeMillis();
	}
	@Override
	public boolean check(String email, String password) {
		System.out.println("Throttling MiddleWare");

		if(System.currentTimeMillis() > currentTime + 60000) {
			request = 0;
			currentTime = System.currentTimeMillis();
		}

		request++;

		if(request > requestPerMinute) {
			System.out.println("Request limit exceeded!");
			Thread.currentThread().interrupt();
		}

		return checkNext(email, password);
	}
}
