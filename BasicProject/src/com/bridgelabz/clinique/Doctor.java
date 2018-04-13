/**
 * @purpose Pojo of Doctor
 * @author Ganesh
 * @since 11 March 2018
 */
package com.bridgelabz.clinique;

public class Doctor 
{
	private long doctorId;
	private String doctorName;
	private String specialization;
	private String availability;
	private long noOfPatients;
	
	public Doctor(long doctorId, String doctorName, String specialization, String availability, long noOfPatients) 
	{
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.availability = availability;
		this.noOfPatients = noOfPatients;
	}
	public Doctor()
	{
		
	}
	
	public long getDoctorId() 
	{
		return doctorId;
	}
	public void setDoctorId(long doctorId) 
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
	public long getNoOfPatients() 
	{
		return noOfPatients;
	}
	public void setNoOfPatients(long noOfPatients) 
	{
		this.noOfPatients = noOfPatients;
	}

	@Override
	public String toString() 
	{
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", specialization=" + specialization
				+ ", availability=" + availability + ", noOfPatients=" + noOfPatients + "]";
	}
}