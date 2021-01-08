package Assignment6_2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Task6_2Partitioner extends Partitioner<IntWritable, Text> {

	@Override
	public int getPartition(IntWritable key, Text value, int numPartitions) {
		
		int sales = key.get();
		
		System.out.println("For value:"+value.getBytes()+"Sales are:"+sales);
		
		if(sales < Task6_2.partition){
			return 0;
		}
				
		return 1;
	}
}