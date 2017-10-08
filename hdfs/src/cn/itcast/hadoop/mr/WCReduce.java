package cn.itcast.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WCReduce extends Reducer<Text, LongWritable, Text, LongWritable> {

	@Override
	protected void reduce(Text k2, Iterable<LongWritable> v2s,
			Reducer<Text, LongWritable, Text, LongWritable>.Context arg2) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		long counter = 0;
		for (LongWritable i : v2s) {
			counter += i.get();
		}
		arg2.write(new Text(k2), new LongWritable(counter));
	}

}
