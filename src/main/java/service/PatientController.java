package service;

import model.Controller;
import model.Patient;
import repository.PatientRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PatientController implements Controller<Patient, Integer> {

    public PatientRepository patientRepository;
    //PatientRepositoryFile patientFileRepository;

    public PatientController(){
        patientRepository = new PatientRepository();
    };
    
    //public PatientController(String e){
        //patientFileRepository = new PatientRepositoryFile(e);
    //};

    public PatientController(PatientRepository repository){
        this.patientRepository = repository;
    }

    @Override
    public void addObj(Patient elem) {
        this.patientRepository.add(elem);
       // this.patientFileRepository.add(elem); //new
    }

    @Override
    public void deleteObj(Patient elem) {
        this.patientRepository.delete(elem);
   
    }

    @Override
    public void updateObj(Patient elem, Integer id) {
        this.patientRepository.update(elem, id);
    }

    @Override
    public Patient searchObj(Integer id) {
        return this.patientRepository.findById(id);
    }

    @Override
    public Iterable<Patient> FindAll() {
        return this.patientRepository.findAll();
    }
    
    //public void writeToFile() {
    	//this.patientFileRepository.writeToFile();
    //}

    /*the names of all patients that have an appointment in a given day;
    - all the appointments for a certain patient (and their status);
    -the problems of a certain patient- the phone number of a certain patient (given by name);
    -the name of the persons who reserved a certain car-all the cars rented by a certain person-
    the list of birthday cakes that for ordered for a given day-the days when a certain birthday cake has to be delivered
    */

    public String getPhoneNumber(String name) {
        ArrayList<Patient> obj = new ArrayList<Patient>();
        for (Patient a : this.patientRepository.findAll())
            obj.add(a);

        String result1 = obj.stream()
                .filter((p) -> p.getName() == name)
                .map(s -> s.getPhoneNumber())
                .findAny()
                .orElse(null);

        return result1;
    }

    public List<String> getNamesOfThoseOlderThan(int age) {
        ArrayList<Patient> obj = new ArrayList<Patient>() {
        };
        for (Patient a : this.patientRepository.findAll())
            obj.add(a);

        List<String> result1 = obj
                .stream()
                .filter((p) -> p.getAge() > age)
                .map(s -> s.getName())
                .collect(Collectors.toList());

        return result1;
    }

    public List<String> getNamesOfThoseYoungerThan(int age) {
        ArrayList<Patient> obj = new ArrayList<Patient>() {
        };
        for (Patient a : this.patientRepository.findAll())
            obj.add(a);

        List<String> result1 = obj
                .stream()
                .filter((p) -> p.getAge() < age)
                .map(s -> s.getName())
                .collect(Collectors.toList());

        return result1;
    }

    public Optional<Patient> getOldestPatient() {
        ArrayList<Patient> obj = new ArrayList<Patient>() {
        };
        for (Patient a : this.patientRepository.findAll())
            obj.add(a);

        Optional<Patient> result1 = obj.stream()
                .max( Comparator.comparing(Patient::getAge));

        return result1;
    }









}
