/**
 * Clase que simula un paciente
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Patient implements Comparable<Patient> {
    //Variables
    private String name;
    private String description;
    private String priority;

    private ArrayList<Patient> patientList;

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    //Constructor
    public Patient (String name, String description, String priority){
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    @Override
    public int compareTo(Patient otherPatient) {
        String[] priorities = {"A", "B", "C", "D", "E"};
        int thisPriorityIndex = Arrays.asList(priorities).indexOf(this.priority);
        int otherPriorityIndex = Arrays.asList(priorities).indexOf(otherPatient.getPriority());
        return Integer.compare(thisPriorityIndex, otherPriorityIndex);
    }

}
