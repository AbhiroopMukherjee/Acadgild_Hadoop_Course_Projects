package Assignment1_2_2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 

public class Task1_2_2Mapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] lineArray = value.toString().split("\\|");
		
		String company = lineArray[0].toUpperCase();
		Text state = new Text(lineArray[3]);
		String product = lineArray[1];
		IntWritable size = new IntWritable(Integer.parseInt(lineArray[2]));
		
		//System.out.println(state);
		if(company.equals("NA") || product.equals("NA")){
			System.out.println("Log  dopped");
		}else if(company.equals("ONIDA")) {
			context.write(state, size);
			//System.out.println(state);
		}
	}
}
