package com.itp.sms.exeption;

public class PlayerNotFoundException extends RuntimeException {

	public PlayerNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}
}
