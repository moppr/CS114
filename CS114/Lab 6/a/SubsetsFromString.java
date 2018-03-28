package a;

import java.util.*;

public class SubsetsFromString{

	public static void main(String[] args){
		
		String word = "abcdef";		
		Queue<String> queue = new LinkedList<String>();
		
		queue.add(" " + word); //quick way to set first CState to prefix "" and suffix "word"
		
		while (!queue.isEmpty()){
			
			//System.out.println(queue); //testing only
			
			String current = queue.peek(); //poll later to avoid double polling
			CState currState = new CState(current.substring(0, current.indexOf(" ")), current.substring(current.indexOf(" ")+1));
			//for a word in the queue like "acb def", CState made with pre="abc", suff="def"
			//note that queue logic uses spaces to convert back and forth from strings to CState
			//i could just make the queue hold CStates but this already happened by itself and i'm not about to fix what ain't broke
			
			if (currState.suff().trim().equals("")){ //when suffix no longer holds anything, spit out the prefix as an output
				System.out.println(queue.poll().trim());
				//queue.poll(); //testing only
			}
			else{ //when suffix isn't empty, create two new CStates, one moving the "space" between pre and suff to the right
				  //and the other having a space replace the first letter of suff
				queue.poll(); //poll now to account for peek earlier
				CState new1 = new CState(currState.pre() + currState.suff().substring(0, 1), currState.suff().substring(1));
				CState new2 = new CState(currState.pre(), currState.suff().substring(1));
				
				queue.offer(new1.toString()); //offer the two new CStates
				queue.offer(new2.toString());
			}
						
		}
		
	}

}
