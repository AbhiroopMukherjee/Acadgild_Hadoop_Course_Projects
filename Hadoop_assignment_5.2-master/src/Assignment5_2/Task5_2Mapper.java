package Assignment5_2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 

public class Task5_2Mapper extends Mapper<LongWritable, Text, CompanyProduct, IntWritable> {
		
	CompanyProduct outKey;
	IntWritable size;
	
	@Override
	public void setup(Context context) {
		outKey = new CompanyProduct();
		size = new IntWritable();
	}
	
	@Override
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] lineArray = value.toString().split("\\|");
		
		String company = lineArray[0];
		String product = lineArray[1];
		size.set(Integer.parseInt(lineArray[2]));
		int size1 = (Integer.parseInt(lineArray[2]));
		System.out.println("The sie is:"+size1);
		outKey.set(company, product, size1);
		
		context.write(outKey, size);
	}
}
