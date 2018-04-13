/**
 * @purpose Utility Class for Clinique
 * @author bridgeit
 * @since 11 March 2018
 */
package com.bridgelabz.clinique;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;

public class CliniqueUtility 
{
	private static final ObjectMapper objectMapper=new ObjectMapper();
	
	private  CliniqueUtility() 
	{	
		
	}
	
	/**
	 * @return static final instance of Object Mapper
	 */
	public static ObjectMapper getObjectMapper()
	{
		return objectMapper;
	}
	
	/**
	 * @param path of the file
	 * @return file of the given path
	 */
	public static File getFile(String path)
	{
		return new File(path);
	}
}