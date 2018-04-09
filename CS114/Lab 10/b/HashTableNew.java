package b;

public class HashTableNew<Key extends Comparable<? super Key>, E>{

	private int M;
	private KVpair<Key, E>[] HT;
	private int col = 0;

	private int h(Key key){
		return M - 1;
	}

	private int p(Key key, int slot){
		return slot;
	}

	void setCol(int i) // Collision count
	{
		col = i;
	}

	int getCol(){
		return col;
	}

	@SuppressWarnings("unchecked") // Generic array allocation
	HashTableNew(int m){
		M = m;
		HT = (KVpair<Key, E>[]) new KVpair[M];
	}

	/** Insert record r with key k into HT */
	boolean hashInsert(int p, Key k, E r){
		int home; // Home position for r
		int pos = home = p; // Initial position
		for (int i = 1; HT[pos] != null; i++){
			pos = (home + p(k, i)) % M; // Next pobe slot
			// assert HT[pos].key().compareTo(k) != 0 :
			// "Duplicates not allowed";
			if (HT[pos] != null){
				if (HT[pos].key().compareTo(k) == 0)
					return false;
				else{
					//System.out.println(HT[pos].key() + " collide with new key " + k + " with hashcode " + pos);
					col++; // increase collision count
				}
			}
			else
				break;
		}
		HT[pos] = new KVpair<Key, E>(k, r); // Insert R
		return true;
	}

	/** Search in hash table HT for the record with key k */
	E hashSearch(int p, Key k){
		int home; // Home position for k
		int pos = home = p; // Initial position
		for (int i = 1; (HT[pos] != null) && (HT[pos].key().compareTo(k) != 0); i++)
			pos = (home + p(k, i)) % M; // Next probe position
		if (HT[pos] == null)
			return null; // Key not in hash table
		else
			return HT[pos].value(); // Found it
	}

}
