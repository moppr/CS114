package c;

public class RandWord{
	
	public RandWord() {
		
	}
	
	private String genLetter() {
		String alphabet = "QWERTYUIOPASDFGHJKLZXCVBNM"; //all uppercase chars
		int rand = (int) (Math.random() * 26); //random int from 0 to 25
		return alphabet.substring(rand, rand+1); //generate one random letter from alphabet (string of len 1)
	}
	
	public void genWord() {
		String result = "";
		for (int i = 0; i < 8; i++) {
			result += genLetter(); //create random letter 8 times and concatenate
		}
		
		System.out.println(result);
	}

}
