package pl.kp.socketExample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import javax.xml.ws.spi.http.HttpHandler;

public class HttpRequestHandler implements Runnable {
	private final Socket s;

	public HttpRequestHandler(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try(
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				) {
			System.out.println("Thread started with name: " + Thread.currentThread().getName());
			String userInput;
			BufferedReader fr = null;
			//HTTP Server
			while (true) {
				userInput = br.readLine();
				if (userInput.startsWith("GET")) {
					String url = userInput.split(" ")[1];
//					url = url.replaceFirst("?.*", "");
					Path path = Paths.get("C:/xampp/htdocs/" + url);
					if (!path.toFile().exists()) {
						System.out.println("Nie istnieje plik: " + path.toString());
					}
					fr = new BufferedReader(new FileReader(path.toFile()));
				}
				if (userInput.isEmpty()) {
					break;
				}
				System.out.println(userInput);
			}
			StringBuilder sb = new StringBuilder();
			sb.append("HTTP/1.1 200 OK\n"
					+ "Date: Fri, 18 Mar 2016 21:37:51 GMT\n"
					+ "Server: KamilHTTPServer v0.1\n\n");
			sb.append(fr.lines().collect(Collectors.joining()));
			bw.write(sb.toString());
			System.out.println("[" + Thread.currentThread().getName() + "]: " + sb.toString());
			bw.newLine();
			bw.flush();
		} catch (SocketException e) {
			System.out.println("Interrupted thread: " + Thread.currentThread().getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
