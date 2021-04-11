package emailApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	NONE("D000"),ACCOUNT("D001"),SALES("D002"),DEVELOPER("D003");
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
	boolean match= false;
	while(!match) {
	System.out.println("Please select your Department :");
	for(Department d :Department.values()) {
		System.out.println("TYPE : "+d.ordinal()+" FOR "+d);}
		System.out.print("Enter your choice------>");
	
	try {
		Scanner sc = new Scanner(System.in) ;
		int dept = sc.nextInt();
		department =Department.values()[dept];
		match=true;
	}
	catch (Exception e) {
		System.out.println("please enter correct choice");
		
		// TODO: handle exception
	}}System.out.println("So you belongs to "+department+" Department");
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
	this.setAlternateEmail();
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
public void setAlternateEmail() {
	String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	boolean isTrue =false;
	while(!isTrue) {
	System.out.println("Enter your Alternate Email id :");
	Scanner scn = new Scanner(System.in);
	String email = scn.nextLine();
	boolean matches = email.matches(regex);
	//scn.close();
	if(matches==true) {
		this.alternateEmail=email;
		isTrue=true;
	}
	else
		System.out.println("Please try Again");
		
}}
public void getUserInput() throws IOException {
	System.out.println("Enter your Firstname :");
	BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
	String fname = bs.readLine();
	this.firstName =fname;
	System.out.println("Enter your Lastname :");
	String lname = bs.readLine();
	this.lastName=lname;
	Email emp = new Email(fname, lname);
	
	
}

@Override
public String toString() {
	return "Email REgistraion form Completed\n firstName=" + firstName + "\n lastName=" + lastName + "\n department="
			+ department + "\n departmentID="
					+ departmentID+"\n email=" + email + "\n password=" + password + "\n alternateEmail=" + alternateEmail + "\n companyName="
			+ companyName + "\n mailBoxCapacity=" + mailBoxCapacity + "\n passwordLength=" + passwordLength ;
}

}
