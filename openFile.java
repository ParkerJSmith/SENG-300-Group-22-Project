package scholarshipSystem;
import java.util.Scanner;
import javax.swing.JFileChooser;


public class openFile {
	JFileChooser fileChooser = new JFileChooser();
	public StringBuilder sb = new StringBuilder();

	public void pick() throws Exception{
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			java.io.File file = fileChooser.getSelectedFile();
			Scanner input = new Scanner(file);
			
			while(input.hasNext()) {
				sb.append(input.nextLine());
				sb.append("\n");
				
			}
			input.close();
		}
		else {
			sb.append("No file was Selected");
			
		}
	}
}
