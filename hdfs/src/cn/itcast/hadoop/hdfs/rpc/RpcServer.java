package cn.itcast.hadoop.hdfs.rpc;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

public class RpcServer implements Bizalbel {
	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		Configuration configuration = new Configuration();
		Server server = new RPC.Builder(configuration).setProtocol(Bizalbel.class).setInstance(new RpcServer())
				.setBindAddress("192.168.31.195").setPort(9527).build();

		server.start();
		System.out.println("启动成功");
	}

	public String sayhi(String name) {
		System.out.println("调用");
		return "hi" + name;
	}
}
