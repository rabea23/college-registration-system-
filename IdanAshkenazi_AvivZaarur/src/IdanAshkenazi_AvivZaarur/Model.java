package IdanAshkenazi_AvivZaarur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {
	LecturerUnion<RegularLecturer> regularLecturers = new LecturerUnion<>(null, null);
	LecturerUnion<GuestLecturer> guestLecturers = new LecturerUnion<>(null, null);
	ArrayList<Lecturer> collegeLecturers = new ArrayList<>();
	ArrayList<String> committees = new ArrayList<>();
	ArrayList<String> colleges = new ArrayList<>();
	
	public static final double regularLecturerBonus = 500;
	public static final double guestLecturerBonus = 350;
	
	public Model() throws FileNotFoundException {
		readColleges();
	}
	
	public void insertLecturer(Lecturer newLecturer, String lecturerType) {
		collegeLecturers.add(newLecturer);
		if (lecturerType == "r")
			regularLecturers.addLecturer((RegularLecturer)newLecturer);
		else 
			guestLecturers.addLecturer((GuestLecturer)newLecturer);
		for (Lecturer lecturer : collegeLecturers)
			System.out.println(lecturer);
	}
	
	public ArrayList<String> getCommittees() {
		return committees;
	} 
	
	public ArrayList<String> getColleges(){
		return colleges;
	}
	
	public void addCollege(String collegeName) {
		colleges.add(collegeName);
	}
	
	public void addPresent() {
		for(Lecturer lecturer : collegeLecturers)
			if(lecturer instanceof RegularLecturer)
				lecturer.setSalary(lecturer.getSalary() + regularLecturerBonus);
			else
				lecturer.setSalary(lecturer.getSalary() + guestLecturerBonus);
	}
	
	public ArrayList<Lecturer> getLecturers() {
		return collegeLecturers;
	}
	
	public Lecturer findLecturerByName (String name) {
		for (Lecturer lecturer : collegeLecturers) {
			if (lecturer.getFullName() == name)
				return lecturer;
		}
		return null;
	}
	
	public void read(String college) throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectInputStream i = new ObjectInputStream(new FileInputStream(college + ".txt"))){
			int n = i.readInt();
			for (int j=0; j<n; j++) {
				Lecturer lecturer = (Lecturer)i.readObject();
				System.out.println(lecturer.getFullName());
				collegeLecturers.add(lecturer);
				if (lecturer instanceof RegularLecturer)
					regularLecturers.addLecturer((RegularLecturer)lecturer);
				else if (lecturer instanceof GuestLecturer)
					guestLecturers.addLecturer((GuestLecturer)lecturer);
				
			}
		}
	}
	
	public void readCommittees(String college) throws FileNotFoundException {
		try {
			committees.clear();
			String filename = "committees.txt";
			File myObj = new File(filename);
			if (myObj.createNewFile()) {
				System.out.println("new file created");
			}
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				committees.add(data);
		    }
		    myReader.close();
		 } catch (IOException e) {
			 System.out.println("error eccured");
		 }
	}
	
	public void readColleges() throws FileNotFoundException {
		try {
			String filename = "colleges.txt";
			File myObj = new File(filename);
			if (myObj.createNewFile()) {
				System.out.println("new file created");
			}
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				colleges.add(data);
		    }
		    myReader.close();
		 } catch (IOException e) {
			 System.out.println("error eccured");
		 }
	}
	
	public void saveColleges(ArrayList<String> colleges) throws FileNotFoundException, IOException {
		FileWriter myWriter = new FileWriter("colleges.txt");
		for (String college : colleges)
			myWriter.write(college + "\n");
		myWriter.close();
		System.out.println("Successfully wrote to the file.");

	}
	
	public void save(String college) throws FileNotFoundException, IOException {
		try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(college + ".txt"))){
			o.writeInt(collegeLecturers.size());
			for (int j=0; j<collegeLecturers.size(); j++) {
				o.writeObject(collegeLecturers.get(j));
			}
		}
	}
}
