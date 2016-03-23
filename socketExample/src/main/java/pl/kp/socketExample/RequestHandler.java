package pl.kp.socketExample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;

public class RequestHandler implements Runnable {
	private final Socket s;

	public RequestHandler(Socket s) {
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
			//Echo server
			while ((userInput = br.readLine()) != null) {
				if (!s.isConnected()) {
					System.out.println("Ending thread: " + Thread.currentThread().getName());
					Thread.currentThread().interrupt();
				}
				userInput = userInput.toLowerCase();
				System.out.println("[" + Thread.currentThread().getName() + "]: " + userInput);
				bw.write("Echo: " + userInput);
				bw.newLine();
				bw.flush();
			}
		} catch (SocketException e) {
			System.out.println("Interrupted thread: " + Thread.currentThread().getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
