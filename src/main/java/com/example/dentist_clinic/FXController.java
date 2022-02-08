package com.example.dentist_clinic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import model.Appointment;
import model.Patient;
import repository.AppointmentRepository;
import repository.AppointmentRepositoryFile;
import service.AppointmentController;

public class FXController {
	
	public AppointmentController appointmentController;
	ObservableList<Patient> patientList;
	ObservableList<Appointment> appointmentList; 
	
	public FXController() {
		this.appointmentController = new AppointmentController();
		this.patientList = FXCollections.observableArrayList();
		this.appointmentList = FXCollections.observableArrayList();
	}
	
	public FXController(AppointmentController appo) {
		this.appointmentController = appo;
		this.patientList = FXCollections.observableArrayList();
		this.appointmentList = FXCollections.observableArrayList();
	}
	
	public FXController(AppointmentRepositoryFile a) {
		this.appointmentController = new AppointmentController();
		this.patientList = FXCollections.observableArrayList();
		this.appointmentList = FXCollections.observableArrayList();
		for (Patient p : a.patientRepo.findAll())
		{
			this.appointmentController.patientController.patientRepository.add(p);
			this.patientList.add(p);
		}
		for (Appointment b :a.findAll())
		{
			this.appointmentController.addObj(b);
			this.appointmentList.add(b);
		}
		
	}
	
    
	
    @FXML
    private TextField ageForUpdate_tf;
	
    @FXML
    private TextField emergencyLevelForUpdate_tf;
	
    @FXML
    private Button updateAppointmentButton;

    @FXML
    private Button updatePatientButton;
	
    @FXML
    private Button searchAppointmentButton;

    @FXML
    private Button searchPatientButton;
	
    @FXML
    private TextField problemForUpdate_tf;
	
    @FXML
    private TextField phoneNumberForUpdate_tf;
	
    @FXML
    private TextField patientIDForUpdate_tf;
	
    @FXML
    private TextField nameForUpdate_tf;
	
	@FXML
    private Button clearFieldsForUpdateAppointmentButton;

    @FXML
    private Button clearFieldsForUpdatePatient;

    @FXML
    private Button deleteAppointmentButton;

    @FXML
    private Button deletePatientButton;

    @FXML
    private TextField idForCrudAppointment_tf;

    @FXML
    private TextField idForCrudPatient_tf;
    
    @FXML
    private Button patientsByNameButton;

    @FXML
    private TextField patientsByName_tf;

    @FXML
    private Button emergencyLevelGreaterThanButton;
	
    @FXML
    private Button addAppointment;

    @FXML
    private Button addPatient;

    @FXML
    private TableColumn<Patient, Integer> ageCol;
    
    @FXML
    private TableColumn<Patient, Integer> ageCol1;

    @FXML
    private TextField age_tf;

    @FXML
    private TableColumn<Appointment, Integer> appointmentIDCol;

    @FXML
    private TableColumn<Appointment, Integer> appointmentIDCol1;
    
    @FXML
    private TableView<Appointment> appointmentTable;
    
    @FXML
    private TableView<Appointment> appointmentTable1;

    @FXML
    private TextField appointment_id_tf;

    @FXML
    private Button clearFieldsBtn;

    @FXML
    private Button clearFieldsBtn1;

    @FXML
    private TableColumn<Appointment, Integer> emergencyLevelCol;
    
    @FXML
    private TableColumn<Appointment, Integer> emergencyLevelCol1;

    @FXML
    private TextField emergency_tf;

    @FXML
    private TableColumn<Patient, String> nameCol;
    
    @FXML
    private TableColumn<Patient, String> nameCol1;

    @FXML
    private TextField name_tf;

    @FXML
    private TableColumn<Patient, Integer> patientIDCol;
    
    @FXML
    private TableColumn<Patient, Integer> patientIDCol1;

    @FXML
    private TableColumn<Appointment, Integer> patientIDForAppointmentCol;
    
