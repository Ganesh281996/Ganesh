package com.bridgelabz.utility;

public class Doctor 
{
	private int doctorId;
	private String doctorName;
	private String specialization;
	private String availability;
	
	public Doctor(int doctorId, String doctorName, String specialization, String availability)
	{
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.availability = availability;
	}

	public int getDoctorId()
	{
		return doctorId;
	}

	public void setDoctorId(int doctorId)
	{
		this.doctorId = doctorId;
	}

	public String getDoctorName()
	{
		return doctorName;
	}

	public void setDoctorName(String doctorName)
	{
		this.doctorName = doctorName;
	}

	public String getSpecialization()
	{
		return specialization;
	}

	public void setSpecialization(String specialization)
	{
		this.specialization = specialization;
	}

	public String getAvailability()
	{
		return availability;
	}

	public void setAvailability(String availability) 
	{
		this.availability = availability;
	}
	
}