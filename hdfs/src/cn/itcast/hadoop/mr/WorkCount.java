package cn.itcast.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WorkCount {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Job job = Job.getInstance(new Configuration());
		job.setJarByClass(WorkCount.class);
		
		job.setMapperClass(WCMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);

		FileInputFormat.setInputPaths(job, new Path("/words"));
		job.setReducerClass(WCReduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		FileOutputFormat.setOutputPath(job, new Path("/wordscount"));
		job.waitForCompletion(true);
		System.out.println("ok");

	}
}
