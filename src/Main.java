import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
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
        int optionPriorityQueue;

        System.out.println("Escoja con que PrioritQueue desea ejecutar el programa\n(1)Propia\n(2)Java");
        optionPriorityQueue = sc.nextInt();

        if (optionPriorityQueue == 1) {
            //Mostrar la lista de pacientes leída del txt file
            System.out.println("\nLISTA DE PACIENTES ");
            for (Patient patient : patientArrayList) {
                queue.offer(patient);
                System.out.println("En fila: " + patient.getName() + ", " + patient.getDescription() + ", " + patient.getPriority());
            }

            //Inicia la interacción con el usuario
            System.out.println("\nEsoja una opción\n(1)Atender al siguiente\n(2)Agregar paciente\n(3)Ver la lista\n(4)Salir");
            int optionn = sc.nextInt();

            while (optionn != 4) {
                if (optionn == 1) {
                    if (queue.isEmpty()) {
                        System.out.println("No hay pacientes en fila");
                    } else {
                        queue.poll();
                        System.out.println("Se ha atendido existosamente");
                    }
                } else if (optionn == 2) {
                    System.out.println("Ingrese el nombre del paciente");
                    String name = sc.next();
                    System.out.println("Agregue la descripcion");
                    String desciption = sc.nextLine();
                    desciption = sc.nextLine();
                    System.out.println("Agregue la prioridad");
                    String letter = sc.next().toUpperCase();
                    Patient newPatient = new Patient(name, desciption, letter);
                    queue.offer(newPatient);
                    System.out.println("Se ha agregado exitosamente");
                } else if (optionn == 3) {
                    int k = 0;
                    while (k < queue.size()) {
                        Patient patient = queue.getPatient(k);
                        System.out.println("Esperando: " + patient.getName() + ", " + patient.getDescription() + ", " + patient.getPriority());
                        k++;
                    }
                }
                System.out.println("\nEsoja una opción\n(1)Atender al siguiente\n(2)Agregar paciente\n(3)Ver la lista\n(4)Salir");
                optionn = sc.nextInt();

            }
        }

        else {
            //Declaracion de variables
            PriorityQueue<Patient> javaPriorityQueue = new PriorityQueue<>();
            ArrayList<Patient> patientArrayList1 = Reader.getPatientList(patients);
            for (Patient p: patientArrayList1){
                javaPriorityQueue.offer(p);
            }
            //Mostrar la lista de pacientes leída del txt file
            System.out.println("\nLISTA DE PACIENTES ");
            Iterator<Patient> iter = javaPriorityQueue.iterator();
            while(iter.hasNext()) {
                Patient elemento = iter.next();
                System.out.println(elemento.getName()+", "+elemento.getDescription()+", "+elemento.getPriority());
                }
            //Inicia interaccion con el usuario
            System.out.println("\nEsoja una opción\n(1)Atender al siguiente\n(2)Agregar paciente\n(3)Ver la lista\n(4)Salir");
            int optionn = sc.nextInt();
            while (optionn != 4) {
                if (optionn == 1) {
                    if (javaPriorityQueue.isEmpty()) {
                        System.out.println("No hay pacientes en fila");
                    } else {
                        javaPriorityQueue.poll();
                        System.out.println("Se ha atendido existosamente");
                    }
                } else if (optionn == 2) {
                    System.out.println("Ingrese el nombre del paciente");
                    String name = sc.next();
                    System.out.println("Agregue la descripcion");
                    String desciption = sc.nextLine();
                    desciption = sc.nextLine();
                    System.out.println("Agregue la prioridad");
                    String letter = sc.next().toUpperCase();
                    Patient newPatient = new Patient(name, desciption, letter);
                    javaPriorityQueue.offer(newPatient);
                    System.out.println("Se ha agregado exitosamente");
                } else if (optionn == 3) {
                    Iterator<Patient> iter2 = javaPriorityQueue.iterator();
                    while(iter2.hasNext()) {
                        Patient elemento2 = iter2.next();
                        System.out.println(elemento2.getName()+", "+ elemento2.getDescription()+", "+ elemento2.getPriority());
                    }
                }
                System.out.println("\nEsoja una opción\n(1)Atender al siguiente\n(2)Agregar paciente\n(3)Ver la lista\n(4)Salir");
                optionn = sc.nextInt();

            }
            }
        }
}


