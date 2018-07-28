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

	public FileLogger(String fileName) {
		Path pathTofile = Paths.get(fileName);
		try {
			logWriter = Files.newBufferedWriter(pathTofile, StandardCharsets.US_ASCII, StandardOpenOption.APPEND);
			lock = new ReentrantLock();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void logError(String error) {
		try {
			lock.lock();
			logWriter.write("ERROR:" + error);
			logWriter.flush();
		} catch (IOException ioe) {

		} finally {
			lock.unlock();
		}

	}

	public void logInfo(String info) {
		try {
			lock.lock();
			logWriter.write("INFO:" + info);
			logWriter.flush();
		} catch (IOException ioe) {

		} finally {
			lock.unlock();
		}
	}

	public void logWarning(String warning) {
		try {
			lock.lock();
			logWriter.write("WARNING:" + warning);
			logWriter.flush();
		} catch (IOException ioe) {

		} finally {
			lock.unlock();
		}
	}

	public void logDebug(String debug) {
		try {
			lock.lock();
			logWriter.write("DEBUG:" + debug);
			logWriter.flush();
		} catch (IOException ioe) {

		} finally {
			lock.unlock();
		}
	}

}
