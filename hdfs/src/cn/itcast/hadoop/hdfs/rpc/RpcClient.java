package cn.itcast.hadoop.hdfs.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class RpcClient {
	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		Bizalbel proxy = RPC.getProxy(Bizalbel.class, 10010, new InetSocketAddress("192.168.31.195", 9527),
				new Configuration());
		String name = proxy.sayhi("wang");
		
		RPC.stopProxy(proxy);
		System.out.println(name);
		System.out.println("ok");

	}

	public String sayhi(String name) {
		return "hi" + name;
	}
}
