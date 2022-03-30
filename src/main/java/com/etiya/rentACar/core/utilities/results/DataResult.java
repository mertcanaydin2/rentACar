package com.etiya.rentACar.core.utilities.results;

public class DataResult<T> extends Result {

	private T data;

	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}

	public DataResult(T data, boolean success, String message) {
		super(success, message);
		this.data = data; // kullanıcının verdiği data yı dönder demek

	}

	public T getData() {
		return data;
	}

}
