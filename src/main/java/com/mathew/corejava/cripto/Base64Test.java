package com.mathew.corejava.cripto;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Base64Test {

	public static void main(String[] args) {
		try {
			String encoded = encodeFile("C:/upload/alexcis.png");
			createImage(encoded, "C:/upload/alexcisnew.png");
			int c = 'O';
			System.out.println(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String encodeFile(String fileName) throws IOException {
		Path pathtoFile = Paths.get(fileName);
		byte[] data = Files.readAllBytes(pathtoFile);
		String encodedData = Base64.getEncoder().encodeToString(data);
		System.out.println("encodedData" + encodedData);
		return encodedData;
	}

	private static void createImage(String encodeFile, String fileName) throws IOException {
		Path pathtoFile = Paths.get(fileName);
		OutputStream out = Files.newOutputStream(pathtoFile);
		byte[] data = Base64.getDecoder().decode(encodeFile);
		System.out.println("data--" + data);
		out.write(data);
		out.close();

	}

}
