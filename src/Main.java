import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Instanciar objetos
        Scanner sc = new Scanner(System.in);


        //Declaracion de variables
        String path = "C:\\Users\\USUARIO\\OneDrive\\UVG\\Clases\\Tercer Semestre\\Estructura de datos\\Codes\\HDT8-PriorityQueue\\HDT8-PriorityQueue\\Patients.txt";
        ArrayList<String> patients;
        patients = Reader.readFile(path);
        PriorityQueue queue = new PriorityQueue();
        ArrayList<Patient> patientArrayList = Reader.getPatientList(patients);
        int remove = -1;



        System.out.println("LISTA DE PACIENTES ");
        for (Patient patient : patientArrayList) {
            queue.offer(patient);
            System.out.println("En fila: " + patient.getName()+" "+patient.getPriority());
        }

        System.out.println("ORDENADOS");

        /**while (!queue.isEmpty()) {
            Patient patient = queue.poll();
            System.out.println("Siguiente: " + patient.getName()+" "+patient.getPriority());
        }*/
        
        while (remove != 3) {
            System.out.println("¿Desea atender al siguiente paciente?\n(1)Si\n(2)No\n(3)Salir");
            remove = sc.nextInt();
            switch (remove) {
                case 1:
                    queue.poll();
                    printPatients(queue);
                case 2:
                    System.out.println("ok");
                    printPatients(queue);

            }
        }
    }
    public static void printPatients(PriorityQueue queue) {
        while (!queue.isEmpty()) {
            Patient patient = queue.peek();
            System.out.println("Siguiente: " + patient.getName()+" "+patient.getPriority());
        }
    }

}
