package pl.kp.socketExample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HttpServer {

	public static void main(String[] args) {
		ExecutorService es = null;
		try (ServerSocket ss = new ServerSocket(1234, 10)) {
			es = Executors.newFixedThreadPool(5);
			System.out.println("Waiting for clients");
			while(true) {
				Socket s = ss.accept();
				Runnable r = new HttpRequestHandler(s);
				es.execute(r);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (es != null) {
				es.shutdown();
			}
		}
    }

}
