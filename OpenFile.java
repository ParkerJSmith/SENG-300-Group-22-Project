package scholarshipSystem;
import java.io.File;

import javax.swing.JFileChooser;


public class OpenFile {
	JFileChooser fileChooser = new JFileChooser();

	public String pick() throws Exception{
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			return file.getAbsolutePath();
		} else {
			return "";
		}
	}
}
