package Assignment6_2;

import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.conf.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat; 
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import mapreduce.demo.task6.Task6Partitioner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class Task6_2 {
	static int MinVal, MaxVal, NumReducer, partition;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = new Job(conf, "Task6_1");
		job.setJarByClass(Task6_2.class);
		
		MinVal = Integer.parseInt(args[2]);
		MaxVal = Integer.parseInt(args[3]);
		NumReducer = Integer.parseInt(args[4]);
		partition = (MaxVal - MinVal)/NumReducer;
		
		
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Text.class);

		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(Text.class);
		job.setMapperClass(Task6_2Mapper.class);
		job.setReducerClass(Task6_2Reducer.class);
		job.setPartitionerClass(Task6_2Partitioner.class);
        		
		job.setNumReduceTasks(NumReducer);

		job.setInputFormatClass(SequenceFileInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0])); 
		FileOutputFormat.setOutputPath(job,new Path(args[1]));
		
		/*
		Path out=new Path(args[1]);
		out.getFileSystem(conf).delete(out);
		*/
		
		job.waitForCompletion(true);
	}
}
