package repository;

import exceptions.RepositoryException;
import model.Patient;

import java.io.*;
import java.util.Map;

public class PatientRepositorySerialization extends AbstractRepository<Patient, Integer>{

    public String filename;

    public PatientRepositorySerialization(String filename) {
        this.filename = filename;
        readFromFile();
    }

    @SuppressWarnings("unchecked")
	private void readFromFile ()
    {
        try(ObjectInputStream in= new ObjectInputStream (new FileInputStream(filename)))
        {
            elem = (Map<Integer, Patient>) in.readObject();
        }
        catch(Exception err)
        {
            throw new RepositoryException("Error reading from file: "+err);
        }
    }

    @Override
    public void add(Patient obj) {
        try {
            super.add(obj);
            writeToFile();
        } catch (RuntimeException e) {
            throw new RepositoryException("Object wasn�t added" + e + " "+obj);
        }
    }

    @Override
    public void delete(Patient obj) {
        try {
            super.delete(obj);
            writeToFile();
        } catch (RuntimeException ex) {
            throw new RepositoryException("Object was not deleted" + ex +" "+obj);
        }
    }

    @Override
    public void update(Patient obj, Integer id) {
        try {
            super.update(obj, id);
            writeToFile();
        } catch (RuntimeException ex) {
            throw new RepositoryException("Object was not updated" + ex + " "+obj);
        }
    }

    public void writeToFile()
    {
        try(ObjectOutputStream e=new ObjectOutputStream(new FileOutputStream(filename))){
            e.writeObject(elem);
        }
        catch(IOException r){
            throw new RepositoryException("message " + r);
        }
    }


}
