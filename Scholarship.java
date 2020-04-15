package scholarshipSystem;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Scholarship implements java.io.Serializable {
	private String[] requirements;
	private int availability;
	private int amount;
	private Calendar deadline;
	private String name;
	private int applicantTotal;
	private int applicantsAccepted;
	private double minGPA;
	private Faculty faculty;
	private boolean nominatable;

	public Scholarship(String nname, Calendar ndeadline, Faculty nfaculty, String[] nrequirements, int navailability,
			int namount, double nminGPA, boolean nnominatable) {
		name = nname;
		deadline = ndeadline;
		requirements = nrequirements;
		availability = navailability;
		amount = namount;
		applicantTotal = 0;
		applicantsAccepted = 0;
		minGPA = nminGPA;
		faculty = nfaculty;
		nominatable = nnominatable;
	}

	public Scholarship(String name) {
		this.name = name;
		deadline = new GregorianCalendar();
		deadline.set(2020, 4, 31);
		requirements = new String[1];
		availability = 3213;
		amount = 32131;
		applicantTotal = 0;
		applicantsAccepted = 0;
		minGPA = 3.2;
		faculty = Faculty.SCIENCE;
		nominatable = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String newname) {
		name = newname;
	}

	public Calendar getDeadline() {
		return deadline;
	}

	public void setDeadline(Calendar newdeadline) {
		deadline = newdeadline;
	}

	public String[] getRequirements() {
		return requirements;
	}

	public void setRequirements(String[] newRequirements) {
		requirements = newRequirements;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int newava) {
		availability = newava;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int namount) {
		amount = namount;
	}
	
	public Faculty getFaculty() {
		return this.faculty;
	}
	
	public double getMinGPA() {
		return this.minGPA;
	}
	
	public void incrementApplicants() {
		this.applicantTotal++;
	}
	
	public boolean getNominatable() {
		return this.nominatable;
	}

}
