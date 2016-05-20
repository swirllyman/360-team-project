import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

/**
 * A database to manage contest entry submissions.
 * @author tryHARD
 * @version 5/19/2016
 */
public class Database {

	private Submission mySub; // A single user entry
	
	private File mySubmissions; // All user submissions 
	
	// Constructs a database
	public Database() {
		mySub = null;
		mySubmissions = new File("submissions.txt");
	}
	
	// Adds the given submission to the database
	public void addSubmission(Submission theSubmission) throws FileNotFoundException, UnsupportedEncodingException {
		int ID = theSubmission.getID();
		String name = theSubmission.getName();
		String category = theSubmission.getCategory();
		int age = theSubmission.getAge();
		File file = theSubmission.getImage();
		String image = file.getName();
		String info = ID + " " + name +  " " + category + " " + image;
		PrintWriter out = new PrintWriter(mySubmissions, "UTF-8");
		CharSequence cs = info.subSequence(0, info.length());
		out.append(cs);
		out.close();
	}
	
	// Adds a flag next to the given submission in the database to 
	// signify that it has been removed.
	public void removeSubmission(Submission theSub) throws FileNotFoundException {
		int givenID = theSub.getID();
		Scanner input = new Scanner(mySubmissions);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] parts = line.split(" ");
			int currentID = Integer.parseInt(parts[0]);
			if (givenID == currentID) {
				// Add delete flag
			} else {
				// continue
			}
		}
		input.close();
	}
	
	
	
	
	
}
