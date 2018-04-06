package b;

import java.io.*;
import java.util.*;

public class PatientRunner{

	public static final int size = 8;

	public static void main(String[] args) throws NumberFormatException, IOException{
		PriorityQueue<Patient> patients = new PriorityQueue<Patient>(size);
		System.out.println("Creating PQueue");
		populate(patients); //initiate pqueue

		System.out.println();
		System.out.println("Ordered PQueue"); //why is pregnancy a 'symptom'
		while (!patients.isEmpty()){
			System.out.println(patients.poll());
		}
	}
	
	public static void populate(PriorityQueue<Patient> patients) throws NumberFormatException, IOException{
		
		String line;		
		BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Lab 9\\b\\patient.txt"));
		
		while ((line = in.readLine()) != null){
			Queue<String> queue = new LinkedList<String>();

			while (line.indexOf(",") != -1){
				queue.offer(line.substring(0, line.indexOf(",")));
				line = line.substring(line.indexOf(",") + 1);
			}

			int id = Integer.parseInt(queue.poll());
			String name = queue.poll();
			String reason = line;

			Patient temp = new Patient(id, name, reason);
			System.out.println(temp);
			patients.offer(temp);
		}

	}
	
}
