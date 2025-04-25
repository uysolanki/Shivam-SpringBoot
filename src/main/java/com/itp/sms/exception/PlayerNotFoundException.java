package com.itp.sms.exception;

public class PlayerNotFoundException extends RuntimeException 
{
	public PlayerNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}
}
