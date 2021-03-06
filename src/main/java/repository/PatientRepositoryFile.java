package repository;

import exceptions.RepositoryException;
import model.Patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class PatientRepositoryFile extends AbstractRepository<Patient, Integer>{

    private String filename;
    public PatientRepositoryFile(String filename){
        this.filename= "PatientFile.txt";
        readFromFile();
    }

    public void readFromFile() {
        try(BufferedReader reader=new BufferedReader(new FileReader(filename))){
            String line;
            while((line=reader.readLine())!=null){
                String[] el=line.split(";");
                if(el.length!=4){
                    System.err.println("Not a valid number of atributes "+line);
                    continue;
                }
                try{
                    int id=Integer.parseInt(el[0]);
                    int age=Integer.parseInt(el[2]);
                    Patient c =new Patient(id,el[1],age,el[3]);
                    super.add(c);
                }
                catch(NumberFormatException n){
                    System.err.println("The ID is not a valid number "+el[0]);
                }
            }
        }
        catch(IOException ex){
            throw new RepositoryException("Error reading"+ex);
        }
    }

    public void writeToFile() {
        try(PrintWriter pw = new PrintWriter(filename)) {
            for(Patient el : findAll()) {
                String line = el.getID() + ";" + el.getName() + ";" + el.getAge() +
                        ";" + el.getPhoneNumber() ;
                pw.println(line);
            }
        }
        catch(IOException ex) {
            throw new RepositoryException("Error writing" + ex);
        }
    }

    @Override
    public void add(Patient obj) {
        try{
            super.add(obj);
            writeToFile();
        }
        catch(RuntimeException e){
            throw new RepositoryException("Object wasn�t added" + e + " " + obj);
        }
    }

    @Override
    public void delete(Patient obj) {
        try{
            super.delete(obj);
            writeToFile();
        }
        catch(RuntimeException ex){
            throw new RepositoryException("Object was not deleted"+ex+" "+obj);
        }
    }

    @Override
    public void update(Patient obj, Integer id) {
        try{
            super.delete(obj);
            writeToFile();
        }
        catch(RuntimeException ex){
            throw new RepositoryException("Object was not deleted"+ex+" "+obj);
        }
    }



}

