package b;

public class HashTableRunner{

	public static void main(String[] args){

		HashFunction function = new HashFunction();
		HashTableNew<String, String> hashTable = new HashTableNew<String, String>(128);
		int check1 = (int) (128 * .4); //40%
		int check2 = (int) (128 * .6); //60%
		
		int inserts = 0;

		while (true){
			if (inserts == check1){ //40% info
				//System.out.println("1-50 omitted for ease of reading");
				System.out.println(inserts + " = 40%");
				System.out.println("Collisions: " + hashTable.getCol());
			}
			else if (inserts == check2){ //60% info + exit;
				//System.out.println("52-75 omitted for ease of reading");
				System.out.println(inserts + " = 60%");
				System.out.println("Collisions: " + hashTable.getCol());
				break;
			}

			String word = "";
			for (int i = 0; i < 8; i++){
				int randASCII = (int) (Math.random() * 26) + 'A';
				word += (char)(randASCII);
			}

			int ins = function.sfold(word, 128);
			if (hashTable.hashInsert(ins, word, word)){
				inserts++;
			}
		}
	}
}
