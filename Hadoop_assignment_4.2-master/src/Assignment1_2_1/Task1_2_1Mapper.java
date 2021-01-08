package Assignment1_2_1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 

public class Task1_2_1Mapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] lineArray = value.toString().split("\\|");
		
		Text company = new Text(lineArray[0]);
		String product = lineArray[1];
		IntWritable size = new IntWritable(Integer.parseInt(lineArray[2]));
		
		if(company.equals("NA") || product.equals("NA")){
			System.out.println("Log  dopped");
		}else{
		context.write(company, size);
		}
	}
}
