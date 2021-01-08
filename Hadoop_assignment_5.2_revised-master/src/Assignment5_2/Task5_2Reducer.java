package Assignment5_2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class Task5_2Reducer extends Reducer<TV, IntWritable, TV, IntWritable>
{
	IntWritable outValue = new IntWritable();
	
	public void reduce(TV key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
	{
		int sum = 0;
		for (IntWritable value : values) {
			sum += value.get();
		}
		
		outValue.set(sum);
		context.write(key, outValue);
	}
}
