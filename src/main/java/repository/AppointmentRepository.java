package repository;

import model.Appointment;

public class AppointmentRepository extends AbstractRepository<Appointment, Integer>{

    public AppointmentRepository(){};

    public AppointmentRepository emergencyLevelGreaterThan(int emergencyLevel){
        AppointmentRepository satisfy = new AppointmentRepository();
        for(Appointment a: this.findAll()){
            if(a.getEmergencyLevel() > emergencyLevel)satisfy.add(a);
        }
        return satisfy;
    }

    public AppointmentRepository emergencyLevelLowerThan(int emergencyLevel){
        AppointmentRepository satisfy = new AppointmentRepository();
        for(Appointment a: this.findAll()){
            if(a.getEmergencyLevel() < emergencyLevel)satisfy.add(a);
        }
        return satisfy;
    }
    public AppointmentRepository sufferFrom(String disease){
        AppointmentRepository satisfy = new AppointmentRepository();
        for(Appointment a: this.findAll()){
            if(a.getProblem().equals(disease))satisfy.add(a);
        }
        return satisfy;
    }
    
    public AppointmentRepository appointmentByName(String name){
        AppointmentRepository satisfy = new AppointmentRepository();
        for(Appointment a: this.findAll()){
            if(a.getPatientName().equals(name))satisfy.add(a);
        }
        return satisfy;
    }

}
