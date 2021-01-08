package Assignment6_1;

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

public class Task6_1 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = new Job(conf, "Task6_1");
		job.setJarByClass(Task6_1.class);

		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Text.class);

		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(Text.class);
		job.setMapperClass(Task6_1Mapper.class);
		job.setReducerClass(Task6_1Reducer.class);
        		
		job.setNumReduceTasks(1);

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
