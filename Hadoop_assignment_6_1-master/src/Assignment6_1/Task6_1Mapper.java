package Assignment6_1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class Task6_1Mapper extends Mapper<Text, IntWritable, IntWritable, Text> {
	public void map(Text key, IntWritable value, Context context) 
			throws IOException, InterruptedException {
//		String[] lineArray = value.toString().split("\t");
//		
//		Text company = new Text(lineArray[0]);
//		IntWritable sales = new IntWritable(Integer.parseInt(lineArray[1]));
		
		Text company = key;
		IntWritable sales = value;
		
		System.out.println("Company:"+company+" sales:"+sales);
		if(company.equals("NA")){
			System.out.println("Log  dopped");
		}else{
		context.write(sales, company);
		}
	}
}
