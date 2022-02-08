package repository;
import model.Patient;

public class PatientRepository extends AbstractRepository<Patient,Integer>{

    public PatientRepository(){};

    public PatientRepository oldestPatient(){
        PatientRepository maxList = new PatientRepository();
        int max = 0;
        for(Patient a: this.findAll()) {
            if(a.getAge() > max)max=a.getAge();
        }
        for(Patient a: this.findAll()) {
            if(a.getAge() == max)maxList.add(a);
        }
        return maxList;
    }

    public PatientRepository youngestPatient(){
        PatientRepository minList = new PatientRepository();
        int min = 200; //the age is for sure less than 200 years :))
        for(Patient a: this.findAll()) {
            if(a.getAge() < min)min=a.getAge();
        }
        for(Patient a: this.findAll()) {
            if(a.getAge() == min)minList.add(a);
        }
        return minList;
    }

}
