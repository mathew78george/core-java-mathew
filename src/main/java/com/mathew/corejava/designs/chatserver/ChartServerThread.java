package com.mathew.corejava.designs.chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChartServerThread implements Runnable {
	private Socket client;
	private DataInputStream input;
	private DataOutputStream output;

	public ChartServerThread(Socket s, int count) throws IOException {
		System.out.println("Count---->"+count);
		client = s;
		initialize();
	}

	private void initialize() throws IOException {
		input = new DataInputStream(client.getInputStream());
		output = new DataOutputStream(client.getOutputStream());
	}

	@Override
	public void run() {
		try {
			String message = "";
			while (input.available() > 0 && message != null) {				
				message = input.readUTF();
				System.out.println("message is" + message);
			}
			input.close();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exit of run");
	}

}
