package net.jccedano92.cyvconstrucciones.security;

import net.jccedano92.cyvconstrucciones.SpringApplicationContext;

public class SecurityConstants {
	
	public static final long EXPIRATION_DATE = 864000000; 
	public static final	String TOKEN_PREFIX = "Bearer "; 
	public static final	String HEADER_STRING = "Authorization"; 
	public static final	String SIGN_UP_URL = "/users"; 
	public static final	String TOKEN_SECRET = getTokenSecret(); 
	
	
	public static String getTokenSecret() {
		AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
		return appProperties.getTokenSecret();
	}
	
}
