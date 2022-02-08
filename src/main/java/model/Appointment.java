package model;

import java.io.Serializable;

public class Appointment implements Identifiable<Integer>, Serializable {
    int appointmentId;
    public Patient patient;
    public String problem;
    int emergencyLevel;


    public Appointment(){

    }
    public Appointment(int appointmentId, Patient patient, String problem, int emergencyLevel){
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.problem = problem;
        this.emergencyLevel = emergencyLevel;
        if(emergencyLevel > 10 || emergencyLevel <0)throw new RuntimeException("the emergency level should be between 0 and 10");
    }

    public int getAppointmentId() {
        return appointmentId;
    }
    
    public int getPatientID() {
    	return patient.getId();
    }
    
    public int getPatientAge() {
    	return this.patient.getAge();
    }
    
    public String getPatientPhoneNumber() {
    	return this.patient.getPhoneNumber();
    }
    
    public String getPatientName() {
    	return patient.getName();
    }
    

    public int getEmergencyLevel(){return emergencyLevel;}

    public Patient getPatient() {
        return patient;
    }

    public String getProblem() {
        return problem;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public void setEmergencyLevel(int emergencyLevel){this.emergencyLevel = emergencyLevel;}

    @Override
    public String toString() {
        return
                "appointmentId='" + appointmentId + '\'' +
                ", patientId='" + patient.getId() + '\'' +
                ", problem='" + problem + '\'' +
                ", emergencyLevel='" + emergencyLevel + '\n';
    }

    @Override
    public Integer getID() {
        return this.appointmentId;
    }

    @Override
    public void setID(Integer id) {
    appointmentId = id;
    }
}
