package Assignment6_2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class Task6_2Reducer extends Reducer<IntWritable, Text, IntWritable, Text>
{	
	public void reduce(IntWritable key, Text values,Context context) throws IOException, InterruptedException
	{
		context.write(key, values );
	}
}
