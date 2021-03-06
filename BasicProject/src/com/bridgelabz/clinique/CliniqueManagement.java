/**
 * @purpose Manage Clinique Operations
 * @author Ganesh
 * @since 11 March 2018
 */
package com.bridgelabz.clinique;

import com.bridgelabz.utility.Utility;

public class CliniqueManagement 
{
	public static void main(String[] args) 
	{
		int choice=0;
		Clinique clinique=new CliniqueImp();
		Utility utility=new Utility();
		
		clinique.readData();
		do
		{
			System.out.println("1. Add Doctor");
			System.out.println("2. Add Patient");
			System.out.println("3. Print Data");
			System.out.println("4. Save Data");
			System.out.println("5. Search Doctor by Id");
			System.out.println("6. Search Doctor by Name");
			System.out.println("7. Search Doctor by Specialization");
			System.out.println("8. Search Doctor by Availability");
			System.out.println("9. Search Patient by Id");
			System.out.println("10. Search Patient by Name");
			System.out.println("11. Search Patient by Phone Number");
			System.out.println("12. Take Appointment by Id");
			System.out.println("13. Popular Doctor");
			System.out.println("14. Exit");
			System.out.println("Enter your Choice=");
			choice=utility.nextInt();
			
			switch(choice)
			{
			case 1:
				clinique.addDoctor();
				break;
				
			case 2:
				clinique.addPatient();
				break;
				
			case 3:
				clinique.printData();
				break;
				
			case 4:
				clinique.writeData();
				break;
				
			case 5:
				clinique.searchDoctorById();
				break;
				
			case 6:
				clinique.searchDoctorByName();
				break;
				
			case 7:
				clinique.searchDoctorBySpecialization();
				break;
				
			case 8:
				clinique.searchDoctorByAvailiability();
				break;
				
			case 9:
				clinique.searchPatientById();
				break;
				
			case 10:
				clinique.searchPatientByName();
				break;
				
			case 11:
				clinique.searchPatientByPhoneNumber();
				break;
				
			case 12:
				clinique.takeAppointmentByID();
				break;
				
			case 13:
				clinique.popularDoctor();
				break;
				
			default:
				if(choice<1)
				{
					System.out.println("Invalid Input Try Again.");
					System.out.println("1. Add Doctor");
					System.out.println("2. Add Patient");
					System.out.println("3. Print Data");
					System.out.println("4. Save Data");
					System.out.println("5. Search Doctor by Id");
					System.out.println("6. Search Doctor by Name");
					System.out.println("7. Search Doctor by Specialization");
					System.out.println("8. Search Doctor by Availability");
					System.out.println("9. Search Patient by Id");
					System.out.println("10. Search Patient by Name");
					System.out.println("11. Search Patient by Phone Number");
					System.out.println("12. Take Appointment by Id");
					System.out.println("13. Popular Doctor");
					System.out.println("14. Exit");
					System.out.println("Enter your Choice=");
					choice=utility.nextInt();
				}
			}
		}
		while(choice!=14);
	}
}