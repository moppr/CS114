package b;

import java.io.File;

public class FileUsage{

	public int totalDiskUsage(File directory){
		int total = 0; //start running total
		for (File file : directory.listFiles()){ //check each file in current directory
			if (file.isFile()) 
				total += file.length(); //add files to total
			else
				total += totalDiskUsage(file); //recursively do process for folders
		}
		return total;
	}

}
