package scholarshipSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ApplicationHandler{

	private ArrayList<Application> applicationList;
	private SystemHandler g;
	
	public ApplicationHandler(SystemHandler h) {
		//Try to deserialize applications from file, otherwise use new accounts
			g = h; //get system handler so we can save scholarship database
			try {
				FileInputStream fIn = new FileInputStream("Applications.ser");
				ObjectInputStream in = new ObjectInputStream(fIn);
				applicationList = (ArrayList<Application>) in.readObject();
				in.close();
				fIn.close();
			} catch(IOException e) {
				System.out.println("Applications.ser not found. Creating new application list...");
				this.applicationList = new ArrayList<Application>();
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	public void addApplication(Application application) {
		applicationList.add(application);
		application.getScholarship().incrementApplicants();
		writeApplications();
		g.writeScholarshipDB();
	}
	
	public void removeApplication(Application application) {
		applicationList.remove(application);
		writeApplications();
	}


	public String [] getApplicationNames() {
    	String names[] = new String[applicationList.size()];
    	for (int i = 0; i < applicationList.size(); i++) {
    		names[i] = applicationList.get(i).getName();
    	}
    	return names;
	}
	
	public int size() {
		return applicationList.size();
	}
	
	public Application getApplication(int index) {
		return applicationList.get(index);
	}
	
	private void writeApplications() {
		try {
	    	FileOutputStream fOut = new FileOutputStream("Applications.ser");
	    	ObjectOutputStream out = new ObjectOutputStream(fOut);
	    	out.writeObject(applicationList);
	    	out.close();
	    	fOut.close();
	    } catch (IOException e) {
	    	System.out.println("Applications.ser not found.");
	    	e.printStackTrace();
	    }
	    return;
	}
	
	
}
