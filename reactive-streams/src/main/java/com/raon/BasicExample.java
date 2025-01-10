package com.raon;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

import lombok.SneakyThrows;

public class BasicExample {

	@SneakyThrows
	public static void main(String[] args) {
		SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

		Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {
			private Flow.Subscription subscription;

			@Override
			public void onSubscribe(Flow.Subscription subscription) {
				this.subscription = subscription;
				subscription.request(2); // 백프레셔 로직
				System.out.println("[Subscriber] Subscribed");
			}

			@Override
			public void onNext(String item) {
				System.out.println("[Subscriber] Received: " + item);
				subscription.request(2); // 백프레셔 로직
			}

			@Override
			public void onError(Throwable throwable) {
				System.err.println("[Subscriber] Error: " + throwable.getMessage());
			}

			@Override
			public void onComplete() {
				System.out.println("[Subscriber] Complete");
			}
		};

		// 3. Subscriber 등록
		publisher.subscribe(subscriber);

		// 4. 데이터 발행
		List<String> items = List.of("Hello", "World", "Java", "Main");
		items.forEach(publisher::submit);

		// 5. Publisher 종료 후 비동기 처리를 위해 대기
		publisher.close();
		Thread.sleep(1000L);
	}
}