    @FXML
    private TableColumn<Appointment, Integer> patientIDForAppointmentCol1;
    @FXML
    private TableView<Patient> patientTable;
    
    @FXML
    private TableView<Patient> patientTable1;

    @FXML
    private TextField patient_id_for_appointment_tf;

    @FXML
    private TextField patient_id_tf;

    @FXML
    private TableColumn<Patient, String> phoneNumberCol;
    
    @FXML
    private TableColumn<Patient, String> phoneNumberCol1;

    @FXML
    private TextField phone_number_tf;

    @FXML
    private TableColumn<Appointment, String> problemCol;
    
    @FXML
    private TableColumn<Appointment, String> problemCol1;

    @FXML
    private TextField problem_tf;

    @FXML
    private Button showAppointmentsButton;

    @FXML
    private Button showPatientsButton;
    
    //for the reports
    
    @FXML
    private TableColumn<Patient, Integer> ageCol_R;
    
    @FXML
    private TableColumn<Appointment, Integer> appointmentIDCol_R;
    
    @FXML
    private TableColumn<Appointment, Integer> emergencyLevelCol_R;
    
    @FXML
    private TableColumn<Patient, Integer> patientIDCol_R;
    
    @FXML
    private TableColumn<Patient, String> patientNameCol_R;
    
    @FXML
    private TableColumn<Patient, String> phoneNumberCol_R;
    
    @FXML
    private TableColumn<Appointment, String> problemCol_R;
    
    @FXML
    private TableView<Appointment> reportTable;

    @FXML
    private Button showOlderThanAndSufferingFrom;

    @FXML
    private Button showPatientsWhoSufferFromButton;

    @FXML
    private TextField showPatientsWhoSufferFrom_tf;

    @FXML
    private Button showPatientsWithEmergencyLevelGreaterThan;

    @FXML
    private TextField showPatientsWithEmergencyLevelGreaterThan_tf;
    
    @FXML
    private TextField getAge_tf;

    @FXML
    private TextField getDisease_tf;
    

