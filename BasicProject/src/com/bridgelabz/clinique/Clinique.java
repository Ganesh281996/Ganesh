package com.bridgelabz.clinique;

public interface Clinique 
{
	void readData();
	void writeData();
	void printData();
	void addDoctor();
	void addPatient();
	void takeAppointmentByID();
	void popularDoctor();
	void searchDoctorById();
	void searchDoctorByName();
	void searchDoctorBySpecialization();
	void searchDoctorByAvailiability();
	void searchPatientById();
	void searchPatientByName();
	void searchPatientByPhoneNumber();
}