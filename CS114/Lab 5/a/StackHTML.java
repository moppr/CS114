package a;

import java.io.*;
import java.net.*;
import java.util.*;

public class StackHTML{

	public static void main(String[] args) throws URISyntaxException, IOException{
		
		File html = new File("C:\\Users\\Matt\\git\\CS114\\CS114\\Lab 5\\a\\html.dat");		
		File html2 = new File("C:\\Users\\Matt\\git\\CS114\\CS114\\Lab 5\\a\\html2.dat");
		checkHTML(html);
		checkHTML(html2);
	}
	
	private static String readFromInputStream(InputStream inputStream) throws IOException {
	    StringBuilder resultStringBuilder = new StringBuilder();
	    try (BufferedReader br
	      = new BufferedReader(new InputStreamReader(inputStream))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            resultStringBuilder.append(line).append("\n");
	        }
	    }
	  return resultStringBuilder.toString();
	}
	
	private static void checkHTML(File f) throws FileNotFoundException{
		
		Stack<String> stack = new Stack<String>();
		Scanner scan = new Scanner(f);									//general setup
		ArrayList<String> mismatch = new ArrayList<String>();

		while (scan.hasNextLine()){
			String line = scan.nextLine();

			int open = 0, close = 0, start = 0;
			
			while (open != -1 && close != -1){
				open = line.indexOf('<', start);										//finding location of tags
				close = line.indexOf('>', start);

				if (open != -1 && close != -1){
					
					try {
					
						if (line.charAt(open+1) != '/'){
							stack.push(line.substring(open+1, close));  				//if no '/' detected, push new tag
						}
						else{
							if (stack.peek().equals(line.substring(open+2, close))){	//if '/' detected for closing tag,
								stack.pop();											//make sure that tag matches before popping
							}
							else{
								mismatch.add(stack.pop());								//if there is an unclosed tag, save it
								stack.pop();										
							}
						}	
						
					} 
					catch (EmptyStackException E) {
						mismatch.add(line.substring(open+2, close)); 					//accounts for extra closing tag
					}																	//as opposed to only extra opening tag
					
				}												
				start = close+1;
			}												//(or 0 if never found)	
		}
		
		for (String s : mismatch)
			stack.push(s);
		
		if (stack.empty()) { //success
			System.out.println("The input file " + f.getName() + " is a matched HTML document");
		}
		else {
			System.out.println("The input file " + f.getName() + " contains the following mismatched elements: ");
			System.out.println(mismatch + "\n");
		}

	}

}
