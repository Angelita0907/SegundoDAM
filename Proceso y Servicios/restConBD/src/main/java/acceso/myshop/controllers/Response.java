package acceso.myshop.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Response {
	public static final int NO_ERROR = 0;
	public static final int NOT_FOUND = 101;
	public static final String NO_MESSAGE = "";

	private Error error;  

	@Data
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	static class Error {
		public Error(int errorCode2, String errorMessage) {
			// TODO Auto-generated constructor stub
		}
		public long getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(long errorCode) {
			this.errorCode = errorCode;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		private long errorCode;
		private String message;
	}

	public Response(Error error2) {
		// TODO Auto-generated constructor stub
	}

	public static Response noErrorResponse() {
		return new Response(new Error(NO_ERROR, NO_MESSAGE));
	}

	public static Response errorResonse(int errorCode, String errorMessage) {
		return new Response(new Error(errorCode, errorMessage));
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
}
