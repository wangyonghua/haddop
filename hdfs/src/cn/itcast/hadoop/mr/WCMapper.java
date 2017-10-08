package cn.itcast.hadoop.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WCMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// ��������
		String line = value.toString();

		// �з�����
		String[] split = line.split(" ");
		for (String s : split) {
			context.write(new Text(s), new LongWritable(1));
		}
	}

}
