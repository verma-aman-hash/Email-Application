package emailApplication;

import java.util.Scanner;


public class Email {
private String firstName;
private String lastName;
private String email;
private Department department;
private String password;
private String alternateEmail;
private String departmentID;
final private String companyName ="myCompany";
private int mailBoxCapacity =500;
final private int passwordLength =8;


enum Department{
	ACCOUNT("D001"),SALES("D002"),DEVELOPER("D003"),NONE("D000");
	private String DepartmentId;
	
	public String getDepartmentId() {
		return DepartmentId;
	}
	
	private Department(String id) {
		this.DepartmentId=id;
	}

}

public Department getDepartment() {
	return department;
}

public Department setDepartment() {
	
	System.out.println("Please select your Department :");
	for(Department d :Department.values()) {
		System.out.println("TYPE : "+d.ordinal()+" FOR "+d);}
		System.out.print("Enter your choice------>");
	
	Scanner sc = new Scanner(System.in);
	int dept = sc.nextInt();
	department =Department.values()[dept];
	return department;
}

public Email(String firstName, String lastName) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.password=generatePassword(passwordLength);
	System.out.println("Welcone "+firstName+" On board");
	this.department = setDepartment();
	this.departmentID=setDepartmentId(getDepartment());
	this.email=createEmail();
	System.out.println(toString());
	}


public String getEmail() {
	return email;
}

public String getPassword() {
	return password;
}

public String getAlternateEmail() {
	return alternateEmail;
}

public void setAlternateEmail(String alternateEmail) {
	this.alternateEmail = alternateEmail;
}

public int getMailBoxCapacity() {
	return mailBoxCapacity;
}

public void setMailBoxCapacity(int mailBoxCapacity) {
	this.mailBoxCapacity = mailBoxCapacity;
}



public String generatePassword(int passwordLength) {
	String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$-";
	char [] password = new char[passwordLength];
	for(int i=0;i<passwordLength;i++) {
		password [i] = passwordSet.charAt((int) (Math.random() * passwordSet.length()));
	}
	return new String(password);
	
}
public String createEmail() {
	
	return firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department.toString().toLowerCase()+"."+companyName+".com";
	
}
public String setDepartmentId(Department department) {
	return departmentID=department.getDepartmentId();
}

@Override
public String toString() {
	return "Email [firstName=" + firstName + ", lastName=" + lastName + ", department="
			+ department + ", departmentID="
					+ departmentID+", email=" + email + ", password=" + password + ", alternateEmail=" + alternateEmail + ", companyName="
			+ companyName + ", mailBoxCapacity=" + mailBoxCapacity + ", passwordLength=" + passwordLength + "]";
}

}
