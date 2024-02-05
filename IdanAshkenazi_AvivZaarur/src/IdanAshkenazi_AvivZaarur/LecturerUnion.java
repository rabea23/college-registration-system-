package IdanAshkenazi_AvivZaarur;

import java.util.ArrayList;

public class LecturerUnion <T extends Lecturer> implements Comparable<LecturerUnion<? extends Lecturer>>{
	String regulations;
	T chairperson;
	ArrayList<T> lecturers = new ArrayList<>();
	
	public LecturerUnion(ArrayList<T> lecturers, T chairperson) {
		if (lecturers != null) {
			for (T lecturer : lecturers) 
				this.lecturers.add(lecturer);
		}
		if (chairperson != null)
			this.chairperson = chairperson;
		else 
			this.chairperson = null;
	}
	
	public void addLecturer(T lecturer) {
		lecturers.add(lecturer);
	}
	
	public void removeLecturer(T lecturer) {
		lecturers.remove(lecturer);
	}
	
	public void setChairperson(T lecturer) {
		this.chairperson = lecturer;
	}

	@Override
	public int compareTo(LecturerUnion<? extends Lecturer> otherUnion) {
		int lecturersAmount;
		int otherLecturersAmount;
		
		lecturersAmount = lecturers.size();
		otherLecturersAmount = otherUnion.lecturers.size();
		if (lecturersAmount > otherLecturersAmount)		return 1;
		if (lecturersAmount < otherLecturersAmount)		return -1;
		return 0;
	}
	
	public String toString() {
        String print = "";
        for (T lecturer : lecturers) {
        	print += lecturer.toString();
        	print += "\n";
        }
        return print;
    }
	
}
