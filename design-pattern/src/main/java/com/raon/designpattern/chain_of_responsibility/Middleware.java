package com.raon.designpattern.chain_of_responsibility;

public abstract class Middleware {
	private Middleware next;

	/**
	 * 미들웨어를 링크드 리스트처럼 엮어준다.
	 */
	public static Middleware link(Middleware first, Middleware... chain) {
		Middleware head = first;

		for(Middleware nextChain: chain) {
			head.next = nextChain;
			head = nextChain;
		}

		return first;
	}

	public abstract boolean check(String email, String password);

	protected boolean checkNext(String email, String password) {
		if(next == null) {
			return true;
		}

		return next.check(email, password);
	}
}
