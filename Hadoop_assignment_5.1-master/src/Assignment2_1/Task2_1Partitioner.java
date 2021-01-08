package Assignment2_1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Task2_1Partitioner extends Partitioner<Text, IntWritable> {

	@Override
	public int getPartition(Text key, IntWritable value, int numPartitions) {
		char ch = key.toString().charAt(0);
		
		if(ch >= 'a' && ch <= 'z')
			ch = (char)(ch - 32);
		
		if (ch>='A' && ch <= 'F') {
			return 0;
		}else if(ch >= 'G' && ch <= 'L'){
			return 1;
		}else if(ch>='M' && ch <= 'R'){
			return 2;
		}
		
		return 3;
	}
}