package com.suka.korsa.common;

import lombok.Builder;

@Builder
public class ResponsePayload<T> {
	private T data;
	private String message;
}
