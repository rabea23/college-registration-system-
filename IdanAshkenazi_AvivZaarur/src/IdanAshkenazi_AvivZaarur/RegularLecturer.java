package IdanAshkenazi_AvivZaarur;

import java.io.Serializable;
import java.util.ArrayList;

public class RegularLecturer extends Lecturer implements Cloneable, Serializable{
	private double salaryPerMonth;
	private double seniority;
	private String committees;
	private static final long serialVersionUID = 1L;
	
	public RegularLecturer(String fullName, double ID , String highestDegree, String speciality, double salary, double salaryPerMonth, double seniority, String committees) {
		super(fullName, ID, highestDegree, speciality, salary);
		this.salaryPerMonth = salaryPerMonth;
		this.seniority = seniority;
		this.committees = committees;
	}

	public double getsalaryPerMonth() {
		return salaryPerMonth;
	}

	public void setsalaryPerMonth(float salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}
	
	public double getSeniority() {
		return seniority;
	}

	public void setSeniority(float seniority) {
		this.seniority = seniority;
	}
	
	public String getCommittees() {
		return committees;
	}

	public void setCommittees(String committees) {
		this.committees = committees;
	}
	
	public String toString() {
        return super.toString() + String.format("%5.2f, %3.0f, %-10s", salaryPerMonth, seniority, committees);
    }
	
	public ArrayList<String> getListProperties(){
		ArrayList<String> properties = super.getListProperties();
		properties.add(String.valueOf(salaryPerMonth));
		properties.add(String.valueOf(seniority));
		properties.add(committees);
		return properties;
	}
	
	@Override
	public RegularLecturer clone() throws CloneNotSupportedException {
		return (RegularLecturer)super.clone();
	}


}