    public void initialize() {
    	
		patientIDCol.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("id")); 
		nameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("name")); 
		ageCol.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
		phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Patient,String>("phoneNumber"));
		
		appointmentIDCol.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("appointmentId")); 
		patientIDForAppointmentCol.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("patientID")); 
		problemCol.setCellValueFactory(new PropertyValueFactory<Appointment, String>("problem"));
		emergencyLevelCol.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("emergencyLevel"));
		
		//set default values for table reports
		
		/*patientNameCol_R.setCellValueFactory(new PropertyValueFactory<Patient, String>("PatientName")); 
		ageCol_R.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("PatientAge"));
		phoneNumberCol_R.setCellValueFactory(new PropertyValueFactory<Patient,String>("PatientphoneNumber"));
		
		appointmentIDCol_R.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("appointmentId")); 
		patientIDCol_R.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("PatientID")); 
		problemCol.setCellValueFactory(new PropertyValueFactory<Appointment, String>("problem"));
		emergencyLevelCol.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("emergencyLevel"));
			
	*/
		patientIDCol1.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("id")); 
		nameCol1.setCellValueFactory(new PropertyValueFactory<Patient, String>("name")); 
		ageCol1.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
		phoneNumberCol1.setCellValueFactory(new PropertyValueFactory<Patient,String>("phoneNumber"));
		
		appointmentIDCol1.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("appointmentId")); 
		patientIDForAppointmentCol1.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("PatientID")); 
		problemCol1.setCellValueFactory(new PropertyValueFactory<Appointment, String>("problem"));
		emergencyLevelCol1.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("emergencyLevel"));
		
		
		for(Patient elem: this.appointmentController.patientController.patientRepository.findAll()){
			this.patientList.add(elem);
		}
		
		for(Appointment elem: this.appointmentController.FindAll())this.appointmentList.add(elem);
		
		System.out.println(patientTable);
		System.out.println(patientList);
		
		patientTable.setItems(patientList);
		appointmentTable.setItems(appointmentList);
		
		
    
    }
    
    
    @FXML
    void addAppointment(ActionEvent event) {
    	
    	String appointmentID = appointment_id_tf.getText();
    	if(appointmentID.equals("")) {
    		appointment_id_tf.setStyle("-fx-border-color: red;");
    		return;
    	}
    	else appointment_id_tf.setStyle("-fx-border-color: none");
    	
    	String patientIDForAppointment = patient_id_for_appointment_tf.getText();
    	if(patientIDForAppointment.equals("")) {
    		patient_id_for_appointment_tf.setStyle("-fx-border-color: red;");
    		return;
    	}
    	else patient_id_for_appointment_tf.setStyle("-fx-border-color: none");
    	
    	String problem = problem_tf.getText();
    	if(problem.equals("")) {
    		problem_tf.setStyle("-fx-border-color: red;");
    		return;
    	}
    	else problem_tf.setStyle("-fx-border-color: none");
    	
    	String emergencyLevel = emergency_tf.getText();
    	if(emergencyLevel.equals("")) {
    		emergency_tf.setStyle("-fx-border-color: red;");
    		return;
    	}
    	else emergency_tf.setStyle("-fx-border-color: none");
    	
    	try {
    		Patient our_patient = this.appointmentController.patientController.searchObj(Integer.parseInt(patientIDForAppointment));
    		Appointment our_new_appointment = new Appointment(Integer.parseInt(appointmentID), our_patient, problem, Integer.parseInt(emergencyLevel));
    		
        	this.appointmentController.addObj(our_new_appointment);
        	this.appointmentList.add(our_new_appointment);
    	    } 
    	catch (Throwable e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	toString();
        	alert.setTitle("An error occured");
        	alert.setHeaderText("we have the following error:");
        	alert.setContentText(e.toString());
        	alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        	alert.show();
    	    System.out.println(e);
    	    }
    	
    }

    @FXML
    void addPatientFunction(ActionEvent event) {
    	
    	String patientID = patient_id_tf.getText();
    	if(patientID.equals("")) {
    		patient_id_tf.setStyle("-fx-border-color: red;");
    		return;
    	}
    	else patient_id_tf.setStyle("-fx-border-color: none");
    	
    	String name = name_tf.getText();
    	if(name.equals("")) {
    		name_tf.setStyle("-fx-border-color: red;");
    		return;
    	}
    	else name_tf.setStyle("-fx-border-color: none");
    	
    	String age = age_tf.getText();
    	if(age.equals("")) {
    		age_tf.setStyle("-fx-border-color: red;");
    		return;
    	}
    	else age_tf.setStyle("-fx-border-color: none");
    	
    	String phoneNumber = phone_number_tf.getText();
    	if(phoneNumber.equals("")) {
    		phone_number_tf.setStyle("-fx-border-color: red;");
    		return;
    	}
    	else phone_number_tf.setStyle("-fx-border-color: none");
    	 	
    	try {
    		Patient our_new_patient = new Patient(Integer.parseInt(patientID), name, Integer.parseInt(age), phoneNumber);
    		this.appointmentController.patientController.addObj(our_new_patient);
    		this.patientList.add(our_new_patient);
    	    } 
    	catch (Throwable e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	toString();
        	alert.setTitle("An error occured");
        	alert.setHeaderText("we have the following error:");
        	alert.setContentText(e.toString());
        	alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        	alert.show();
    	    System.out.println(e);
    	    }
    	

    }
    
    @FXML
    public void clearFieldsForPatient(ActionEvent event) {

    	patient_id_tf.setText("");
    	name_tf.setText("");
    	age_tf.setText("");
    	phone_number_tf.setText("");

    }
    
    @FXML
    void ClearFieldsForAppointment(ActionEvent event) {
    	appointment_id_tf.setText("");
    	patient_id_for_appointment_tf.setText("");
    	problem_tf.setText("");
    	emergency_tf.setText("");
    }


    @FXML
    void showAllAppointments(ActionEvent event) {

    	System.out.print(this.appointmentController.patientController.FindAll());
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	toString();
    	alert.setTitle("Appointments List");
    	alert.setHeaderText("the list of the appointments is:");
    	alert.setContentText(this.appointmentController.FindAll().toString());
    	alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    	alert.show();
    	
    }

    @FXML
    void showAllPatients(ActionEvent event) {

    	this.patientTable.setItems(this.patientList);
    	Alert alert = new Alert(AlertType.INFORMATION);
    	toString();
    	alert.setTitle("Patients List");
    	alert.setHeaderText("The list of the patients is:");
    	alert.setContentText(this.appointmentController.patientController.FindAll().toString());
    	alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

    	alert.show();
    	
    }
    
    public void saveToFile(AppointmentRepositoryFile a) {
    	a.writeToFile();
    }
    
   //functions for the reports
    
    @FXML
    void showOlderThanAndSufferingFromFunction(ActionEvent event) {
    	
    }

    @FXML
    void showPatientsWhoSufferFromFunction(ActionEvent event) {
    	

		ObservableList<Patient> repo_p = FXCollections.observableArrayList();
		ObservableList<Appointment> repo_a = FXCollections.observableArrayList();
    	
    	String disease = showPatientsWhoSufferFrom_tf.getText();
    	// we use the function
    	System.out.println(appointmentController.appointmentRepository);
    	AppointmentRepository sufferFrom = this.appointmentController.appointmentRepository.sufferFrom(disease);
    	System.out.println(sufferFrom);
    	for(Appointment a: sufferFrom.findAll())
    	{
    		repo_p.add(a.getPatient());
    		repo_a.add(a);
    	}
    	System.out.println(disease);
    	System.out.println(repo_a);
    	System.out.println(repo_p);
    	
    	
    	appointmentTable1.setItems((ObservableList<Appointment>) repo_a);
    	patientTable1.setItems(repo_p);
    
    }

    @FXML
    void emergencyLevelGreaterThanFuction(ActionEvent event) {

		ObservableList<Patient> repo_p = FXCollections.observableArrayList();
		ObservableList<Appointment> repo_a = FXCollections.observableArrayList();
    	
    	int emergencyLevel = Integer.parseInt(showPatientsWithEmergencyLevelGreaterThan_tf.getText());

    	AppointmentRepository emergencyGreaterThan = this.appointmentController.appointmentRepository.emergencyLevelGreaterThan(emergencyLevel);
    	System.out.println(emergencyGreaterThan);
    	for(Appointment a: emergencyGreaterThan.findAll())
    	{
    		repo_p.add(a.getPatient());
    		repo_a.add(a);
    	}
    	System.out.println(emergencyLevel);
    	System.out.println(repo_a);
    	System.out.println(repo_p);
    	
    	
    	appointmentTable1.setItems((ObservableList<Appointment>) repo_a);
    	patientTable1.setItems(repo_p);
        
    }
    
    @FXML
    void patientsByNameFunction(ActionEvent event) {
    	
    	ObservableList<Patient> repo_p = FXCollections.observableArrayList();
		ObservableList<Appointment> repo_a = FXCollections.observableArrayList();
    	
    	String name  = patientsByName_tf.getText();
    	AppointmentRepository byName = this.appointmentController.appointmentRepository.appointmentByName(name);
    	System.out.println(byName);
    	for(Appointment a: byName.findAll())
    	{
    		repo_p.add(a.getPatient());
    		repo_a.add(a);
    	}
    	System.out.println(name);
    	System.out.println(repo_a);
    	System.out.println(repo_p);
    
    	appointmentTable1.setItems((ObservableList<Appointment>) repo_a);
    	patientTable1.setItems(repo_p);
    	

    }
    
    @FXML
    void updateAppointmentFunction(ActionEvent event) {
    	
    	Appointment a = new Appointment();
    	try {
    		int id = Integer.parseInt(idForCrudAppointment_tf.getText());
    		System.out.println(this.appointmentController.appointmentRepository.findById(id));
    		a = this.appointmentController.appointmentRepository.findById(id);
    	    } 
    	catch (Throwable e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	toString();
        	alert.setTitle("An error occured");
        	alert.setHeaderText("we have the following error:");
        	alert.setContentText(e.toString());
        	alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        	alert.show();
    	    System.out.println(e);
    	    }
    	
    	int new_patientID;
    	String patientIDUpdate = patientIDForUpdate_tf.getText();
    	if(patientIDUpdate .equals("")) {
    		new_patientID =  a.getPatientID();
    	}
    	else new_patientID =  Integer.parseInt(patientIDUpdate);
    	
    	String new_problem;
    	String problemUpdate = problemForUpdate_tf.getText();
    	if(problemUpdate.equals("")) {
    		new_problem = a.getProblem();
    	}
    	else new_problem = problemUpdate ;
    	
    	int new_emergencyLevel;
    	String emergencyLevelUpdate = emergencyLevelForUpdate_tf.getText();
    	if(emergencyLevelUpdate.equals("")) {
    		new_emergencyLevel =  a.getEmergencyLevel();
    	}
    	else new_emergencyLevel = Integer.parseInt(emergencyLevelUpdate);
    	 	
    	try {
    		Appointment new_a = new Appointment(a.getID(), this.appointmentController.patientController.patientRepository.findById(new_patientID), new_problem, new_emergencyLevel);
    		this.appointmentController.deleteObj(a);
    		this.appointmentList.remove(a);
    		this.appointmentController.addObj(new_a);
    		this.appointmentList.add(new_a);
    		
    	    } 
    	catch (Throwable e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	toString();
        	alert.setTitle("An error occured");
        	alert.setHeaderText("we have the following error:");
        	alert.setContentText(e.toString());
        	alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        	alert.show();
    	    System.out.println(e);
    	    }
    	

    }

    @FXML
    void updatePatientFunction(ActionEvent event) {
    	
    	Patient p = new Patient();
    	try {
    		int id = Integer.parseInt(idForCrudPatient_tf.getText());
    		System.out.println(this.appointmentController.patientController.patientRepository.findById(id));
    		p  = this.appointmentController.patientController.patientRepository.findById(id);
    	    } 
    	catch (Throwable e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	toString();
        	alert.setTitle("An error occured");
        	alert.setHeaderText("we have the following error:");
        	alert.setContentText(e.toString());
        	alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        	alert.show();
    	    System.out.println(e);
    	    }
    	
    	String new_name;
    	String nameUpdate = nameForUpdate_tf.getText();
    	if(nameUpdate.equals("")) {
    		new_name =  p.getName();
    	}
    	else new_name = nameUpdate;
    	
    	int new_age;
    	String age = ageForUpdate_tf.getText();
    	if(age.equals("")) {
    		new_age = p.getAge();
    	}
    	else new_age = Integer.parseInt(age);
    	
    	String new_phoneNumber;
    	String phoneNumberUpdate = phoneNumberForUpdate_tf.getText();
    	if(phoneNumberUpdate.equals("")) {
    		new_phoneNumber =  p.getPhoneNumber();
    	}
    	else new_phoneNumber = phoneNumberUpdate;
    	 	
    	try {
    		Patient new_p = new Patient(p.getId(), new_name, new_age, new_phoneNumber);
    		this.appointmentController.patientController.deleteObj(p);
    		this.patientList.remove(p);
    		this.appointmentController.patientController.addObj(new_p);
    		this.patientList.add(new_p);
    		
    	    } 
    	catch (Throwable e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	toString();
        	alert.setTitle("An error occured");
        	alert.setHeaderText("we have the following error:");
        	alert.setContentText(e.toString());
        	alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        	alert.show();
    	    System.out.println(e);
    	    }
    
    }
    
    @FXML
    void searchAppointmentFunction(ActionEvent event) {
    	
    	try {
    		int id = Integer.parseInt(idForCrudPatient_tf.getText());
    		System.out.println(this.appointmentController.appointmentRepository.findById(id));
    		Appointment new_a = this.appointmentController.appointmentRepository.findById(id);
    		
    		Alert show = new Alert(AlertType.INFORMATION);
        	toString();
        	show.setTitle("An error occured");
        	show.setHeaderText("the appointment you are looking for is:");
        	show.setContentText(new_a.toString());
        	show.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        	show.show();
    	    System.out.println(new_a);
    		
    	    } 
    	catch (Throwable e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	toString();
        	alert.setTitle("An error occured");
        	alert.setHeaderText("we have the following error:");
        	alert.setContentText(e.toString());
        	alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        	alert.show();
    	    System.out.println(e);
    	    }
    }

    @FXML
    void searchPatientFunction(ActionEvent event) {
    	
    	try {
    		int id = Integer.parseInt(idForCrudPatient_tf.getText());
    		System.out.println(this.appointmentController.patientController.patientRepository.findById(id));
    		Patient new_p = this.appointmentController.patientController.patientRepository.findById(id);
    		
    		Alert show = new Alert(AlertType.INFORMATION);
        	toString();
        	show.setTitle("An error occured");
        	show.setHeaderText("the patient you are looking for is:");
        	show.setContentText(new_p.toString());
        	show.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        	show.show();
    	    System.out.println(new_p);
    		
    	    } 
    	catch (Throwable e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	toString();
        	alert.setTitle("An error occured");
        	alert.setHeaderText("we have the following error:");
        	alert.setContentText(e.toString());
        	alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        	alert.show();
    	    System.out.println(e);
    	    }

    }
    
    @FXML
    void deleteAppointmentFunction(ActionEvent event) {
    	
    	
    	try {
    		int id = Integer.parseInt(idForCrudAppointment_tf.getText());
    		System.out.println(this.appointmentController.appointmentRepository.findById(id));
    		Appointment new_a = this.appointmentController.appointmentRepository.findById(id);
        	this.appointmentController.deleteObj(new_a);
        	this.appointmentList.remove(new_a);
        	appointmentTable.setItems(appointmentList);
    	    } 
    	catch (Throwable e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	toString();
        	alert.setTitle("An error occured");
        	alert.setHeaderText("we have the following error:");
        	alert.setContentText(e.toString());
        	alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        	alert.show();
    	    System.out.println(e);
    	    }
    	
    }


    @FXML
    void deletePatientFunction(ActionEvent event) {
    	
     	try {
    		int id = Integer.parseInt(idForCrudPatient_tf.getText());
    		System.out.println(this.appointmentController.patientController.patientRepository.findById(id));
    		Patient new_p = this.appointmentController.patientController.patientRepository.findById(id);
        	this.appointmentController.patientController.deleteObj(new_p);
        	this.patientList.remove(new_p);
        	patientTable.setItems(patientList);
    	    } 
    	catch (Throwable e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
        	toString();
        	alert.setTitle("An error occured");
        	alert.setHeaderText("we have the following error:");
        	alert.setContentText(e.toString());
        	alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        	alert.show();
    	    System.out.println(e);
    	    }
     	
    }
    
    @FXML
    void ClearFieldsForAppointmentUpdate(ActionEvent event) {
    	idForCrudAppointment_tf.setText("");
    	patientIDForUpdate_tf.setText("");
    	problemForUpdate_tf.setText("");
    	emergencyLevelForUpdate_tf.setText("");
    }

    @FXML
    void ClearFieldsForPatientUpdate(ActionEvent event) {
    	idForCrudPatient_tf.setText("");
    	nameForUpdate_tf.setText("");
    	ageForUpdate_tf.setText("");
    	phoneNumberForUpdate_tf.setText("");
    }
    

}


