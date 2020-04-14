package scholarshipSystem;

import java.util.ArrayList;

public class ApplicationHandler {

	private ArrayList<Application> applicationList = new ArrayList<>();
	
	public ApplicationHandler() {
		
	}
	
	public void addApplication(Application application) {
		applicationList.add(application);
		application.getScholarship().incrementApplicants();
	}
	
	public void removeApplication(Application application) {
		applicationList.remove(application);
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
	
	
}
