package com.bridgelabz.objectoriented;

import com.bridgelabz.utility.Clinique;

public class CliniqueManagement 
{
	public static void main(String[] args) 
	{
		Clinique c=new Clinique();
		c.addDoctor("a", 2, "ff", "dfsdf", 0);
		c.addPatient("a", 2, 31, 43645635);
	}
}