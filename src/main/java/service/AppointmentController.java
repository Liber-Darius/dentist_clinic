package service;

import model.Appointment;
import model.Controller;
import repository.AppointmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AppointmentController implements Controller<Appointment, Integer> {

    public AppointmentRepository appointmentRepository;
    //AppointmentRepositoryFile appointmentFileRepository;
    public PatientController patientController;
    
    //public AppointmentController(String nameFileAppointment, PatientController patientController) {
    	//this.patientController = patientController;
    	//this.appointmentFileRepository = new AppointmentRepositoryFile(nameFileAppointment, patientController.patientFileRepository);
    //}
    
 

    public AppointmentController(PatientController patientController, AppointmentRepository repository) {
        this.patientController = patientController;
        this.appointmentRepository = repository;
        for (Appointment a : repository.findAll()) {
            try {
                this.patientController.searchObj(a.getPatient().getId());
            } catch (Exception e){
                this.patientController.addObj(a.getPatient());
            }
        } ;
    }
    public AppointmentController(PatientController patientController){
        this.patientController = patientController;
        this.appointmentRepository = new AppointmentRepository();
    };

    public AppointmentController(){
        this.appointmentRepository = new AppointmentRepository();
        this.patientController = new PatientController();
    }

    @Override
    public void addObj(Appointment elem) {
        this.appointmentRepository.add(elem);
    }

    @Override
    public void deleteObj(Appointment elem) {
        this.appointmentRepository.delete(elem);
    }

    @Override
    public void updateObj(Appointment elem, Integer id) {
        this.appointmentRepository.update(elem, id);
    }

    @Override
    public Appointment searchObj(Integer id) {
        return this.appointmentRepository.findById(id);
    }

    @Override
    public Iterable<Appointment> FindAll() {
        return this.appointmentRepository.findAll();
    }

    public List<Integer> getaAgeOfThoseWithEmergencyLevelGreaterThan(int emergencyLevel) {
        ArrayList<Appointment> obj = new ArrayList<Appointment>() {
        };
        for( Appointment a : this.appointmentRepository.findAll())
            obj.add(a);

        List<Integer> result1 = obj
                .stream()
                .filter((p) -> p.getEmergencyLevel() > emergencyLevel)
                .map(s -> s.getPatient().getAge())
                .collect(Collectors.toList());

        return result1;
    }

    public List<String> getNamesOfThoseSufferingFrom(String disease) {
        ArrayList<Appointment> obj = new ArrayList<Appointment>() {
        };
        for( Appointment a : this.appointmentRepository.findAll())
            obj.add(a);

        List<String> result1 = obj
                .stream()
                .filter((p) -> p.getProblem().equals(disease))
                .map(s -> s.getPatient().getName())
                .collect(Collectors.toList());

        return result1;
    }

    public List<Appointment> getAppointmentsOfaPatientById(int id){

        ArrayList<Appointment> obj = new ArrayList<Appointment>() {
        };
        for( Appointment a : this.appointmentRepository.findAll())
            if(a.getPatient().getId() == id)obj.add(a);

        List<Appointment> result1 = obj
                .stream()
                .collect(Collectors.toList());

        return result1;

    }
    
    public List<Appointment> getAppointmentsByName(String name){

        ArrayList<Appointment> obj = new ArrayList<Appointment>() {
        };
        for( Appointment a : this.appointmentRepository.findAll())
            if(a.getPatient().getName().equals(name))obj.add(a);

        List<Appointment> result1 = obj
                .stream()
                .collect(Collectors.toList());

        return result1;

    }
    
    //public void writeToFile() {
    //	this.appointmentFileRepository.writeToFile();
    //}
    
   
    
    
}
