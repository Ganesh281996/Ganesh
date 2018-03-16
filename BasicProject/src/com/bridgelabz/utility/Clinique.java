package com.bridgelabz.utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Clinique 
{
	String doctorPath="/home/bridgeit/Ganesh/BasicProject/Files/Doctor.json";
	String patientPath="/home/bridgeit/Ganesh/BasicProject/Files/Patient.json";
	String appointmentsPath="/home/bridgeit/Ganesh/BasicProject/Files/Appointments.json";
	
	public boolean addDoctor(String name,long id,String specialization,
							String availability,long noOfPatients)
	{
		boolean flag=false;
		JSONArray jsonArray=Utility.readJsonArrayFile(doctorPath);
		JSONObject jsonObject=null;
		for(int i=0;i<jsonArray.size();i++)
		{
			jsonObject=(JSONObject)jsonArray.get(i);
			if((long)jsonObject.get("Id")==id)
			{
				flag=true;
				break;
			}
		}
		if(flag==false)
		{
			jsonObject=new JSONObject();
			jsonObject.put("DoctorName", name);
			jsonObject.put("Id", id);
			jsonObject.put("Specialization", specialization);
			jsonObject.put("Availability", availability);
			jsonObject.put("NoOfPatients", noOfPatients);
			jsonArray.add(jsonObject);
			Utility.writeJsonArrayFile(doctorPath, jsonArray);
			return true;
		}
		return false;
	}
	
	public boolean addPatient(String name,long id,long age,long mobile)
	{
		boolean flag=false;
		JSONArray jsonArray=Utility.readJsonArrayFile(patientPath);
		JSONObject jsonObject=null;
		for(int i=0;i<jsonArray.size();i++)
		{
			jsonObject=(JSONObject)jsonArray.get(i);
			if((long)jsonObject.get("Id")==id)
			{
				flag=true;
				break;
			}
		}
		if(flag==false)
		{
			jsonObject=new JSONObject();
			jsonObject.put("DoctorName", name);
			jsonObject.put("Id", id);
			jsonObject.put("Age", age);
			jsonObject.put("MobileNumber", mobile);
			jsonArray.add(jsonObject);
			Utility.writeJsonArrayFile(patientPath, jsonArray);
			return true;
		}
		return false;
	}
	
	public void searchPatientById(long id)
	{
		boolean flag=false;int i;
		JSONArray jsonArray=Utility.readJsonArrayFile(patientPath);
		JSONObject jsonObject=new JSONObject();
		for(i=0;i<jsonArray.size();i++)
		{
			jsonObject=(JSONObject)jsonArray.get(i);
			if((long)jsonObject.get("Id")==id)
			{
				flag=true;
				break;
			}
		}
		if(flag==false)
		{
			
		}
	}

}