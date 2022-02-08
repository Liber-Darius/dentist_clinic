package repository;

import exceptions.RepositoryException;
import model.Appointment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AppointmentRepositoryFile extends AbstractRepository <Appointment, Integer>{

    public String filename;
    public PatientRepositoryFile patientRepo;

    public AppointmentRepositoryFile(String filename, PatientRepositoryFile patientRepo) {
        this.filename = "AppointmentFile.txt";
        this.patientRepo = patientRepo;
        readFromFile();
    }

    //public Appointment(int appointmentId, int patientId, String problem, int emergencyLevel)

    private void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] el = line.split(";");
                if (el.length != 4) {System.err.println("Not a valid number of atributes" + line);
                    continue;
                }
                try {
                    int appointmentID = Integer.parseInt(el[0]);
                    int emergencyLevel = Integer.parseInt(el[3]);
                    Appointment c = new Appointment(appointmentID, patientRepo.findById(Integer.parseInt(el[1])), el[2], emergencyLevel);
                    super.add(c);
                } catch (NumberFormatException n) {
                    System.err.println("The ID is not a valid number" + el[0]);
                }
            }
        } catch (IOException ex) {
            throw new RepositoryException("Error reading" + ex);
        }
    }

    @Override
    public void add(Appointment obj) {
        try {
            super.add(obj);
            writeToFile();
        } catch (RuntimeException e) {
            throw new RepositoryException("Object wasn�t added" + e + " "+obj);
        }
    }

    public void writeToFile() {
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (Appointment el : findAll()) {
                String line = el.getID() + ";"+el.getPatient().getID()+";"+el.getProblem() + ";"+el.getEmergencyLevel();

                pw.println(line);
            }
        } catch (IOException ex) {
            throw new RepositoryException("Error writing" + ex);
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
