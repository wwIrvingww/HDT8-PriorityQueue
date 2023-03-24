/**
 * Clase que se encarga de leer un txtFile
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

    /**
     * Metodo que lee un text file
     * @param fileName
     * @return
     */
    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line.getClass());
                lines.add(line);
            }

            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo '" + fileName + "'");
            ex.printStackTrace();
        }
        return lines;
    }


    //Para crear una lista de pacientes:
    public static ArrayList<Patient> getPatientList(ArrayList<String> patients) {
        ArrayList<Patient> patientArrayList = new ArrayList<>();
        for (String s : patients) {
            String[] date = s.split(", ");
            Patient patient = new Patient(date[0], date[1], date[2]);
            patientArrayList.add(patient);
        }
        return patientArrayList;
    }


}
