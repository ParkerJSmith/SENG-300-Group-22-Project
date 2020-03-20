public class Scholarship {
    private String department;
    private String level;
    private String[] requirements;
    private int availability;
    private String name;

    public Scholarship(String nname, String ndepartment, String nlevel, String[] nrequirements, int navailability){
        name = nname;
        department = ndepartment;
        level = nlevel;
        requirements = nrequirements;
        availability = navailability;
    }

    public Scholarship(){}

    public String getName(){
        return name;
    }

    public void setName(String newname){
        name = newname;
    }

    public String getDepartment(){
        return department;
    }

    public void setDepartment(String newdepart){
        department = newdepart;
    }

    public String getLevel(){
        return level;
    }

    public void setLevel(String newlevel){
        level = newlevel;
    }
    public String[] getRequirements(){
        return requirements;
    }

    public void setRequirements(String[] newRequirements){
        requirements = newRequirements;
    }

    public int getAvailability(){
        return availability;
    }

    public void setAvailability(int newava){
        availability = newava;
    }

}
