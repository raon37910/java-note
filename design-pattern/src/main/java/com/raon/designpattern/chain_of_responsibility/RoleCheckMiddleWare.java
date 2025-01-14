package com.raon.designpattern.chain_of_responsibility;

public class RoleCheckMiddleWare extends Middleware {
	@Override
	public boolean check(String email, String password) {
		System.out.println("RoleCheck MiddleWare");

		if (email.equals("admin@example.com")) {
			System.out.println("Hello, admin!");
			return true;
		}

		System.out.println("Hello, user!");

		return checkNext(email, password);
	}
}
