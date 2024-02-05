package IdanAshkenazi_AvivZaarur;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Controller  {	
	public Model model;
	public View view;
	private String college = "";
	
	public Controller(Model model ,View view) {
		this.model = model;
		this.view = view;
		
		view.handleSubmitCollegeButton(e -> {
			if (view.getCollege() != null) {
				try {
					college = view.getSubmitCollegeName();
					model.readCommittees(college);
					model.read(college);
				} catch (FileNotFoundException f){
					Alert dialog = new Alert(AlertType.ERROR, "the college file not found", ButtonType.OK);
					dialog.show();
				} catch (ClassNotFoundException f) {
					Alert dialog = new Alert(AlertType.ERROR, "class cannot be found", ButtonType.OK);
					dialog.show();
				} catch (IOException f) {
					f.printStackTrace();
				}
				view.setCommittees(model.getCommittees());
				view.setMain();
			}
		});
		
		view.handleCollegeComboButton(e -> {
			view.setColleges(model.getColleges());
		});
		
		view.handleAddCollegeButton(e -> {
			String collegeName = view.getCollegeName();
			if (collegeName != "")
				model.addCollege(collegeName);
		});
		
		view.handleAddLecturerButton(e -> {
			Lecturer newLecturer = view.buildLecturer();
			if (newLecturer != null) { 
				model.insertLecturer(newLecturer, view.getLecturerType());
				Alert dialog = new Alert(AlertType.CONFIRMATION, "lecturer added successfully!", ButtonType.OK);
				dialog.show();
			}
		});
		
		view.handleSendMessageButton (e -> { 
			view.sendMessage();
		});
		
		view.handleSendPresentButton(e -> {
			view.sendPresent();
			model.addPresent();
		});
		
		view.handleShowLecturersButton(e -> {
			view.lecturersView(model.regularLecturers.lecturers, model.guestLecturers.lecturers, model.regularLecturers.compareTo(model.guestLecturers), model.regularLecturers.chairperson, model.guestLecturers.chairperson);
		});
		
		view.handleLecturersComboButton(e -> {
			view.setLecturersComboBox(model.getLecturers());
		});
		
		view.handleRemoveLecturerButton(e -> {
			String lecturerName = view.getLecturerValue();
			Lecturer lecturer = model.findLecturerByName(lecturerName);
			model.collegeLecturers.remove(lecturer);
			if (view.getLecturerType() == "r")
				model.regularLecturers.removeLecturer((RegularLecturer)lecturer);
			else if (view.getLecturerType() == "g")
				model.guestLecturers.removeLecturer((GuestLecturer)lecturer);
		});
		
		view.handleChairpersonComboButton(e -> {
			view.setChairpesronComboBox(model.getLecturers());
		});
		
		view.handleSetChairpersonButton(e -> {
			String lecturerName = view.getChairpersonValue();
			Lecturer lecturer = model.findLecturerByName(lecturerName);
			if (lecturer instanceof RegularLecturer)
				model.regularLecturers.setChairperson((RegularLecturer)lecturer);
			else 
				model.guestLecturers.setChairperson((GuestLecturer)lecturer);
		});
		
		view.handleCloseMainStage(e -> {
			try {
				model.save(college);
			} catch (FileNotFoundException f) {
				Alert dialog = new Alert(AlertType.ERROR, "the file did not found", ButtonType.OK);
				dialog.show();
			} catch (IOException g) {
				Alert dialog = new Alert(AlertType.ERROR, "problem with wirting to file", ButtonType.OK);
				dialog.show();
			}
		});
		
		view.handleCloseCollegeStage(e -> {
			try {
				model.saveColleges(model.colleges);
			} catch (FileNotFoundException f) {
				Alert dialog = new Alert(AlertType.ERROR, "the file did not found", ButtonType.OK);
				dialog.show();
			} catch (IOException f) {
				Alert dialog = new Alert(AlertType.ERROR, "problem with wirting to file", ButtonType.OK);
				dialog.show();
			}
		});
		
	}
	
	
}
