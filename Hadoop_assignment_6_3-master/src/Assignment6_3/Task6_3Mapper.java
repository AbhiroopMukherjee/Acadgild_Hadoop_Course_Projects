package Assignment6_3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class Task6_3Mapper extends Mapper<LongWritable, Text, Text, Text> {
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] lineArray = value.toString().split("\\|");
		
		Text company = new Text(lineArray[0]);
        Text state = new Text(lineArray[3]);
		
		//System.out.println("Company:"+company+" sales:"+sales);
		if(company.equals("NA")){
			System.out.println("Log  dopped");
		}else{
		context.write(state, company);
		}
	}
}
