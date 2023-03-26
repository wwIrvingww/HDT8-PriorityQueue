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
        MyPriorityQueue queue = new MyPriorityQueue();
        ArrayList<Patient> patientArrayList = Reader.getPatientList(patients);
        int remove = -1;


        //Mostrar la lista de pacientes leída del txt file
        System.out.println("\nLISTA DE PACIENTES ");
        for (Patient patient : patientArrayList) {
            queue.offer(patient);
            System.out.println("En fila: " + patient.getName()+ ", "+patient.getDescription()+ ", "+patient.getPriority());
        }


        //Inicia la interacción con el usuario
        System.out.println("\nEsoja una opción\n(1)Atender al siguiente\n(2)Agregar paciente\n(3)Ver la lista\n(4)Salir");
        int optionn = sc.nextInt();

        while (optionn != 4){
            if (optionn == 1)
            {
                if (queue.isEmpty()){
                    System.out.println("No hay pacientes en fila");
                }
                else {
                    queue.poll();
                    System.out.println("Se ha atendido existosamente");
                }
            }
            else if (optionn == 2){
                System.out.println("Ingrese el nombre del paciente");
                String name  = sc.next();
                System.out.println("Agregue la descripcion");
                String desciption  = sc.nextLine();
                desciption = sc.nextLine();
                System.out.println("Agregue la prioridad");
                String letter = sc.next().toUpperCase();
                Patient newPatient = new Patient(name,desciption,letter);
                queue.offer(newPatient);
                System.out.println("Se ha agregado exitosamente");
            }
            else if (optionn == 3){
                int k = 0;
                while (k < queue.size()) {
                    Patient patient = queue.getPatient(k);
                    System.out.println("Esperando: " + patient.getName()+ ", "+patient.getDescription()+", "+patient.getPriority());
                    k++;
                }
            }
            System.out.println("\nEsoja una opción\n(1)Atender al siguiente\n(2)Agregar paciente\n(3)Ver la lista\n(4)Salir");
            optionn = sc.nextInt();

        }
    }

}
