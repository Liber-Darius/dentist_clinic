package model;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Patient implements Identifiable<Integer>, Serializable {
    private String name;
    int id;
    int age;
    String phoneNumber;
    private List<Appointment> applist;

    public Patient(){

    }

    public Patient(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        if(age < 0)throw new RuntimeException("the age must be positive");
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAge(int age) {
        if(age < 0) try {
            throw new RuntimeException("the age must be positive");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                '}' + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getAge() == patient.getAge() && Objects.equals(getId(), patient.getId()) && Objects.equals(getName(), patient.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge());
    }


    @Override
    public Integer getID() {
        return this.id;
    }

    @Override
    public void setID(Integer id) {

    }
}
