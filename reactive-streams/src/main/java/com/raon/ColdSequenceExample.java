package com.raon;

import lombok.SneakyThrows;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ColdSequenceExample {
	@SneakyThrows
	public static void main(String[] args) {
		Flux<String> coldSequence1 = Flux.just("a", "b", "c", "d", "e", "f", "g")
			.map(String::toUpperCase);

		Mono<String> coldSequence2 = Mono.just("Hi!!")
			.map(String::toUpperCase);

		coldSequence1.subscribe(System.out::println);
		coldSequence2.subscribe(System.out::println);

		Thread.sleep(1000L);

		coldSequence1.subscribe(System.out::println);
		coldSequence2.subscribe(System.out::println);
	}
}
