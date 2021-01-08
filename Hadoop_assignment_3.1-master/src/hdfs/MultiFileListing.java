package hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class MultiFileListing {	

	public static void listing(Path path){
		try{

			Configuration conf = new Configuration();
			FileSystem fileSystem = FileSystem.get(path.toUri(), conf);
			FileStatus[] fileStatus=fileSystem.listStatus(path);

			for (FileStatus fStat : fileStatus) {
				if (fStat.isDirectory()) {
					listing(fStat.getPath());
					System.out.println("Directory: " + fStat.getPath());
				}
				else if (fStat.isFile()) {
					System.out.println("File: " + fStat.getPath());
				}
				else if (fStat.isSymlink()) {
					System.out.println("Symlink: " + fStat.getPath());
				}
			}
		}catch(IOException e){}
	}


	public static void main(String[] args){
		if (args.length == 0) {
			System.out.println("Pass one argument");
			System.exit(1);
		}

		for(String p : args){
			Path path = new Path(p);
			listing(path);
		}
		
		

	}
}