package IdanAshkenazi_AvivZaarur;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class View {
	private ComboBox<String> collegeCombo = new ComboBox<>();
	private Label collegeLabel = new Label("Collage:");
	private Button submitCollegeButton = new Button("Submit");
	private Button addCollegeButton = new Button("Add college");
	private TextField collegeName = new TextField();

	private RadioButton regularLecturerTypeRadio = new RadioButton("Regular Lecturer");
	private RadioButton guestLecturerTypeRadio = new RadioButton("Guest Lecturer");
	private TextField nameField = new TextField();
	private TextField idField = new TextField();
	private ComboBox<String> degreeCombo = new ComboBox<>();
	private TextField specialityField = new TextField();
	private TextField salaryField = new TextField();
	private TextField seniorityField = new TextField();
	private TextField hourlyRateField = new TextField();
	private TextField hoursPerMonths = new TextField();
	private Button addLecturerButton = new Button("Add Lecturer");
	private ArrayList<CheckBox> committeesCheckBoxs = new ArrayList<>();
	private ComboBox<String> lecturersComboBox = new ComboBox<>();
	private TextField messageContent = new TextField();
	private Button sendMessageButton = new Button("send message");
	private Label presentLabel = new Label("happy Holidays! Click here to increase lecturers' salaries:");
	private Button PresentButton = new Button("Send a gift!");
	private Button showLecturersButton = new Button("college lecturers");
	private Button removeLecturersButton = new Button("remove this lecturer");
	private Button setChairpersonButton = new Button("set chairperson");
	private ComboBox<String> chairpersonComboBox = new ComboBox<>();
	private Stage mainStage = new Stage();
	private Stage collegeStage = new Stage();
	
	public View() {	
		collegeView();
	}
	
	public void handleCloseMainStage(EventHandler<WindowEvent> e) {
		mainStage.setOnCloseRequest(e);
	}
	
	public void handleCloseCollegeStage(EventHandler<WindowEvent> e) {
		collegeStage.setOnCloseRequest(e);
	}
	
	public void handleCollegeComboButton(EventHandler<Event> e) {
		collegeCombo.setOnMousePressed(e);
	}
	
	public void handleAddCollegeButton(EventHandler<ActionEvent> e) {
		addCollegeButton.setOnAction(e);
	}
	
	public void handleSubmitCollegeButton(EventHandler<ActionEvent> e) {
		submitCollegeButton.setOnAction(e);
	}
	
	public void handleAddLecturerButton(EventHandler<ActionEvent> e) {
		addLecturerButton.setOnAction(e);
	}
	
	public void handleSendMessageButton(EventHandler<ActionEvent> e) {
		sendMessageButton.setOnAction(e);
	}
	
	public void handleSendPresentButton(EventHandler<ActionEvent> e) {
		PresentButton.setOnAction(e);
	}
	
	public void handleShowLecturersButton(EventHandler<ActionEvent> e) {
		showLecturersButton.setOnAction(e);
	}
	
	public void handleLecturersComboButton(EventHandler<Event> e) {
		lecturersComboBox.setOnMousePressed(e);
	}
	
	public void handleRemoveLecturerButton(EventHandler<ActionEvent> e) {
		removeLecturersButton.setOnAction(e);
	}
	
	public void handleSetChairpersonButton(EventHandler<ActionEvent> e) {
		setChairpersonButton.setOnAction(e);
	}
	
	public void handleChairpersonComboButton(EventHandler<Event> e) {
		chairpersonComboBox.setOnMousePressed(e);
	}
	
	public void collegeView() {
		collegeLabel.setTextFill(Color.GREEN);
		HBox collegeHbox = new HBox(20, collegeLabel, collegeCombo, submitCollegeButton);
		collegeHbox.getSpacing();
		collegeHbox.setAlignment(Pos.CENTER);
		
		collegeName.setPromptText("College name");
		HBox addCollegeHbox = new HBox(20, collegeName, addCollegeButton);
		addCollegeHbox.getSpacing();
		addCollegeHbox.setAlignment(Pos.CENTER);
		
		VBox collegeVbox = new VBox(30, collegeHbox, addCollegeHbox);
		collegeVbox.setPadding(new Insets(100,0,0,0));
		
		Scene collegeScene = new Scene(collegeVbox, 400, 400);
		
		collegeStage.setTitle("Main");
		collegeStage.setScene(collegeScene);
		collegeStage.show();
	}
	
	public void setMain() {
		ToggleGroup lecturerType = new ToggleGroup();
		regularLecturerTypeRadio.setToggleGroup(lecturerType);
		guestLecturerTypeRadio.setToggleGroup(lecturerType);
		HBox radioHbox = new HBox(20, regularLecturerTypeRadio, guestLecturerTypeRadio);
		radioHbox.getSpacing();
		
		EventHandler<ActionEvent> fieldsHandler = e -> editField();
		regularLecturerTypeRadio.setOnAction(fieldsHandler);
		guestLecturerTypeRadio.setOnAction(fieldsHandler);
		
		nameField.setPromptText("enter name");
		idField.setPromptText("enter id");
		degreeCombo.getItems().addAll("Bachelor", "Master", "Doctor", "Professor");
		specialityField.setPromptText("enter speciality");
		HBox lecturerHbox = new HBox(20, nameField, idField, degreeCombo, specialityField);
		lecturerHbox.getSpacing();
		
		salaryField.setPromptText("enter salary");
		salaryField.setEditable(false);
		seniorityField.setPromptText("enter seniority");
		seniorityField.setEditable(false);
		HBox regularLecturer = new HBox(20, salaryField, seniorityField);
		regularLecturer.getSpacing();
		
		HBox committees = new HBox(20);
		for (CheckBox committeeBox : committeesCheckBoxs) {
			committees.getChildren().add(committeeBox);
		}
		committees.getSpacing();
		
		hourlyRateField.setPromptText("enter salary per hour");
		hourlyRateField.setEditable(false);
		hoursPerMonths.setPromptText("enter hours per month");
		hoursPerMonths.setEditable(false);
		HBox guestLecturer = new HBox(20, hourlyRateField, hoursPerMonths);
		guestLecturer.getSpacing();
		
		VBox addLecturer = new VBox(30, lecturerHbox, regularLecturer, committees, guestLecturer, addLecturerButton);
		
		addLecturer.setStyle("-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" + 
                "-fx-border-radius: 5;" + 
                "-fx-border-color: black;");
		
		
		HBox removeLecturer = new HBox(20, lecturersComboBox , removeLecturersButton);
		guestLecturer.getSpacing();		
		removeLecturer.setStyle("-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" + 
                "-fx-border-radius: 5;" + 
                "-fx-border-color: black;");

		HBox setChairPerson = new HBox(20, chairpersonComboBox, setChairpersonButton);
		setChairPerson.getSpacing();
		setChairPerson.setStyle("-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" + 
                "-fx-border-radius: 5;" + 
                "-fx-border-color: black;");
		
		messageContent.setPromptText("enter message");
		HBox sendMessage = new HBox(20, messageContent, sendMessageButton);
		sendMessage.getSpacing();
		sendMessage.setPadding(new Insets(50, 0, 0, 0));		
		sendMessage.setStyle("-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" + 
                "-fx-border-radius: 5;" + 
                "-fx-border-color: black;");
		
		HBox presentHbox = new HBox(20, presentLabel, PresentButton );
		presentHbox.getSpacing();
		presentHbox.setPadding(new Insets(50, 0, 0, 0));		
		presentHbox.setStyle("-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" + 
                "-fx-border-radius: 5;" + 
                "-fx-border-color: black;");
		
		VBox mainVbox = new VBox(30, radioHbox, addLecturer, removeLecturer, setChairPerson, sendMessage, presentHbox, showLecturersButton);
		mainVbox.setPadding(new Insets(30));
		Scene mainScene = new Scene(mainVbox, 800, 800);
		
		mainStage.setTitle("Main");
		mainStage.setScene(mainScene);
		mainStage.show();	

	}
	
	public void lecturersView(ArrayList<RegularLecturer> modelRegularLecturers, ArrayList<GuestLecturer> modelGuestLecturers, int stronger, RegularLecturer regularChairperson, GuestLecturer guestChairperson) {
		Label headerRegularLecturers = new Label(String.format("%-15s : %-10s, %-3s, %-10s, %-10s, %-7s, %-7s, %-3s, %-10s",
				"type", "name", "id", "highest degree", "speciality", "salary", "salary per month", "seniority", "committees"));
		Label headerGuestLecturers = new Label(String.format("%-15s : %-10s, %-3s, %-10s, %-10s, %-7s, %-7s, %-3s",
				"type", "name", "id", "highest degree", "speciality", "salary", "hourly rate", "hours per month"));
		
		VBox regularLecturersShow = new VBox(30, headerRegularLecturers);
		regularLecturersShow.setPadding(new Insets(30));
		for (Lecturer lecturer : modelRegularLecturers) {
			Label regularLecturer = new Label();
			if (lecturer == regularChairperson)
				regularLecturer.setText(lecturer.toString() + " (this is the chairperson)"); 
			else	
				regularLecturer.setText(lecturer.toString());
			regularLecturersShow.getChildren().add(regularLecturer);
			
		}
		

		VBox guestLecturersShow = new VBox(30, headerGuestLecturers);
		guestLecturersShow.setPadding(new Insets(30));
		for (Lecturer lecturer : modelGuestLecturers) {
			Label guestLecturer = new Label();
			if (lecturer == guestChairperson)
				guestLecturer.setText(lecturer.toString() + " (this is the chairperson)"); 
			else	
				guestLecturer.setText(lecturer.toString());
			guestLecturersShow.getChildren().add(guestLecturer);
			
		}
		
		HBox allLecturers = new HBox(30, regularLecturersShow, guestLecturersShow);
		allLecturers.setPadding(new Insets(30));
		
		Label strong = new Label();
		if (stronger == 1)
			strong.setText("regular union is stronger then guest union");
		else if (stronger == -1)
			strong.setText("guest union is stronger then regular union");
		else
			strong.setText("guest union and regular union are equals");
		
		VBox allView = new VBox(30, allLecturers, strong);
		allView.setPadding(new Insets(30));

		Scene showScene = new Scene(allView, 1400, 800);
		Stage showStage = new Stage();
		showStage.setTitle("college lecturers");
		showStage.setScene(showScene);
		showStage.show();
		
	}
	
	public void setColleges(ArrayList<String> colleges) {
		collegeCombo.getItems().clear();
		for (String college : colleges)
			collegeCombo.getItems().add(college);
	}
	
	public String getCollegeName() {
		String name = getText(collegeName);
		collegeName.setText("");
		return name;
	}
	
	public String getSubmitCollegeName() {
		return collegeCombo.getValue();
	}
	
	public String getCollege() {
		try {
			if (collegeCombo.getValue() == null)
				throw new Exception();
			return collegeCombo.getValue();
		}
		catch (Exception ex) {
			Platform.runLater(() -> {
				Alert dialog = new Alert(AlertType.ERROR, "you must choose college", ButtonType.OK);
				dialog.show();
			});	
			return null;
		}
	}
	
	public void setCommittees(ArrayList<String> committeesNames) {
		committeesCheckBoxs.clear();
		for (String committeeName : committeesNames)
			this.committeesCheckBoxs.add(new CheckBox(committeeName));
	}
	
	public String getCommittees() {
		String committees = "";
		
		try {
			for (int i = 0; i < committeesCheckBoxs.size(); i++ )
				if (committeesCheckBoxs.get(i).isSelected())
					committees += committeesCheckBoxs.get(i).getText() + ", ";
			if (committees == "") 
				throw new Exception();
			return committees;
		}
		catch (Exception e) {
			Platform.runLater(() -> {
				Alert dialog = new Alert(AlertType.ERROR, "you must choose at least one committee", ButtonType.OK);
				dialog.show();
			});
			return committees;
		}
	}
	
	public void setLecturersComboBox(ArrayList<Lecturer> lecturers) {
		lecturersComboBox.getItems().clear();
		for (Lecturer lecturer : lecturers) {
			lecturersComboBox.getItems().add(lecturer.getFullName());
		}
	}
	
	public void setChairpesronComboBox(ArrayList<Lecturer> lecturers) {
		chairpersonComboBox.getItems().clear();
		for (Lecturer lecturer : lecturers) {
			chairpersonComboBox.getItems().add(lecturer.getFullName());
		}
	}
	
	public String getLecturerType() {
		if (regularLecturerTypeRadio.isSelected())
			return "r";
		if (guestLecturerTypeRadio.isSelected())
			return "g";
		Platform.runLater(() -> {
			Alert dialog = new Alert(AlertType.ERROR, "must choose lecturer type", ButtonType.OK);
			dialog.show();
		});
		return "";
	}
	
	public String getText(TextField someText) {
		String name;
		try {
			name = someText.getText();
			if (name.matches("[a-zA-Z]+"))
				return name;
			else 
				throw new Exception();
		}
		catch (Exception e) {
			Platform.runLater(() -> {
				Alert dialog = new Alert(AlertType.ERROR, someText.getPromptText().replace("enter ", "") + " must be chars only", ButtonType.OK);
				dialog.show();
			});
			someText.setText("");
			return "";
		}
	}
	
	public double getNumber(TextField someText) {
		double number = -1;
	
		try {
			number = Double.parseDouble(someText.getText());
			if(number < 0) 
				throw new Exception();
		}
		catch (NumberFormatException e) {
			someText.setText("");
			Alert dialog = new Alert(AlertType.ERROR, someText.getPromptText().replace("enter ", "") + " only number!", ButtonType.OK);
			dialog.show();
		}
		catch (Exception e) {
			Platform.runLater(() -> {
				someText.setText("");
				Alert dialog = new Alert(AlertType.ERROR, someText.getPromptText().replace("enter ", "") + " cant be negative", ButtonType.OK);
				dialog.show();
			});
		}
		return number;
	} 
	
	public Lecturer buildLecturer() {
		String name = getText(nameField);
		double id = getNumber(idField);
		String highestDegree = degreeCombo.getValue();
		String speciality = getText(specialityField);
		String lecturerType = getLecturerType();
		if(name == "" || id == -1 || highestDegree == "" || speciality == "" || lecturerType == "")
			return null;
		
		if (lecturerType == "r") {
			double salaryPerMonth = getNumber(salaryField);
			double seniority = getNumber(seniorityField);
			double salary = regularLecturerSalaryCalculation(salaryPerMonth, seniority);
			String committees = getCommittees();
			if (salaryPerMonth == -1 || seniority == -1 || committees == "")
				return null;
			RegularLecturer newLecturer = new RegularLecturer(name, id, highestDegree, speciality, salary, salaryPerMonth, seniority, committees);
			clearAddLecturer(lecturerType);
			return newLecturer;
		}
		
		if (lecturerType == "g") {
			double hourlyRate = getNumber(hourlyRateField);
			double hoursPerMonth = getNumber(hoursPerMonths);
			double salary = guestLecturerSalaryCalculation(hourlyRate, hoursPerMonth);
			if (hoursPerMonth > 14) {
				Alert dialog = new Alert(AlertType.ERROR, "guest lecturer cant work more then 14 hours in one month", ButtonType.OK);
				dialog.show();
				return null;
			}
			if (hourlyRate == -1 || hoursPerMonth == -1)
				return null;
			GuestLecturer newLecturer =  new GuestLecturer(name, id, highestDegree, speciality, salary, hourlyRate, hoursPerMonth);
			clearAddLecturer(lecturerType);
			return newLecturer;
		}
		return null;
	}
	
	public double regularLecturerSalaryCalculation(double salaryPerMonth, double seniority) {
		double finalSalary = 0;
		finalSalary = ((seniority / 200 + 1) * (salaryPerMonth));
		return finalSalary;
	}
	
	
	public double guestLecturerSalaryCalculation(double hourlyRate , double hoursPerMonths) {
		double finalSalary = 0;
		finalSalary = hourlyRate * hoursPerMonths;
		return finalSalary;
	}  
	
	
	public void clearAddLecturer(String lecturerType) {
		nameField.setText("");
		idField.setText("");
		degreeCombo.setValue("");
		specialityField.setText("");
		if (lecturerType == "r") {
			salaryField.setText("");
			seniorityField.setText("");
			for (CheckBox committeeBox : committeesCheckBoxs)
				committeeBox.setSelected(false);
		}
		else {
			hourlyRateField.setText("");
			hoursPerMonths.setText("");
		}
	}
	
	public String getLecturerValue () {
		return lecturersComboBox.getValue();
	}
	
	public String getChairpersonValue () {
		return chairpersonComboBox.getValue();
	}
	
	public void editField() {
		if (regularLecturerTypeRadio.isSelected()) {
			salaryField.setEditable(true);
			seniorityField.setEditable(true);
			for (CheckBox committeeBox : committeesCheckBoxs)
				committeeBox.setVisible(true);
			hourlyRateField.setEditable(false);
			hourlyRateField.setText("");
			hoursPerMonths.setEditable(false);
			hoursPerMonths.setText("");
		}
		if (guestLecturerTypeRadio.isSelected()) {
			hourlyRateField.setEditable(true);
			hoursPerMonths.setEditable(true);
			salaryField.setEditable(false);
			salaryField.setText("");
			seniorityField.setEditable(false);
			seniorityField.setText("");
			for (CheckBox committeeBox : committeesCheckBoxs)
				committeeBox.setVisible(false);
		}
	}
	
	public void sendMessage() {
		Platform.runLater(() -> {
			Alert dialog = new Alert(AlertType.INFORMATION, messageContent.getText() + "\r\nwas sent successfully!", ButtonType.OK);
			dialog.show();
		});
	}
	
	public void sendPresent() {
		Platform.runLater(() -> {
			Alert dialog = new Alert(AlertType.INFORMATION,"Salary was raised successfully!", ButtonType.OK);
			dialog.show();
		});
	}
	

}
