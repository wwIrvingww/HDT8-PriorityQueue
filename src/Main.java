import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Declaracion de variables
        String path = "C:\\Users\\USUARIO\\OneDrive\\UVG\\Clases\\Tercer Semestre\\Estructura de datos\\Codes\\HDT8-PriorityQueue\\HDT8-PriorityQueue\\Patients.txt";
        ArrayList<String> patients;
        patients = Reader.readFile(path);
        PriorityQueue queue = new PriorityQueue();
        ArrayList<Patient> patientArrayList = Reader.getPatientList(patients);

        System.out.println("LISTA DE PACIENTES ");
        for (Patient patient : patientArrayList) {
            queue.offer(patient);
            System.out.println("En fila: " + patient.getName()+" "+patient.getPriority());
        }

        System.out.println("ORDENADOS");
        while (!queue.isEmpty()) {
            Patient patient = queue.poll();
            System.out.println("Siguiente: " + patient.getName()+" "+patient.getPriority());
        }






    }
}
