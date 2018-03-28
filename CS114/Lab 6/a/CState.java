package a;

public class CState{

	private String prefix = new String();
	private String suffix = new String();

	public CState(String pre, String suff){
		prefix = pre;
		suffix = suff;
	}

	public String pre(){
		return prefix;
	}

	public String suff(){
		return suffix;
	}
	
	public String toString() {
		return prefix + " " + suffix;
	}
}