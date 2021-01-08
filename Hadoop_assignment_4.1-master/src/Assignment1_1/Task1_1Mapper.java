package Assignment1_1;

import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 

public class Task1_1Mapper extends Mapper<LongWritable, Text, NullWritable, Text> {
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		//System.out.println("VAlue : " + Arrays.toString(value.toString().split("|")));
		String[] lineArray = value.toString().split("\\|");
		
		String company = lineArray[0];
		String product = lineArray[1];
		
		//System.out.println("Company : " + company + " Product : " + product);
		
		if(company.equals("NA") || product.equals("NA")){
			System.out.println("Log  dopped");
		}else{
			context.write(NullWritable.get(), value);
		}
	}
}
