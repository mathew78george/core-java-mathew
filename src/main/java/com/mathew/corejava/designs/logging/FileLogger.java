package com.mathew.corejava.designs.logging;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.locks.ReentrantLock;

public class FileLogger implements LoggerBase {

	BufferedWriter logWriter;
	ReentrantLock lock;
	String fileName;

	public FileLogger(String file) {
		fileName = file;
		lock = new ReentrantLock();
		createFile();		
	}

	public void createFile() {
		Path pathTofile = Paths.get(fileName);
		try {
			logWriter = Files.newBufferedWriter(pathTofile, StandardCharsets.US_ASCII, StandardOpenOption.CREATE);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void logError(String error) {
		try {
			lock.lock();
			logWriter.write("ERROR:" + error + "\n");
			logWriter.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	public void logInfo(String info) {
		try {
			lock.lock();
			logWriter.write("INFO:" + info + "\n");
			logWriter.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void logWarning(String warning) {
		try {
			lock.lock();
			logWriter.write("WARNING:" + warning + "\n");
			logWriter.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void logDebug(String debug) {
		try {
			lock.lock();
			logWriter.write("DEBUG:" + debug + "\n");
			logWriter.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void rolloverFile() {
		Path pathTofile = Paths.get(fileName);
		long sizeinBytes = pathTofile.toFile().length();
		long kbs = sizeinBytes / 1024;
		if (kbs >= 100) {
			System.out.println("File size reached 100 KB");
			synchronized (this) {
				String newfilename = "logfile" + System.currentTimeMillis() / 1000 + ".txt";
				Path newpathTofile = Paths.get(newfilename);
				pathTofile.toFile().renameTo(newpathTofile.toFile());
				pathTofile.toFile().delete();
				System.out.println("Done rolloverFile ");
				logWriter = null;
				createFile();
			}
		}
	}

}
