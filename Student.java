package scholarshipSystem;

import java.util.ArrayList;

public class Student extends User {
	private Scholarship scholarship;
	private String studentID = "";
	private Faculty faculty;
	private ArrayList<Scholarship> appliedScholarships = new ArrayList<>();
	private ArrayList<Application> applicationList = new ArrayList<>();

	public Student(String username, String password, Faculty faculty, AccountHandler accountHandler) {
		super(username, password);
		this.scholarship = null;
		this.faculty = faculty;
		do {
			for (int i = 0; i < 8; i++) {
				this.studentID += (int) (Math.random() * 10);
			}
		} while (!accountHandler.checkUniqueID(this.studentID));
		System.out.println(studentID);
	}

	public void setScholarship(Scholarship scholarship) {
		this.scholarship = scholarship;
	}

	public Scholarship getScholarship() {
		return this.scholarship;
	}

	public void addAppliedScholarships(Scholarship scholarship) {
		if (!checkAppliedMax()) {
			appliedScholarships.add(scholarship);
		}
	}

	public boolean checkAppliedMax() {
		if (appliedScholarships.size() == 3) {
			return true;
		}
		return false;
	}

	public void addApplication(Application application) {
		applicationList.add(application);
		addAppliedScholarships(application.getScholarship());
	}

	public String[] getApplicationNames() {
		String names[] = new String[applicationList.size()];
		for (int i = 0; i < applicationList.size(); i++) {
			names[i] = applicationList.get(i).getName() + " " + applicationList.get(i).getStatus();
		}
		return names;
	}

	public Faculty getFaculty() {
		return this.faculty;
	}

	public String getStudentID() {
		return this.studentID;
	}
}
