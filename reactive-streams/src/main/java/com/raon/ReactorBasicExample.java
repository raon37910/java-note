package com.raon;

import lombok.SneakyThrows;
import reactor.core.publisher.Flux;

public class ReactorBasicExample {

	@SneakyThrows
	public static void main(String[] args) {
		Flux<String> flux = Flux.just("Hello", "World")
			.map(String::toUpperCase)
			.log();

		flux.subscribe(System.out::println,
			error -> System.out.println(error.getMessage()),
			() -> System.out.print("end"));

		Thread.sleep(1000L);
	}
}
