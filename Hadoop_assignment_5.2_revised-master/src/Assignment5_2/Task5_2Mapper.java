package Assignment5_2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 

public class Task5_2Mapper extends Mapper<LongWritable, Text, TV, IntWritable> {
	TV outKey = new TV();
	
	IntWritable outValue = new IntWritable();
	
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] lineArray = value.toString().split("\\|");
		outKey.set(lineArray[0], Integer.parseInt(lineArray[2]));
		outValue.set(1);
		context.write(outKey, outValue);
	}
}
