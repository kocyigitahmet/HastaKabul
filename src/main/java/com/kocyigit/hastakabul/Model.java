package com.kocyigit.hastakabul;

public class Model {

    private String firstName;
    private String lastName;
    private String patientID;
    private String Department;
    public Model(){

    }

    public Model(String firstName, String lastName, String patientID, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientID = patientID;
        this.Department = department;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
