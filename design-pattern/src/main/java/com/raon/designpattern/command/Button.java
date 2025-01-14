package com.raon.designpattern.command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Button {

	private final Command command;

	public void onClick() {
		command.execute();
	}

	public static void main(String[] args) {
		Button button1 = new Button(() -> {
			Dialog dialog = new Dialog();
			dialog.show();
		});

		Button button2 = new Button(() -> {
			Alert alert = new Alert();
			alert.error("error");
		});

		button1.onClick();
		button2.onClick();
	}
}
