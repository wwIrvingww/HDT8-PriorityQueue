import java.util.PriorityQueue;

public class JavaPriorityQueue {
    PriorityQueue<Patient> priorityQueue = new PriorityQueue<>();


    public  void add(Patient patient){
        priorityQueue.offer(patient);

    }
    public void remove (){
        priorityQueue.poll();
    }

}
