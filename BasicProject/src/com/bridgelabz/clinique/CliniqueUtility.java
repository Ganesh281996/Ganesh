package com.bridgelabz.clinique;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;

public class CliniqueUtility 
{
	private static final ObjectMapper objectMapper=new ObjectMapper();
	
	private  CliniqueUtility() 
	{	
		
	}
	
	public static ObjectMapper getObjectMapper()
	{
		return objectMapper;
	}
	
	public static File getFile(String path)
	{
		return new File(path);
	}
}