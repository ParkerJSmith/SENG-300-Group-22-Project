package scholarshipSystem;

import java.util.Date;

public class Application {

	String lastName, firstName, id;
	Faculty faculty;
	int year, gpa;
	String birthDate;
	Scholarship scholarship;
	String status;
	Student student;
	String [] files;

	public static final int PENDING = -1;
	public static final int APPROVED = 1;
	public static final int REJECTED = 0;

	public Application(String lastName, String firstName, String id, String birthDate, Faculty faculty, int year, int gpa,
			Scholarship scholarship, Student student, String [] files) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
		this.birthDate = birthDate;
		this.faculty = faculty;
		this.year = year;
		this.gpa = gpa;
		this.scholarship = scholarship;
		this.status = "(pending)";
		this.student = student;
		this.files = files;
	}
	
	public Application(String lastName, String firstName, String id, String birthDate, Faculty faculty, int year, int gpa,
			Scholarship scholarship, Student student, int status) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
		this.birthDate = birthDate;
		this.faculty = faculty;
		this.year = year;
		this.gpa = gpa;
		this.scholarship = scholarship;
		this.student = student;
		setStatus(status);
	}

	public String getName() {
		return lastName + " " + scholarship.getName();
	}

	public Scholarship getScholarship() {
		return this.scholarship;
	}

	public void setStatus(int statusCode) {
		switch (statusCode) {
		case -1:
			this.status = "(pending)";
			break;
		case 0:
			this.status = "(rejected)";
			break;
		case 1:
			this.status = "(approved)";
			break;
		}
	}

	public Student getStudent() {
		return this.student;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getID() {
		return this.id;
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public Faculty getFaculty() {
		return this.faculty;
	}

	public int getYear() {
		return this.year;
	}
	
	public int getGPA() {
		return this.gpa;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public String [] getFilePaths() {
		return this.files;
	}

}
