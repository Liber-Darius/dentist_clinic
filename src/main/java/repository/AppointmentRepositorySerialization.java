package repository;

import exceptions.RepositoryException;
import model.Appointment;

import java.io.*;
import java.util.Map;


public class AppointmentRepositorySerialization extends AbstractRepository<Appointment, Integer>{

    private String filename;
    public PatientRepositorySerialization patientRepository;

    public AppointmentRepositorySerialization(String filename, PatientRepositorySerialization patientRepository)
    {
        this.filename = filename;
        this.patientRepository = patientRepository;
//        readFromFile();
    }


    public void writeToFile(){
        try(ObjectOutputStream e=new ObjectOutputStream(new FileOutputStream(filename)))
        {
            e.writeObject(elem);
        }
        catch(IOException r){
            throw new RepositoryException("message " + r);
        }
    }


    private void readFromFile ()
    {
        try(ObjectInputStream in= new ObjectInputStream (new FileInputStream(filename)))
        {
            elem = (Map<Integer, Appointment>) in.readObject();
        }
        catch(IOException|ClassNotFoundException err)
        {
            throw new RepositoryException("Error reading from file: "+err);
        }
    }

    @Override
    public void add(Appointment obj) {
        try {
            super.add(obj);
            if(this.patientRepository.elem.containsValue(obj.getPatient()) == false)this.patientRepository.add(obj.getPatient());
            writeToFile();

        } catch (RuntimeException e) {
            throw new RepositoryException("Object wasn't added" + e + " "+obj);
        }
    }

    @Override
    public void delete(Appointment obj) {
        try {
            super.delete(obj);
            writeToFile();
        } catch (RuntimeException ex) {
            throw new RepositoryException("Object was not deleted" + ex +" "+obj);
        }
    }

    @Override
    public void update(Appointment obj, Integer id) {
        try {
            super.update(obj, id);
            writeToFile();
        } catch (RuntimeException ex) {
            throw new RepositoryException("Object was not updated" + ex + " "+obj);
        }
    }


}
