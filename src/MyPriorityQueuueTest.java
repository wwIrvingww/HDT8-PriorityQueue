/**
 * Pruebas unitarias de la clase MyPriorityQueue
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class MyPriorityQueuueTest {

    @Test
    public void offerTest (){
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        Patient patientJuan = new Patient("Juan", "dolor cervical", "C");
        myPriorityQueue.offer(patientJuan);
        String esperado = "C";
        String resultado = myPriorityQueue.getPatient(0).getPriority();

        assertEquals(esperado,resultado);
    }

    @Test
    public void isEmptyTest(){
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        boolean esperado = true;
        boolean resultado = myPriorityQueue.isEmpty();

        assertEquals(esperado,resultado);
    }

    @Test
    public void pollTest(){
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        Patient patientJuan = new Patient("Juan", "Dolor estomacal", "C");
        myPriorityQueue.offer(patientJuan);
        Patient patientIma = new Patient("Ima", "Hombro dislocado", "B");
        myPriorityQueue.offer(patientIma);

        String esperado = "Ima";
        String resultado = myPriorityQueue.poll().getName();

        assertEquals(esperado, resultado);

    }

    @Test
    public void sizeTest(){
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        Patient patientJuan = new Patient("Juan", "Dolor estomacal", "C");
        myPriorityQueue.offer(patientJuan);
        Patient patientIma = new Patient("Ima", "Hombro dislocado", "B");
        myPriorityQueue.offer(patientIma);
        Patient patientGerson = new Patient("Gerson", "dolor lumbar", "E");

        int esperado = 3;
        int resultado = myPriorityQueue.size();

        assertEquals(esperado,resultado);

    }


}
