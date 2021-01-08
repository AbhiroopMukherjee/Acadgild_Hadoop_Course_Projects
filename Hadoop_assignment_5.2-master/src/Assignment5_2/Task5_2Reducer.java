package Assignment5_2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class Task5_2Reducer extends Reducer<CompanyProduct, IntWritable, CompanyProduct, IntWritable>
{	
	public void reduce(CompanyProduct key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
	{
		int counter = 0;
		for (IntWritable value : values) {
			counter++;
		}

		context.write(key, new IntWritable(counter));
	}
}
