package pl.kp.socketExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class Client {

	public static void main(String[] args) {
		try (
				Socket s = new Socket("127.0.0.1", 1234);
				PrintWriter sOut = new PrintWriter(s.getOutputStream(), true);
				BufferedReader sIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));) {
			String in;
			while((in = stdIn.readLine())!=null) {
				sOut.println(in + ((int)(Math.random()*10)));
				System.out.println("Server answer: " + sIn.readLine());
			}
		} catch (SocketException e) {
			System.err.println("Zerwane połączenie!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
