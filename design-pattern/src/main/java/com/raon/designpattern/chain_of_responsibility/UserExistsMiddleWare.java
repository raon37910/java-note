package com.raon.designpattern.chain_of_responsibility;

import com.raon.designpattern.chain_of_responsibility.server.Server;

public class UserExistsMiddleWare extends Middleware {
	private Server server;

	public UserExistsMiddleWare(Server server) {
		this.server = server;
	}

	@Override
	public boolean check(String email, String password) {
		System.out.println("UserExists MiddleWare");

		if(!server.hasEmail(email)) {
			System.out.println("This email is not registered!");
			return false;
		}

		if(!server.isValidPassword(email, password)) {
			System.out.println("Invalid password!");
			return false;
		}

		return checkNext(email, password);
	}
}
