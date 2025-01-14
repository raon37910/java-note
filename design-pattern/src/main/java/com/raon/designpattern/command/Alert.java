package com.raon.designpattern.command;

public class Alert {

	public void alert(String message) {
		System.out.println("alert:" + message);
	}

	public void warn(String message) {
		System.out.println("warn:" + message);
	}

	public void error(String message) {
		System.out.println("error:" + message);
	}
}
