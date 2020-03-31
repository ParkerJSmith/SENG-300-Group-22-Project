package scholarshipSystem;

public class Scholarship {
	private String department;
	private String level;
	private String[] requirements;
	private int availability;
	private int amount;
	private String name;

	public Scholarship(String nname, String ndepartment, String nlevel, String[] nrequirements, int navailability,
			int namount) {
		name = nname;
		department = ndepartment;
		level = nlevel;
		requirements = nrequirements;
		availability = navailability;
		amount = namount;
	}

	public Scholarship(String name) {
		this.name = name;
		department = "Test department";
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String newdepart) {
		department = newdepart;
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

}
