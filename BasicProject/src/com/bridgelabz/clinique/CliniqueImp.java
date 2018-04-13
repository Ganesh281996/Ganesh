/**
 * @purpose Implementation of Clinique Interface
 * @author Ganesh
 * @since 11 March 2018
 */
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

public class CliniqueImp implements Clinique
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
	ObjectMapper objectMapper=CliniqueUtility.getObjectMapper();
	File file;
	List<Doctor> doctorList;
	List<Patient> patientList;
	List<Patient> patientAppointment;
	Map<String, List<Patient>> appointments;
	boolean flag=false;
	Doctor doctor;
	Patient patient;
	Iterator<?> iterator;
	Iterator<Map.Entry<String, List<Patient>>> mapIterator;
	
	/* 
	 * Read Data from files of Doctor Patient and Appointments
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void readData()
	{
		try 
		{
			file=CliniqueUtility.getFile(doctorPath);
			doctorList=new ArrayList<>(Arrays.asList(objectMapper.readValue(file, Doctor[].class)));
			file=CliniqueUtility.getFile(patientPath);
			patientList=new ArrayList<>(Arrays.asList(objectMapper.readValue(file, Patient[].class)));
			file=CliniqueUtility.getFile(appointmentPath);
			appointments=objectMapper.readValue(file, LinkedHashMap.class);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/* 
	 * Write changed data of Doctors Patient and appointments in there files
	 */
	@Override
	public void writeData()
	{
		try 
		{
			file=CliniqueUtility.getFile(doctorPath);
			objectMapper.writeValue(file, doctorList);
			file=CliniqueUtility.getFile(patientPath);
			objectMapper.writeValue(file, patientList);
			file=CliniqueUtility.getFile(appointmentPath);
			objectMapper.writeValue(file, appointments);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Data has been Saved.");
	}
	
	/* 
	 * Print details of Doctors Patient and Appointments
	 */
	@Override
	public void printData()
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
			Entry<String, List<Patient>> entry=mapIterator.next();
			System.out.println(entry.getKey());
			patientAppointment=entry.getValue();
			iterator=patientAppointment.iterator();
			while(iterator.hasNext())
			{
				System.out.println(iterator.next());
			}
		}
	}
	
	/* 
	 * Add new Doctor in list of Doctors
	 */
	@Override
	public void addDoctor()
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
	
	/* 
	 * Add new Patient in list of Patients
	 */
	@Override
	public void addPatient()
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
	
	/* 
	 * Patient takes Appointment from available Doctors
	 */
	@Override
	public void takeAppointmentByID()
	{
		searchPatientById();
		if(!flag)
		{
			System.out.println("Patient not Found");
			System.out.println("Enter 2 to Add patient");
			return;
		}
		flag=false;
		searchDoctorById();
		if(flag)
		{
			if(doctor.getNoOfPatients()==0)
			{
				System.out.println(patient.getPatientName()+" took Appointment with Doctor "+doctor.getDoctorName());
				doctor.setNoOfPatients(1);
				patientAppointment=new ArrayList<>();
				patientAppointment.add(patient);
				appointments.put(doctor.toString(), patientAppointment);
				return;
			}
			else if(doctor.getNoOfPatients()>0 && doctor.getNoOfPatients()<5)
			{
				System.out.println(patient.getPatientName()+" took Appointment with Doctor "+doctor.getDoctorName());
				patientAppointment=appointments.get(doctor.toString()); 
				appointments.remove(doctor.toString());
				doctor.setNoOfPatients(doctor.getNoOfPatients()+1);
				patientAppointment.add(patient);
				appointments.put(doctor.toString(), patientAppointment);
				return;
			}
			else
			{
				System.out.println("Doctor with Id="+doctorId+" is Not Available");
			}
		}
		flag=false;
	}
	
	/* 
	 * Prints Popular Doctors on the basis of no of Patients
	 */
	@Override
	public void popularDoctor()
	{
		System.out.println("Popular Doctors are");
		iterator=doctorList.iterator();
		while(iterator.hasNext())
		{
			doctor=(Doctor) iterator.next();
			if(doctor.getNoOfPatients()==5)
			{
				System.out.println(doctor);
			}
		}
	}
	
	/* 
	 * Searches Doctor of given Id
	 */
	@Override
	public void searchDoctorById()
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
	
	/* 
	 * Searches Doctor of given Name
	 */
	@Override
	public void searchDoctorByName()
	{
		System.out.println("Enter Doctor Name=");
		doctorName=utility.next();
		iterator=doctorList.iterator();
		while(iterator.hasNext())
		{
			flag=true;
			doctor=(Doctor) iterator.next();
			if(doctorName.equalsIgnoreCase(doctor.getDoctorName()))
			{
				System.out.println(doctor);
			}
		}
		if(!flag)
		{
			System.out.println("Doctor with Name ="+doctorName+" was not found");
		}
		flag=false;
	}
	
	/* 
	 * Searches Doctor of given Specialization
	 */
	@Override
	public void searchDoctorBySpecialization()
	{
		System.out.println("Enter Doctor Specialization=");
		specialization=utility.next();
		iterator=doctorList.iterator();
		while(iterator.hasNext())
		{
			doctor=(Doctor) iterator.next();
			if(specialization.equalsIgnoreCase(doctor.getSpecialization()))
			{
				flag=true;
				System.out.println(doctor);
			}
		}
		if(!flag)
		{
			System.out.println("Doctor with Specialization ="+specialization+" was not found");
		}		
		flag=false;
	}
	
	/* 
	 * Searches Doctor of by there Avialibility
	 */
	@Override
	public void searchDoctorByAvailiability()
	{
		System.out.println("Enter Doctor Availability=");
		availability=utility.next();
		iterator=doctorList.iterator();
		while(iterator.hasNext())
		{
			doctor=(Doctor) iterator.next();
			if(availability.equalsIgnoreCase(doctor.getAvailability()))
			{
				flag=true;
				System.out.println(doctor);
			}
		}
		if(!flag)
		{
			System.out.println("Doctor with Availability="+availability+" was not found");
		}	
		flag=false;
		
	}
	
	/* 
	 * Searches Patients of given Id
	 */
	@Override
	public void searchPatientById()
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
				flag=true;
				return;
			}
		}
		System.out.println("Patient with Id ="+patientId+" was not found");
	}
	
	/* 
	 * Searches Patients of given Name
	 */
	@Override
	public void searchPatientByName()
	{
		System.out.println("Enter Patient Name=");
		patientName=utility.next();
		iterator=patientList.iterator();
		while(iterator.hasNext())
		{
			patient=(Patient) iterator.next();
			if(patientName.equalsIgnoreCase(patient.getPatientName()))
			{
				flag=true;
				System.out.println(patient);
			}
		}
		if(!flag)
		{
			System.out.println("Patient with Name ="+patientName+" was not found");
		}	
		flag=false;
	}
	
	/* 
	 * Searches Patients with given Phone Number
	 */
	@Override
	public void searchPatientByPhoneNumber()
	{
		System.out.println("Enter Patient Phone Number=");
		phoneNumber=utility.nextLong();
		iterator=patientList.iterator();
		while(iterator.hasNext())
		{
			patient=(Patient) iterator.next();
			if(phoneNumber==patient.getPhoneNumber())
			{
				flag=true;
				System.out.println(patient);
			}
		}
		if(!flag)
		{
			System.out.println("Patient with Phone Number ="+phoneNumber+" was not found");
		}	
		flag=false;
	}	
}