package com.example.dentist_clinic;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Appointment;
import model.Patient;
import repository.AppointmentRepositoryFile;
import repository.PatientRepositoryFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("MainViewSem6.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(HelloApplication.class.getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

                @SuppressWarnings("unchecked")
                @Override
                public void handle(WindowEvent we) {



                    //PatientController patientController = new PatientController("PatientFile.txt");
                    //AppointmentController cont = new AppointmentController("AppointmentFile.txt", patientController);
                    try {
                        Properties properties = new Properties();
                        properties.load(new FileInputStream("DentistClinic.properties"));
                        String patientFileName=properties.getProperty("patientFileName");
                        System.out.println(patientFileName);
                        if (patientFileName==null){
                            patientFileName="PatientFile.txt";         //patient instead of request
                            System.err.println("Patient file not found. Using default" + patientFileName);
                        }
                        String appointmentFileName=properties.getProperty("appointmentFileName");
                        System.out.println(appointmentFileName);
                        if (appointmentFileName==null){
                            appointmentFileName="AppointmentFile.txt";
                            System.err.println("Appointment file not found. Using default"+appointmentFileName);
                        }
                        PatientRepositoryFile patient_file_repo = new PatientRepositoryFile(patientFileName);
                        AppointmentRepositoryFile appointment_file_repo = new AppointmentRepositoryFile(appointmentFileName, patient_file_repo);
                        System.out.print(appointment_file_repo.findAll());
                        FXController controller = loader.getController();

                        for (Patient p :controller.appointmentController.patientController.FindAll())
                        {
                            patient_file_repo.add(p);
                        }
                        for (Appointment a :controller.appointmentController.FindAll())
                        {
                            appointment_file_repo.add(a);
                        }

                        controller.saveToFile(appointment_file_repo);
                    }
                    catch (IOException ex){
                        System.err.println("Error reading the configuration file"+ex);
                    }

                }

            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

