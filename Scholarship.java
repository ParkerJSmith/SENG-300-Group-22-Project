package scholarshipSystem;

public class Scholarship {
	private String level;
	private String[] requirements;
	private int availability;
	private int amount;
	private String name;
	private int applicantTotal;
	private int applicantsAccepted;
	private double minGPA;
	private Faculty faculty;

	public Scholarship(String nname, String nlevel, Faculty nfaculty, String[] nrequirements, int navailability,
			int namount, double nminGPA) {
		name = nname;
		level = nlevel;
		requirements = nrequirements;
		availability = navailability;
		amount = namount;
		applicantTotal = 0;
		applicantsAccepted = 0;
		minGPA = nminGPA;
		faculty = nfaculty;
	}

	public Scholarship(String name) {
		this.name = name;
		level = "Level";
		requirements = new String[1];
		availability = 3213;
		amount = 32131;
	}

	public String getName() {
		return name;
	}

	public void setName(String newname) {
		name = newname;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String newlevel) {
		level = newlevel;
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

}
