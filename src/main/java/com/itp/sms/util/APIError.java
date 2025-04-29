package com.itp.sms.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIError {
	
    private String message;
    private String field;
    private Object rejectedValue;

    public APIError(String message, String field, Object rejectedValue) {
        this.message = message;
        this.field = field;
        this.rejectedValue = rejectedValue;
    }
}
