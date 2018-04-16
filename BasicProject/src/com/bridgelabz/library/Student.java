package com.bridgelabz.library;

public class Student 
{
	private long studentId;
	private String studentName;
	private long contactNumber;
	
	public Student(String studentName, long contactNumber) 
	{
		this.studentName = studentName;
		this.contactNumber = contactNumber;
	}
	
	public long getStudentId() 
	{
		return studentId;
	}
	public void setStudentId(long studentId) 
	{
		this.studentId = studentId;
	}
	public String getStudentName()
	{
		return studentName;
	}
	public void setStudentName(String studentName) 
	{
		this.studentName = studentName;
	}
	public long getContactNumber()
	{
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) 
	{
		this.contactNumber = contactNumber;
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (contactNumber ^ (contactNumber >>> 32));
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (contactNumber != other.contactNumber)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", contactNumber=" + contactNumber
				+ "]";
	}
}