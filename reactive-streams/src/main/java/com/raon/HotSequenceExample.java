package com.raon;

import java.time.Duration;

import lombok.SneakyThrows;
import reactor.core.publisher.Flux;

public class HotSequenceExample {
	@SneakyThrows
	public static void main(String[] args) {
		Flux<String> hotSequence1 = Flux.just("a", "b", "c", "d", "e", "f", "g")
			.map(String::toUpperCase)
			.delayElements(Duration.ofSeconds(1))
			.publish()
			.refCount(1);

		hotSequence1.subscribe(System.out::println);
		Thread.sleep(2100L);

		hotSequence1.subscribe(System.out::println);
		Thread.sleep(2100L);

		hotSequence1.subscribe(System.out::println);
		Thread.sleep(2100L);
	}
}
