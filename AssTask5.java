/** 
* <h1>AssTask5</h1> 
* print files and directories recursively in the hdfs path
**/ 
package hdfs; 
import java.io.*; 
import org.apache.hadoop.conf.Configuration; 
import org.apache.hadoop.fs.FileSystem; 
import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.fs.FileStatus; 

public class AssTask5 { 
	public static void main(String[] args) { 
		if (args.length != 1) { 
			System.out.println("Please pass the argument"); 
			System.exit(1); 
		} 		 
		Path path = new Path(args[0]); 		 
		try 
		{ 
			Configuration conf = new Configuration(); 
			FileSystem fileSystem = FileSystem.get(path.toUri(), conf); 
			FileStatus[] fileStatus = fileSystem.listStatus(path); 
			System.out.println("All directories and files inside the given path recursively are: "); 
			browse(fileSystem,fileStatus); 


		} 
		catch (IOException e) 
		{ 
            e.printStackTrace(); 
		} 
	} 

	private static void browse(FileSystem fileSystem, FileStatus[] status) throws IOException { 
		for (int i = 0; i < status.length; i++) { 
            FileStatus fileStatus = status[i]; 
            if (fileStatus.isDir()) { 
                FileStatus[] subStatus = fileSystem.listStatus(fileStatus.getPath()); 
                browse(fileSystem,subStatus); 
            } else { 
                System.out.println(fileStatus.getPath()); 
            } 
        } 
		 
	} 
} 
