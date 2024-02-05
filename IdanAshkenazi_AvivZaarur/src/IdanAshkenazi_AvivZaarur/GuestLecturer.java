package IdanAshkenazi_AvivZaarur;

import java.io.Serializable;
import java.util.ArrayList;

public class GuestLecturer extends Lecturer implements Serializable {
	
	private double hourlyRate;
	private double hoursPerMonths;
	private static final long serialVersionUID = 1L;
	
	public GuestLecturer(String fullName, double ID , String highestDegree, String speciality, double salary, double hourlyRate, double hoursPerMonths) {
		super(fullName, ID, highestDegree, speciality, salary);
		this.hourlyRate = hourlyRate;
		this.hoursPerMonths = hoursPerMonths;
	}
	
	public double getHoursPerMonths() {
		return hoursPerMonths;
	}

	public void setHoursPerMonths(double hoursPerMonths) {
		this.hoursPerMonths = hoursPerMonths;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	public String toString() {
        return super.toString() + String.format("%5.2f, %3.0f", hourlyRate, hoursPerMonths);
    }
	
	public ArrayList<String> getListProperties(){
		ArrayList<String> properties = super.getListProperties();
		properties.add((String.valueOf(hourlyRate)));
		properties.add(String.valueOf(hoursPerMonths));
		return properties;
	}

}

