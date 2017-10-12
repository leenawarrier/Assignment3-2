/** 
* <h1>AssTask4</h1> 
* print files and dir in HDFS path
* */ 
package hdfs; 
import java.io.*; 
import org.apache.hadoop.conf.Configuration; 
import org.apache.hadoop.fs.FileSystem; 
import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.fs.FileStatus; 

 public class AssTask4 { 
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
 			FileStatus[] fileStatus=fileSystem.listStatus(path); 
 			System.out.println("All directories and files inside the given path are: "); 
 			for (FileStatus fStat : fileStatus) { 
 				System.out.println(fStat.getPath()); 
 			} 
 		} 
 		catch (IOException e) 
 		{ 
             e.printStackTrace(); 
 		} 
 	} 
 } 
