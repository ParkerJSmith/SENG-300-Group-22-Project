package scholarshipSystem;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Application {

	String lastName, firstName, id;
	Faculty faculty;
	int year;
	double gpa;
	Calendar date;
	Scholarship scholarship;
	String status;
	Student student;
	String[] files;

	public static final int PENDING = -1;
	public static final int APPROVED = 1;
	public static final int REJECTED = 0;

	public Application(String lastName, String firstName, String id, Calendar date, Faculty faculty, int year,
			double gpa, Scholarship scholarship, Student student, String[] files) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
		this.date = date;
		this.faculty = faculty;
		this.year = year;
		this.gpa = gpa;
		this.scholarship = scholarship;
		setStatus(-1);
		this.student = student;
		this.files = files;
	}

	public Application(String lastName, String firstName, String id, Calendar date, Faculty faculty, int year, double gpa,
			Scholarship scholarship, Student student, int status) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
		this.date = date;
		this.faculty = faculty;
		this.year = year;
		this.gpa = gpa;
		this.scholarship = scholarship;
		this.student = student;
		setStatus(status);
	}
	
	public Application(Student student, Scholarship scholarship) {
		this.lastName = "Nomination Candidate";
		this.id = student.getStudentID();
		this.faculty = student.getFaculty();
		this.date = new GregorianCalendar();
		this.scholarship = scholarship;
		setStatus(-1);
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

	public Calendar getDate() {
		return this.date;
	}

	public Faculty getFaculty() {
		return this.faculty;
	}

	public int getYear() {
		return this.year;
	}

	public double getGPA() {
		return this.gpa;
	}

	public String getStatus() {
		return this.status;
	}

	public String[] getFilePaths() {
		return this.files;
	}

}
