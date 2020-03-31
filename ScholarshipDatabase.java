package scholarshipSystem;
import java.util.ArrayList;
public class ScholarshipDatabase {
    private int size;
    private ArrayList<Scholarship> db;

    ScholarshipDatabase(){
        db = new ArrayList<Scholarship>();
    }

    public void addScholarship(Scholarship n){
        db.add(n);
    }

    public void removeScholarship(Scholarship n){
        db.remove(n);
    }

    public void removerScholarship(Scholarship n){
        db.remove(n);
    }

    public Object[] getScholarshipList(){
        return db.toArray();
    }

    public String [] getScholarshipNames() {
    	String names[] = new String[db.size()];
    	for (int i = 0; i < db.size(); i++) {
    		names[i] = db.get(i).getName();
    	}
    	return names;
    }

}
