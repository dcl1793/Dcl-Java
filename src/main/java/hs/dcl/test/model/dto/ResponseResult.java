package hs.dcl.test.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseResult<T> {

	private String status;
	
	private String message;
	
	private T data;
	
	public ResponseResult<T> success() {
		this.status= ResultCode.success.toString();
		return this;
	}
	public ResponseResult(){
		
	}

	public ResponseResult(String status, String message, T data){
		this.status=status;
		this.message=message;
		this.data=data;
	}
	
	public ResponseResult<T> success(T data) {
		this.status= ResultCode.success.toString();
		this.data = data;
		return this;
	}
		

	public ResponseResult<T> success(T data, String message){
		this.status= ResultCode.success.toString();
		this.message=message;
		this.data = data;
		return this;
	}

	public ResponseResult<T> failure() {
		this.status= ResultCode.ERROR.toString();
		return this;
	}

	public ResponseResult<T> failure(String message) {
		this.status= ResultCode.ERROR.toString();
		this.message=message;
		return this;
	}
	
	public ResponseResult<T> failure(T data, String message) {
		this.status= ResultCode.ERROR.toString();
		this.message=message;
		this.data = data;
		return this;
	}
	
	

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}



	private enum ResultCode {
		success{
			@Override
			public String toString() {
				return "OK";
			}
		},
		ERROR {
			@Override
			public String toString() {
				return "servers error";
			}
		},
		UNKNOWN {
			@Override
			public String toString() {
				return "unknown";
			}
		},
		INVALID_ARGUMENT {
			@Override
			public String toString() {
				return "invalid_argument";
			}
		};		
		public abstract String toString();
	}
	
}
