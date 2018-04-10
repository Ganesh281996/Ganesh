package com.bridgelabz.clinique;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.codehaus.jackson.map.ObjectMapper;
import com.bridgelabz.utility.Utility;

public class Clinique 
{
	long doctorId;
	String doctorName;
	String specialization;
	String availability;
	long noOfPatients;
	long patientId;
	String patientName;
	long phoneNumber;
	long age;
	
	String appointmentPath="/home/bridgeit/Ganesh/BasicProject/Files/Clinique/Appointment.json";
	String doctorPath="/home/bridgeit/Ganesh/BasicProject/Files/Clinique/Doctor.json";
	String patientPath="/home/bridgeit/Ganesh/BasicProject/Files/Clinique/Patient.json";
	
	Utility utility=new Utility();
	ObjectMapper objectMapper=new ObjectMapper();
	File file;
	List<Doctor> doctorList;
	List<Patient> patientList;
	List<Patient> patientAppointment;
	List<?> tempList;
	Map<Doctor, List<Patient>> appointments;
	boolean flag=false;
	Doctor doctor;
	Patient patient;
	Iterator<?> iterator;
	Iterator<Map.Entry<Doctor, List<Patient>>> mapIterator;
	
	
	void readData()
	{
		try 
		{
			file=new File(doctorPath);
			doctorList=new ArrayList<Doctor>(Arrays.asList(objectMapper.readValue(file, Doctor[].class)));
			file=new File(patientPath);
			patientList=new ArrayList<Patient>(Arrays.asList(objectMapper.readValue(file, Patient[].class)));
			file=new File(appointmentPath);
			appointments=objectMapper.readValue(file, LinkedHashMap.class);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	void writeData()
	{
		try 
		{
			file=new File(doctorPath);
			objectMapper.writeValue(file, doctorList);
			file=new File(patientPath);
			objectMapper.writeValue(file, patientList);
			file=new File(appointmentPath);
			objectMapper.writeValue(file, appointments);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Data has been Saved.");
	}
	
	void printData()
	{
		System.out.println("Doctors=");
		iterator=doctorList.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
		System.out.println("Patients=");
		iterator=patientList.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
		System.out.println("Appointments=");
		mapIterator=appointments.entrySet().iterator();
		while(mapIterator.hasNext())
		{
			Entry<Doctor, List<Patient>> entry=mapIterator.next();
			System.out.println(entry.getKey());
			tempList=entry.getValue();
			iterator=tempList.iterator();
			while(iterator.hasNext())
			{
				System.out.println(iterator.next());
			}
		}
	}
	
	void addDoctor()
	{
		System.out.println("Enter Doctor Id");
		doctorId=utility.nextLong();
		System.out.println("Enter Doctor Name");
		doctorName=utility.next();
		System.out.println("Enter Doctor Specialization");
		specialization=utility.next();
		System.out.println("Enter Doctor Availiability");
		availability=utility.next();
		
		doctor=new Doctor(doctorId, doctorName, specialization, availability, 0);
		doctorList.add(doctor);
		System.out.println("Doctor has been Added.");
		System.out.println(doctor);
	}
	
	void addPatient()
	{
		System.out.println("Enter Patient Id");
		patientId=utility.nextLong();
		System.out.println("Enter Patient Name");
		patientName=utility.next();
		System.out.println("Enter Patient Phone Number");
		phoneNumber=utility.nextLong();
		System.out.println("Enter Patient Age");
		age=utility.nextLong();
		
		patient=new Patient(patientId, patientName, phoneNumber, age);
		patientList.add(patient);
		System.out.println("Patient has been Added.");
		System.out.println(patient);
	}
	
	void takeAppointmentByID()
	{
		searchPatientById();
		searchDoctorById();
		if(flag==true)
		{
			if(doctor.getNoOfPatients()==0)
			{
				doctor.setNoOfPatients(1);
				patientAppointment=new ArrayList<Patient>();
				patientAppointment.add(patient);
				appointments.put(doctor, patientAppointment);
			}
			else if(doctor.getNoOfPatients()>0 && doctor.getNoOfPatients()<5)
			{
				patientAppointment=appointments.get(doctor); 
				appointments.remove(doctor);
				doctor.setNoOfPatients(doctor.getNoOfPatients()+1);
				patientAppointment.add(patient);
				appointments.put(doctor, patientAppointment);
			}
		}
		flag=false;
	}
	
	void searchDoctorById()
	{
		System.out.println("Enter Doctor Id=");
		doctorId=utility.nextLong();
		iterator=doctorList.iterator();
		while(iterator.hasNext())
		{
			doctor=(Doctor) iterator.next();
			if(doctorId==doctor.getDoctorId())
			{
				flag=true;
				System.out.println("Doctor with Id ="+doctorId+" was found");
				System.out.println(doctor);
				return;
			}
		}
		System.out.println("Doctor with Id ="+doctorId+" was not found");
	}
	
	void searchDoctorByName()
	{
		System.out.println("Enter Doctor Name=");
		doctorName=utility.next();
		iterator=doctorList.iterator();
		while(iterator.hasNext())
		{
			doctor=(Doctor) iterator.next();
			if(doctorName.equalsIgnoreCase(doctor.getDoctorName()))
			{
				System.out.println("Doctor with Name ="+doctorName+" was found");
				System.out.println(doctor);
				return;
			}
		}
		System.out.println("Doctor with Name ="+doctorName+" was not found");
	}
	
	void searchDoctorBySpecialization()
	{
		System.out.println("Enter Doctor Specialization=");
		specialization=utility.next();
		iterator=doctorList.iterator();
		while(iterator.hasNext())
		{
			doctor=(Doctor) iterator.next();
			if(specialization.equalsIgnoreCase(doctor.getSpecialization()))
			{
				System.out.println("Doctor with Specialization ="+specialization+" was found");
				System.out.println(doctor);
				return;
			}
		}
		System.out.println("Doctor with Specialization ="+specialization+" was not found");
	}
	
	void searchDoctorByAvailiability()
	{
		System.out.println("Enter Doctor Availability=");
		availability=utility.next();
		iterator=doctorList.iterator();
		while(iterator.hasNext())
		{
			doctor=(Doctor) iterator.next();
			if(availability.equalsIgnoreCase(doctor.getAvailability()))
			{
				System.out.println("Doctor with Availability ="+availability+" was found");
				System.out.println(doctor);
				return;
			}
		}
		System.out.println("Doctor with Availability="+availability+" was not found");
	}
	
	void searchPatientById()
	{
		System.out.println("Enter Patient Id=");
		patientId=utility.nextLong();
		iterator=patientList.iterator();
		while(iterator.hasNext())
		{
			patient=(Patient) iterator.next();
			if(patientId==patient.getPatientId())
			{
				System.out.println("Patient with Id ="+patientId+" was found");
				System.out.println(patient);
				return;
			}
		}
		System.out.println("Patient with Id ="+patientId+" was not found");
	}
	
	void searchPatientByName()
	{
		System.out.println("Enter Patient Name=");
		patientName=utility.next();
		iterator=patientList.iterator();
		while(iterator.hasNext())
		{
			patient=(Patient) iterator.next();
			if(patientName.equalsIgnoreCase(patient.getPatientName()))
			{
				System.out.println("Patient with Name ="+patientName+" was found");
				System.out.println(patient);
				return;
			}
		}
		System.out.println("Patient with Name ="+patientName+" was not found");
	}
	
	void searchPatientByPhoneNumber()
	{
		System.out.println("Enter Patient Phone Number=");
		phoneNumber=utility.nextLong();
		iterator=patientList.iterator();
		while(iterator.hasNext())
		{
			patient=(Patient) iterator.next();
			if(phoneNumber==patient.getPhoneNumber())
			{
				System.out.println("Patient with Phone Number ="+phoneNumber+" was found");
				System.out.println(patient);
				return;
			}
		}
		System.out.println("Patient with Phone Number ="+phoneNumber+" was not found");
	}	
}