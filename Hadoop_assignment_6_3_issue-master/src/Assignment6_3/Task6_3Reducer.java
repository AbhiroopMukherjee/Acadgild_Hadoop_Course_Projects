package Assignment6_3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class Task6_3Reducer extends Reducer<Text, Text, Text, IntWritable>
{	
	private static int top=0;
	public void reduce(Text key, Iterable<Text> values,Context context) throws IOException, InterruptedException
	{
		int counter = 0;
		for (Text value : values) {
			counter++;
		}

		if(top<3){
			top++;
			context.write(key, new IntWritable(counter));
		}
		

	}
}
