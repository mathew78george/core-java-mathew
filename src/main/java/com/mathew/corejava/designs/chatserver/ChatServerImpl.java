package com.mathew.corejava.designs.chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServerImpl {

	private ServerSocket serverSocket;
	private int serverPort = 2010;
	private ExecutorService executors;
	static int count = 1;
	public ChatServerImpl() {
		executors = Executors.newFixedThreadPool(2);
	}

	private void startServer() throws ChartServerException {
		try {
			serverSocket = new ServerSocket(serverPort);
			System.out.println("Server Started....");
			while (true) {
				Socket client = serverSocket.accept();
				executors.execute(new ChartServerThread(client,count++));
				System.out.println("Got Connection" + client.getInetAddress());
			}
			
//			executors.shutdown();
//			System.out.println("DONE");
//			DataInputStream reader = new DataInputStream(client.getInputStream());
//			String message = reader.readUTF();
//			System.out.println("message" + message);
//			DataOutputStream writer = new DataOutputStream(client.getOutputStream());
//			writer.writeUTF("From Server"+message);
			// BufferedWriter writer = new BufferedWriter(new
			// OutputStreamWriter(client.getOutputStream()));
			// writer.write("Message from Server" + message);
			// reader.close();
			// writer.close();
			// client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ChartServerException ioe = new ChartServerException();
			ioe.setMessage("IO Exception in starting server");
			ioe.setErrorCode(100);
			throw ioe;
		}
	}

	public static void main(String[] args) {
		ChatServerImpl serverIml = new ChatServerImpl();
		try {
			serverIml.startServer();
		} catch (ChartServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TestClient clientTask = new TestClient();
		// ExecutorService executer = Executors.newSingleThreadExecutor();
		// executer.submit(clientTask);
		// executer.shutdown();
	}

}

class TestClient implements Callable<Boolean> {

	@Override
	public Boolean call() throws Exception {
		Socket client = new Socket("127.0.0.1", 2010);
		System.out.println("Client Connected");
		return true;
	}

}
