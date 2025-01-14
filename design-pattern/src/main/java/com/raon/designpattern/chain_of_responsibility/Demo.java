package com.raon.designpattern.chain_of_responsibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.raon.designpattern.chain_of_responsibility.server.Server;

public class Demo {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static Server server;

	private static void init() {
		server = new Server();
		server.register("admin@example.com", "admin_pass");
		server.register("user@example.com", "user_pass");

		// 미들웨어 연결
		Middleware middleware = Middleware.link(
			new ThrottlingMiddleWare(2),
			new UserExistsMiddleWare(server),
			new RoleCheckMiddleWare()
		);

		// Server gets a chain from client code.
		server.setMiddleware(middleware);
	}

	public static void main(String[] args) throws IOException {
		init();

		boolean success;
		do {
			System.out.print("Enter email: ");
			String email = reader.readLine();
			System.out.print("Input password: ");
			String password = reader.readLine();
			success = server.logIn(email, password);
		} while (!success);
	}
}
