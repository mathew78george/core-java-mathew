package com.mathew.corejava.designs.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.locks.ReentrantLock;

public class FileLogger implements LoggerBase {
	
	String pattern = "yyyy-MM-dd HH:mm:ss";
	SimpleDateFormat format = new SimpleDateFormat(pattern);

	BufferedWriter logWriter;
	ReentrantLock lock;
	String fileName;

	public FileLogger(String file) {
		fileName = file;
		lock = new ReentrantLock();
		createFile();
		FileRollOverTask task = new FileRollOverTask(this);
		Timer timer = new Timer("FileRollOverTask", true);
		timer.scheduleAtFixedRate(task, 0, 1000);
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
			logWriter.write(format.format(new Date())+"ERROR:" + error + "\n");
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
			logWriter.write(format.format(new Date())+"INFO:" + info + "\n");
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
			logWriter.write(format.format(new Date())+"WARNING:" + warning + "\n");
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
			logWriter.write(format.format(new Date())+"DEBUG:" + debug + "\n");
			logWriter.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void rolloverFile() {
		try {
			File file = Paths.get(fileName).toFile();
			long sizeBytes = file.length();
			long kbs = sizeBytes / 1024;
			if (kbs > 1000) {
				String pattern1 = "yyyy-MM-dd HH:mm:ss";
				SimpleDateFormat format1 = new SimpleDateFormat(pattern1);
				String fileappend = format1.format(new Date());
				System.out.println("file append"+fileappend);
				synchronized (this) {
					File newfile = new File(fileName + System.currentTimeMillis()/1000 + ".txt");
					file.renameTo(newfile);
					// writer.close();
					file = null;
					// writer = null;
					System.out.println("inside rolloverFile");
					createFile();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public static void main(String[] args) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		System.out.println(format.format(new Date()));
	}
}
