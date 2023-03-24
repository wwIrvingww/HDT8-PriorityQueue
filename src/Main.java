import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Declaracion de variables
        String path = "C:\\Users\\USUARIO\\OneDrive\\UVG\\Clases\\Tercer Semestre\\Estructura de datos\\Codes\\HDT8-PriorityQueue\\HDT8-PriorityQueue\\Patients.txt";
        ArrayList<String> patients;
        patients = Reader.readFile(path);

        ArrayList<Patient> patientArrayList = Reader.getPatientList(patients);
        for (Patient p: patientArrayList){
            System.out.println(p.getName()+" "+p.getPriority()+" "+p.getDescription());
        }






    }
}
