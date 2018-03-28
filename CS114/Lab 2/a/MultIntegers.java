package a;

public class MultIntegers{

	public long multiplyLoop(int num, int times){
		long cur = 0;
		for (int i = times; i > 0; i--){ //run a loop of "times" times
			cur += num; //add cur each time which effectively produces times*cur
		}
		return cur;
	}

	public long multiplyRecursive(int num, int times){
		if (times <= 0) //call method and add num each time until it's been done "times" times
			return 0;
		return num + multiplyRecursive(num, times - 1);
	}

}
