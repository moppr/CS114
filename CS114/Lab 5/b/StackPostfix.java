package b;

import java.io.*;
import java.util.*;

public class StackPostfix{ //commit 4 from second computer test

	private static final String operators = "+-*/";

	public static void main(String[] args) throws FileNotFoundException{

		File postfix = new File("C:\\Users\\Matt\\git\\CS114\\CS114\\Lab 5\\b\\postfix.dat");
		evaluate(postfix);

	}

	private static void evaluate(File f) throws FileNotFoundException{

		Scanner scan = new Scanner(f);
		Stack<String> stack = new Stack<String>();

		System.out.println("Input from file " + f.getName() + "\n");

		while (scan.hasNextLine()){
			String line = scan.nextLine();
			StringTokenizer st = new StringTokenizer(line);				//general setup and output stuff

			System.out.println("Evaluating expression: " + line);

			boolean errorStateAchieved = false;							//to be used later
																		//(avoids stating incorrect type of error)
			while (st.hasMoreTokens()){
				String item = st.nextToken();

				if (operators.contains(item)){									//if current item is +, -, *, or /
					if (stack.size() < 2){										//make sure there are enough numbers
						System.out.println("error: too many operators");		//to perform operation on
						errorStateAchieved = true;
						break;
					}
					int a = Integer.parseInt(stack.pop()), b = Integer.parseInt(stack.pop());

					try{

						switch (item){
						case "+":
							stack.push((b + a) + "");				//b done before a because a is actually
							break;									//the second term of the expression
						case "-":									//but is higher on the stack because it
							stack.push((b - a) + "");				//entered later
							break;
						case "*":
							stack.push((b * a) + "");
							break;
						case "/":
							stack.push((b / a) + "");
							break;
						default:
							System.out.println("wtf did u do");		//this code should not be reachable unless
							;										//forgot to break between cases
						}

					} catch (ArithmeticException E){
						System.out.println("error: " + E.getMessage());
						errorStateAchieved = true;
					}

				} else{											//if item is not + - * / 
					stack.push(item);							//then it is an operand
				}
			}

			if (!errorStateAchieved){
				if (stack.size() != 1)												//!=1 means something went wrong
					System.out.println("error: too many operands");					//div by 0 and not enough operands already accounted for
				else																//so only possible error at this point is too many operands
					System.out.println("Expression evaluated to " + stack.pop());
			}

			stack.clear();								//clearing stack between expressions
			System.out.println("");						//if everything was perfect, wouldn't need it,
														//but some stacks end with more than 1 item left
		}
	}
}
