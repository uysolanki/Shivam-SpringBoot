package com.itp.sms.response;

import java.time.LocalDateTime;

public class ErrorResponse {
	private String error;
    private String message;
    private LocalDateTime timestamp;
    private int status;
	
    public ErrorResponse() {}
    public ErrorResponse(String error, String message, LocalDateTime timestamp, int status) {
		this.error = error;
		this.message = message;
		this.timestamp = timestamp;
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ErrorResponse [error=" + error + ", message=" + message + ", timestamp=" + timestamp + ", status="
				+ status + "]";
	}
}
