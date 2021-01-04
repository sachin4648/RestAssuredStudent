package com.student.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	private static PropertyReader propertyReader;
	
	private PropertyReader() {

	}

	public static synchronized PropertyReader getPropertyReader() {
		if(propertyReader == null) {
			propertyReader = new PropertyReader();
		}	
		return propertyReader;
	}

	public String getProperty(String propertyKey) {
		//String valueToReturn = null;
		Properties prop = new Properties();
		try {		
			InputStream inputStream = getClass().getClassLoader()
					.getResourceAsStream("application.properties");	
			prop.load(inputStream);

			if(prop.getProperty(propertyKey) != null) {
				return  prop.getProperty(propertyKey);
			}
			
		} catch (IOException e) {
			System.out.println("Property not found");
		}
		return null;
	}
}
