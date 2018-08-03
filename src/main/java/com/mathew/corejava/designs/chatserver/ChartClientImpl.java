package com.mathew.corejava.designs.chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChartClientImpl {
	private String host;
	private int port;
	private Socket socket;
	private DataInputStream reader;
	private DataOutputStream writer;

	public ChartClientImpl(String hst, int prt) {
		host = hst;
		port = prt;
	}

	public void startClient() throws UnknownHostException, IOException {
		socket = new Socket(host, port);
		reader = new DataInputStream(socket.getInputStream());
		writer = new DataOutputStream(socket.getOutputStream());
	}

	public void stopClient() throws IOException {
		reader.close();
		writer.close();
		socket.close();
	}

	public String readFromServer() throws IOException {
		return reader.readUTF();
	}

	public void writeToServer(String message) throws IOException {
		writer.writeUTF(message);
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Thread 1");
					ChartClientImpl client1 = new ChartClientImpl("127.0.0.1", 2010);
					client1.startClient();
					client1.writeToServer("Client 2 Hi Hello 1");
					client1.writeToServer("Client 2  Hi Hello 2");
					client1.writeToServer("Client 2 Hi Hello 3");
					client1.writeToServer("Client 2 Hi Hello 4");
					client1.startClient();
				} catch (UnknownHostException ue) {
					ue.printStackTrace();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}

			}
		});
		t1.setName("Thread 1");
		t1.start();
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Thread 2");
					ChartClientImpl client2 = new ChartClientImpl("127.0.0.1", 2010);
					client2.startClient();
					client2.writeToServer("Client 1 Hi Hello 1");
					client2.writeToServer("Client 1 Hi Hello 2");
					client2.writeToServer("Client 1 Hi Hello 3");
					client2.writeToServer("Client 1 Hi Hello 4");
					client2.startClient();
				} catch (UnknownHostException ue) {
					ue.printStackTrace();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}

			}
		});
		t2.setName("Thread 2");
		t2.start();

	}

}
