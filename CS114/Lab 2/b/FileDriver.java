package b;

import java.io.File;

public class FileDriver{

	public static void main(String[] args){
		
		FileUsage file = new FileUsage();
		System.out.println(file.totalDiskUsage(new File("C:\\Users\\Matt\\eclipse-workspace\\CS114\\Lab 2\\b")));
		System.out.println(file.totalDiskUsage(new File("C:\\Users\\Matt\\eclipse-workspace\\CS114\\Lab 2")));
		System.out.println(file.totalDiskUsage(new File("C:\\Users\\Matt\\eclipse-workspace\\CS114"))); //testing some paths; broader ones give higher values

	}

}
