package IdanAshkenazi_AvivZaarur;

import java.io.Serializable;
import java.util.ArrayList;

public class Lecturer implements Serializable {
	private String fullName;
	private double ID;
	private String highestDegree;
	private String speciality;
	private double Salary;
	private static final long serialVersionUID = 1L;
	
	public Lecturer(String fullName, double ID , String highestDegree, String speciality, double Salary){
		this.fullName = fullName;
		this.ID = ID;
		this.highestDegree = highestDegree;
		this.speciality = speciality;
		this.Salary = Salary;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}
	
	public ArrayList<String> getListProperties(){
		ArrayList<String> properties = new ArrayList<>();
		properties.add(fullName);
		properties.add(highestDegree);
		properties.add(speciality);
		properties.add(String.valueOf(ID));
		properties.add(String.valueOf(Salary));
		return properties;
	}
	
	@Override
	public String toString() {
		return String.format("%-15s : %-10s, %3.0f, %-10s, %-10s, %5.2f, ", this.getClass().getSimpleName(), getFullName()
				, getID(), getHighestDegree(), getSpeciality(), getSalary()); 
	}
}
