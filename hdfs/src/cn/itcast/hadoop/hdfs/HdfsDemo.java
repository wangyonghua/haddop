package cn.itcast.hadoop.hdfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class HdfsDemo {
	private FileSystem fs = null;

	@Before
	public void init() throws IOException, URISyntaxException, InterruptedException {
		fs = FileSystem.get(new URI("hdfs://itcast01:9000"), new Configuration(), "root");
	}

	@Test
	public void testUpload() throws IllegalArgumentException, IOException {
		InputStream inputStream = new FileInputStream("f://test.txt");
		OutputStream outputStream = fs.create(new Path("/test"));
		IOUtils.copyBytes(inputStream, outputStream, 4096, true);
		System.out.println("ok");
	}

	public static void main(String[] args) throws IOException, URISyntaxException {
		FileSystem fs = FileSystem.get(new URI("hdfs://itcast01:9000"), new Configuration());
		InputStream stream = fs.open(new Path("/java"));
		OutputStream outputStream = new FileOutputStream("F://test");
		IOUtils.copyBytes(stream, outputStream, 4096, true);
		System.out.println("ok");
	}
}
